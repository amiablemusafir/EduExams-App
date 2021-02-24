<%@ page session="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<%
	response.setHeader("pragma", "no-cache");//HTTP 1.1   
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Cache-Control", "must-revalidate");
	response.addDateHeader("Expires", -1);
	response.setDateHeader("max-age", 0);
%>
<!DOCTYPE html>
<html>
<body>	

<tiles:insertAttribute name="header"/>

<tiles:insertAttribute name="menu"/>

<section>
	<div id="dms_middle">
		<div class="dms_details_home">
			<tiles:insertAttribute name="body"/>
		</div>
	</div>
</section>

<tiles:insertAttribute name="footer"/>

</body>
</html>
