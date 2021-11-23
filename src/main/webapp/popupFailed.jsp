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
    <title>Oops...</title>
    <link rel="stylesheet" href="styles/popup.css" type="text/css">
    <link href="styles/navbar.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@include file="jspHelpers/navbarMain.jsp"%>
<main>
    <div class="modal-container" id="modal_container">
        <div class="modal">
            <h2>Det oppstå en feil, prøv igjen!</h2>
            <%--        Bytt action til hvor brukeren skal sendes til!                        --%>
            <form method="post" action="FrontpageServlet">
                <button class="btn">Ok</button>
            </form>
        </div>
    </div>
</main>
</body>
</html>
