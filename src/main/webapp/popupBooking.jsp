<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Popup</title>
    <link rel="stylesheet" href="styles/popup.css" type="text/css">
    <link href="styles/navbar.css" type="text/css" rel="stylesheet">
</head>
<body>
<%@include file="jspHelpers/navbarMain.jsp"%>
<main>
    <div class="modal-container" id="modal_container">
        <div class="modal">
            <h2>Booking bekreftet</h2>
            <%--        Bytt action til hvor brukeren skal sendes til!                        --%>
            <a href="frontpageServlet">
                <button class="btn">Ok</button>
            </a>
        </div>
    </div>
</main>
</body>
</html>