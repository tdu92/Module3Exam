<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="<c:url value="/css/home.css"/>">
</head>
<body>
<a href="http://localhost:8080/employee?action=add">Add</a>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Phone Number</td>
        <td>Salary</td>
        <td>Department</td>
        <td colspan="2"> Action </td>
    </tr>
    <c:forEach var="item" items="${employeeList}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.email}</td>
            <td>${item.address}</td>
            <td>${item.phoneNumber}</td>
            <td>${item.salary}</td>
            <td>${item.department.name}</td>
            <td>
                <button><a href="http://localhost:8080/employee?action=edit&idEdit="${item.id}">Edit</a></button>
            </td>
            <td>
                <button>Delete</button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>