<%@page import="java.util.HashMap"%>
<%@page import="com.oes.dto.ResultReviewSubjectDto"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
</head>

<body>

				<div class="row">
				<table width="100%" style="border-collapse: collapse; text-align: left;">
				<tr>
					<td width="50%" style="padding: 15px; border-bottom: 1px solid #ddd; text-align: left;">Exam Name:&nbsp;&nbsp;<b> </b></td>
					<td width="30%" style="padding: 15px; border-bottom: 1px solid #ddd; text-align: left;">Date:&nbsp;&nbsp;<b>12-Dec-2018</b></td>
					<td width="20%" style="padding: 15px; border-bottom: 1px solid #ddd; text-align: left;"><a href="#"><u>Click for Details</u></a></td>
				</tr>
				</table>
				<div style="max-height: 325px; min-height: 325px; overflow: scroll; margin-top: -20px; margin-bottom: -20px;">
				<%
				Map<Integer, ResultReviewSubjectDto> subjectMapDetails = new HashMap<Integer, ResultReviewSubjectDto>();
				subjectMapDetails = (HashMap<Integer, ResultReviewSubjectDto>) request.getSession().getAttribute("subjectMapDetails");
				
				if(subjectMapDetails != null && subjectMapDetails.size()>0) {
				%>
				    <div align="center">
						<table width="100%" style="border-collapse: collapse;">
						<tr style="background: #eee;">
							<th width="40%" style="background: #333; height: 20px; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left; font-size: 10px; font-weight: bold;">SUBJECT</th>
							<th width="15%" style="background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left; font-size: 10px; font-weight: bold;">TOTAL QUESTION</th>
							<th width="15%" style="background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left; font-size: 10px; font-weight: bold;">CORRECT</th>
							<th width="15%" style="background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left; font-size: 10px; font-weight: bold;">WRONG</th>
							<th width="15%" style="background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left; font-size: 10px; font-weight: bold;">UNATTEMPTED</th>
						</tr>
						<%for(Integer number : subjectMapDetails.keySet()) {
							ResultReviewSubjectDto resultReviewSubjectDto = new ResultReviewSubjectDto();
							resultReviewSubjectDto = subjectMapDetails.get(number);%>
							<tr style="background: #eee;">
							<td align="left" style="padding: 6px; border: 1px solid #ccc; height: 15px; font-size: 11px; font-weight: bold;"><%=resultReviewSubjectDto.getSectionDetailsDto().getSubCategoryDetailsDto().getOstr_sub_category_name()%></td>
							<td align="center" style="padding: 6px; border: 1px solid #ccc; height: 15px; font-size: 11px; font-weight: bold;"><%=resultReviewSubjectDto.getTotal_question()%></td>
							<td align="center" style="padding: 6px; border: 1px solid #ccc; height: 15px; font-size: 11px; font-weight: bold;"><%=resultReviewSubjectDto.getTotal_right()%></td>
							<td align="center" style="padding: 6px; border: 1px solid #ccc; height: 15px; font-size: 11px; font-weight: bold;"><%=resultReviewSubjectDto.getTotal_wrong()%></td>
							<td align="center" style="padding: 6px; border: 1px solid #ccc; height: 15px; font-size: 11px; font-weight: bold;"><%=resultReviewSubjectDto.getTotal_left()%></td>	
							</tr>
						<%}
						%>
						</table>
					</div>			
				<%
				}
				%>
				
				
				<div id="piechart" style="margin-top: -20px;"></div>
				<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
				
				<script type="text/javascript">
				// Load google charts
				google.charts.load('current', {'packages':['corechart']});
				google.charts.setOnLoadCallback(drawChart);
				
				// Draw the chart and set the chart values
				function drawChart() {
				  var data = google.visualization.arrayToDataTable([
				  ['Task', 'Hours per Day'],
				  ['CORRECT', 30],
				  ['WRONG', 40],
				  ['UNATTEMPTED', 30]
				]);
				
				  // Optional; add a title and set the width and height of the chart
				  var options = {'title':'Result Review', 'width':550, 'height':300};
				
				  // Display the chart inside the <div> element with id="piechart"
				  var chart = new google.visualization.PieChart(document.getElementById('piechart'));
				  chart.draw(data, options);
				}
				</script>
				</div>
				</div>
</body>
</html>
