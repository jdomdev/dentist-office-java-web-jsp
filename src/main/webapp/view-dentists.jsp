<%@page import="io.sunbit.dentistoffice.logic.Dentist"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/body-start.jsp" %>

<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">View Dentists</h1>
    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Active Dentists List</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Dni</th>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Phone</th>
                            <th>Email Address</th>
                            <th>Birth Date</th>
                            <th>Specialty</th>
                            <th style="width:210px">Option</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>Id</th>
                            <th>Dni</th>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>Phone</th>
                            <th>Email Address</th>
                            <th>Birth Date</th>
                            <th>Specialty</th>
                            <th style="width:210px">Option</th>
                        </tr>
                    </tfoot>
                    
                    <%
                        List<Dentist>dentists = (List)request.getSession().getAttribute("dentists");                        
                    %>                    
                    <tbody>
                        <%for(Dentist dentist:dentists){%>
                        <tr>
                            <td id="id<%=dentist.getId()%>"><%=dentist.getId()%></td>
                            <td><%=dentist.getDni()%></td>
                            <td><%=dentist.getName()%></td>
                            <td><%=dentist.getSurname()%></td>
                            <td><%=dentist.getPhone()%></td>
                            <td><%=dentist.getEmail()%></td>
                            <td><%=dentist.getBirthDate()%></td>
                            <td><%=dentist.getSpecialty()%></td>
                            <td style="display: flex; width: 230px">                            
                                <form name="dentist-deletion" action="DentistDeletionServlet" method="POST">
                                    <button type="submit" class="btn btn-danger btn-user" style="margin-right: 5px">
                                        <i class="fas fa-trash-alt"></i> Delete                      
                                    </button>                                    
                                    <input type="hidden" name="dentist-id" value="<%=dentist.getId()%>"/>                        
                                </form>
                                <form name="dentist-update" action="DentistUpdateServlet" method="GET">
                                    <button type="submit" class="btn btn-warning btn-user" style="margin-left: 5px">
                                        <i class="fas fa-pencil-alt"></i> Update
                                    </button>                                    
                                    <input type="hidden" name="dentist-id" value="<%=dentist.getId()%>" />
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