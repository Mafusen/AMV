<%--
  Created by IntelliJ IDEA.
  User: 47973
  Date: 10/11/2021
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Popup</title>
    <link rel="stylesheet" href="styles/popup.css" type="text/css">
    <link href="styles/navbar.css" type="text/css" rel="stylesheet">
</head>
<body>
<nav class="navbar">
    <a class="logo" href= productPage.jsp>
        <img src="https://images.squarespace-cdn.com/content/5bcf4baf90f904e66e8eb8bf/1571139220977-8Y75FILX6E39M4ZH8REW/Logo-eng-web-blue.png?content-type=image%2Fpng">
    </a>
    <ul class="nav-links">

        <li class="nav-item"><a href="adminTools.jsp">Admin</a></li>
        <li class="nav-item"><a href="myPage.jsp">Min Side</a></li>
        <li class="nav-item"><a href="bookings.jsp">Bookinger</a></li>
        <li class="nav-item"><a style="padding-right: 30px" href="index.jsp">Logg ut</a></li>
    </ul>
</nav>
<main>
    <div class="modal-container" id="modal_container">
        <div class="modal">
            <h2>Booking failed prøv igjen!</h2>
            <%--        Bytt action til hvor brukeren skal sendes til!                        --%>
            <form method="post" action="FrontpageServlet">
                <button class="btn">Ok</button>
            </form>
        </div>
    </div>
</main>
</body>
</html>
