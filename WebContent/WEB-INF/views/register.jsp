<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
	integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
	crossorigin="anonymous">
<link href="resources/style.css" rel="stylesheet" />
<style>

</style>
<title> Register</title>

</head>
<body>
	<section>
		<div class="container form-group">
			<img src="resources/GrandCircusLogo.jpg" />
			<h2>Welcome to the Grand Circus Coffee Shop</h2>
			<p>
					Already have an account? <a href="index.html">Click Here</a> to
					login.
			</p>
			<h2> ${update }</h2>
			<form action="submitform" method="post">
			<input type="text" class="form-control" name="customername" placeholder="Full Name">
			<input type="email" class="form-control" name="emailaddress" placeholder="Email Address" value=${enteredEmail}>
			<input type="password" class="form-control" name="password"  placeholder="Password" id="password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
				required>
			<input type="password" class="form-control" name="re-enterpassword" placeholder="Confirm Password" id="confirm_password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
					required/>
		
			 <input type="submit" class="form-control" value="Create Account" id="buttonactivate" disabled="true"/>
 			</form>
 			<div id="message">
					<h6>Password must contain the following:</h6>
					<p id="letter" class="invalid">
						A <b>lowercase</b> letter
					</p>
					<p id="capital" class="invalid">
						A <b>capital (uppercase)</b> letter
					</p>
					<p id="number" class="invalid">
						A <b>number</b>
					</p>
					<p id="length" class="invalid">
						Minimum <b>8 characters</b>
					</p>
					<p id="match" class="invalid">
						Passwords must match
					</p>
				</div>	
		</div>

	</section>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
	
<script>
var myInput = document.getElementById("password");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");
var match = document.getElementById("match");
var confirmPassword = document.getElementById("confirm_password");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
   // document.getElementById("message").style.display = "flex";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
    //document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
  
  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
  confirmPassword.onkeyup = function() {
	  var pass1 = myInput.value;
	  var pass2 = confirm_password.value;
	  if(pass2){
		  if(pass1 == pass2){
			  match.classList.remove("invalid");
			  match.classList.add("valid");
			  document.getElementById("buttonactivate").disabled = false; 
		  }
	  }
  }
}
</script>

</body>

</html>