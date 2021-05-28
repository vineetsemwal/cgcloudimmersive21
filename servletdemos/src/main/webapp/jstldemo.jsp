<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>First JSP</title>
</head>
<body>

<h1> Jstl demo </h1>

<h3> All Students </h3>

<--
 Below c:foreach will do the same task
  for(Student stud: list){
   out.println(stud.rollno);
  }
-->
<c:forEach items="${list}" var="stud" >

<c:out value="${stud.rollno}" />

<c:out value="${stud.age}" />

<c:out value="${stud.name}" />

<br>
</c:forEach>




<h3>Top Student Information</h3>

<c:out value="${student.rollno}" />

<c:out value="${student.age}" />

<c:out value="${student.name}" />




</body>
</html>


