<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*"  %>
<%@ page import="com.dxctraining.Calculator"  %>

<jsp:useBean id="calcy" scope="page"  class= "com.dxctraining.Calculator"/>
<!--
internally this is what is happening for above jsp usebean tag
 Calculator calcy=new Calculator();

 -->


<!DOCTYPE html>
<html>
<head>
<title>First JSP</title>
</head>
<body>
<h1> Our First jsp </h1>

<div>
 How are you?
</div>

<!--expression below-->
<%= "hello in expression" %>

<br>

<!---Comment-->

<h3>Scriplet below </h3>
<br>

<%
for( int i=0; i<10;i++){
out.println("i="+i+" <br>");
}
%>


<h3>Another Scriplet below</h3>
<br>

<!--Declaring variable below -->
<%! int j=20; %>

<%

List<String> list=new ArrayList<>();
list.add("prakash");
list.add("praadeep");
list.add("anuj");
for(String name:list){
out.println(name+"<br>");
}

%>

<br>

<!---Using declared variable -->
<%
out.println("j ="+j);
%>

<br>
<h3>Calculator use below </h3>

<br>
 <%

 Calculator calculator=new Calculator();
  int result1=calculator.add(1,2);
  out.println("result of addition="+result1);

 %>
<br>

<h3>Using   object created by jsp useBean </h3>

<br>
<%
int result2=calcy.add(3,4);
out.println("result of addition="+result2);
%>

<br>

</body>
</html>


