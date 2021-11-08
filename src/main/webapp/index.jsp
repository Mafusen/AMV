<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href = "styles/login.css">
    <title>AMV Innlogging</title>
    <style>
    </style>
</head>
<body>
<br><br><br><br>
<h2><img src="https://images.squarespace-cdn.com/content/v1/5bcf4baf90f904e66e8eb8bf/1571139220977-8Y75FILX6E39M4ZH8REW/
              Logo-eng-web-blue.png?format=1500w"></h2><br>
<div class="login">
    <form action="logInServlet" method="post">
        <br><br>
        <label><b>Brukernavn:
        </b>
            <br>
        </label>
        <label for="Username"></label><input type="text" name="Username" id="Username" placeholder="">
        <br><br>
        <label><b>Passord:
        </b>
            <br>
        </label>
        <label for="Password"></label><input type="Password" name="Password" id="Password" placeholder="">
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
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date date = Calendar.getInstance().getTime();
            return dateFormat.format(date);
        }
    %>
</div>
</body>
</html>