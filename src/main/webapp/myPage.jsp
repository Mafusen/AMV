<%@ page import="bacit.web.Models.UserModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<link href="<%=request.getContextPath()%>/styles/navbar.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/styles/report.css" rel="stylesheet" type="text/css">
<title>Min Side</title>

<body>

<%@include file="jspHelpers/navbarMain.jsp"%>
<br><br>
<%
    UserModel user = (UserModel) request.getAttribute("user");
%>
<main class="container">
    <div class="main">
        <h1 id="kontoinfo">Kontodetaljer</h1>
            <div>
                <div id="usern">
                    <span>Brukernavn: </span>
                    <a><%=user.getUserName()%></a>
                </div>
                <div id="name">
                    <span>Navn: </span>
                    <a><%=user.getFirstName()%></a>
                    <a><%=user.getLastName()%></a>
                </div>
                <div id="phone">
                    <span>Mobil: </span>
                    <a><%=user.getPhone()%></a>
                </div>
                <br>
                <div class="btn">
                    <a href = "<%=request.getContextPath()%>/minSide/redigerPassord">
                        <button id="rp" type = submit>Rediger Passord</button>
                    </a>
                </div>
            </div>
        </form>
    </div>

</main>
</body>
</html>
