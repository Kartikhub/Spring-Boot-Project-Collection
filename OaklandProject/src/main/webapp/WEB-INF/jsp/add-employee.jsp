<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Register Employee</title>
    </head>
    <body>
        <c:if test="${addEmployeeSuccess}">
        <h1>${savedEmployee.name}, you are successfully registered!!!</h1>
        </c:if>
        <c:if test="${!addEmployeeSuccess}">
        <h1>Register Employee</h1>    
        <c:url var="add_employee_url" value="/addEmployee"/>
        <form:form action="${add_employee_url}" method="post" modelAttribute="employee">
            <form:label path="employeeId">Employee Id: </form:label> <form:input type="text" path="employeeId"/>
            <br />
            <br />
            <form:label path="name">Employee Name: </form:label> <form:input type="text" path="name"/>
            <br />
            <br />
            <form:label path="dob">Date Of Birth: </form:label> <form:input path="dob"/>
            <br />
            <br />
            <form:label path="address">Address: </form:label> <form:input path="address"/>
            <br />
            <br />
            <form:label path="city">City: </form:label> <form:input path="city"/>
            <br />
            <br />
            <form:label path="state">State: </form:label> <form:input path="state"/>
            <br />
            <br />
            <form:label path="gender">Gender: </form:label> <form:input path="gender"/>
            <br />
            <br />
            <form:label path="loginId">LoginId: </form:label> <form:input path="loginId"/>
            <br /><br />
            <form:label path="password">Password: </form:label> <form:input path="password"/>
            <br />
            <br />
            <input type="submit" value="submit"/>
        </form:form>
        </c:if>
    </body>
</html>