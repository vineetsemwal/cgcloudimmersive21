<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Employee Details</title>
</head>
<body>

<h1>Employee Details </h1>

Id is <c:out value="${emp.id}"/>
<br/>
Name is <c:out value="${emp.name}"/>
<br/>
Age is <c:out value="${emp.age}"/>
</body>
</html>
