var contextPath;


function updatePermission() {

	contextPath = document.getElementById('contextPath').value;
	var pnum_role_id = document.getElementById('inum_role_id').value;
	
	//alert("Role ID : "+pnum_role_id);
	
  	var dataToPass = 'SelectMode=permissionName&searchBy=' + pnum_role_id;
	var url = contextPath + "/getRolePermissionMasterDropDown.action?" + dataToPass;
	
	//document.getElementById("submit").disabled = true;
//	alert("URL = "+url);
	ajaxEditFunctionCall(url, 'responsePermission');
}

function updateBatchExamDetails() {

	contextPath = document.getElementById('contextPath').value;
	var inum_batch_id = document.getElementById('onum_slno').value;
	
	//alert("Role ID : "+pnum_role_id);
	
  	var dataToPass = 'SelectMode=examBatchBox&searchBy='+inum_batch_id;
	var url = contextPath + "/getExamBatchMappingDropDown.action?" + dataToPass;
	
	//document.getElementById("submit").disabled = true;
//	alert("URL = "+url);
	ajaxEditFunctionCall(url, 'responsePermission');
}


function checkAvailability(){

	/*if (contextPath == undefined) {
		contextPath = document.getElementById('contextPath').value;
		alert(contextPath);
	}
	*/
	//alert("Context Path is "+contextPath);
	
	   var loginId =  document.getElementById("pstr_login_id").value;
	   
	   if(loginId==""){
		   
		  //  document.getElementById('mess').style.display="none";
			document.getElementById('error').innerHTML = "Please Fill LoginId";
			document.getElementById('pstr_login_id').value="";
			
	    	return false;
		   
	   }
	 
	   // alert("Login Id is "+loginId);
	   
	   var url = "./checkLoginIdAvail.action?loginid="+document.getElementById("pstr_login_id").value;
		
	 //  alert(url);
	   
	   ajaxEditFunctionCall(url, 'responseCheckAvailability');
	
}



var xmlHttp = null;
function ajaxEditFunctionCall(url, responseMethod) {

	var URL = url;
	try {
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("Your browser does not support AJAX!");
				return false;
			}
		}
	}
	xmlHttp.onreadystatechange = window[responseMethod];
	xmlHttp.open("GET", URL, true);
	xmlHttp.send(null);
}


function responsePermission() {
	if (xmlHttp.readyState == 4) {
		
		
		//alert(xmlHttp.responseText);
		
		var array = xmlHttp.responseText.split('^');
		document.getElementById("leftList").innerHTML = array[0];
		document.getElementById("rightList").innerHTML = array[1];

		document.getElementById("leftList").style.display = 'block';
		document.getElementById("rightList").style.display = 'block';
		document.getElementById("listButton").style.display = 'block';
		// document.getElementById("dependentPermission").innerHTML=xmlHttp.responseText;
	}
}


function responseCheckAvailability() {
	if (xmlHttp.readyState == 4) {
		
		if (xmlHttp.responseText == "1") {
			
			//alert("success");
			document.getElementById('info').style.display = "none";
			document.getElementById('error').innerHTML = "Login ID Already Exists, Try Diffrent!";
			document.getElementById('error').style.display = "block";
			document.getElementById('pstr_login_id').value="";
			return false;
		
		} 
		else
		{       if (xmlHttp.responseText == "0"){
				alert("You can take this as login Id!");		
				document.getElementById('error').style.display = "none";
				document.getElementById('info').InnerHTML = "You can take this as login Id!";
				document.getElementById('info').style.display = "block";
						
				return true;
		        }
		}

		
	}
}


function disableCheckErrorDiv(){
	
	document.getElementById('info').style.display = "none";
	document.getElementById('error').style.display = "none";
	
}


function getCountryComboBox(obj, type){
	
	if (contextPath == undefined) {
		contextPath = document.getElementById('contextPath').value;
	//	alert(contextPath);
	}
	var a = obj.value;
//	alert("a = "+a);
	var url = null;
	if(type == "1"){
	//	alert("type 1");
		url = contextPath + "/getStateComboBox.action?countryId="+obj.value;

		  ajaxEditFunctionCall(url, 'responseStateCombo');
		
	}else{
		if(type == "2"){
			
		//	alert("type 2");
			
		//	alert("state id is "+obj.value);

			url = contextPath + "/getDistrictComboBox.action?stateId="+obj.value;

			  ajaxEditFunctionCall(url, 'responseDistrictCombo');
		
		}
		else{
			
			if(type=="3"){
				
			//	alert("3");
				
				url = contextPath + "/getCityComboBox.action?districtId="+obj.value;
				
			//	alert("URL is "+url);

				 ajaxEditFunctionCall(url, 'responseCityCombo');
				
			}
			
		}
	}
	
}






function responseStateCombo(){
	
	if (xmlHttp.readyState == 4) {
	
		document.getElementById('statediv').innerHTML = xmlHttp.responseText;
		
		
	}
}


function responseDistrictCombo(){
	
	if (xmlHttp.readyState == 4) {
	
		document.getElementById('districtdiv').innerHTML = xmlHttp.responseText;
		
	}
	
}


function responseCityCombo(){
	
	if (xmlHttp.readyState == 4) {
	
		document.getElementById('citydiv').innerHTML = xmlHttp.responseText;
		
	}
}


function fileUpload() {
	
//	alert("Hello");
	
	//alert(g);
	
	var x = document.getElementById("pstr_admin_image").value;
	
//	alert("path is "+x);
	//	document.getElementById(fileId).value = x.replace("C:\\AdminUpload\\", '');
	
}

function imageUpload(g, fileId) {
	
	contextPath = document.getElementById('contextPath').value;
	
//	alert(contextPath);
	//alert("image upload");
	
	var x = document.getElementById("pstr_admin_image").value;
	
	var path = contextPath + '/' + x;
	
//	alert(path);
	//var x = document.getElementById(g).value;
	
//	alert(g);
		document.getElementById(fileId).value = path;

}

function cleanDivAll(){
	
   	document.getElementById('info').style.display = "none";
   	document.getElementById('error').style.display = "none";
    
	
}

function checkPassword()
{
//alert("Password");
    // at least one number, one lowercase and one uppercase letter 
    // at least six characters that are letters, numbers or the underscore
   // var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,}$/;
   // var validPassword = re.test(input); 
    var pwd1 = document.getElementById("pstr_password").value;
    
  //  var pwd2 = document.getElementById("pwd2").value;
  
    var userid = document.getElementById("pstr_login_id").value;
    if(pwd1 == userid){
 	   
    	document.getElementById("error").innerHTML = "password should not be same as Login Id";
    	document.getElementById('error').style.display = "block";
		
    //	alert("password should not be same as Login Id");
    //	document.getElementById('info').style.display = "none";
    	document.getElementById("pstr_password").value = "";
 	   return false;
    }
    
   if(re.test(pwd1) && pwd1.length<=10){
    
    	//alert("Valid Password");
		//document.getElementById('error').style.display = "none";
	    document.getElementById("error").innerHTML="Valid Password";
	    document.getElementById('error').style.display = "block";
		
	    return true;
    	
    }else{
    	
    	//alert("Invalid Password");
    	//document.getElementById("res1").innerHTML="";
    	document.getElementById("error").innerHTML = "Invalid Password";
    //	document.getElementById('info').style.display = "none";
    	document.getElementById("pstr_password").value = "";
    	//document.getElementById("pwd1").focus();
    	//document.getElementById("pwd1").focus();
    	return false;
     }  
  }

function confirm(){
	var pwd1 = document.getElementById("pstr_password").value;
    var pwd2 = document.getElementById("confirm_password").value;
  if(pwd1 == pwd2){
	  document.getElementById('error').style.display = "none";
	  document.getElementById("error").innerHTML="Confirm Password";
	  document.getElementById('error').style.display = "block";
	  return true;
  }else{
	  document.getElementById('error').style.display = "none";
	  document.getElementById("error").innerHTML="INValid Password";
	  document.getElementById('error').style.display = "block";
	  document.getElementById("confirm_password").value = "";
  	 // document.getElementById("pwd2").focus();
  	
	  return false;
  } 	

}

