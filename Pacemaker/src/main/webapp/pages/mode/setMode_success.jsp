<%--
  Created by IntelliJ IDEA.
  User: qhr74
  Date: 2020/10/26
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success set mode</title>
    <%@include file="/pages/common/head.jsp" %>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.png">
    <%@ include file="/pages/common/login_success_menu.jsp" %>
</div>
<div id="modeMain">
    <div class="communication">
        connected
    </div>
    <div class="pacemakerID">
        pacemaker ID: 74426726
    </div>
    <div style="font-size: 30px; position: absolute;top: 15px;left: 12px">Dear<span class="um_span">${sessionScope.user.username}</span>, here are your choice of mode and parameters:</div>
    <table class="modeTable">
        <tr><td>Mode:${sessionScope.mode.mode}</td></tr>
        <tr><td>Lower Rate Limit:${empty sessionScope.mode.LRL?"null":sessionScope.mode.LRL}</td></tr>
        <tr><td>Upper Rate Limit:${empty sessionScope.mode.URL?"null":sessionScope.mode.URL}</td></tr>
        <tr><td>Atrial Amplitude:${empty sessionScope.mode.AA?"null":sessionScope.mode.AA}</td></tr>
        <tr><td>Ventricular Amplitude:${empty sessionScope.mode.VA?"null":sessionScope.mode.VA}</td></tr>
        <tr><td>Atrial Pulse Width:${empty sessionScope.mode.APW?"null":sessionScope.mode.APW}</td></tr>
        <tr><td>Ventricular Pulse Width:${empty sessionScope.mode.VPW?"null":sessionScope.mode.VPW}</td></tr>
        <tr><td>VRP:${empty sessionScope.mode.VRP?"null":sessionScope.mode.VRP}</td></tr>
        <tr><td>ARP:${empty sessionScope.mode.ARP?"null":sessionScope.mode.ARP}</td></tr>
        <tr><td>Maximum Sensor Rate:${empty sessionScope.mode.MSR?"null":sessionScope.mode.MSR}</td></tr>
        <tr><td>Fixed AV Delay:${empty sessionScope.mode.FAD?"null":sessionScope.mode.FAD}</td></tr>
        <tr><td>Atrial Sensitivity:${empty sessionScope.mode.AS?"null":sessionScope.mode.AS}</td></tr>
        <tr><td>Ventricular Sensitivity:${empty sessionScope.mode.VS?"null":sessionScope.mode.VS}</td></tr>
        <tr><td>PVARP:${empty sessionScope.mode.PVARP?"null":sessionScope.mode.PVARP}</td></tr>
    </table>
    <table class="modeTable2">
        <tr><td>Activity Threshold:${empty sessionScope.mode.AT?"null":sessionScope.mode.AT}</td></tr>
        <tr><td>Reaction Time:${empty sessionScope.mode.RT?"null":sessionScope.mode.RT}</td></tr>
        <tr><td>Response Factor:${empty sessionScope.mode.RF?"null":sessionScope.mode.RF}</td></tr>
        <tr><td>Recovery Time:${empty sessionScope.mode.recT?"null":sessionScope.mode.recT}</td></tr>
    </table>

    <form action="modeServlet" method="post" class="echo">
        <input type="hidden" name="action" value="getEcho">
        <input type="submit" value="get Echoed Parameters">
    </form>

    <form action="modeServlet" method="post" class="egram">
        <input type="hidden" name="action" value="getPlot">
        <input type="submit" value="lauch pacamaker graph plotter">
    </form>

    <form action="modeServlet" method="post" class="stop">
        <input type="hidden" name="action" value="stopReceiveData">
        <input type="submit" value="stop receiving data">
    </form>
</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>
