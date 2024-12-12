<%@page import="java.util.List"%>
<%@page import="io.sunbit.dentistoffice.logic.OfficeUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/body-start.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">View Office Users</h1>
    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Active Users List</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>User Name</th>
                            <th>Role</th>
                            <th style="width:210px">Option</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>User Name</th>
                            <th>Role</th> 
                            <th style="width:210px">Option</th>
                        </tr>
                    </tfoot>
                    
                    <%
                        List<OfficeUser>officeUsers = (List)request.getSession().getAttribute("officeUsers");                        
                    %>                    
                    <tbody>
                        <%for(OfficeUser officeUser:officeUsers){%>
                        <tr>
                            <td id="userId<%=officeUser.getUserId()%>"><%=officeUser.getUserId()%></td>
                            <td><%=officeUser.getUserName()%></td>
                            <td><%=officeUser.getUserRole()%></td>
                            <td style="display: flex; width: 230px">                            
                                <form name="user-deletion" action="UserDeletionServlet" method="POST">
                                    <button type="submit" class="btn btn-danger btn-user" style="margin-right: 5px">
                                        <i class="fas fa-trash-alt"></i> Delete                      
                                    </button>
                                    <!-- This is the data(user-id) which is sending to /UserDeletionServlet-->
                                    <input type="hidden" name="user-id" value="<%=officeUser.getUserId()%>"/>                        
                                </form>
                                <form name="user-update" action="UserUpdateServlet" method="GET">
                                    <button type="submit" class="btn btn-warning btn-user" style="margin-left: 5px">
                                        <i class="fas fa-pencil-alt"></i> Update
                                    </button>                                    
                                    <input type="hidden" name="user-id" value="<%=officeUser.getUserId()%>" />
                                </form>                    
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->


<%@include file="components/body-end.jsp" %>