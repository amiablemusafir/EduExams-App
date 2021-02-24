<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%@page import="java.util.ArrayList"%>
<%@page import="com.oes.dto.ExamDetailsDto"%>
<%@page import="java.util.List"%>
<%@page import="com.sms.admin.dto.AdminDetailDto"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<link rel='shortcut icon' type='image/x-icon' href='image/favicon.ico'/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />

    <title>XamDesk</title>

    <link rel="stylesheet" type="text/css" href="css/text.css" media="screen" />

    <link rel="stylesheet" type="text/css" href="css/grid.css" media="screen" />

    <link rel="stylesheet" type="text/css" href="css/layout.css" media="screen" />

    <link rel="stylesheet" type="text/css" href="css/nav.css" media="screen" />
    
    <link rel="stylesheet" type="text/css" href="css/reset2.css" media="screen" />

    

    <!--[if IE 6]><link rel="stylesheet" type="text/css" href="css/ie6.css" media="screen" /><![endif]-->

    <!--[if IE 7]><link rel="stylesheet" type="text/css" href="css/ie.css" media="screen" /><![endif]-->


    <!-- BEGIN: load jquery -->

    <script src="js/jquery-1.6.4.min.js" type="text/javascript"></script>

    <script type="text/javascript" src="js/jquery-ui/jquery.ui.core.min.js"></script>

    <script src="js/jquery-ui/jquery.ui.widget.min.js" type="text/javascript"></script>

    <script src="js/jquery-ui/jquery.ui.accordion.min.js" type="text/javascript"></script>

    <script src="js/jquery-ui/jquery.effects.core.min.js" type="text/javascript"></script>

    <script src="js/jquery-ui/jquery.effects.slide.min.js" type="text/javascript"></script>

    <script src="js/jquery-ui/jquery.ui.mouse.min.js" type="text/javascript"></script>

    <script src="js/jquery-ui/jquery.ui.sortable.min.js" type="text/javascript"></script>

    <script src="js/table/jquery.dataTables.min.js" type="text/javascript"></script>

    <!-- END: load jquery -->

    <script type="text/javascript" src="js/table/table.js"></script>

    <script src="js/setup.js" type="text/javascript"></script>
<script type="text/javascript">



        $(document).ready(function () {

            setupLeftMenu();



            $('.datatable').dataTable();

			setSidebarHeight();





        });

    </script>

 <script type="text/javascript">

     $(window).load(function () {

         $('#demo-side-bar').removeAttr('style');

     });

</script>

<style type="text/css">

#demo-side-bar{left:90%!important;display:block!important;}

#branding .floatright{margin-right:22px!important;}

</style>
</head>
	<!--Dynamically creates ads markup-->
