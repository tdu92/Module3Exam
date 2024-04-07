<%--
  Created by IntelliJ IDEA.
  User: JVC Store
  Date: 05/04/2024
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="http://localhost:8080/employee?action=edit" method="post">
    <input type="number" name="id" placeholder="ID" value="${employeeEdit.id}" readonly>
    <input type="text" name="name" placeholder="NAME" value="${employeeEdit.name}" >
    <input type="text" name="email" placeholder="EMAIL" value="${employeeEdit.email}" >
    <input type="text" name="address" placeholder="ADDRESS" value="${employeeEdit.address}" >
    <input type="text" name="phoneNumber" placeholder="PHONE NUMBER" value="${employeeEdit.phoneNumber}" >
    <input type="number" name="salary" placeholder="SALARY" value="${employeeEdit.salary}" >
    <input type="text" name="department" placeholder="DEPARTMENT" value="${employeeEdit.department}" >
    <button>Submit</button>
</form>
</body>
</html>
