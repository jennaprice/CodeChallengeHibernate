<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Code Challenge</title>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
	<link href="resources/style.css" rel="stylesheet" />
  </head>
  <body>
    <section >
      <div class="container">

        <h2> Welcome</h2>
	
    	  <form action="login" method="post" style="display:flex; flex-direction:column" >
    	  		${update }
        <label for="emailaddress">Email Address</label>
	       <input type="text" name="emailaddress">
         <label for="password">Password </label>
         <input type="password" name="password">
         <br />
         <input type="submit" value="Log In" />
         <!--  p>
            Don't have an account? <a href="register.html">Click Here</a> to register.
         </p>-->
       </form>
      </div>

    </section>


  </body>
  <script> 
  	
  </script>
</html>