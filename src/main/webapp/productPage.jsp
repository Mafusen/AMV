<%@ page import="bacit.web.amv_models.FileModel" %>
<%@ page import="bacit.web.amv_models.ToolFileModel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.Blob" %>
<%@ page import="java.io.OutputStream" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>

<head>
    <meta name="AMV - Produktside" content="width=device-width, initial-scale=1">
    <link href="styles/productPage.css" rel="stylesheet">
    <link href="styles/navbar.css" rel="stylesheet">
    <title>AMV - Velferden</title>
</head>

<body>
<nav class="navbar">
    <a class="logo" href = "frontpageAvailableServlet">
        <img src="https://images.squarespace-cdn.com/content/5bcf4baf90f904e66e8eb8bf/1571139220977-8Y75FILX6E39M4ZH8REW/Logo-eng-web-blue.png?content-type=image%2Fpng" alt="AMV">
    </a>
    <ul class="nav-links">

        <li class="nav-item"><a href="getToolsServlet">Admin</a></li>
        <li class="nav-item"><a href="myPage.jsp">Min Side</a></li>
        <li class="nav-item"><a href="bookingHistoryServlet">Bookinger</a></li>
        <li class="nav-item"><a style="padding-right: 30px" href="logInServlet">Logg ut</a></li>
    </ul>
</nav>

<div class="main">
    <div class="search">
        <label>
            <input type="text" placeholder="Søk etter produkt..">
        </label>
    </div>

    <button type="button" class="collapsible"><strong>Aktive Bookinger</strong></button>
    <div class="content">
        <div class="container">

            <a class="products" href="bookingPage.jsp">
                <img src="styles/#">
                <div class="product">
                    <div class="productname">Eksentersliper 230VAC</div>
                    <div class="productinfo"> Info om produkt:</div>
                    <div class="productinfo"> + papir </div>
                </div>
            </a>
        </div>
    </div>

    <button type="button" class="notcollapsible"><strong>Andre Produkter</strong></button>
    <div class="content">
        <div class="container">
    <%
        List<ToolFileModel> products = (ArrayList<ToolFileModel>) request.getAttribute("toolViews");

        for(ToolFileModel product : products){
            // int fileIDint = tool.getFileID();
            //String fileID = Integer.toString(fileIDint);

    %>
            <a class="products" href="registerBooking">
                <img src="fileDownloadServlet?FILE_ID=<%=product.getFileID()%>" alt = "<%=product.getToolName()%>">
                <div class="product">
                    <div class="productname"><%=product.getToolName()%></div>
                    <div class="productinfo">Info: <%=product.getToolInfo()%></div>
                </div>
            </a>


    <%
        }
    %>


        </div>
    </div>

    <script>
        var coll = document.getElementsByClassName("collapsible");
        var i;
        for (i = 0; i < coll.length; i++) {
            coll[i].addEventListener("click", function() {
                this.classList.toggle("active");
                var content = this.nextElementSibling;
                if (content.style.display === "block") {
                    content.style.display = "none";
                } else {
                    content.style.display = "block";
                }
            });
        }
    </script>
</div>
</body>
</html>
