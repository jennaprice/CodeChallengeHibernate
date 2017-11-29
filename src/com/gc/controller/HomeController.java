package com.gc.controller;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gc.dto.UserDto;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String homepage() {
		return "index";
	}
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {

		ArrayList<UserDto> list = getAllProducts();

		return new ModelAndView("welcome", "message", list);
	}

	@RequestMapping("/getnewprod")
	public String prodFrom() {
		return "addprodform";
	}
	
	@RequestMapping(value= "login", method=RequestMethod.POST)
	public ModelAndView customerLogin(@RequestParam("emailaddress") String emailaddress, @RequestParam("password") String password, Model model) {
	
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		Criteria crit = session.createCriteria(UserDto.class);

		crit.add(Restrictions.eq("emailaddress", emailaddress));

		ArrayList<UserDto> list = (ArrayList<UserDto>) crit.list();
		
		String pageName ="";
		String update ="";
		
		if( !list.isEmpty()) {
			UserDto user = list.get(0);
			update = "Your password didn't match";
			pageName = "index";
			//we still have to check the password
			boolean passwordMatch = BCrypt.checkpw(password, user.getPw_hash());
			if(passwordMatch) {
				pageName = "success";
				model.addAttribute("customername", user.getFullname());
			}
			
		}
		else {
			pageName="register";
			update= "No user found with that email address. Please register.";
			model.addAttribute("enteredEmail", emailaddress);
		}

		tx.commit();
		session.close();
		return new ModelAndView(pageName, "update", update);
	}
	
	
	// this method has been extracted for reusability
	private ArrayList<UserDto> getAllProducts() {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria crit = session.createCriteria(UserDto.class);
		ArrayList<UserDto> list = (ArrayList<UserDto>) crit.list();
		tx.commit();
		session.close();
		return list;
	}

	@RequestMapping(value = "submitform", method = RequestMethod.POST)
	public ModelAndView addNewUser(@RequestParam("customername") String customername, @RequestParam("emailaddress") String emailaddress,
			@RequestParam("password") String password, Model model) {

		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		UserDto newUser = new UserDto(customername, emailaddress, password);
		String pw_hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
		newUser.setPw_hash(pw_hash);	
		session.save(newUser);
		tx.commit();
		session.close();
		

		return new ModelAndView("success", "customername", newUser.getFullname());
	}
/*
	@RequestMapping(value = "searchbyproduct", method = RequestMethod.GET)
	public ModelAndView searchProduct(@RequestParam("product") String prod) {
		Configuration config = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		Criteria crit = session.createCriteria(UserDto.class);

		crit.add(Restrictions.eq("emailaddress", emailaddress));

		ArrayList<UserDto> list = (ArrayList<UserDto>) crit.list();
		tx.commit();
		session.close();

		return new ModelAndView("welcome", "message", list);

	}

	@RequestMapping("/update")
	public ModelAndView updateForm(@RequestParam("id") int id) {

		return new ModelAndView("updateprodform", "productID", id);
	}
	
	@RequestMapping("/updateproduct")
	public ModelAndView updateProduct(@RequestParam("id") int id, @RequestParam("code") String code,
			@RequestParam("description") String desc, @RequestParam("listPrice") double price) {

		// temp Object will store info for the object we want to update
		UserDto temp = new UserDto();
		// by passing in the product id from a hidden field we can determine what row to edit
		temp.setProductID(id);
		temp.setCode(code);
		temp.setDescription(desc);
		temp.setListPrice(price);

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFact = cfg.buildSessionFactory();

		Session codes = sessionFact.openSession();

		codes.beginTransaction();

		codes.update(temp); // update the object from the list

		codes.getTransaction().commit(); // update the row from the database table

		ArrayList<UserDto> userList = getAllUsers();

		return new ModelAndView("welcome", "message", userList);
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteCustomer(@RequestParam("id") int id) {

		// temp Object will store info for the object we want to delete
		UserDto temp = new UserDto();
		temp.setProductID(id);

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sessionFact = cfg.buildSessionFactory();

		Session codes = sessionFact.openSession();

		codes.beginTransaction();

		codes.delete(temp); // delete the object from the list

		codes.getTransaction().commit(); // delete the row from the database table

		ArrayList<UserDto> prodList = getAllProducts();

		return new ModelAndView("welcome", "cList", prodList);
	}
	*/
	

}

