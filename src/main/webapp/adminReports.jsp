<%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 15/10/2021
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href = "styles/navbar.css" rel="stylesheet" type = "text/css">
    <title>Title</title>
</head>
<body>
<nav class="navbar">
    <a class="logo" href = "<%=request.getContextPath()%>/frontpageServlet">
        <img src="https://images.squarespace-cdn.com/content/5bcf4baf90f904e66e8eb8bf/1571139220977-8Y75FILX6E39M4ZH8REW/Logo-eng-web-blue.png?content-type=image%2Fpng">
    </a>
    <ul class="nav-links">

        <li class="nav-item"><a href="admin/Tools">Admin</a></li>
        <li class="nav-item"><a href="myPage.jsp">Min Side</a></li>
        <li class="nav-item"><a href="bookings.jsp">Bookinger</a></li>
        <li class="nav-item"><a style="padding-right: 30px" href="#logout">Logg ut</a></li>
    </ul>
</nav>
<br><br><br><br>
<nav class="adminTabs">

    <ul class="nav-links">

        <li class="nav-item"><a href="adminEmployees.jsp">Ansatte</a></li>
        <li class="nav-item"><a href="admin/getToolsServlet">Verktoy</a></li>
        <li class="nav-item"><a href="adminReports.jsp">Rapport</a></li>
    </ul>

</nav>

<div class="main">
    <br><br><h1>Side for rapporter</h1>


    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
    <p>Some text some text some text some text..</p>
</div>

</body>
</html>
