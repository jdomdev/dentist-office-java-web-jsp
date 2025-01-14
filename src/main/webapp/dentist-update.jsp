<%@page import="io.sunbit.dentistoffice.logic.Dentist"%>
<%@page import="io.sunbit.dentistoffice.logic.Controller"%>
<%@page import="io.sunbit.dentistoffice.logic.OfficeUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp" %>
<%@include file="components/body-start.jsp" %>

<h1>Dentist Updating</h1>
<p>This is the form to update the details of dentists of the system</p>

<%                    
    Dentist dentistToUp = (Dentist)request.getSession().getAttribute("dentistToUp");
%>   
%>
<!-- Display user data in a form for editing -->
<form class="dentist-update" action="DentistUpdateServlet" method="POST">
    <input type="hidden" name="dentist-id" value="<%=dentistToUp.getId() %>">
    <div class="form-group col">
        <div class="col-sm-6 mb-3">    
            <input type="text" id="dni" name="dni" class="form-control form-control-user" value="<%=dentistToUp.getDni() %>"
        </div>
        <div class="col-sm-6 mb-3">                        
            <input type="text" id="name" name="name" class="form-control form-control-user" value="<%=dentistToUp.getName() %>"><br>
        </div>
        <div class="col-sm-6 mb-3">                        
            <input type="text" id="surname" name="surname" class="form-control form-control-user" value="<%=dentistToUp.getSurname() %>"><br>
        </div> 
        <div class="col-sm-6 mb-3">    
            <input type="tel" id="phone" name="phone" class="form-control form-control-user" value="<%=dentistToUp.getPhone() %>"
        </div>
        <div class="col-sm-6 mb-3">    
            <input type="email" id="email" name="email" class="form-control form-control-user" value="<%=dentistToUp.getEmail() %>"
        </div>        
        <div class="col-sm-6 mb-3">    
            <input type="date" id="birth-date" name="birth-date" class="form-control form-control-user" value="<%=dentistToUp.getBirthDate() %>"
        </div>
        <div class="col-sm-6 mb-3">    
            <input type="text" id="specialty" name="specialty" class="form-control form-control-user" value="<%=dentistToUp.getSpecialty() %>"
        </div>        
    </div>
    <button class="btn btn-primary btn-user btn-block" type="submit">
        Update
    </button>

</form>

<%@include file="components/body-end.jsp" %>