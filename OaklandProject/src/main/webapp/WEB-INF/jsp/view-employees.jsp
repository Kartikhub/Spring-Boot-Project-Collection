<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Employees List</title>
    </head>
    <body>
    	<h1>Employees List</h1>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Date of Birth</th>
                    <th>Address</th>
                    <th>City</th>
                    <th>State</th>
                    <th>Gender</th>
                    <th>LoginId</th>
                    <th>Password</th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${employees}" var="employee">
                    <tr>
                        <td>${employee.employeeId}</td>
                        <td>${employee.name}</td>
                        <td>${employee.dob}</td>
                        <td>${employee.address}</td>
                        <td>${employee.city}</td>
                        <td>${employee.state}</td>
                        <td>${employee.gender}</td>
                        <td>${employee.loginId}</td>
                        <td>${employee.password}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>