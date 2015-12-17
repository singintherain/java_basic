<html>
<head>
    <title>登录页面</title>

</head>
<body>
    <%@page import="java.lang.*" %>
    <%@page import="java.io.*" %>
    <%@page import="lvsong.club.*" %>
    <%
        InputStream inputStream = new FileInputStream("TestClass.class");
        byte[] b = new byte[inputStream.available()];
        inputStream.read(b);
        System.out.println("<textarea style='width: 1000; height=800'>");
        System.out.println(JavaClassExecutor.execute(b));
        System.out.println("</textarea>");
    %>
</body>
</html>