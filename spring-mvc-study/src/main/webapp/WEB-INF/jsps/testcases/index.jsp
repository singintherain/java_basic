<%--
  Created by IntelliJ IDEA.
  User: lvsong
  Date: 7/16/15
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<div id="main">
    <div id="testcase_info">
        <form action="/testcases/execute" method="post">
            <span>测试用例：</span>
            <br/>
            <textarea id="testcase" name="testcase" cols="40" rows="5">
            </textarea>
            <br/>
            <input type="submit" value="Submit"/>
        </form>
    </div>
</div>

</body>
</html>
