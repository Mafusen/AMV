<%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 15/10/2021
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="bacit.web.Models.ReportModel" %>
<%@ page import="java.util.ArrayList" %>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Produkt Side</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <title>Rapport Side</title>
    <style>
            #print {
                text-align: center;
            }
            .button {
                font: bold 11px Arial;
                text-decoration: none;
                background-color: green;
                color: white;
                padding: 6px 12px 6px 12px;
                border-top: 1px solid #CCCCCC;
                border-right: 1px solid #333333;
                border-bottom: 1px solid #333333;
                border-left: 1px solid #CCCCCC;
            }
            @media print {
                /* All your print styles go here */
                #print { display: none !important; }
            }
    </style>
</head>

<body>

<table class="table" style=text-align:center border=1 width=50% height=10%>
    <thead>
    <tr>
        <th>Booking ID</th>
        <th>Verktøy</th>
        <th>Bruker</th>
        <th>Start Dato</th>
        <th>Slutt Dato</th>
        <th>Kommentar</th>
        <th>Total Pris</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<ReportModel> report = (ArrayList<ReportModel>) request.getAttribute("report");
        for(ReportModel model : report){
    %>
    <tr>
        <td><%=model.getBookingID()%></td>
        <td><%=model.getToolName()%></td>
        <td><%=model.getFirstName()%> <%=model.getLastName()%></td>
        <td><%=model.getStartDate()%></td>
        <td><%=model.getEndDate()%></td>
        <td><%=model.getComment()%></td>
        <td><%=model.getTotalPrice()%></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<div id="print">
    <a href="#" class = "button" onclick="window.print();return false;" rel="nofollow noopener">Last Ned Rapporten</a>
</div>
</body>