<%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 17/11/2021
  Time: 13:51
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

<%@include file="jspHelpers/navbarMain.jsp"%>

<br><br><br><br>
<h1>Rediger bruker:</h1>

<main class="container">
  <form action="<%=request.getContextPath()%>/minSide/byttPassord" method="post">

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

      <div class="userForm">
        <button class="reset" type="reset" value="Reset alle felter">Reset alle felter</button>

        <a href = "minSide/byttPassord">
          <button class="submit" type="submit" >Lagre</button>
        </a>
      </div>

    </div>
  </form>

</main>



</body>

</html>
