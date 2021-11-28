<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<link href="<%=request.getContextPath()%>/styles/navbar.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/styles/report.css" rel="stylesheet" type="text/css">
<title>Report Side</title>

<body>

<%@include file="jspHelpers/navbarMain.jsp"%>
<br><br><br><br>
<%@include file="jspHelpers/navbarAdmin.jsp"%>
<br><br>

<main class="container">
    <div class="main">
        <h1>Rapport fra og til</h1>
        <form action="<%=request.getContextPath()%>/admin/getReport" method="post">

            <div>
                <div id="from">
                    <label for="fDate">Fra: </label>
                    <input class="input" type="date" name="fDate" id="fDate" required>
                </div>
                <div id="to">
                    <label for="eDate">Til: </label>
                    <input type="date" name="eDate" id="eDate" required>
                </div>
                <br>
                <div>
                    <button class="submit" type="submit" >Lag Rapport</button>
                </div>
            </div>
        </form>
    </div>

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