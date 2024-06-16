<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login Employee</title>
    </head>
    <body>
        <c:if test="${logEmployeeSuccess}">
        <h1>Welcome, ${logEmployee.name}</h1>
        <h2>You are logged in!</h2>
        </c:if>
        <c:if test="${!logEmployeeSuccess}">
        <h1>Log In</h1>    
        <c:url var="log_employee_url" value="/logEmployee"/>
        <form:form action="${log_employee_url}" method="post" modelAttribute="employeeDetailsReq">
            <form:label path="loginId">Login Id: </form:label> <form:input type="text" path="loginId"/>
            <br />
            <br />
            <form:label path="password">Password: </form:label> <form:input type="text" path="password"/>
            <br />
            <br />
            <input type="submit" value="LOGIN"/>
        </form:form>
        </c:if>
    </body>
</html>