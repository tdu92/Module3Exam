<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Add</title>
</head>
<body>
<a href="http://localhost:8080/employee?action=home">Home</a>

<form action="http://localhost:8080/employee?action=add" method="post">
    <input type="text" name="name" placeholder="NAME">
    <input type="text" name="email" placeholder="EMAIL">
    <input type="text" name="address" placeholder="ADDRESS">
    <input type="text" name="phoneNumber" placeholder="PHONE NUMBER">
    <input type="number" name="salary" placeholder="SALARY">
    <select name="idDepartment">
        <c:forEach var="item" items="${list}">
            <option value="${item.id}">${item.name}</option>
        </c:forEach>
    </select>
    <button>Submit</button>
</form>

</body>
</html>
