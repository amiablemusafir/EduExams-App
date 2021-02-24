<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@page import="com.sms.admin.dto.RolePermissionMasterDto"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="com.sms.admin.dto.PermissionMasterDto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang=''>
<head>
   <meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="side_menu/styles.css">
  <script src="side_menu/script.js"></script>
   <title>CSS MenuMaker</title>
</head>
<body>


<div class="clear"></div>

<div class="grid_2">

<div class="box sidemenu">

<div class="block" id="section-menu">

<div id='cssmenu'>
<ul>
					<%
					try {
							String permissionSelect=(String)request.getSession().getAttribute("permissionSelect");
							if(permissionSelect == null) {
								permissionSelect = "0";
							}
							String displayMenuHeader=(String)request.getSession().getAttribute("currentMenu");
							if(displayMenuHeader == null) {
								displayMenuHeader ="0";
							}
							
							System.out.println(request.getSession().getAttribute("permissionSelect")+"<----------------Permission Selected-------->"+request.getSession().getAttribute("currentMenu")+permissionSelect);
							String ParentPermissionSelected = null;
							List<RolePermissionMasterDto> permissionDtoSideMenuList = (List<RolePermissionMasterDto>)request.getSession().getAttribute("rolePermissionDtoList");
							//System.out.println("size----------->"+permissionDtoSideMenuList.size());
							
							Set<Integer> st=new HashSet<Integer>();
							for(RolePermissionMasterDto rdto:permissionDtoSideMenuList) {
								if(rdto.getPermissionMasterDto().getInum_parent_permission_id()!=null) {	
									if(request.getSession().getAttribute("permissionSelect")!=null && rdto.getPermissionMasterDto().getInum_permission_id().equals(Integer.valueOf(permissionSelect))) {
										ParentPermissionSelected = String.valueOf(rdto.getPermissionMasterDto().getInum_parent_permission_id());
										//System.out.println("ParentPermissionSelected------->"+ParentPermissionSelected);
									}
									st.add(rdto.getPermissionMasterDto().getInum_parent_permission_id());
								}
							}
							
							
							for (RolePermissionMasterDto roleMotherPermission : permissionDtoSideMenuList) {
								if(roleMotherPermission.getPermissionMasterDto().getInum_is_parent().equals(0)) {
								
									int has_child = 0;
									for (RolePermissionMasterDto roleChildPermission : permissionDtoSideMenuList) {
										if(roleChildPermission.getPermissionMasterDto().getInum_parent_permission_id().equals((roleMotherPermission.getPermissionMasterDto().getInum_permission_id()))) {
											has_child++; 
										}
									}
									
									if(has_child == 0) {
										%><li><a href='#'><span><%=roleMotherPermission.getPermissionMasterDto().getIstr_permission_name()%></span></a></li><%
									} else {
										%><li class='has-sub'><a href='#'><span><%=roleMotherPermission.getPermissionMasterDto().getIstr_permission_name()%></span></a><%
									}
								%>
										<ul>
										<%
										for (RolePermissionMasterDto roleChildPermission : permissionDtoSideMenuList) {
											if(roleChildPermission.getPermissionMasterDto().getInum_parent_permission_id().equals((roleMotherPermission.getPermissionMasterDto().getInum_permission_id()))) {
												
												//System.out.println(roleChildPermission.getPermissionMasterDto().getInum_permission_id()+"===="+Integer.valueOf(permissionSelect));
												
												if(roleChildPermission.getPermissionMasterDto().getInum_permission_id().equals(Integer.valueOf(permissionSelect))) {										
													%>
													<li class='active'><a href="<%=roleChildPermission.getPermissionMasterDto().getIstr_permission_url()+"?permissionSelect="+roleChildPermission.getPermissionMasterDto().getInum_permission_id()%>"><span><%=roleChildPermission.getPermissionMasterDto().getIstr_permission_name()%></span></a></li>
													<%
												} else {
													%>
													<li><a href="<%=roleChildPermission.getPermissionMasterDto().getIstr_permission_url()+"?permissionSelect="+roleChildPermission.getPermissionMasterDto().getInum_permission_id()%>"><span><%=roleChildPermission.getPermissionMasterDto().getIstr_permission_name()%></span></a></li>
													<%
												}				
												
											}
										}
										%>									
		                            </ul>
								</li>
								<%	
								}								
							}
						
						} catch(Exception e) {
							e.printStackTrace();
						}
						%>

</ul>
</div>
</div>
</div>
</div>
</body>
<html>
