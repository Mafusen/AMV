<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Produkt Side</title>

    <head>
        <link href="bookingPage.css" rel="stylesheet" type="text/css">
        <link href="styles/navbar.css" rel="stylesheet" type="text/css">
        <title>Produkt Side</title>

<body>

<nav class="navbar">
    <a class="logo" href="<%=request.getContextPath()%>/frontpageServlet">
        <img src="https://images.squarespace-cdn.com/content/5bcf4baf90f904e66e8eb8bf/1571139220977-8Y75FILX6E39M4ZH8REW/Logo-eng-web-blue.png?content-type=image%2Fpng">
    </a>
    <ul class="nav-links">

        <li class="nav-item"><a href="admin/Tools">Admin</a></li>
        <li class="nav-item"><a href="myPage.jsp">Min Side</a></li>
        <li class="nav-item"><a href="bookingHistoryServlet">Bookinger</a></li>
        <li class="nav-item"><a style="padding-right: 30px" href="logInServlet">Logg ut</a></li>
    </ul>
</nav>

<main class="container">

    <!-- Left Column-->
    <div class="left-column">
        <img src="styles/Eksenter.jpeg" alt="">
    </div>


    <!-- Right Column -->
    <div class="right-column">

        <!-- Product Description -->
        <div class="product-description">
            <h1>Eksentersliper 230VAC</h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur justo leo, aliquet maximus neque nec, cursus porttitor odio. Pellentesque semper dui et purus ultricies consectetur. Nulla rutrum lacinia urna vel sollicitudin.
                Proin cursus scelerisque lacinia. Duis dolor odio, pretium ut elementum id, viverra non ante. Proin sit amet suscipit est. Aliquam luctus nec nunc eget facilisis.</p>
        </div>

        <!-- Product Pricing -->
        <div class="calendar">
            <div>
                <label for="start">Start Dato:</label>
                <input type="date" id="start" name="start" value="Today" min="Today" max="Today + 4">
            </div>
            <div>
                <label for="end">Slutt Dato:</label>
                <input type="date" id="end" name="end" value="?" min="Today" max="2021-12-30">
            </div>

        </div>
        <div class="product-price">
            <span>100kr/dag</span>
            <a href="#" class="cart-btn">Book</a>
        </div>

    </div>

</main>
<script id="endDate validation">
    $("#end").change(function() {
        var startDate = document.getElementById("start").value;
        var endDate = document.getElementById("end").value;
        if ((Date.parse(endDate) <= Date.parse(startDate))) {
            alert("End date should be greater than Start date");
            document.getElementById("end").value = "";
        }
    });
</script>
</body>

</html>
