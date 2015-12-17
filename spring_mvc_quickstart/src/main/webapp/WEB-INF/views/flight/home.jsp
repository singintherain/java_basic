<%--
  Created by IntelliJ IDEA.
  User: lvsong
  Date: 7/15/15
  Time: 2:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="content-type" content="text/html; charset=ISO-8859-1" />
    <title>Flight Booking Service</title>
</head>
<body>
<h1>Welcome to the Flight Booking Service</h1>
<p>We have the following specials now: </p>
<ul>
    <c:forEach items="${specials}" var="special">
        <li>${special.getDepartFrom().getName() - special.getArriveAt().getName()} from $${special.getCost()}</li>
    </c:forEach>
</ul>

<p><a href="flight/search">Search for a flight.</a> </p>

</body>
</html>
