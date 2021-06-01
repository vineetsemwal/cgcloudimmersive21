<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<body>

<a href="/"> GoBack to Home page  </a>

<form  method="get" action="/processregister" >

<div>
<label> Employee Name </label>

 <input name="empname" type="text"  />

</div>


<div>
<label> Employee Salary </label>

 <input name="empsalary" type="number"  />

</div>



<input type="submit" value="Register"  />


</form>

</body>
</html>