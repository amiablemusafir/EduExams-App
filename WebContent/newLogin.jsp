<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
/* Full-width input fields */
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
.button {
  padding: 15px 25px;
  font-size: 18px;
  text-align: center;
  cursor: pointer;
  outline: none;
  color: #fff;
  background-color: #4CAF50;
  border: none;
  border-radius: 10px;
  box-shadow: 0 4px #999;
  width: 60%;
}

.button:hover {background-color: #3e8e41}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 2px #666;
  transform: translateY(2px);
}

/* Extra styles for the cancel button */
.cancelbtn {
    width: auto;
    padding: 10px 18px;
    border: none;
  	border-radius: 10px;
    background-color: #f44336;    
    font-size: 18px;
  	text-align: center;
  	cursor: pointer;
  	outline: none;
  	color: #fff;
  	border: none;
  	border-radius: 5px;
  	box-shadow: 0 2px #999;
}

/* Center the image and position the close button */
.imgcontainer {
    text-align: left;
    margin: 24px 0 12px 0;
    position: relative;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 40%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
    position: absolute;
    right: 25px;
    top: 0;
    color: #000;
    font-size: 35px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}

/* Add Zoom Animation */
.animate {
    -webkit-animation: animatezoom 0.6s;
    animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
    from {-webkit-transform: scale(0)} 
    to {-webkit-transform: scale(1)}
}
    
@keyframes animatezoom {
    from {transform: scale(0)} 
    to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}

.register-head {
    color: #57aefe;
    font-size: 35px;
    font-family: robotolight;
}

.register-top {
    padding: 5%;
}
</style>


<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
<body>

<!-- <h2>Modal Login Form</h2>

<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;" class="button">Login</button>
 -->

<table style="border-collapse:collapse;border-spacing:0;display:block;padding:0px;text-align:left;vertical-align:top;width:100%"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:10px 0px 0px;text-align:left;vertical-align:top;word-break:break-word" align="left" valign="top">
<table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left">
<td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td>
</tr></tbody></table><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:28px 0px 5px;text-align:left;vertical-align:top;word-break:break-word" align="left" valign="top">
<h1 style="color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:19px;font-weight:normal;line-height:1.3;margin:0;padding:0;text-align:left;word-break:normal" align="left">Hi&nbsp;^username^,</h1>
</td><td style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td>
</tr><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0px 0px 5px;text-align:left;vertical-align:top;word-break:break-word" align="left" valign="top">
<p style="color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.5;margin:0 0 10px;padding:0;text-align:left" align="left">Someone recently requested a password change for your Xamdesk Account. If this was you, you can set a new password here:</p></td>
<td style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td>
</tr></tbody></table><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td class="m_1890662970661706988twelve" style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0px;text-align:left;vertical-align:top;width:100%;word-break:break-word" align="left" valign="top">&nbsp;</td>
<td style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td>
</tr></tbody></table><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td class="m_1890662970661706988four" style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0px 0px 10px;text-align:left;vertical-align:top;width:33.333333%;word-break:break-word" align="left" valign="top"></td>
<td style="background:#84c700;border-collapse:collapse!important;border-radius:3px;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:10px 0px;text-align:center;vertical-align:top;width:33.333333%;word-break:break-word" class="m_1890662970661706988four" align="center" bgcolor="#84c700" valign="top">
<a href="http://www.crazydomains.in/set-account-password/?action=account_manager&amp;key=9fa3763d20dc120cc5b4d4c383128525" style="color:#ffffff;font-size:15px;font-weight:bold;text-decoration:none" target="_blank" data-saferedirecturl="https://www.google.com/url?hl=en&amp;q=http://www.xamdesk.com/setAccountPassword?account_manager_key=^RandomKey^&account_regdno=^regdno^">Reset Password</a>
</td><td style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0px 0px 10px;text-align:left;vertical-align:top;width:33.333333%;word-break:break-word" align="left" valign="top"></td>
<td style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td>
</tr></tbody></table><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td class="m_1890662970661706988last" style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:14px 0px 10px;text-align:left;vertical-align:top;word-break:break-word" align="left" valign="top">
<p style="color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:13px;font-weight:normal;line-height:1.5;margin:0 0 10px;padding:12px 0 0px;text-align:left" align="left">If you don't want to change your password or didn't request this, just ignore and delete this message.</p>
<p style="color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:13px;font-weight:normal;line-height:1.5;margin:0 0 10px;padding:12px 0 0px;text-align:left" align="left">To keep your account secure, please don't forward this email to anyone. See our Online Support for more security tips.</p>
<p style="color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:13px;font-weight:normal;line-height:1.5;margin:0 0 10px;padding:12px 0 0px;text-align:left" align="left">Thank You,<br><b>XamDesk</b><br>www.xamdesk.com</p>
</td><td style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td>
</tr><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td class="m_1890662970661706988last" style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:3px 0px 10px;text-align:left;vertical-align:top;word-break:break-word" align="left" valign="top">
<h3 style="color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:15px;font-weight:bold;line-height:1.3;margin:0;padding:0;text-align:left;word-break:normal" align="left">Need help?</h3>
<p style="color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:13px;font-weight:normal;line-height:1.5;margin:0 0 10px;padding-top:12px!important;padding-left:0;padding-right:0;padding-bottom:15px;text-align:left" align="left">If you have any enquiries, please do not hesitate to contact our support team who are available 24/7 to assist you. Call +91 9950903074.</p>
</td></tr></tbody></table></td></tr></tbody></table>



