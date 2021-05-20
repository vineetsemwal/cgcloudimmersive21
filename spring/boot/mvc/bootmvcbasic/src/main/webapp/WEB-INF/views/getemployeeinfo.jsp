<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>


<html>

<body>

<form  method="get" action="/processgetemp" >

<div>
<label> Employee Id </label>

 <input name="id" type="number"  />

</div>



<input type="submit" value="Get Employee"  />


</form>

</body>


</html>
