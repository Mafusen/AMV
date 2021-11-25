<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Levert</title>
    <link rel="stylesheet" href="styles/popup.css" type="text/css">
    <link href="navbar.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@include file="jspHelpers/navbarMain.jsp"%>
<main>
    <div class="modal-container" id="modal_container">
        <div class="modal">
            <h2>Verktøy levert!</h2>
            <%--        Bytt action til hvor brukeren skal sendes til!                        --%>
            <form method="post" action="frontPageServlet">
                <button class="btn">Ok</button>
            </form>
        </div>
    </div>
</main>
</body>
</html>