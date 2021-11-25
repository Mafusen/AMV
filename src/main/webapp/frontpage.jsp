<%@ page import="bacit.web.Models.FileModel" %>
<%@ page import="bacit.web.Models.ToolModel" %>
<%@ page import="java.util.*" %>
<%@ page import="bacit.web.Models.BookingModel" %>
<%@ page import="bacit.web.DAOs.FileDAO" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>

<head>
    <meta name="AMV - Forside" content="width=device-width, initial-scale=1">
    <link href="styles/productPage.css" rel="stylesheet">
    <link href="styles/navbar.css" rel="stylesheet">
    <title>AMV - Velferden</title>
</head>

<body>
<%@include file="jspHelpers/navbarMain.jsp"%>

<div class="main">
    <form action = "<%=request.getContextPath()%>/frontpageServlet" method = "get">
        <div class="search">
            <label>
                <input type="text" name = "search" id = "search" placeholder="Søk etter produkt..">
            </label>
        </div>
    </form>

    <button type="button" class="collapsible"><strong>Aktive Bookinger</strong></button>
    <div class="content">
        <div class="activecontainer">

            <%
                LinkedHashMap<ToolModel, BookingModel> bookings = (LinkedHashMap<ToolModel, BookingModel>) request.getAttribute("bookings");
                for(Map.Entry<ToolModel, BookingModel> booking : bookings.entrySet()){
                    FileDAO fDao = new FileDAO();
                    int fileID = 0;
                    try {
                        fileID = fDao.getFileForTool(booking.getKey().getToolID()).getFileID();
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    String info;
                    if(booking.getKey().getToolInfo() != null){
                        info = booking.getKey().getToolInfo();
                    }else{
                        info = " ";
                    }
            %>
            <a class="products" href="passBooking?bookingID=<%=booking.getValue().getBookingID()%>">
                <img src="fileDownloadServlet?FILE_ID=<%=fileID%>" alt = "<%=booking.getKey().getToolName()%>">
                <div class="product">
                    <div class="productname"><%=booking.getKey().getToolName()%></div>
                    <div class="producttitles">Info:</div>
                    <div class="productinfo"><%=info%></div>
                    <div class="producttitles">Pris per dag:</div>
                    <div class="productprice"><%=booking.getKey().getPrice()%> kr</div>
                </div>
            </a>
            <%
                }
            %>
        </div>
    </div>

    <button type="button" class="notcollapsible"><strong>Andre Produkter</strong></button>

    <div class="content">
        <div class="container">


            <%
                LinkedHashMap<ToolModel, FileModel> products = (LinkedHashMap<ToolModel, FileModel>) request.getAttribute("products");
                for (Map.Entry<ToolModel, FileModel> product : products.entrySet()) {

                    String info;
                    if(product.getKey().getToolInfo() != null){
                        info = product.getKey().getToolInfo();
                    }else{
                        info = " ";
                    }

            %>
            <a class="products" href="passProduct?toolID= + <%=product.getKey().getToolID()%>">
                <img src="fileDownloadServlet?FILE_ID=<%=product.getValue().getFileID()%>" alt = "<%=product.getKey().getToolName()%>">
                <div class="product">
                    <div class="productname"><%=product.getKey().getToolName()%></div>
                    <div class="producttitles">Info:</div>
                    <div class="productinfo"> <%=info%></div>
                    <div class="producttitles">Pris per dag:</div>
                    <div class="productprice"> <%=product.getKey().getPrice()%> kr</div>

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

    <script>
        var coll = document.getElementsByClassName("collapsibleinfo");
        var i;
        for (i = 0; i < coll.length; i++) {
            coll[i].addEventListener("click", function() {
                this.classList.toggle("active");
                var content = this.nextElementSibling;
                if (content.style.maxHeight){
                    content.style.maxHeight = null;
                } else {
                    content.style.maxHeight = content.scrollHeight + "px";
                }
            });
        }
    </script>

</div>
</body>
</html>