<%
AdminDetailDto adminDetailDto = (AdminDetailDto) request.getSession().getAttribute("adminDetailDto");
%>
    <div class="container_12">

        <div class="grid_12 header-repeat">

            <div id="branding">

                <div class="floatleft">
				<%
				if(adminDetailDto.getInstituteDetailsDto() != null) {
					%><img src="img/<%=adminDetailDto.getInstituteDetailsDto().getOstr_institute_logo()%>" alt="Logo" width="35%" style="margin-top: -15px;"/><%
				} else {
					%><img src="img/logo.png" alt="Logo" width="35%" style="margin-top: -15px;"/><%
				}
				%>                   
                </div>

                <div class="floatright">

                    <div class="floatleft">

                        <img src="img/img-profile.jpg" alt="Profile Pic" /></div>

                    <div class="floatleft marginleft10">

                        <ul class="inline-ul floatleft">

                            <li>Hello <%=adminDetailDto.getIstr_user_name()%></li>

                            <li><a href="#">Helpdesk</a></li>

                            <li><a href="<%=request.getContextPath()%>/logout">Logout</a></li>

                        </ul>

                        <br />

                        <span class="small grey">Welcome to <%
						if(adminDetailDto.getInstituteDetailsDto() != null) {
							%><%=adminDetailDto.getInstituteDetailsDto().getOstr_institute_name()%><%
						} else {
							%>Xamdesk<%
						}
						%>  <!-- Last Login: 3 hours ago -->
						</span>

                    </div>

                </div>

                <!-- <div class="clear"></div>  -->

            </div>

        </div>

        <div class="clear">

        </div>

        <div class="grid_12">

            <ul class="nav main">
                <li class="ic-dashboard"><a href="<%=request.getContextPath()%>/homepage"><span>Dashboard</span></a> </li>
                <li class="ic-form-style"><a href="javascript:"><span>User Controls</span></a>
                    <ul>
                        <li><a href="changePasswordNSecretQusForm">Change Password</a> </li>
                        <li><a href="showNoticBoard">Notice Board</a> </li>
                    </ul>
                </li>
				<li class="ic-typography"><a href="#"><span>Tutorials</span></a></li>
                <li class="ic-grid-tables"><a href="showxamdeskforum"><span>Ask & Answer</span></a></li>         
                <li class="ic-notifications"><a href="showNotification"><span>Notifications</span></a></li>
            </ul>
        </div>

        <div class="clear"></div>
	<%-- <div id="menu"> 
	<ul id="main-menu" class="sm sm-blue" data-smartmenus-id="13916825528422676">
		<%
					//strNotificationUrl
					
				%>
				
				<%
					
				List<RolePermissionMasterDto> rolePermissionMasterList = (List<RolePermissionMasterDto>) request.getSession().getAttribute("rolePermissionDtoList");
				if(rolePermissionMasterList != null && rolePermissionMasterList.size() > 0) {
					
				try
				{
					
					System.out.println("size:--->"+rolePermissionMasterList.size());
					Set<Integer> st=new HashSet<Integer>();
					for(RolePermissionMasterDto rdto:rolePermissionMasterList)
					{
						if(rdto.getPermissionMasterDto().getInum_parent_permission_id()!=null)
						{
							st.add(rdto.getPermissionMasterDto().getInum_parent_permission_id());
						}
					}
					//System.out.println("size:--->"+st.size());
					for (RolePermissionMasterDto rolePermission : rolePermissionMasterList) {
						//System.out.println(rolePermission.getPermissionMasterDto().getInum_permission_id());
						if(st.contains(rolePermission.getPermissionMasterDto().getInum_permission_id()) && rolePermission.getPermissionMasterDto().getInum_is_parent().equals(0))
						{
							//System.out.println("get child"+rolePermission.getPermissionMasterDto().getInum_permission_id());
							%>
							<li><a
								href="#"><%=rolePermission.getPermissionMasterDto()
									.getIstr_permission_name()%></a>
							<ul class="sub-menu sm-nowrap">
							<%
							for (RolePermissionMasterDto rolechildPermission : rolePermissionMasterList) {
								
								if(rolechildPermission.getPermissionMasterDto().getInum_parent_permission_id().equals(rolePermission.getPermissionMasterDto().getInum_permission_id()) && rolechildPermission.getPermissionMasterDto().getInum_is_parent().equals(1))
								{
									if(st.contains(rolechildPermission.getPermissionMasterDto().getInum_permission_id()) && rolechildPermission.getPermissionMasterDto().getInum_is_parent().equals(1))
									{
										//System.out.println("get child"+rolechildPermission.getPermissionMasterDto().getInum_permission_id());
										%>
										<li><a
											href="<%=rolechildPermission.getPermissionMasterDto()
														.getIstr_permission_url()+"?currentMenu="+rolechildPermission.getPermissionMasterDto().getInum_parent_permission_id()+"&permissionSelect="+rolechildPermission.getPermissionMasterDto().getInum_permission_id()%>"><%=rolechildPermission.getPermissionMasterDto()
												.getIstr_permission_name()%></a>
										<ul class="sub-menu sm-nowrap">
										<%
										for (RolePermissionMasterDto rolechild1Permission : rolePermissionMasterList) {
											
											if(rolechild1Permission.getPermissionMasterDto().getInum_parent_permission_id().equals(rolechildPermission.getPermissionMasterDto().getInum_permission_id()) && rolechild1Permission.getPermissionMasterDto().getInum_is_parent().equals(2))
											{
												/*Level3 start*/
													if(st.contains(rolechild1Permission.getPermissionMasterDto().getInum_permission_id()) && rolechild1Permission.getPermissionMasterDto().getInum_is_parent().equals(2))
														{
															//System.out.println("get child"+rolechild1Permission.getPermissionMasterDto().getInum_permission_id());
															%>
															<li><a
																href="<%=rolechild1Permission.getPermissionMasterDto()
																			.getIstr_permission_url()+"?currentMenu="+rolechild1Permission.getPermissionMasterDto().getInum_parent_permission_id()+"&permissionSelect="+rolechild1Permission.getPermissionMasterDto().getInum_permission_id()%>"><%=rolechild1Permission.getPermissionMasterDto()
																	.getIstr_permission_name()%></a>
															<ul class="sub-menu sm-nowrap">
															<%
															for (RolePermissionMasterDto rolechild2Permission : rolePermissionMasterList) {
																
																if(rolechild2Permission.getPermissionMasterDto().getInum_parent_permission_id().equals(rolechild1Permission.getPermissionMasterDto().getInum_permission_id()) && rolechild2Permission.getPermissionMasterDto().getInum_is_parent().equals(3))
																{
																	%><li><a href="<%=rolechild2Permission.getPermissionMasterDto()
																			.getIstr_permission_url()+"?currentMenu="+rolechildPermission.getPermissionMasterDto().getInum_parent_permission_id()+"&permissionSelect="+rolechild2Permission.getPermissionMasterDto().getInum_permission_id()%>"><%=rolechild2Permission.getPermissionMasterDto()
																			.getIstr_permission_name()%></a>
																			
																	</li>
																	<%	
																}
															}
															%>
															</ul>
															</li>
															<%
															
														}
														else
														{
															%>
															<li><a
																href="<%=rolechild1Permission.getPermissionMasterDto()
																			.getIstr_permission_url()+"?currentMenu="+rolechildPermission.getPermissionMasterDto().getInum_parent_permission_id()+"&permissionSelect="+rolechild1Permission.getPermissionMasterDto().getInum_permission_id()%>"><%=rolechild1Permission.getPermissionMasterDto()
																	.getIstr_permission_name()%></a></li>
															<%
														}
												/*Level3 End*/
											}
										}
										%>
										</ul>
										</li>
										<%
										
									}
									else
									{
										%>
										<li><a
											href="<%=rolechildPermission.getPermissionMasterDto()
														.getIstr_permission_url()+"?currentMenu="+rolechildPermission.getPermissionMasterDto().getInum_parent_permission_id()+"&permissionSelect="+rolechildPermission.getPermissionMasterDto().getInum_permission_id()%>"><%=rolechildPermission.getPermissionMasterDto()
												.getIstr_permission_name()%></a></li>
										<%
									}
								}
								
							}
							%>
							</ul>
							</li>
							<%
							
						}
						else if(rolePermission.getPermissionMasterDto().getInum_is_parent().equals(0))
						{
							%>
							
							<li><a href="<%=rolePermission.getPermissionMasterDto()
									.getIstr_permission_url()+"?currentMenu="+rolePermission.getPermissionMasterDto().getInum_parent_permission_id()+"&permissionSelect="+rolePermission.getPermissionMasterDto().getInum_permission_id()%>"><%=rolePermission.getPermissionMasterDto()
									.getIstr_permission_name()%></a></li>
							<%
						
						}
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
				}
			%>
	</ul> 
	</div>
	</nav>
	<!-- menu part end -->
	
	<!-- header part end -->
	</header> --%>
 


<!-- <input type="hidden" name="currentMenu" id="currentMenu" /> -->
</body>
</html>