<div id=":1k5" class="a3s" style="overflow: hidden;">
<div style="color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;min-width:100%;padding:0;text-align:left;width:100%!important">
<table style="border-collapse:collapse;border-spacing:0;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;height:100%;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:100%">
<tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left">
<td align="center" valign="top" style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:center;vertical-align:top;word-break:break-word">
<center style="min-width:580px;width:100%"><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:inherit;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left">
<td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;word-break:break-word" align="left" valign="top"><table style="border-collapse:collapse;border-spacing:0;display:block;padding:0px;text-align:left;vertical-align:top;width:100%"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:10px 0px 0px;text-align:left;vertical-align:top;word-break:break-word" align="left" valign="top"><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0px 0px 10px;text-align:left;vertical-align:middle;width:50%;word-break:break-word" align="left" valign="middle"><a href="https://www.xamdesk.com" style="color:#3f5f92;text-decoration:none" target="_blank"><img src="http://www.xamdesk.com/image/logo_mail.png" alt="WWW.XAMDESK.COM" style="border:none;clear:both;display:block;float:left;max-width:100%;outline:none;text-decoration:none;width:auto" align="left" class="CToWUd"></a></td><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0px 0px 10px;text-align:right;vertical-align:middle;width:50%;word-break:break-word" align="right" valign="middle"><a href="#" style="color:#3f5f92;text-decoration:none" target="_blank"><img width="290" height="42" src="http://www.xamdesk.com/image/support_mail.png" alt="Contact Details" style="border:none;clear:both;display:block;float:left;max-width:100%;outline:none;text-decoration:none;width:auto" align="left" class="CToWUd"></a></td><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr></tbody></table><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:28px 0px 5px;text-align:left;vertical-align:top;word-break:break-word" align="left" valign="top"><h1 style="color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:19px;font-weight:normal;line-height:1.3;margin:0;padding:0;text-align:left;word-break:normal" align="left">Hi&nbsp;"+adminDetailDto.getIstr_user_name()+",</h1></td><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0px 0px 12px;text-align:left;vertical-align:top;word-break:break-word" align="left" valign="top"><p style="color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.5;margin:0 0 10px;padding:0;text-align:left" align="left">Someone recently requested a password change for your Account Manager. If this was you, you can set a new password here.</p></td><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr></tbody></table><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td> 
</tr><td style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td>
</tr></tbody></table><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td class="m_1890662970661706988twelve" style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0px;text-align:left;vertical-align:top;width:100%;word-break:break-word" align="left" valign="top">&nbsp;</td>
<td style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td>
</tr></tbody></table><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td class="m_1890662970661706988four" style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0px 0px 10px;text-align:left;vertical-align:top;width:33.333333%;word-break:break-word" align="left" valign="top"></td>
<td style="background:#84c700;border-collapse:collapse!important;border-radius:3px;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:10px 0px;text-align:center;vertical-align:top;width:33.333333%;word-break:break-word" class="m_1890662970661706988four" align="center" bgcolor="#84c700" valign="top">
<a href="http://www.crazydomains.in/set-account-password/?action=account_manager&amp;key=9fa3763d20dc120cc5b4d4c383128525" style="color:#ffffff;font-size:15px;font-weight:bold;text-decoration:none" target="_blank" data-saferedirecturl="https://www.google.com/url?hl=en&amp;q=http://www.xamdesk.com/setAccountPassword?account_manager_key=^RandomKey^&account_regdno=^regdno^">Reset Password</a>
</td><td style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0px 0px 10px;text-align:left;vertical-align:top;width:33.333333%;word-break:break-word" align="left" valign="top"></td>
<td style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td>
</tr></tbody></table><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td class="m_1890662970661706988last" style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:14px 0px 10px;text-align:left;vertical-align:top;word-break:break-word" align="left" valign="top">
<p style="color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:13px;font-weight:normal;line-height:1.5;margin:0 0 10px;padding:12px 0 0px;text-align:left" align="left">If you don't want to change your password or didn't request this, just ignore and delete this message.</p>
<p style="color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:13px;font-weight:normal;line-height:1.5;margin:0 0 10px;padding:12px 0 0px;text-align:left" align="left">To keep your account secure, please don't forward this email to anyone. See our Online Support for more security tips.</p>
<p style="color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:13px;font-weight:normal;line-height:1.5;margin:0 0 10px;padding:12px 0 0px;text-align:left" align="left">Thank You,<br><b>XamDesk</b><br>www.xamdesk.com</p>
<h3 style="color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:15px;font-weight:bold;line-height:1.3;margin:0;padding:0;text-align:left;word-break:normal" align="left">Need help?</h3><p style="color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:13px;font-weight:normal;line-height:1.5;margin:0 0 10px;padding-top:12px!important;padding-left:0;padding-right:0;padding-bottom:15px;text-align:left" align="left">If you have any enquiries, please do not hesitate to contact our support team who are available 24/7 to assist you. Call <b>(+91) 9958903074</b>.</p></td></tr></tbody></table><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:8px 0px 10px;text-align:left;vertical-align:top;width:33.333333%;word-break:break-word" align="left" valign="top"><table style="border-collapse:collapse;border-spacing:0;overflow:hidden;padding:0;text-align:left;vertical-align:top;width:100%"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="background:#406090;border-collapse:collapse!important;border-radius:3px;border:1px solid #406090;color:#ffffff;display:block;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:8px 0 9px;text-align:center;vertical-align:top;width:auto!important;word-break:break-word" align="center" bgcolor="#406090" valign="top"><a href="https://www.xamdesk.com/" alt="My Account" style="color:#ffffff;font-family:Helvetica,Arial,sans-serif;font-size:13px;font-weight:bold;text-decoration:none" target="_blank">My Account</a></td><td style="border-collapse:collapse!important;border-radius:3px;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr></tbody></table></td><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:8px 4px 10px;text-align:left;vertical-align:top;width:33.333333%;word-break:break-word" align="left" valign="top"><table style="border-collapse:collapse;border-spacing:0;overflow:hidden;padding:0;text-align:left;vertical-align:top;width:100%"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="background:#406090;border-collapse:collapse!important;border-radius:3px;border:1px solid #406090;color:#ffffff;display:block;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:8px 0 9px;text-align:center;vertical-align:top;width:auto!important;word-break:break-word" align="center" bgcolor="#406090" valign="top"><a href="http://www.xamdesk.com/web/ContactUs" alt="Online Help" style="color:#ffffff;font-family:Helvetica,Arial,sans-serif;font-size:13px;font-weight:bold;text-decoration:none" target="_blank">Online Help</a></td><td style="border-collapse:collapse!important;border-radius:3px;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr></tbody></table></td><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:8px 0px 10px;text-align:left;vertical-align:top;width:33.333333%;word-break:break-word" align="left" valign="top"><table style="border-collapse:collapse;border-spacing:0;overflow:hidden;padding:0;text-align:left;vertical-align:top;width:100%"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="background:#406090;border-collapse:collapse!important;border-radius:3px;border:1px solid #406090;color:#ffffff;display:block;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:8px 0 9px;text-align:center;vertical-align:top;width:auto!important;word-break:break-word" align="center" bgcolor="#406090" valign="top"><a href="http://www.xamdesk.com/web/ContactUs" alt="Contact Us" style="color:#ffffff;font-family:Helvetica,Arial,sans-serif;font-size:13px;font-weight:bold;text-decoration:none" target="_blank">Contact Us</a></td><td style="border-collapse:collapse!important;border-radius:3px;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr></tbody></table></td><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr></tbody></table><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:10px 0px 13px;text-align:left;vertical-align:top;word-break:break-word" align="left" valign="top"><p style="color:#aaaaaa;font-family:'Helvetica','Arial',sans-serif;font-size:11px;font-weight:normal;line-height:1.5;margin:0 0 10px;padding:0;text-align:center" align="center"><span class="il">Xamdesk</span> <span class="il">ONLINE EXAM</span> respects your privacy. View <a href="#" style="color:#3f5f92;text-decoration:none">privacy policy</a>.<br> Copyright �2015 <span class="il">Xamdesk</span>. <a href="#" style="color:#3f5f92;text-decoration:none">All rights reserved</a>.</p></td><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody>


