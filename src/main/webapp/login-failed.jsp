<%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 10/11/2021
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href = "<%=request.getContextPath()%>/styles/login.css" type = "text/css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" />

  <title>AMV Innlogging</title>
  <style>
  </style>
</head>
<body id="bodyf">
<br><br><br><br>
<h2><img src="https://images.squarespace-cdn.com/content/v1/5bcf4baf90f904e66e8eb8bf/1571139220977-8Y75FILX6E39M4ZH8REW/
              Logo-eng-web-blue.png?format=1500w"></h2><br>
<div class="login">
  <form action="j_security_check" method="post">
    <div class="error">
      <div class="close" onclick="this.parentElement.remove()">X</div>
      Feil passord eller brukernavn...
      <br>
      Prøv igjen!
    </div>
    <label><b>Brukernavn:
    </b>
      <br>
    </label>
    <label for="Username"></label><input type="text" name="j_username" id="Username" placeholder="">
    <br><br>
    <label><b>Passord:
    </b>
      <br>
    </label>
    <label for="password"></label>
    <input type="Password" name="j_password" id="Password" placeholder="">
    <i class="bi bi-eye-slash" id="togglePassword"></i>
    <br><br>
    <label>
      <input type = "submit" name = "submit" id = "submit" value = "Logg Inn">
    </label>
  </form>
  <a>
    <%=
    displayDate()
    %>
  </a>

  <%!
    public String displayDate(){
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
      Date date = Calendar.getInstance().getTime();
      return dateFormat.format(date);
    }
  %>
</div>
<script>
  const togglePassword = document.querySelector('#togglePassword');
  const password = document.querySelector('#Password');
  togglePassword.addEventListener('click', function (e) {
    // toggle the type attribute
    const type = password.getAttribute('type') === 'Password' ? 'text' : 'password';
    password.setAttribute('type', type);
    // toggle the eye / eye slash icon
    this.classList.toggle('bi-eye');
  });
</script>
</body>
</html>