function SecurityValidate(){
	var squestion = document.getElementById("secrete_question").value;
	
	if(squestion=='0'){
		//document.getElementById("secure").innerHTML= "select question properly !!! ";
	//	alert("select question properly !!! ");
		return false;
	}
	
	return true;
}

function checkEmail() {
	var email = document.getElementById('pstr_email').value;
	var filter = /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/;
	if (!filter.test(email)) {
    document.getElementById("info").innerHTML="Please provide a valid email address";
// 	alert('Please provide a valid email address');
    document.getElementById('emailid').value = "";
    document.getElementById('emailid').focus;
	return false;
	}
	else{
		document.getElementById("info").innerHTML="Valid Email";
		document.getElementById('error').style.display = "none";
		return true;
	}
	
}


function mobilePhoneValidate()
{
	var mobile_no=document.getElementById("mobile_no").value;
  if(mobile_no=="")
  {
	  document.getElementById("error").innerHTML="Number Field is empty";
	  document.getElementById('error').style.display = "block";
	  document.getElementById("mobile_no").value = "";
	 // document.getElementById("mobile_no").focus;
	  return false;
  }
  
  if(mobile_no.length>10){
	  document.getElementById("error").innerHTML="Number is not correct";
	  document.getElementById('error').style.display = "block";
	  document.getElementById("mobile_no").value = "";
	 // document.getElementById("mobile_no").focus;
	  return false;
  }
  
 
	if (!isInteger(mobile_no)) {
		document.getElementById("error").innerHTML='Please enter a valid mobile number';
		//alert('Please enter a valid mobile number');
		document.getElementById("mobile_no").value = "";
		return false;
	}
}


function phoneValidation(){
	
	var pnum_tel_no=document.getElementById("tel_no").value;
	
	if(pnum_tel_no.length>12){
		  document.getElementById('error').style.display = "none";
		  document.getElementById("info").innerHTML="Number is not correct";
		  document.getElementById("tel_no").value = "";
		  document.getElementById("tel_no").focus;
		  return false;
	  }
	  
	 
		if (!isInteger(pnum_tel_no)) {
			 document.getElementById('error').style.display = "none";
			document.getElementById("info").innerHTML='Please enter a valid phone number';
			//alert('Please enter a valid mobile number');
			document.getElementById("tel_no").value = "";
			return false;
		}
	
}