<div id=":1k5" class="a3s" style="overflow: hidden;"><div style="color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;min-width:100%;padding:0;text-align:left;width:100%!important"><table style="border-collapse:collapse;border-spacing:0;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;height:100%;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:100%"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td align="center" valign="top" style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:center;vertical-align:top;word-break:break-word"><center style="min-width:580px;width:100%"><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:inherit;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;word-break:break-word" align="left" valign="top"><table style="border-collapse:collapse;border-spacing:0;display:block;padding:0px;text-align:left;vertical-align:top;width:100%"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:10px 0px 0px;text-align:left;vertical-align:top;word-break:break-word" align="left" valign="top"><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0px 0px 10px;text-align:left;vertical-align:middle;width:50%;word-break:break-word" align="left" valign="middle"><a href="https://www.xamdesk.com" style="color:#3f5f92;text-decoration:none" target="_blank"><img src="http://www.xamdesk.com/image/logo_mail.png" alt="WWW.XAMDESK.COM" style="border:none;clear:both;display:block;float:left;max-width:100%;outline:none;text-decoration:none;width:auto" align="left" class="CToWUd"></a></td><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0px 0px 10px;text-align:right;vertical-align:middle;width:50%;word-break:break-word" align="right" valign="middle"><a href="#" style="color:#3f5f92;text-decoration:none" target="_blank"><img width="290" height="42" src="http://www.xamdesk.com/image/support_mail.png" alt="Contact Details" style="border:none;clear:both;display:block;float:left;max-width:100%;outline:none;text-decoration:none;width:auto" align="left" class="CToWUd"></a></td><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr></tbody></table><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:28px 0px 5px;text-align:left;vertical-align:top;word-break:break-word" align="left" valign="top"><h1 style="color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:19px;font-weight:normal;line-height:1.3;margin:0;padding:0;text-align:left;word-break:normal" align="left">Hi&nbsp;aa,</h1></td><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0px 0px 12px;text-align:left;vertical-align:top;word-break:break-word" align="left" valign="top"><p style="color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.5;margin:0 0 10px;padding:0;text-align:left" align="left">Someone recently requested a password change for your Account Manager. If this was you, you can set a new password here.</p></td><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr></tbody></table><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr><td style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr></tbody></table><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td class="m_1890662970661706988twelve" style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0px;text-align:left;vertical-align:top;width:100%;word-break:break-word" align="left" valign="top">&nbsp;</td><td style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr></tbody></table><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td class="m_1890662970661706988four" style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0px 0px 10px;text-align:left;vertical-align:top;width:33.333333%;word-break:break-word" align="left" valign="top"></td><td style="background:#84c700;border-collapse:collapse!important;border-radius:3px;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:10px 0px;text-align:center;vertical-align:top;width:33.333333%;word-break:break-word" class="m_1890662970661706988four" align="center" bgcolor="#84c700" valign="top"><a href="https://www.xamdesk.com/set-account-password?key=tnfxsumq&unique_id=XD/17/101" style="color:#ffffff;font-size:15px;font-weight:bold;text-decoration:none" target="_blank">Reset Password</a></td><td style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0px 0px 10px;text-align:left;vertical-align:top;width:33.333333%;word-break:break-word" align="left" valign="top"></td><td style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr></tbody></table><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td class="m_1890662970661706988last" style="border-collapse:collapse!important;color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:14px 0px 10px;text-align:left;vertical-align:top;word-break:break-word" align="left" valign="top"><p style="color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:13px;font-weight:normal;line-height:1.5;margin:0 0 10px;padding:12px 0 0px;text-align:left" align="left">If you don't want to change your password or didn't request this, just ignore and delete this message.</p><p style="color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:13px;font-weight:normal;line-height:1.5;margin:0 0 10px;padding:12px 0 0px;text-align:left" align="left">To keep your account secure, please don't forward this email to anyone. See our Online Support for more security tips.</p><p style="color:#212121;font-family:'Helvetica','Arial',sans-serif;font-size:13px;font-weight:normal;line-height:1.5;margin:0 0 10px;padding:12px 0 0px;text-align:left" align="left">Thank You,<br><b>XamDesk</b><br>www.xamdesk.com</p><h3 style="color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:15px;font-weight:bold;line-height:1.3;margin:0;padding:0;text-align:left;word-break:normal" align="left">Need help?</h3><p style="color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:13px;font-weight:normal;line-height:1.5;margin:0 0 10px;padding-top:12px!important;padding-left:0;padding-right:0;padding-bottom:15px;text-align:left" align="left">If you have any enquiries, please do not hesitate to contact our support team who are available 24/7 to assist you. Call <b>(+91) 9958903074</b>.</p></td></tr></tbody></table><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:8px 0px 10px;text-align:left;vertical-align:top;width:33.333333%;word-break:break-word" align="left" valign="top"><table style="border-collapse:collapse;border-spacing:0;overflow:hidden;padding:0;text-align:left;vertical-align:top;width:100%"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="background:#406090;border-collapse:collapse!important;border-radius:3px;border:1px solid #406090;color:#ffffff;display:block;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:8px 0 9px;text-align:center;vertical-align:top;width:auto!important;word-break:break-word" align="center" bgcolor="#406090" valign="top"><a href="https://www.xamdesk.com/" alt="My Account" style="color:#ffffff;font-family:Helvetica,Arial,sans-serif;font-size:13px;font-weight:bold;text-decoration:none" target="_blank">My Account</a></td><td style="border-collapse:collapse!important;border-radius:3px;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr></tbody></table></td><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:8px 4px 10px;text-align:left;vertical-align:top;width:33.333333%;word-break:break-word" align="left" valign="top"><table style="border-collapse:collapse;border-spacing:0;overflow:hidden;padding:0;text-align:left;vertical-align:top;width:100%"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="background:#406090;border-collapse:collapse!important;border-radius:3px;border:1px solid #406090;color:#ffffff;display:block;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:8px 0 9px;text-align:center;vertical-align:top;width:auto!important;word-break:break-word" align="center" bgcolor="#406090" valign="top"><a href="http://www.xamdesk.com/web/ContactUs" alt="Online Help" style="color:#ffffff;font-family:Helvetica,Arial,sans-serif;font-size:13px;font-weight:bold;text-decoration:none" target="_blank">Online Help</a></td><td style="border-collapse:collapse!important;border-radius:3px;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr></tbody></table></td><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:8px 0px 10px;text-align:left;vertical-align:top;width:33.333333%;word-break:break-word" align="left" valign="top"><table style="border-collapse:collapse;border-spacing:0;overflow:hidden;padding:0;text-align:left;vertical-align:top;width:100%"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="background:#406090;border-collapse:collapse!important;border-radius:3px;border:1px solid #406090;color:#ffffff;display:block;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:8px 0 9px;text-align:center;vertical-align:top;width:auto!important;word-break:break-word" align="center" bgcolor="#406090" valign="top"><a href="http://www.xamdesk.com/web/ContactUs" alt="Contact Us" style="color:#ffffff;font-family:Helvetica,Arial,sans-serif;font-size:13px;font-weight:bold;text-decoration:none" target="_blank">Contact Us</a></td><td style="border-collapse:collapse!important;border-radius:3px;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr></tbody></table></td><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr></tbody></table><table style="border-collapse:collapse;border-spacing:0;margin:0 auto;padding:0;text-align:left;vertical-align:top;width:580px"><tbody><tr style="padding:0;text-align:left;vertical-align:top" align="left"><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:10px 0px 13px;text-align:left;vertical-align:top;word-break:break-word" align="left" valign="top"><p style="color:#aaaaaa;font-family:'Helvetica','Arial',sans-serif;font-size:11px;font-weight:normal;line-height:1.5;margin:0 0 10px;padding:0;text-align:center" align="center"><span class="il">Xamdesk</span> <span class="il">ONLINE EXAM</span> respects your privacy. View <a href="#" style="color:#3f5f92;text-decoration:none">privacy policy</a>.<br> Copyright ?2015 <span class="il">Xamdesk</span>. <a href="#" style="color:#3f5f92;text-decoration:none">All rights reserved</a>.</p></td><td style="border-collapse:collapse!important;color:#484848;font-family:'Helvetica','Arial',sans-serif;font-size:14px;font-weight:normal;line-height:1.2;margin:0;padding:0;text-align:left;vertical-align:top;width:0px;word-break:break-word" align="left" valign="top"></td></tr></tbody></table></td></tr></tbody></table></td></tr></tbody>


<div id="id01" class="modal">
  
  <div class="modal-content animate"> 
  	  <div class="imgcontainer">
		      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
		      <div class="register-head">
		      <img src="image/rect.png" class="rect-img">
		      <span>Login</span>
		      </div>
	  </div>
  	  
  	  <form action="/action_page.php">
	    
	      <div class="container">
	      <div style="margin-top: 25px;">
		     <hr style="border-top: dotted 1px;"/>
		     
		  </div>
	      <label><b>Username / Email Id</b></label>
	      <input type="text" placeholder="Enter Username" name="uname" required>
	
	      <label><b>Password</b></label>
	      <input type="password" placeholder="Enter Password" name="psw" required>
	        
	      <br/><br/>   <br/><br/>  
	      <button type="submit" class="button">LOGIN</button>
	      <span class="psw"><a href="#" style="text-decoration: none; font-weight: bold;">Forgot password?</a></span>
	      </div>
	
	      <div class="container" style="background-color:#f1f1f1;">
	      
	      
	      
	      </div>   
	  </form>
	
   </div>
</div>


</body>
</html>