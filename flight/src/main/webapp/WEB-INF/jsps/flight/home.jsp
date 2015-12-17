<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>home flight</title>
</head>
<body>
<h1>Welcome to the Flight Service</h1>
<p>we have the following specials: </p>

<ul>
    <c:forEach items="${specials}" var="special">
        <li>${special.getDepartFrom().getName()} - ${special.getArriveAt().getName()} from $ ${special.getCost()}</li>
    </c:forEach>
</ul>

<p><a href="flight/search">Search for a flight.</a> </p>


</body>
</html>
