<%--
  Created by IntelliJ IDEA.
  User: bjornarsomme
  Date: 16/11/2021
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav2 class="navbar2">

    <ul class="nav-links">

        <li class="nav-item"><a href="<%=request.getContextPath()%>/bookingHistoryServlet">LeieHistorikk</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/aktiveBookinger">Aktive Bookinger</a></li>
        <li class="nav-item"><a href="<%=request.getContextPath()%>/fremtidigeBookinger">Fremtidige Bookinger</a></li>
    </ul>

</nav2>
