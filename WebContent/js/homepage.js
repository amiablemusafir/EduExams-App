// Get the modal
		var modal = document.getElementById('id01');
		var modal2 = document.getElementById('id02');
		
		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
		    if (event.target == modal) {
		        modal.style.display = "none";
		    }
		}
		
		/*window.onclick = function(event) {
		    if (event.target == modal2) {
		        modal.style.display = "none";
		    }
		}*/
		
		function showLoginForm() {
			$("#login_form").show();
			$("#login_header").show();
			$("#registration_form").hide();
			$("#registration_header").hide();
		}
		
		function showRegistrationForm() {
			$("#registration_form").show();
			$("#registration_header").show();
			$("#login_form").hide();	
			$("#login_header").hide();
		}
		
		function LoginValidation() {
			
			$("#username").html('');
			$("#password").html('');
			
			var username = document.getElementById('istr_login_id').value;
			var password = document.getElementById('istr_password').value;
			
			username = username.trim();
			password = password.trim();
			 
			var randomString = document.getElementById('randomstr').value;
			if (username == '') {
				$("#username").html('Please enter Username');
				return false;
			}
			if (password == '') {
				$("#password").html('Please enter Password');
				return false;
			} else {
			
				var hashPass = calcMD5(password);			
				var concateString = hashPass + randomString;
				
				var finalPassword = calcMD5(concateString);					
				document.getElementById('istr_password').value = finalPassword;
			}	
			return true;	
		}
		
		function StudentValidation() {
		 	 
			 $('#reg_username').html('');
			 $('#reg_emailid').html('');
			 $('#reg_phoneno').html('');
						 
			 var result = '';
			 var pattern = new RegExp(/^[0-9]{1,10}$/);
				 
			 var first_name = document.getElementById('istr_first_name').value;
			 if (first_name == '') {
				$('#reg_username').html('Please Enter Full Name');
				document.getElementById('istr_first_name').focus();

				return false;
			 }				
				
			 var email_id = document.getElementById('istr_email').value;
			 if (email_id == '') {
				$('#reg_emailid').html('Please Enter Email Id');
				document.getElementById('istr_email').focus();

				return false;
			 }
			
			 if (!checkEmail(email_id)) {
				$('#reg_emailid').html('Please Enter valid Email Id');
				document.getElementById('istr_email').focus();

				return false;
			 }
			 
			 var mobile_number = document.getElementById('inum_mobile_number').value;
			 if (mobile_number == '') {
				$('#reg_phoneno').html('Please Enter Mobile Number');
				document.getElementById('inum_mobile_number').focus();

				return false;
			}
			
			if (!isInteger(mobile_number)) {
				$('#reg_phoneno').html('Please Enter valid Mobile Number');
				document.getElementById('inum_mobile_number').focus();
				return false;
			}
			if(mobile_number.length != 10) {
				$('#reg_phoneno').html('Mobile Number should 10 digits');
				document.getElementById('inum_mobile_number').focus();
				return false;
			}	
			
			return true;
		}
		
		function checkEmail(inputvalue) 
		{
		 	var pattern = /^[_\.\!\#\$\%\&\'\*\+\-\/\=\?\^\`\{\|\}\~A-Za-z0-9](([_\.\!\#\$\%\&\'\*\+\-\/\=\?\^\`\{\|\}\~]?[a-zA-Z0-9_\.\!\#\$\%\&\'\*\+\-\/\=\?\^\`\{\|\}\~]+)*)@([a-zA-Z0-9-\s].+\.[a-zA-Z]{2,5})$/;
		 	if (pattern.test(inputvalue)) {
		 		return true;
		 	} else {
		 		return false;
		 	}
		}
		function isInteger(s) {
			var i;
			for (i = 0; i < s.length; i++) {
			var c = s.charAt(i);
			if (((c < "0") || (c > "9")))
				return false;
			}
			return true;
		}