<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Produkt Side</title>

  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="styles/navbar.css" rel="stylesheet" type="text/css">
    <link href="styles/calendar.css" type="text/css" rel="stylesheet">
    <title>Produkt Side</title>

<body>

<nav class="navbar">
  <a class="logo" href="<%=request.getContextPath()%>/frontpageServlet">
    <img src="https://images.squarespace-cdn.com/content/5bcf4baf90f904e66e8eb8bf/1571139220977-8Y75FILX6E39M4ZH8REW/Logo-eng-web-blue.png?content-type=image%2Fpng">
  </a>
  <ul class="nav-links">

    <li class="nav-item"><a href="<%=request.getContextPath()%>/admin/Tools">Admin</a></li>
    <li class="nav-item"><a href="myPage.jsp">Min Side</a></li>
    <li class="nav-item"><a href="<%=request.getContextPath()%>/bookingHistoryServlet">Bookinger</a></li>
    <li class="nav-item"><a style="padding-right: 30px" href="<%=request.getContextPath()%>/logOut">Logg ut</a></li>
  </ul>
</nav>

<main class="container">
  <form action = "deliverBooking" method = "get">

    <!-- Left Column / Headphones Image -->
    <div class="left-column">
      <img src="lift2.jpg" alt="">
    </div>


    <!-- Right Column -->
    <div class="right-column">

      <!-- Product Description -->
      <div class="product-description">
        <h1>Lift</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur justo leo, aliquet maximus neque nec, cursus porttitor odio. Pellentesque semper dui et purus ultricies consectetur. Nulla rutrum lacinia urna vel sollicitudin.
          Proin cursus scelerisque lacinia. Duis dolor odio, pretium ut elementum id, viverra non ante. Proin sit amet suscipit est. Aliquam luctus nec nunc eget facilisis.</p>
      </div>

      <div class="product-price">
        <p>
          100kr/dag
        </p>
      </div>

      <div class="comment">
        <div>
          <label for="kommentar">Kommentar</label>
        </div>
        <input id="kommentar" name="kommentar" type="text" placeholder="Din kommentar..." size="35">
      </div>

      <div class="buttons">
        <button type="submit" class="btn btn-danger" id="divide">Lever</button>
      </div>

    </div>
  </form>
</main>
<script>
  var today = new Date().toISOString().split('T')[0];
  document.getElementsByName("startDate")[0].setAttribute('min', today);
</script>
<script>
  var endDate = new Date();
  var dd = endDate.getDate();
  var mm = endDate.getMonth()+4; //January is 0 so need to add 1 to make it 1!
  var yyyy = endDate.getFullYear();
  if(dd<10){
    dd='0'+dd
  }
  if(mm<10){
    mm='0'+mm
  }
  endDate = yyyy+'-'+mm+ '-'+dd;
  document.getElementById("endDate").setAttribute("min", endDate);
</script>
</body>

</html>
