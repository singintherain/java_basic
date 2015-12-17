<%--
  Created by IntelliJ IDEA.
  User: lvsong
  Date: 7/17/15
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<jsp:include page="../fragments/header.jsp"/>
<head>
    <title></title>
</head>
<body>
<div class="container">

  <c:if test="${not empty msg}">
    <div class="alert alert-${css} alert-dismissible" role="alert">
      <button type="button" class="close" data-dismiss="alert"
              aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
      <strong>${msg}</strong>
    </div>
  </c:if>

  <h1>User Detail</h1>
  <br />

  <div class="row">
    <label class="col-sm-2">ID</label>
    <div class="col-sm-10">${user.id}</div>
  </div>

  <div class="row">
    <label class="col-sm-2">Name</label>
    <div class="col-sm-10">${user.name}</div>
  </div>

  <div class="row">
    <label class="col-sm-2">Email</label>
    <div class="col-sm-10">${user.email}</div>
  </div>

  <div class="row">
    <label class="col-sm-2">Address</label>
    <div class="col-sm-10">${user.address}</div>
  </div>

  <div class="row">
    <label class="col-sm-2">Newsletter</label>
    <div class="col-sm-10">${user.newsletter}</div>
  </div>

  <div class="row">
    <label class="col-sm-2">Web Frameworks</label>
    <div class="col-sm-10">${user.framework}</div>
  </div>

  <div class="row">
    <label class="col-sm-2">Sex</label>
    <div class="col-sm-10">${user.sex}</div>
  </div>

  <div class="row">
    <label class="col-sm-2">Number</label>
    <div class="col-sm-10">${user.number}</div>
  </div>

  <div class="row">
    <label class="col-sm-2">Country</label>
    <div class="col-sm-10">${user.country}</div>
  </div>

  <div class="row">
    <label class="col-sm-2">Skill</label>
    <div class="col-sm-10">${user.skill}</div>
  </div>

</div>

<jsp:include page="../fragments/footer.jsp" />
</body>
</html>
