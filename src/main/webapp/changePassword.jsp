<%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 11/11/2021
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/newUser.css">
    <title>Registrer bruker</title>
</head>
<link href="<%=request.getContextPath()%>/styles/navbar.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/styles/newUser.css" rel="stylesheet" type="text/css">
<title>Bytt Passord</title>

<body>

<nav class="navbar">
    <a class="logo" href= "<%=request.getContextPath()%>/frontpageServlet">
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
<nav class="navbar2">

    <ul class="nav-links">

        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Users">Ansatte</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Tools">Verktoy</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/report">Rapport</a></li>
    </ul>

</nav>
<br><br><br><br>
<h1>Rediger bruker:</h1>

<main class="container">
    <form action="changePasswordServlet" method="post">

        <div class="column">
            <div class="inputtext">
                <label for="oldPassword">Gammelt Passord: </label>
            </div>
            <div>
                <input class="input" type="password" name="oldPassword" id="oldPassword" required>
            </div>

            <div class="inputtext">
                <label for="newPassword">Nytt Passord: </label>
            </div>
            <div>
                <input class="input" type="password" name="newPassword" id="newPassword" required>
            </div>

            <div class="inputtext">
                <label for="confirmPassword">Bekreft Passord: </label>
            </div>
            <div>
                <input class="input" type="password" name="confirmPassword" id="confirmPassword" required>
            </div>
        </div>
            <div class="userForm">
                <button class="reset" type="reset" value="Reset alle felter">Reset alle felter</button>
                <button class="submit" type="submit" >Lagre</button>
            </div>
        </div>
    </form>

</main>



</body>

</html>
