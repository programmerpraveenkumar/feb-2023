<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.app.PersonDetails"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<!--
scriptlet -> import the java and other libraries.
expression->display the varaibles.
declaration -> to declare the variables and methods
  -->
  <%!
  PersonDetails personObj = new PersonDetails();
  	int square(int num){
	  return num*num;
  }
  %>
  <%!
  String name = "sample name";
  %>
<body>
<h1><%=name %></h1>
<h1><% out.print(name); %></h1>
<h2><%= square(5) %></h2>
<h2><% out.print(square(9));out.print(square(5));out.print(square(6)); %></h2>

<h3><%= personObj.getDetails() %></h3>
<h3><%out.print(personObj.getDetails()); %></h3>
<h3>
<%
PersonDetails personObj1 = new PersonDetails();
out.print(personObj1.getDetails());

%></h3>
</body>
</html>