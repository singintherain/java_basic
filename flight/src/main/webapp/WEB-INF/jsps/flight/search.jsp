<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>home flight</title>
</head>
<body>

<h1>Search For Flight Service</h1>

    <spring action="" method="post">
        <table>
            <tr>
                <td>Depart From:</td>
                <td>
                    <%--<spring:input path="departFrom"></spring:input>--%>
                </td>
            </tr>
            <tr>
                <td>Depart On:</td>
                <td>
                    <%--<spring:input path="departOn"/>--%>
                </td>
            </tr>
            <tr>
                <td>Arrite At:</td>
                <td>
                    <%--<spring:textarea path="testcase"/>--%>
                </td>
            </tr>
        </table>
    </spring>

</body>
</html>
