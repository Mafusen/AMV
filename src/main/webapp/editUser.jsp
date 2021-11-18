<%@ page import="bacit.web.Models.UserModel" %>
<%@ page import="java.util.List" %>
<%@ page import="bacit.web.DAOs.CertificateDAO" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 17/11/2021
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="styles/newUser.css">
  <title>Rediger Bruker</title>
</head>
<link href="<%=request.getContextPath()%>/styles/navbar.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/styles/newUser.css" rel="stylesheet" type="text/css">

<body>

<%@include file="jspHelpers/navbarMain.jsp"%>
<br><br><br><br>
<%@include file="jspHelpers/navbarAdmin.jsp"%>
<br><br><br><br>


    <%
      UserModel user = (UserModel) request.getAttribute("user");
      int userID = user.getUserID();

      List<String> roles = (List<String>) request.getAttribute("roles");
      boolean administrator = false;
      boolean unionMember = false;
      if(roles.contains("administrator")){
        administrator = true;
      }if(roles.contains("union-member")){
        unionMember = true;
      }

      List<Integer> certificates = (List<Integer>) request.getAttribute("certificates");
      boolean lift = certificates.contains(1);
      CertificateDAO cDao = new CertificateDAO();
      Date expires = null;
      try {
        expires = cDao.expiryDate(1, userID);
      } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
      }
    %>
<h1>Rediger bruker: <%=user.getUserName()%></h1>

<main class="container">

  <form action="<%=request.getContextPath()%>/admin/gjorEndring?userID=<%=userID%>" method="post">
    <div class="column">

      <div class="inputtext">
        <label for="phone">Telefonnummer: </label>
      </div>
      <div>
        <input class="input" type="text" name="phone" id="phone" value = "<%=user.getPhone()%>" required placeholder="99966999">
      </div>

      <div class="inputtext">
        <label for="passWord">Nytt Passord (hvis ønsket): </label>
      </div>
      <div>
        <input class="input" type="text" name="passWord" id="passWord" placeholder="Passord123">
      </div>

    </div>

    <div class="column">
      <br> <br> <br>
      <div class="role">
        <label for="unionMember"> Unionsmedlem </label>
        <input type="checkbox" name="unionMember" id="unionMember" value="unionMember_value"
          <% if(unionMember){ %> checked <% } %>>
      </div>

      <div class="role">
        <label for="admin"> Administrator </label>
        <input type="checkbox" name="admin" id="admin" value="admin_value"
          <% if(administrator){ %> checked <% } %>>
      </div>

      <div class="role">
        <label for="lift"> Personløftersertifikat </label>
        <input type="checkbox" name="lift" id="lift" value ="lift_value"
        <% if(lift){ %> checked <% } %>>
      </div>

      <div class="role">
        <label for="endDate"> Sertifikatet går ut: </label>
        <input type="date" name="endDate" id="endDate" value="<%=expires%>">
      </div>

      <br><br>
      <div class="userForm">

        <a href = "admin/Users">
          <button class="submit" type="submit" >Lagre endringer</button>
        </a>
      </div>
    </div>
  </form>

</main>



</body>

</html>