function faxValidation(){
	
	var fax_no=document.getElementById("fax_no").value;
	
	if(fax_no.length>12){
		  document.getElementById('info').style.display = "none";
		  document.getElementById("error").innerHTML="Number is not correct";
		  document.getElementById("fax_no").value = "";
		  document.getElementById("error").focus;
		  return false;
	  }
	  
	 
		if (!isInteger(fax_no)) {
			 document.getElementById('info').style.display = "none";
			document.getElementById("error").innerHTML='Please enter a valid phone number';
			//alert('Please enter a valid mobile number');
			document.getElementById("fax_no").value = "";
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


function getComboBox(obj, type, callfor) {
	 //alert(callfor);
	if (contextPath == undefined) {
		contextPath = document.getElementById('contextPath').value;
	}
	var x = obj.options[obj.selectedIndex].text;
	
   //alert(x);
   
   //alert(type);
	
	if (type == "1") {
		
			url = contextPath + '/getStateDropDown.action?countryId='
					+ obj.value + '&OptionFor=' + type + '&CallFor=' + callfor;
	
			//alert(url);
			
			ajaxEditFunctionCall(url, 'responseStateCombo');
		
	}
	else{
		
		if(type == "2"){
			
			url = contextPath + '/getDistrictDropDown.action?stateId='
			+ obj.value + '&OptionFor=' + type + '&CallFor=' + callfor;

		//	alert(url);
			
			ajaxEditFunctionCall(url, 'responseDistrictCombo');
			
			
		}
		else{
			if(type == "3"){
				
				url = contextPath + '/getCityDropDown.action?districtId='
				+ obj.value + '&OptionFor=' + type + '&CallFor=' + callfor;

			//	alert(url);
				
				ajaxEditFunctionCall(url, 'responseCityCombo');
			
			}
					
		}	
		
	}
}

function showQuestionWindow()
{

    var no_of_question = document.getElementById("no_of_question").value;
    
    alert(no_of_question);

	if (contextPath == undefined) {
		contextPath = document.getElementById('contextPath').value;
	}

	url = contextPath + '/showQuestionWindowForm.action?questionCount='+document.getElementById("no_of_question").value;

 // alert(url);
  


  ajaxEditFunctionCall(url, 'responseQuestionWindow');
}


function responseQuestionWindow(){
	
	if (xmlHttp.readyState == 4) {
		document.getElementById('questiondiv').innerHTML = xmlHttp.responseText;	
	}
}


function showMoreOption() {
	
	var pstr_option = document.getElementById("pstr_option").value;
	
	//alert("pstr Option is "+pstr_option);
	
	if(pstr_option == ""){
		
		alert('Error: Option can not be null');
		
		document.getElementById('optionError').innerHTML = "Option can not be null";
		
	    return false;	
		
	}
	else{
		
		if (contextPath == undefined) {
			contextPath = document.getElementById('contextPath').value;
		}
		
		url = contextPath + '/oneMoreOptionForm.action?pstr_option='+pstr_option;
		
		  ajaxEditFunctionCall(url, 'responseMoreOption');
				
	}
	
}

function responseMoreOption(){
	
	if (xmlHttp.readyState == 4) {
		document.getElementById('optiondiv').innerHTML = xmlHttp.responseText;	
	}
}

//method for edit option

function editOptionAjax(optionid){

	//alert("--edit function--");
	//alert("optionid ="+optionid);
	//alert("optionname ="+optionname);
		
	if (contextPath == undefined) {
		contextPath = document.getElementById('contextPath').value;
	}
	
	
	url = contextPath + '/editOptionMaster.action?pnum_option_id='+optionid;
		 
   if(optionid==1){
	   
		  ajaxEditFunctionCall(url, 'responseEditprocess1');
   }
   else{
	   if(optionid==2){
		  
		   ajaxEditFunctionCall(url, 'responseEditprocess2');
	   }
	   else{
		   if(optionid==3){
			   
			   ajaxEditFunctionCall(url, 'responseEditprocess3');
		   }
		   else{
			   if(optionid==4){
					   
					   ajaxEditFunctionCall(url, 'responseEditprocess4');
				}   
			   else{
				   if(optionid==5){
						   
						   ajaxEditFunctionCall(url, 'responseEditprocess5');
					}  
				   else{
					   if(optionid==6){
							   
							   ajaxEditFunctionCall(url, 'responseEditprocess6');
						}
					   else{
						   if(optionid==7){
								   
								   ajaxEditFunctionCall(url, 'responseEditprocess7');
							}
						   else{
							   if(optionid==8){
									   
									   ajaxEditFunctionCall(url, 'responseEditprocess8');
								}  
							   else{
								   if(optionid==9){
										   
										   ajaxEditFunctionCall(url, 'responseEditprocess9');
									}  
								   
							   }
						   }
					   }
				   }
			  }
		   }
	   }
     }
       
	
	
}


function responseEditprocess1(){
	
	if(xmlHttp.readyState==4){
	//	alert("response 1");
        document.getElementById("editoptiondiv1").innerHTML=xmlHttp.responseText;
}
	
}

function responseEditprocess2(){
	
	if(xmlHttp.readyState==4){
		
	//	alert("response 2");
        document.getElementById("editoptiondiv2").innerHTML=xmlHttp.responseText;
}
	
}

function responseEditprocess3(){
	
	if(xmlHttp.readyState==4){
		
		//alert("response 3");
        document.getElementById("editoptiondiv3").innerHTML=xmlHttp.responseText;
}
	
}

function responseEditprocess4(){
	
	if(xmlHttp.readyState==4){
		
		//alert("response 3");
        document.getElementById("editoptiondiv4").innerHTML=xmlHttp.responseText;
}
	
}

function responseEditprocess5(){
	
	if(xmlHttp.readyState==4){
		
		//alert("response 3");
        document.getElementById("editoptiondiv5").innerHTML=xmlHttp.responseText;
}
	
}

function responseEditprocess6(){
	
	if(xmlHttp.readyState==4){
		
		//alert("response 3");
        document.getElementById("editoptiondiv6").innerHTML=xmlHttp.responseText;
}
	
}

function responseEditprocess7(){
	
	if(xmlHttp.readyState==4){
		
		//alert("response 3");
        document.getElementById("editoptiondiv7").innerHTML=xmlHttp.responseText;
}
	
}

function responseEditprocess8(){
	
	if(xmlHttp.readyState==4){
		
		//alert("response 3");
        document.getElementById("editoptiondiv8").innerHTML=xmlHttp.responseText;
}
	
}

function responseEditprocess9(){
	
	if(xmlHttp.readyState==4){
		
		//alert("response 3");
        document.getElementById("editoptiondiv9").innerHTML=xmlHttp.responseText;
}
	
}


//update option ajax method

function updateOptionAjax(updateoptionid){
	
	//alert("Update method call");
	
	//alert("updateoptionid = "+updateoptionid);
	
    var optionname = document.getElementById("pstr_option").value;

    alert(optionname);
    
    if(optionname == ""){
    	
    	alert("Error : Option can not be null");
    	
    	return false;
    }
    else{
    	
    	if (contextPath == undefined) {
    		contextPath = document.getElementById('contextPath').value;
    	}
    	
    	
    	url = contextPath + "/updateOptionMaster.action?optionid="+updateoptionid+"&optionname="+optionname;

    	
    	  if(updateoptionid==1){ // 1st
    		  
    		  ajaxEditFunctionCall(url, 'updateprocess1');
    		  
    	  }
    	  else{
    		  if(updateoptionid==2){ // 2nd
    			
    			 ajaxEditFunctionCall(url, 'updateprocess2');
    			   
    		  }
    		  else{
    			  if(updateoptionid==3){ // 3rd
    				  	  
    				  ajaxEditFunctionCall(url, 'updateprocess3');
    	
    			  }
    			  else{
    				  if(updateoptionid==4){ // 4th
    				  	  
        				  ajaxEditFunctionCall(url, 'updateprocess4');
        	
        			  }
    				  else{
    					  if(updateoptionid==5){ //5th
        				  	  
    	    				  ajaxEditFunctionCall(url, 'updateprocess5');
    	    	
    	    			  }
    					  else{
    						  if(updateoptionid==6){  // 6th
            				  	  
        	    				  ajaxEditFunctionCall(url, 'updateprocess6');
        	    	
        	    			  }
    						  else{
    							  if(updateoptionid==7){  //7th
                				  	  
            	    				  ajaxEditFunctionCall(url, 'updateprocess7');
            	    	
            	    			  }  
    							  else{
    								  if(updateoptionid==8){  //8th
    	            				  	  
    	        	    				  ajaxEditFunctionCall(url, 'updateprocess8');
    	        	    	
    	        	    			  } 
    								  else{
    									  if(updateoptionid==9){ // 9th
    		            				  	  
    		        	    				  ajaxEditFunctionCall(url, 'updateprocess9');
    		        	    	
    		        	    			  } } } } }	} } } } 
    	  }
}

function updateprocess1(){
	
	if(xmlHttp.readyState==4){
	//	alert("update1");
        document.getElementById("updateoptiondiv1").innerHTML=xmlHttp.responseText;
}
	
}

function updateprocess2(){
	
	if(xmlHttp.readyState==4){
		//alert("update2");
        document.getElementById("updateoptiondiv2").innerHTML=xmlHttp.responseText;
}
	
}

function updateprocess3(){
	
	if(xmlHttp.readyState==4){
		//alert("update3");
        document.getElementById("updateoptiondiv3").innerHTML=xmlHttp.responseText;
}
	
}

function updateprocess4(){
	if(xmlHttp.readyState==4){
        document.getElementById("updateoptiondiv4").innerHTML=xmlHttp.responseText;
	}
}

function updateprocess5(){
	if(xmlHttp.readyState==4){
        document.getElementById("updateoptiondiv5").innerHTML=xmlHttp.responseText;
	}
}

function updateprocess6(){
	if(xmlHttp.readyState==4){
        document.getElementById("updateoptiondiv6").innerHTML=xmlHttp.responseText;
	}
}

function updateprocess7(){
	if(xmlHttp.readyState==4){
        document.getElementById("updateoptiondiv7").innerHTML=xmlHttp.responseText;
	}
}

function updateprocess8(){
	if(xmlHttp.readyState==4){
        document.getElementById("updateoptiondiv8").innerHTML=xmlHttp.responseText;
	}
}

function updateprocess9(){
	if(xmlHttp.readyState==4){
        document.getElementById("updateoptiondiv9").innerHTML=xmlHttp.responseText;
	}
}



//Ajax function is used during selection of filter
function filterationAjaxCall(){
	 //alert("hello");
	 var filter_id = document.getElementById("filterby").value;
	 
	   //alert("select filter_id = "+filter_id);
	   
	   if (contextPath == undefined) {
			contextPath = document.getElementById('contextPath').value;
		}
		
	   if(filter_id == 1){
		   
		// alert("Category Select");
			
			url = contextPath + "/showFilterChoice.action?filter_id="+filter_id;
		
   		    ajaxEditFunctionCall(url, 'responsefilter');
   
	   }
	   else{
		   if(filter_id == 2){
			   
			   // alert("Gender Based");

			    document.getElementById('question_type').value = "Gender Based";
				
			    document.getElementById('pstr_filter_by').value = "Gender Based";
			   
			    document.getElementById('category_id').value = "1";

			    //4
				   document.getElementById('sub_category_id').value = "";
				   
				   //5
				   document.getElementById('mla_id').value = "";
				   
				   //6
				   document.getElementById('mp_id').value = "";

			    
				url = contextPath + "/showFilterChoice.action?filter_id="+filter_id;

			    ajaxEditFunctionCall(url, 'responsefilter');
			   
			   
		   }
		   else{
			   if(filter_id == 3){
				   
				   //alert("General");
				   document.getElementById('filterdiv').innerHTML =" ";
				   //1
				   document.getElementById('question_type').value = "general question";
					//alert("1");
				   //2
				   document.getElementById('pstr_filter_by').value = "General";
				   //alert("2");
				   //3
				   document.getElementById('category_id').value = "1";
				   //alert("3");
				   //4
				   document.getElementById('sub_category_id').value = "";
				   //alert("4");
				   //5
				   document.getElementById('mla_id').value = "";
				   //alert("5");
				   //6
				   document.getElementById('mp_id').value = "";
				  // alert("6");
				   //7
				   document.getElementById('pstr_gender').value = "";
				   
				   document.getElementById('subcategorydiv').innerHTML = "";
				   
				   document.getElementById('mladiv').innerHTML = "";

				  
				   
				   document.getElementById('filterdiv').removeChild(oldChild);
			   }   			 
		   }
	   }
	   
			
}

function responsefilter(){
	 
	 if(xmlHttp.readyState==4){
        document.getElementById("filterdiv").innerHTML=xmlHttp.responseText;
}
}


function constituencyAjaxCall(category_id){
	
//	alert("category_id is "+category_id);
	
	
	   if (contextPath == undefined) {
			contextPath = document.getElementById('contextPath').value;
		}
	   
	//   alert("Hello");
		
	  if(category_id==1){

		   //1
		   document.getElementById('question_type').value = "general question ";
			
		   //2
		   document.getElementById('pstr_filter_by').value = "General";
			
		   //3
		   document.getElementById('category_id').value = "1";
		   
		   //4
		   document.getElementById('sub_category_id').value = "";
		   
		   //5
		   document.getElementById('mla_id').value = "";
		   
		   //6
		   document.getElementById('mp_id').value = "";
		   
		   //7
		   document.getElementById('pstr_gender').value = "";
	
		  // alert("General");
		   
		   document.getElementById('subcategorydiv').innerHTML = "";
		   
		   document.getElementById('mladiv').innerHTML = "";
		   
		return false;
		   
	  } 
	  else{
		
		  if(category_id==2){
			  		   
			   document.getElementById('question_type').value = "political question ";
				
			   document.getElementById('pstr_filter_by').value = "Politics";
			   
			   document.getElementById('category_id').value = category_id;

			   document.getElementById('sub_category_id').value = "";
			   
			   document.getElementById('pstr_gender').value = "";
			   
			  // alert("Politics");
			   
			   document.getElementById('subcategorydiv').innerHTML = "";
		   
				url = contextPath + "/showConstituencytChoice.action?category_id="+category_id;
				
				  ajaxEditFunctionCall(url, 'responseConstituency');
 
		   }
		   else{
			   
			//   alert("For Sub Category");
			   
			   //1
			   document.getElementById('question_type').value = "";
				
			   //2
			   document.getElementById('pstr_filter_by').value = "";
				  
			   //5
			   document.getElementById('mla_id').value = "";
			   
			   //6
			   document.getElementById('mp_id').value = "";
			   
			   //7
			   document.getElementById('pstr_gender').value = "";
		
			   
			   document.getElementById('category_id').value = category_id;
			   
			   url = contextPath + "/showSubCategoryChoice.action?category_id="+category_id;
			   
			  // alert("Category");

			   document.getElementById('mladiv').innerHTML = "";
			   
			   ajaxEditFunctionCall(url, 'responseSubCategory');
		   }

		  
	  }
	   
	  	   
	
}

function responseConstituency(){
	 if(xmlHttp.readyState==4){
		 
		// alert("hello ");
	        document.getElementById("mladiv").innerHTML=xmlHttp.responseText;
	}
}

function responseSubCategory(){
	 if(xmlHttp.readyState==4){
		 
	        document.getElementById("subcategorydiv").innerHTML=xmlHttp.responseText;
	}
}


function getSubCategoryComboBox(obj){
	
//	alert("SUB CATEGORY");
	
	if (contextPath == undefined) {
		contextPath = document.getElementById('contextPath').value;
		
	}
	var url = null;
	
		url = contextPath + "/getSubCategoryboBox.action?CategoryId="+obj.value;

		  ajaxEditFunctionCall(url, 'responseSubCategoryCombo');
	
}

function responseSubCategoryCombo(){
	
	if (xmlHttp.readyState == 4) {
	    
		document.getElementById('subCategorydiv').innerHTML = xmlHttp.responseText;
			
	}
}	


function setSubCategoryValue(sub_category_id){
	
//	alert("sub category id is "+sub_category_id);
	
	 document.getElementById('sub_category_id').value = sub_category_id;
	
	 
}


function setMlaConstituencyValue(obj){
	
//	alert("MLA id is"+obj);
	
	 document.getElementById('mla_id').value = obj;
	// document.getElementById('mp_id').value = "";
}


function setMpConstituencyValue(obj){
	
//	alert("MP id is "+obj);
//	document.getElementById('mla_id').value = "";
	document.getElementById('mp_id').value = obj;
}


function setGenderChoice(obj){
	
//	alert("Gender is "+obj);
	
	document.getElementById('pstr_gender').value = obj;
}


function saveQuestionDetail(total_question, flag){
	
	//alert("Flag is "+flag);
	
	//alert("Total question is "+total_question);
		 
   var pnum_company_id = document.getElementById("pnum_company_id").value;
	    
	  //  alert("pnum_company_id is "+pnum_company_id);
	    
   var a = document.getElementById("pstr_gender").value;
   //alert("Gender is "+a);
   var b = document.getElementById("category_id").value;
  // alert("category id is "+b);
   var c = document.getElementById("sub_category_id").value;
   //alert("Sub category id is "+c);
   var d = document.getElementById("mla_id").value;
   //alert("mla id is "+d);
   var e = document.getElementById("mp_id").value;
   //alert("Mp id is "+e);
  // var f = document.getElementById("pstr_question_type").value;
   //alert("question type is "+f);
   var g = document.getElementById("pstr_filter_by").value;
   //alert("filter id is "+g);
   var h = document.getElementById("pstr_option").value;
   //alert("filter id is "+h);
   var qus = document.getElementById("pstr_question_name").value;
   //alert("question name is "+qus);
   var htime = document.getElementById("hourtime").value;
	var stime = document.getElementById("sectime").value;
	var valid_hour = document.getElementById("hour_valid_time").value;
	var valid_sec = document.getElementById("sec_valid_time").value;
	
	var publish_time = htime + ':' + stime + ':00';
	
	//alert("publish_time is = "+publish_time);
	
    var valid_time = valid_hour + ":" + valid_sec + ":00";  
   
    //alert("Valid time is "+valid_time);
    
 
  //  alert("counter is "+saveQuestionDetail.counter);
    
  // alert("Total question is "+total_question);
    
    var qus_des_type = document.getElementById("question_type").value;
   // alert("Question Description type is "+qus_des_type);
    
    var newfilterby = document.getElementById("filterby").value;
    
    if(qus == "" || h == "" || pnum_company_id == "0" || newfilterby=="0" || htime == "none" || stime == "none" || valid_hour == "none" || valid_sec == "none"){
    	
    	alert("Error: Any Field Can not be null");
    	return false;
    }
    else
    {
    	
    	if (saveQuestionDetail.counter == undefined)
 		{
 		 saveQuestionDetail.counter = 0;
 		}
 	      saveQuestionDetail.counter++;
 	
   
    	 if(total_question==saveQuestionDetail.counter){
    	     	
    	   	//alert("Final Process");
    	    	
    	    	//alert("Last URL");
    	    	
    		 
    		 
    	    	url = "./lastQuestionDetails.action?qus="+qus+"&option="+h+"&qtype=General&gender="+a+"" +
    	 	    "&categoryid="+b+"&sub_cat_id="+c+"&mlaId="+d+"&mpId="+e+"&filter_by="+g+"&publish_time="+publish_time+"" +
    	 	   	"&valid_time="+valid_time+"&company_id="+pnum_company_id+"&main_qus_type="+qus_des_type;
    	 	
    	    	
    	    	//alert("url::"+url); 
    	   	      //window.location.href = url;
    	 
    	    	ajaxEditFunctionCall(url, 'lastquestionresponse');
    	    }
    	    else{
    	    	
    	    	//alert("Continue...");
    	    	 
    	 	    url = "./insertQuestionDetails.action?qus="+qus+"&option="+h+"&qtype=General&gender="+a+" " +
    	 	    "&categoryid="+b+"&sub_cat_id="+c+"&mlaId="+d+"&mpId="+e+"&filter_by="+g+"&publish_time="+publish_time+" " +
    	 	   	"&valid_time="+valid_time+"&company_id="+pnum_company_id+"&main_qus_type="+qus_des_type;
    	 	   
    	 	   //alert("URL"+url);
    	 		
    	 	   ajaxEditFunctionCall(url, 'responseQuestionPage');
    	 			
    	    }	
    }	
}

function displayResult(thevalue) {
//	alert("Hello");
    var x=document.getElementById(thevalue).value;
  //  alert(x);
}

function responseQuestionPage(){
	 if(xmlHttp.readyState==4){
		 
	//	 alert("data ");
	        document.getElementById("data").innerHTML=xmlHttp.responseText;
	}
}
function lastquestionresponse(){
	 if(xmlHttp.readyState==4){
		 
	//	 alert("data ");
		 url="./showQuestionCreationForm.action";
		 window.location.href = url;
	       // document.getElementById("questionsection").innerHTML=xmlHttp.responseText;
	}
}

function editSaveQuestion(type){
	
//alert("Type is "+type);

	var communication_id = document.getElementById("communication_id").value;
	//alert(communication_id);
	var question_id = document.getElementById("question_id").value;
	//alert(question_id);
    var url = null;
	
	 if(type='4'){
		 
		 //alrt("type4");
		 url = "./saveEditQuestion.action";
			
			//alert("URL is "+url);
			
		 ajaxEditFunctionCall(url, 'responsesaveQuestionFromTemp');	
		 
	 }
}

function editAdminQuestion(type){
	
	//alert("Type is "+type);

		var communication_id = document.getElementById("communication_id").value;
		//alert(communication_id);
		var question_id = document.getElementById("question_id").value;
		//alert(question_id);
	    var url = null;
		
		 if(type='4'){
			 
			 //alrt("type4");
			 url = "./saveAdminEditQuestion.action";
				
				//alert("URL is "+url);
				
			 ajaxEditFunctionCall(url, 'editresponse');	
			 
		 }
	}

function editresponse() {
	//alert("close this");
	if (xmlHttp.readyState == 4) {
		//if (xmlHttp.responseText == "2") 
			//alert("Password has been send to User Successfully");
		parent.jQuery.fancybox.close();
		 document.getElementById('showdiv').innerHTML=xmlHttp.responseText;
		 
			//return true;

	}

}


function filterationChangeStatus(){
	
	
alert("hello1");
var fromDate = document.getElementByNmae("pdt_entry_date");
alert(fromdate);
var endDate = document.getElementById("entry_date1").value;
alert(endDate);
		var communication_id = document.getElementById("filterby").value;
		alert(communication_id);
		
	    var url = null;
		
		
			 
			alrt("type4");
			 url = "./chngeStatus.action";
				
				//alert("URL is "+url);
				
			
			 
		 
	}

function saveOrRejectQuestion(type){//1  
	
	//alert("Type is "+type);

	var communication_id = document.getElementById("communication_id").value;
	//alert(communication_id);
	var question_id = document.getElementById("question_id").value;
	//alert(question_id);
    var url = null;

	/*if (contextPath == undefined) {
		contextPath = document.getElementById('contextPath').value;
		alert(contextPath);
	}*/
   
    
    
    
	if(type == '1'){//2
		
  //alert("communication_id is "+communication_id);
 //alert("question_id is "+question_id);
	
	url =  "./saveQuestionFromTemp.action?com_id="+communication_id+"&qus_id="+question_id;
	   
//	alert("url::"+url); 
	
	ajaxEditFunctionCall(url, 'responsesaveQuestionFromTemp');	
   
	}//2
	else{//3
		if(type == 2){//4
			
		//alert("Type is  for"+type);
			
		url = "./showCommentForRejectQus.action";
		
		//alert("URL is "+url);
		
		 ajaxEditFunctionCall(url, 'responseForComments');
	 		
		 
		
		}//4
		else{//5
		 if(type == 3){//6
			 
		//	 alert("Hello");
			 	
			 var comment =  document.getElementById("reject_comment").value; 
			// alert("comment is "+comment);
			 if(comment==""){//7
				 
				 document.getElementById("info").innerHTML = "Comment field is mandatory";
				 
			 }//7
			 else{//8
			
				// alert("communication_id is "+communication_id);
				// alert("question_id is "+question_id);
                  
					url =  "./rejectQuestionDetails.action?com_id="+communication_id+"&qus_id="+question_id+"&comment="+comment;
                       
					ajaxEditFunctionCall(url, 'responsesaveQuestionFromTemp');	
					
			 }//8
			
			 
				
			 
		 }//6	
		
		
			
		}//5
		
		
		
	}//3
	
}//1

function responsesaveQuestionFromTemp() {
	//alert("close this");
	if (xmlHttp.readyState == 4) {
		//if (xmlHttp.responseText == "2") 
			//alert("Password has been send to User Successfully");
		parent.jQuery.fancybox.close();
		 document.getElementById('quesave').innerHTML=xmlHttp.responseText;
		 
			//return true;

	}

}


function colsefancyBox() {
alert("close this");
if (xmlHttp.readyState == 4) {
	if (xmlHttp.responseText == "2") 
		alert("Password has been send to User Successfully");
		 parent.jQuery.fancybox.close(); 
		return true;

}
}

function responseForComments(){
	 if(xmlHttp.readyState==4){
		 
		 var array = xmlHttp.responseText.split('^');
			document.getElementById("comment").innerHTML = array[0];
			document.getElementById("buttondiv").innerHTML = array[1];

	}
}

function changePassValidation() {
	
	var pstr_Password = document.getElementById('pstr_Password').value;
	var confirm_Password = document.getElementById('confirm_Password').value;
	/*var secret_question = document.getElementById('secret_question').value;
	var pstr_Answer = document.getElementById('pstr_Answer').value;*/
	var iChars = "<>[]{}%";
	var iCharsAnswer = "*|,\":<>[]{}`\';()@&$#%";
	/*if (document.userinfo.checkbox1.checked == false && document.userinfo.checkbox2.checked == false) {
		//alert("Please select atleast one checkbox");
		document.getElementById('errors').innerHTML="*Please select atleast one checkbox";

		return false;
	}*/
	
	/*if (document.userinfo.checkbox1.checked == true) {*/
		if (pstr_Password == '') {
			//alert("Please enter Password");
			document.getElementById('pass-error').innerHTML="*Required Field can not be null";
			

			return false;
		}
		else {
			/*var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,}$/;
			   
			   if(re.test(pstr_Password)){
				   
			   }           
			   else {
				//alert('Error: Your password should contain atleast 1 Capital Letter, 1 lower letter, 1 special character, 1 numeric and length should be minimum 6 characters');
				   document.getElementById('pass-error').innerHTML="* minimum 6 characters";
				return false;
			}*/
		}
		if (confirm_Password == '') {
			
			//alert("Please enter ConfirmPassword");
			document.getElementById('divCheckPasswordMatch').innerHTML="*Required Field can not be null";
			return false;
		}
		if (confirm_Password !=pstr_Password) {
			
			//alert("Confirm password is not same as password");
			
			document.getElementById('divCheckPasswordMatch').innerHTML="Confirm password is not same as password";
			return false;
		}
		
		
		
	/*
	if (document.userinfo.checkbox2.checked == true) {
		if (secret_question == '0') {
			//alert("Please Select Secret Question");
			document.getElementById('srt-error').innerHTML="Select Secret Question";
			return false;
		}
		if (pstr_Answer == '') {
			//alert("Please Enter your answer");
			document.getElementById('que-error').innerHTML="*Required Field can not be null";
			return false;
		   }
		
		}*/
	
//	alert(true);
	return true;
}


function checkPasswordMatch() {
	var pstr_Password = document.getElementById('pstr_Password').value;
	var confirm_Password = document.getElementById('confirm_Password').value;
	if(confirm_Password !=null & confirm_Password !="")
   {
    if (pstr_Password != confirm_Password)
        $("#divCheckPasswordMatch").html("Passwords do not match!");
    else
        $("#divCheckPasswordMatch").html("Passwords match.");
}
	else
		{
		$("#divCheckPasswordMatch").html("* Required Field can not be null");
		}
}

function sendforgetPasswordDetails() {
	
	  var login_id =	document.getElementById("pstr_login_id").value;
	  var sec_question = document.getElementById("secret_question").value;
	  var answer = document.getElementById("answer").value;
		
	//alert("Login id is "+login_id);
//	alert("Secret Question is "+sec_question);
	//alert("Answer is "+answer);


	if(login_id == ""){
		
		
		alert("Error : Login Id can not be null");
		document.getElementById("pstr_login_id").value = "";
		document.getElementById("secret_question").value = "0";
		document.getElementById("answer").value = "";
		
		
		return false;
		
	}
	else{
		if(sec_question == "0"){
			
			alert("Error : Security question can not be null");
			document.getElementById("pstr_login_id").value = "";
			document.getElementById("secret_question").value = "0";
			document.getElementById("answer").value = "";
			
			
			return false;
			
		}
		else{
			if(answer == ""){
				
				alert("Error : Answer can not be null");
				document.getElementById("pstr_login_id").value = "";
				document.getElementById("secret_question").value = "0";
				document.getElementById("answer").value = "";
					
				return false;
				
			}
			else{
				
				var url = "./sendForgotPassword.action?loginId="+login_id+"&sec_question="+sec_question+"&answer="+answer;

				ajaxEditFunctionCall(url, 'sendForgetPasswordResponse');	
				
			}
			
		}
	}
	
	
		}


	function sendForgetPasswordResponse() {

		if (xmlHttp.readyState == 4) {
			if (xmlHttp.responseText == "0") {
				alert("Password has been send to User Successfully");
				parent.jQuery.fancybox.close();
				return true;
			} 
			else 
			{
				if(xmlHttp.responseText == "1"){
					
					alert("Combinations are incorrect, Try Again");
					document.getElementById("pstr_login_id").value = "";
					document.getElementById("secret_question").value = "0";
					document.getElementById("answer").value = "";
						
					return false;
				}
				else{
					if(xmlHttp.responseText == "2"){
					
						alert("Please Fill all field values, Try Again");
						document.getElementById("pstr_login_id").value = "";
						document.getElementById("secret_question").value = "0";
						document.getElementById("answer").value = "";
					 
						
					}
				}
			
			}

		}

	}

	
	function forgetResetButton(){
		
		document.getElementById("pstr_login_id").value = "";
		document.getElementById("secret_question").value = "0";
		document.getElementById("answer").value = "";
		
		
	}
	
	
	function makeComboBoxDisable(){
		 var x=document.getElementById("no_of_question");
	     x.disabled=true; 
	     
		}
	

function roleMasterValidation(){
	
	var pstr_role_name = document.getElementById("pstr_role_name").value;
	var pstr_role_desc = document.getElementById("pstr_role_desc").value;
	
	
	if(pstr_role_name == '')
	{
		
		//alert('Error: Role Name can not be null'); 
		 document.getElementById('errors').innerHTML="* Required Field can not be null";
		 document.getElementById("pstr_role_name").focus();
		 return false;
	 }
	else
		{
		 
		document.getElementById('errors').innerHTML="  ";
		document.getElementById("pstr_role_desc").focus();
		
		}
	
		
	
	
	if(pstr_role_desc == ''){
		
		//alert('Error: Role Description can not be null');
		 document.getElementById('errors2').innerHTML="*Required Filed can not be null";
		return false;
	}
	else
	{
	 
	document.getElementById('errors2').innerHTML="  ";
	//document.getElementById("pstr_role_desc").focus();
	
	}
	
	if(document.getElementById("pstr_role_desc").value.length > 50)
		{
		
		 // alert("not valid");
		  document.getElementById('errors2').innerHTML="*Maximum length is 50 characters";
		  document.getElementById("pstr_role_desc").focus();
		  
		 return false;
		}
		
	
	return true;
}
	

function permissionValidation() 
{
	var pstr_permission_name =  document.getElementById("pstr_permission_name").value;
	
    var pstr_permission_desc =  document.getElementById("pstr_permission_desc").value;
    
    if(pstr_permission_name == ''){
    	
    	//alert('Error: Permission Name can not be null');
    	document.getElementById('errors').innerHTML="* Required Field can not be null";
    	return false;
    }
    
    if(pstr_permission_desc == ''){
    	
    	//alert('Error: Permission Description can not be null');
    	document.getElementById('errors2').innerHTML="* Required Field can not be null";
    	return false;
    }
    if(document.getElementById("pstr_permission_desc").value.length > 50)
	{
	
	 // alert("not valid");
	  document.getElementById('errors2').innerHTML="*Maximum length is 50 characters";
	  
	  document.getElementById("pstr_permission_desc").focus();
	  
	 return false;
	}
    
    return true;
}


function rolePermissionvalidation(){
	
   var pnum_role_id = document.getElementById("pnum_role_id").value;
	
   if(pnum_role_id == 0){
	   
	  // alert('Error: Atleast one role should be selected');
	   document.getElementById('errors').innerHTML="*Atleast one role should be selected";
	   
	   return false;
   } 
   
   return true;
		
}


function profileUpdateValidation(){
	
	var user_name = document.getElementById("user_name").value;
    var pstr_email = document.getElementById("pstr_email").value;
	var pstr_designation = document.getElementById("pstr_designation").value;
	var mobile_no = document.getElementById("mobile_no").value;
	var fax_no = document.getElementById("fax_no").value;
	var tel_no = document.getElementById("tel_no").value;
	
	var filter = /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/;
	
	
	if(user_name == ''){
		
		alert('Error: User Name can not be null');
	
		return false;
	}
	else{
	
	if(!filter.test(pstr_email)) {
    
    alert('Error: Please provide a valid email address');
    
    return false;
	}
	else{
	
		if(pstr_designation == ''){
			
			alert("Error: Designation can not be null");
		
			return false;
		}
		
	 }
	}
	
	
	if(mobile_no.length>10){
		
		alert('Error: Mobile No can not be greater than 10 digit');
		return false;
	}
}

function registrationValidation()
{
	
	var pstr_login_id = document.getElementById('pstr_login_id').value;
	if(pstr_login_id == '') {

		
		//alert('Error: Login Id can not be null');
		document.getElementById('errors').innerHTML="* Required Field can not be null";
		return false;
	}
	
	
	var pstr_Password = document.getElementById('pstr_password').value;
	
	if(pstr_Password == '') {
		
       // alert('Error: Password can not be null');
		document.getElementById('errors').innerHTML="* Required Field can not be null";
		
		return false;
	}
	
	
		/*if (pstr_Password == pstr_login_id) {
	
			alert('Error: Your password should contain atleast 1 Capital Letter, 1 lower letter, 1 numeric, length should be minimum 6 characters and should not be same as Login Id ');
			
			return false;
		}*/

	var confirm_Password = document.getElementById('confirm_password').value;
	
	if (confirm_Password == '') {
	
         
		//alert('Error: Confirmation Password can not be null');
		document.getElementById('errors').innerHTML="* Required Field can not be null";
		
		return false;
	}
	
	if (pstr_Password != confirm_Password) {
	
     //alert('Error: Confirmation Password should be same as password');
		document.getElementById('errors').innerHTML="*Required Field can not be null";
		return false;
	}

	var secret_question = document.getElementById('secrete_question').value;
	
	if (secret_question == '0') {
	
		//alert('Error: Please select Security Question');
		document.getElementById('errors').innerHTML="* Required Field can not be null";
		return false;
	}
	
	
	var pstr_Answer = document.getElementById('pstr_answer').value;
	
	if (pstr_Answer == '') {
	
       // alert('Error: Answer should not be blank');
		document.getElementById('errors').innerHTML="* Required Field can not be null";
		return false;
	}
	
	var pnum_mobile_no1 = document.getElementById('mobile_no').value;
	if (pnum_mobile_no1 == '') {
		//alert('Error: Mobile Number can not be blank');
		
		document.getElementById('errors').innerHTML="* Required Field can not be null";
		return false;
	}
	if (!isInteger(pnum_mobile_no1)) {
		//alert('Error: Please enter a valid mobile number');
		document.getElementById('errors').innerHTML="* Required Field can not be null";
		return false;
	}
	
	

	var pstr_email = document.getElementById('pstr_email').value;
	
	if (pstr_email == '') {
	
	   //alert('Error: Email should not be blank.');
		document.getElementById('errors').innerHTML="* Required Field can not be null";
		return false;
	}
	
	var filter = /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/;
	
	if(!filter.test(pstr_email)) {
	    
	    //alert('Error: Please provide a valid email address');
		document.getElementById('errors').innerHTML="*Invalid email address";
	    return false;
		}
	
	return true;
}

function categoryMasterValidation(){
	
    var category_name = document.getElementById("pstr_category_name").value;
    
    var category_desc = document.getElementById("pstr_category_desc").value;
	
    if(category_name == ""){
    	
    	document.getElementById('cat_error').innerHTML="*Required Field can not be null";
		return false;
    	
    }
    
    if(category_desc == ""){
    	
    	document.getElementById('cat_error1').innerHTML="*Required Field can not be null";
		return false;
    	
    }
    return true;
}

function subCategoryValidation(){
	
    var category_id = document.getElementById("pnum_category_id").value;
    
    var sub_category_name = document.getElementById("pstr_sub_category_name").value;
    
    var sub_category_desc = document.getElementById("pstr_sub_category_desc").value;
	
	if(category_id == "0"){
		
		//alert('Error: Category can not be null');
		
		document.getElementById('cat_error').innerHTML="*Required Field can not be null";
		return false;
		
	}
    
	if(sub_category_name == ""){
		
		document.getElementById('cat_error1').innerHTML="*Required Field can not be null";
		return false;
		
		
	}
    
	if(sub_category_desc == ""){
		
		document.getElementById('cat_error2').innerHTML="*Required Field can not be null";
		return false;
		
	}
return true;	
}

function mlaValidation(){
	
  var country_id = document.getElementById("pnum_country_id").value;
  var state_id = document.getElementById("pnum_state_id").value;
  var district_id = document.getElementById("pnum_district_id").value;
  var city_id = document.getElementById("pnum_city_id").value;
  var mla_name = document.getElementById("pstr_mp_name").value;
  
 if(country_id == "0"){
	 
	//alert('Error: Country can not be null');
	 document.getElementById('mla_error').innerHTML="*Required Field can not be null";
	return false;
	 
 } 
 if(state_id == "0"){
	 
	 //alert('Error: State can not be null');
	 document.getElementById('mla_error1').innerHTML="*Required Field can not be null";
	 return false;
 }
 if(district_id == "0"){
	 
	 document.getElementById('mla_error2').innerHTML="*Required Field can not be null";
	 return false;
	 
 }
 if(city_id == "0"){
	 
	// alert('Error: City can not be null');
	 document.getElementById('mla_error3').innerHTML="*Required Field can not be null";
	 return false;
	 
 }
 if(mla_name == ""){
	
	// alert('Error: MLA Name can not be null');
	 document.getElementById('mala_error4').innerHTML="*Required Field can not be null";
	 return false;
	 
 }
 
 return true;
}


function mpValidation(){
	
	  var country_id = document.getElementById("pnum_country_id").value;
	  var state_id = document.getElementById("pnum_state_id").value;
	  var district_id = document.getElementById("pnum_district_id").value;
	  var city_id = document.getElementById("pnum_city_id").value;
	  var mp_name = document.getElementById("pstr_mla_mp_name").value;
	  
	 if(country_id == "0"){
		 
		//alert('Error: Country can not be null');
		 document.getElementById('mp_error').innerHTML="*Required Field can not be null";
		return false;
		 
	 } 
	 if(state_id == "0"){
		 
		 //alert('Error: State can not be null');
		 document.getElementById('mp_error1').innerHTML="*Required Field can not be null";
		 return false;
	 }
	 if(district_id == "0"){
		 
		 //alert('Error: District can not be null');
		 document.getElementById('mp_error2').innerHTML="*Required Field can not be null";
		 return false;
		 
	 }
	 if(city_id == "0"){
		 
		 //alert('Error: City can not be null');
		 document.getElementById('mp_error3').innerHTML="*Required Field can not be null";
		 return false;
		 
	 }
	 if(mp_name == ""){
		
		 //alert('Error: MP Name can not be null');
		 document.getElementById('mp_error4').innerHTML="*Required Field can not be null";
		 return false;
		 
	 }
	 
	 return true;
	}


function advertisementValidation(){

	var pstr_company_name = document.getElementById("pstr_company_name").value;
	var category_id = document.getElementById("pnum_category_id").value;
	var sub_category_id = document.getElementById("pnum_sub_category_id").value;
	var upload_file = document.getElementById("uploadfile").value;
	//var valid_upto = document.getElementById("valid_upto").value;
	var url = document.getElementById("URL").value;
	
	if(pstr_company_name == ""){
		
		 document.getElementById('comp_error').innerHTML="*Required Field can not be null";
		 //alert('Error: Company name can not be null');
		 return false;
		
	}
	if(category_id == "0"){
		
		// alert('Error: Category can not be null');
		 document.getElementById('comp_error1').innerHTML="*Required Field can not be null";
		 return false;
		
	}
	if(sub_category_id == "0"){
		
		// alert('Error: Sub Category can not be null');
		 document.getElementById('comp_error2').innerHTML="*Required Field can not be null";
		 return false;
		
	}
	if(upload_file == ""){
		
		 //alert('Error: image upload is mandatory');
		 document.getElementById('comp_error3').innerHTML="*Required Field can not be null";
		 return false;
		
	}
	/*if(valid_upto == ""){
		 alert('Error: Valid Time can not be null');
		 return false;
		
	}*/
	if(url == ""){
		 //alert('Error: Image URL can not be null');
		 document.getElementById('comp_error4').innerHTML="*Required Field can not be null";
		 return false;
		
	}
	return true;
}


function loginIdExistence(){
	
	var loginId =  document.getElementById("pstr_login_id").value;
	   
	//alert(loginId);	
		
	   if(loginId == ""){
		  
			document.getElementById('error').innerHTML = "Please Fill LoginId";
			document.getElementById('pstr_login_id').value="";
			
	    	return false;
		   
	   }
	 
	   // alert("Login Id is "+loginId);
	   
	   var url = "./checkLoginIdAvail.action?loginid="+document.getElementById("pstr_login_id").value;
		
	 //  alert(url);
	   
	   ajaxEditFunctionCall(url, 'responseLoginIdExistence');
	
}


function responseLoginIdExistence(){
if (xmlHttp.readyState == 4) {
		
		if (xmlHttp.responseText == "1") {

			document.getElementById('error').innerHTML = "Continue...";
			
			return true;
		
		} 
		else
		{       if (xmlHttp.responseText == "0"){
				document.getElementById('error').innerHTML = "Login Id does not Exist, Try Again";
				document.getElementById("pstr_login_id").value = "";
						
				return false;
		        }
		}
		
	}

}


function questionValidation(){
	
	alert("Testing");
	
//	document.getElementById('editoptiondiv1').innerHTML = "";
//	document.getElementById('editoptiondiv2').innerHTML = "";
//	document.getElementById('editoptiondiv3').innerHTML = "";
//	document.getElementById('filterdiv').style.display = "none";
	document.getElementById('pstr_question_name').value = "";
	document.getElementById('pstr_option').value = "";
	document.getElementById('hourtime').value = "none";
	document.getElementById('sectime').value = "none";
	document.getElementById('hour_valid_time').value = "none";
	document.getElementById('sec_valid_time').value = "none";
}



//Test Question Creation Trial Function
function showTrial(){
	
//	    alert("Testing");
	    var no_of_question = document.getElementById("no_of_question").value;
	    
	    var entry_date = document.getElementById("entry_date").value;
	       
	    if(entry_date != ""){
	    	 
	    	//alert(entry_date);
	    	
	    	//alert(no_of_question+"date_image");
	    	
	    	 var x=document.getElementById("no_of_question");
		     x.disabled=false; 
		     var div = document.getElementById('showdiv');
		     div.style.visibility = "hidden";
		     div.style.display = "none";
		    
		     /*document.getElementById('hide').style.visibility = 'hidden';*/
		     
			if (contextPath == undefined) {
				contextPath = document.getElementById('contextPath').value;
			}

			url = contextPath + '/testShowQuestionWindowForm.action?questionCount='+document.getElementById("no_of_question").value+'&entry_date='+document.getElementById("entry_date").value;

		    //alert(url);
		  
    	    ajaxEditFunctionCall(url, 'responseTrial');	
	    }
	    else{
	    	
	    	//alert("Error : Date is not in Format 'YYYY-MM-DD'");
	    	
	    	document.getElementById("no_of_question").value = "0";
	    //	document.getElementById('dateDiv').innerHTML = "Date is not in Format 'YYYY-MM-DD'";
	    	return false;
	    }
	    
}




function responseTrial(){

	if (xmlHttp.readyState == 4) {
		
		document.getElementById('trialdiv').innerHTML = xmlHttp.responseText;
		
	}

}

function showBanner(){
	
	
   //alert("Testing");
    var banner_id = document.getElementById("pnum_company_id").value;
   // alert(banner_id);
    
    //var banner_name= document.getElementById("entry_date").value;
   // alert(banner_id);   
    
    if(banner_id != ""){
    	 
    	//alert(banner_id);
    	
    	
	     
		if (contextPath == undefined) {
			contextPath = document.getElementById('contextPath').value;
		}

		url = contextPath + '/ShowCompanyBanner.action?banner_id='+document.getElementById("pnum_company_id").value;

	   // alert(url);
	  
	    ajaxEditFunctionCall(url, 'responseImage');	
    }
    else{
    	
    	//alert("Banner image no found");
    	
    	//document.getElementById("no_of_question").value = "0";
    //	document.getElementById('dateDiv').innerHTML = "Date is not in Format 'YYYY-MM-DD'";
    	return false;
    }
    
}




function responseImage(){

if (xmlHttp.readyState == 4) {
	
	document.getElementById('showimage').innerHTML = xmlHttp.responseText;
	
}

}


function hideAllDiv()
{
	 document.getElementById('optionError').innerHTML = "";
}


function dateExistence(){
	
	//alert("Already Exist");
	
	var date = document.getElementById("entry_date").value;

	if(date==""){
		
		document.getElementById('dateError').innerHTML = "Date can not be blank";
		
		return false;
	}
	else{
	
		//alert("Current Date is "+date);

		document.getElementById('dateError').innerHTML = "";
		
		if (contextPath == undefined) {
			contextPath = document.getElementById('contextPath').value;
		}

		url = contextPath + '/dateExistence.action?currentDate='+date;

	    //alert(url);
	  
	    ajaxEditFunctionCall(url, 'responseDateExistence');	

	   
	}
}

function responseDateExistence(){
	
if (xmlHttp.readyState == 4) {
		
	if(xmlHttp.responseText == ""){
	
		var x=document.getElementById("no_of_question");
	     x.disabled=false; 
		
	    
	     
		document.getElementById('dateError').innerHTML = xmlHttp.responseText;
	}
	else{
		 
		var y=document.getElementById('trialdiv');
	     y.disabled=true;
		document.getElementById('dateError').innerHTML = xmlHttp.responseText;
	}
		
	}
}

function questionDisable(){
	
	 var x=document.getElementById("no_of_question");
     x.disabled=true; 

}

function checklength(){
	
	if (document.getElementById("pstr_role_desc").value.length > 23) 
	 { 
	    //alert('Invalid User'); 
	  
		document.getElementById('errors2').innerHTML = "Login Id does not Exist, Try Again";
		
		element.focus();
	   
		return false; 
	
	 } 
	
}

function showTooltip( tooltip_id ) {

	
	
	
	  document.getElementById( tooltip_id ).style.display = "inline";

	}

	function hideTooltip( tooltip_id ) {

	  document.getElementById( tooltip_id ).style.display = "none";

	}
	
	function keydownTooltip( event, tooltip_id ) {

		  var e = window.event || event;

		  if( e.keyCode == 27 ) {
		    document.getElementById( tooltip_id ).style.display = "none";
		    
		    return browser.stopPropagation( e );
		    
		  } else {
		    return true;
		  }

		}
	
	function dateBaseValidation(){
		
		//alert("hello1");
		
		var date = document.getElementById("entry_date").value;
		//alert("entry_date"+date);
		var date1 = document.getElementById("entry_date1").value;
	//	alert("entry_date1"+date1);
		
		if(date==""){
			//alert("hellodate")
			//alert('Error: Role Name can not be null'); 
			//document.getElementById('dateError').innerHTML = "Date can not be blank";
			 document.getElementById('dateError').innerHTML="* Required Field can not be null";
			document.getElementById("entry_date").focus();
			return false;
		 }
		else
			{
			 
			document.getElementById('dateError').innerHTML="  ";
			document.getElementById("entry_date1").focus();
			
			}
		
			
		
		
		if(date1==""){
			//alert("hellodate2");
			//alert('Error: Role Description can not be null');
			 document.getElementById('dateError').innerHTML="*Required Filed can not be null";
			return false;
		}
		else
		{
		 
		document.getElementById('dateError').innerHTML="  ";
		//document.getElementById("pstr_role_desc").focus();
		
		}
		
		
			
	return true;
	}

function showmobileUserValidation(){
	
	//alert("hello ");
	var name=document.getElementById("mobileUser").value;
	//alert(name);
	var mobileNo=document.getElementById("mobileno").value;
	var email=document.getElementById("email").value;

	var country_id=document.getElementById("country_id").value;
	//alert("country"+country);
	var state_id=document.getElementById("state_id").value;
	//alert("stateid"+stateid);
	var district_id=document.getElementById("district_id").value;
	//alert("districtid"+districtid);
	/*var cityid=document.getElementById("city_id").value;
	//alert("cityid"+cityid);
	var mla_mp_id=document.getElementById("mla_mp_id").value;*/
	
	//alert("cityid"+mla_mp_id);
	var city_id=document.getElementById("city_id").value;
	
	//alert("cityid"+cityid);
	
    var mp_id=document.getElementById("mp_id").value;
	
	//alert("mp_id"+mp_id);
	
    var mla_mp_id=document.getElementById("mla_mp_id").value;
	
	//alert("mla_mp_id"+mla_mp_id);
	
    if (contextPath == undefined) {
		contextPath = document.getElementById('contextPath').value;
	}

	url = contextPath + '/searchMobileUser.action?country_id='+document.getElementById("country_id").value+'&state_id='+document.getElementById("state_id").value+'&district_id='+document.getElementById("district_id").value+'&city_id='+document.getElementById("city_id").value+'&mp_id='+document.getElementById("mp_id").value+'&mla_mp_id='+document.getElementById("mla_mp_id").value+'&name='+document.getElementById("mobileUser").value+'&mobileNo='+document.getElementById("mobileno").value+'&email='+document.getElementById("email").value;

   // alert(url);
	
	
  
    ajaxEditFunctionCall(url, 'responseShowmobilesuser');
}

function responseShowmobilesuser(){

	if (xmlHttp.readyState == 4) {
		
		document.getElementById('Showmobilesuser').innerHTML = xmlHttp.responseText;
		
	}

	}
function dateBaseFilterValidation(){
	
	//alert("hello1");
	
	var date = document.getElementById("entry_date").value;
	//alert("entry_date"+date);
	var date1 = document.getElementById("entry_date1").value;
//	alert("entry_date1"+date1);
	var filter=document.getElementById("filterby").value;
	//alert("filter filterby"+filter);
	if(date==""){
		//alert("hellodate")
		//alert('Error: Role Name can not be null'); 
		//document.getElementById('dateError').innerHTML = "Date can not be blank";
		 document.getElementById('dateError').innerHTML="* Required Field can not be null";
		document.getElementById("entry_date").focus();
		return false;
	 }
	else
		{
		 
		document.getElementById('dateError').innerHTML="  ";
		document.getElementById("entry_date1").focus();
		
		}
	
		
	
	
	if(date1==""){
		//alert("hellodate2");
		//alert('Error: Role Description can not be null');
		 document.getElementById('dateError').innerHTML="*Required Filed can not be null";
		return false;
	}
	else
	{
	 
	document.getElementById('dateError').innerHTML="  ";
	document.getElementById("filterby").focus();
	
	}
	if(filter=="0"){
		document.getElementById('dateError').innerHTML="*Required Filed can not be null";
		return false;
		
	}
	else
	{
	 
	document.getElementById('dateError').innerHTML="  ";
	}
	
	
		
return true;
}


function showQuestionAnswer(){
	
	   //alert("Testing");
	    var entry_date = document.getElementById("entry_date").value;
	    
	    var to_date = document.getElementById("to_date").value ;
	    
	    //var mobileUser = document.getElementById("mobileUser").value;
	       
	    
	  /*  if(entry_date != "" & to_date !=""){*/
	    	 
	    	//alert(entry_date);
	    	//alert(mobileUser);
	    	
	    	//alert(no_of_question+"date_image");
	   
		     
			if (contextPath == undefined) {
				contextPath = document.getElementById('contextPath').value;
			}

			url = contextPath + '/ShowQuestionAnswer.action?date='+document.getElementById("entry_date").value+'&todate='+document.getElementById("to_date").value+'&mobileuser='+document.getElementById("mobileUser").value+'&gender='+document.getElementById("gender").value+'&option='+document.getElementById("option").value;

		    // alert(url);
		  
		    ajaxEditFunctionCall(url, 'responseShowdiv');	
	    }
	   /* else{
	    	
	    	alert("*Required Field can not be null");
	    	
	    	//document.getElementById("no_of_question").value = "0";
	    //	document.getElementById('dateDiv').innerHTML = "Date is not in Format 'YYYY-MM-DD'";
	    	return false;
	    }*/
	    
	//}




	function responseShowdiv(){

	if (xmlHttp.readyState == 4) {
		
		document.getElementById('ShowRecord').innerHTML = xmlHttp.responseText;
		
	}

	}


function CalluserValidtaion()
{
	


}
	
