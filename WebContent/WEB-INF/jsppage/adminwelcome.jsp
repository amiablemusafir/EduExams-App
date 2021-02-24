<%@page isThreadSafe="true" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<head>
<style>
.button {  
     width: 150px;  
     height: 40px;  
     line-height: 40px;  
     color: white;  
     text-decoration: none; 
     font-size: 18px;  
     font-family: helvetica, arial;  
     font-weight: bold;  
     display: block;  
     text-align: center;
     margin-top: -20px;  
     position: inherit;  
  
     /* BACKGROUND GRADIENTS */  
     background: #014464;  
     background: -moz-linear-gradient(top, #0D658E, #0C577A 50%, #014D71 51%, #003E5C);  
     background: -webkit-gradient(linear, left top, left bottombottom, color-stop(0, #0E658E), color-stop(.5, #0C577A), color-stop(.5, #014D71), to(#003E5C));  
     /* BORDER RADIUS */  
     -moz-border-radius: 10px;  
     -webkit-border-radius: 10px;  
     border-radius: 10px;  
  
     border: 1px solid #368DBE;  
     border-top: 1px solid #c3d6df;  
     /* TEXT SHADOW */  
  
     text-shadow: 1px 1px 1px black;  
  
     /* BOX SHADOW */  
     -moz-box-shadow: 0 1px 3px black;  
     -webkit-box-shadow: 0 1px 3px black;  
     box-shadow: 0 1px 3px black;  
    }  
      
    /* WHILE HOVERED */  
    .button:hover {  
        background: #e40a0a; background-image: -webkit-gradient(linear, left top, left bottom, from(#e40a0a), to(#9f0202));  
        background: -moz-linear-gradient(top, #0c5f85, #0b5273 50%, #024869 51%, #003853);  
        background: -webkit-gradient(linear, left top, left bottombottom, color-stop(0, #0c5f85), color-stop(.5, #0b5273), color-stop(.51, #024869), to(#003853));  
    }  
      
    /* WHILE BEING CLICKED */  
    .button:active {  
        -moz-box-shadow: 0 2px 6px black;  
        -webkit-box-shadow: 0 2px 6px black;  
    }  
    /* FONT GLYPH (MOSTLY FOR FUN) */  
    .button:before {  
        font-family: EfonRegular;  
        content: '    ';  
        color: #09232F;  
        font-size: 50px;  
        float: left;  
        margin-left: 35px;  
        margin-right: -10px;  
        text-shadow: 0 1px 0 #4190AF;  
    }  


</style></head>
<html>
<body>


<%String totalVisits = (String)request.getSession().getAttribute("totalVisits"); %>
<center style="font-size: 15px; height: 25px; font-weight: bold; margin-top: 5px;"><font color="black">Welcome Admin Pannel</font></center>
<hr/>
<center style="font-size: 25px; margin-right: 60px; height: 45px; font-weight: bold; margin-top: 40px;">Total Visits : <%=totalVisits%></center>
<center style="font-size: 15px; margin-right: 50px; height: 45px; font-weight: bold; margin-top: 5px;">Please Regular Login and check your Email Id </center>
<center style="font-size: 25px; margin-right: -180px; height: 45px; font-weight: bold; margin-top: -60px;"><a href="http://webmail.oes.com" target="_blank" class="button" style="margin: 40px auto;" >Email Login</a></center> 
</body>
</html>






