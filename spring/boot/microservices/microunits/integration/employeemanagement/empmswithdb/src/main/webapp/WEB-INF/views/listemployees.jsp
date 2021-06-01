<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<body>

<a href="/"> GoBack to Home page  </a>

<h1>Details of Employees </h1>

<c:forEach items="${list}"  var="emp" >


Id is <c:out value="${emp.id}"  />
<br/>
Name is <c:out value="${emp.name}"  />
<br/>
Salary is <c:out value="${emp.salary}"  />

<br/>
</c:forEach>


</body>
</html>