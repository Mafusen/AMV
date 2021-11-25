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
<title>Report Side</title>

<body>

<%@include file="jspHelpers/navbarMain.jsp"%>
<br><br><br><br>
<%@include file="jspHelpers/navbarAdmin.jsp"%>
<h1>Rapport fra og til</h1>

<main class="container">
    <form action="<%=request.getContextPath()%>/admin/getReport" method="post">

        <div>
            <div>
                <label for="fDate">Fra: </label>
            </div>
            <div>
                <input class="input" type="date" name="fDate" id="fDate" required>
            </div>
            <div>
                <label for="eDate">Til: </label>
            </div>
            <div>
                <input type="date" name="eDate" id="eDate" required>
            </div>
            <br> </br> <br> </br>
            <div>
                <button class="submit" type="submit" >Lag Rapport</button>
            </div>
        </div>
    </form>

</main>
<script>
    let fDate = document.querySelector('#fDate');
    let tDate = document.querySelector('#eDate');

    fDate.addEventListener('change', function() {
        tDate.min = this.value;
    });
</script>


</body>

</html>