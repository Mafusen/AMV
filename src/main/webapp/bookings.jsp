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

    <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Tools">Admin</a></li>
    <li class="nav-item"><a href="myPage.jsp">Min Side</a></li>
    <li class="nav-item"><a href="<%=request.getContextPath()%>/bookingHistoryServlet">Bookinger</a></li>
    <li class="nav-item"><a style="padding-right: 30px" href="<%=request.getContextPath()%>/logOut">Logg ut</a></li>
  </ul>
</nav>
<br><br><br><br>
<nav2 class="navbar2">

  <ul class="nav-links">

    <li class="nav-item"><a href="<%=request.getContextPath()%>/bookingHistoryServlet">LeieHistorikk</a></li>
    <li class="nav-item"><a href="getToolsServlet">Aktive Bookinger</a></li>
    <li class="nav-item"><a href="adminReports.jsp">Fremtidige Bookinger</a></li>
  </ul>

</nav2>

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
