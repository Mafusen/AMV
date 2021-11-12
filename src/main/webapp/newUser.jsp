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
        <title></title>

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
<nav class="adminTabs">

    <ul class="nav-links">

        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Users">Ansatte</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Tools">Verktoy</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/report">Rapport</a></li>
    </ul>

</nav>

<h1>Legg til ny bruker:</h1>

<main class="container">
    <form action="<%=request.getContextPath()%>/admin/registerUser" method="post">


        <div class="column">
            <div class="inputtext">
                <label for="firstName">Fornavn: </label>
            </div>
            <div>
                <input class="input" type="text" name="firstName" id="firstName" required placeholder="Ola">
            </div>

            <div class="inputtext">
                <label for="lastName">Etternavn: </label>
            </div>
            <div>
                <input class="input" type="text" name="lastName" id="lastName" required placeholder="Nordmann">
            </div>

            <div class="inputtext">
                <label for="phone">Tlf: </label>
            </div>
            <div>
                <input class="input" type="text" name="phone" id="phone" required placeholder="99966999">
            </div>

            <div class="inputtext">
                <label for="userName">Brukernavn: </label>
            </div>
            <div>
                <input class="input" type="text" name="userName" id="userName" required placeholder="Norol">
            </div>

            <div class="inputtext">
                <label for="passWord">Passord: </label>
            </div>
            <div>
                <input class="input" type="text" name="passWord" id="passWord" required placeholder="Passord1">
            </div>
        </div>

        <div class="column">
            <br> </br> <br> </br> <br> </br>
            <div class="role">
                <label for="unionMember"> Unionsmedlem </label>
                <input type="checkbox" name="unionMember" id="unionMember" value="unionMember_value">
            </div>

            <div class="role">
                <label for="admin"> Administrator </label>
                <input type="checkbox" name="admin" id="admin" value="admin_value">
            </div>

            <div class="role">
                <label for="lift"> Personløftersertifikat </label>
                <input type="checkbox" name="lift" id="lift" value ="lift_value">
            </div>

            <div class="role">
                <label for="endDate"> Sertifikatet går ut: </label>
            </div>
            <div>
                <input type="date" name="endDate" id="endDate">
            </div>
            <br> </br> <br> </br>
            <div class="userForm">
                <button class="reset" type="reset" value="Reset alle felter">Reset alle felter</button>

                <a href = "admin/Users">
                    <button class="submit" type="submit" >Registrer ny bruker</button>
                </a>
            </div>
        </div>
    </form>

</main>



</body>

</html>