<%@ page import="java.math.BigDecimal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qhr74
  Date: 2020/10/18
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pacemaker Mode</title>
    <%@include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("#AOO").click(function () {
                var mode = document.getElementById('mode');
                mode.innerHTML = $(this).val();
                document.getElementById("modeToServer").value = "AOO"
                document.getElementById("Lower Rate Limit").disabled = false;
                document.getElementById("Upper Rate Limit").disabled = false;
                document.getElementById("Atrial Amplitude").disabled = false;
                document.getElementById("Ventricular Amplitude").disabled = true;
                document.getElementById("Atrial Pulse Width").disabled = false;
                document.getElementById("Ventricular Pulse Width").disabled = true;
                document.getElementById("VRP").disabled = true;
                document.getElementById("ARP").disabled = true;
                document.getElementById("Maximum Sensor Rate").disabled = true;
                document.getElementById("Fixed AV Delay").disabled = true;
                document.getElementById("Atrial Sensitivity").disabled = true;
                document.getElementById("Ventricular Sensitivity").disabled = true;
                document.getElementById("PVARP").disabled = true;
                document.getElementById("Activity Threshold").disabled = true;
                document.getElementById("Reaction Time").disabled = true;
                document.getElementById("Response Factor").disabled = true;
                document.getElementById("Recovery Time").disabled = true;
            })
            $("#VOO").click(function () {
                var mode = document.getElementById('mode');
                mode.innerHTML = $(this).val();
                document.getElementById("modeToServer").value = "VOO"
                document.getElementById("Lower Rate Limit").disabled = false;
                document.getElementById("Upper Rate Limit").disabled = false;
                document.getElementById("Atrial Amplitude").disabled = true;
                document.getElementById("Ventricular Amplitude").disabled = false;
                document.getElementById("Atrial Pulse Width").disabled = true;
                document.getElementById("Ventricular Pulse Width").disabled = false;
                document.getElementById("VRP").disabled = true;
                document.getElementById("ARP").disabled = true;
                document.getElementById("Maximum Sensor Rate").disabled = true;
                document.getElementById("Fixed AV Delay").disabled = true;
                document.getElementById("Atrial Sensitivity").disabled = true;
                document.getElementById("Ventricular Sensitivity").disabled = true;
                document.getElementById("PVARP").disabled = true;
                document.getElementById("Activity Threshold").disabled = true;
                document.getElementById("Reaction Time").disabled = true;
                document.getElementById("Response Factor").disabled = true;
                document.getElementById("Recovery Time").disabled = true;
            })
            $("#AAI").click(function () {
                var mode = document.getElementById('mode');
                mode.innerHTML = $(this).val();
                document.getElementById("modeToServer").value = "AAI"
                document.getElementById("Lower Rate Limit").disabled = false;
                document.getElementById("Upper Rate Limit").disabled = false;
                document.getElementById("Atrial Amplitude").disabled = false;
                document.getElementById("Ventricular Amplitude").disabled = true;
                document.getElementById("Atrial Pulse Width").disabled = false;
                document.getElementById("Ventricular Pulse Width").disabled = true;
                document.getElementById("VRP").disabled = true;
                document.getElementById("ARP").disabled = false;
                document.getElementById("Maximum Sensor Rate").disabled = true;
                document.getElementById("Fixed AV Delay").disabled = true;
                document.getElementById("Atrial Sensitivity").disabled = false;
                document.getElementById("Ventricular Sensitivity").disabled = true;
                document.getElementById("PVARP").disabled = false;
                document.getElementById("Activity Threshold").disabled = true;
                document.getElementById("Reaction Time").disabled = true;
                document.getElementById("Response Factor").disabled = true;
                document.getElementById("Recovery Time").disabled = true;
            })
            $("#VVI").click(function () {
                var mode = document.getElementById('mode');
                mode.innerHTML = $(this).val();
                document.getElementById("modeToServer").value = "VVI"
                document.getElementById("Lower Rate Limit").disabled = false;
                document.getElementById("Upper Rate Limit").disabled = false;
                document.getElementById("Atrial Amplitude").disabled = true;
                document.getElementById("Ventricular Amplitude").disabled = false;
                document.getElementById("Atrial Pulse Width").disabled = true;
                document.getElementById("Ventricular Pulse Width").disabled = false;
                document.getElementById("VRP").disabled = false;
                document.getElementById("ARP").disabled = true;
                document.getElementById("Maximum Sensor Rate").disabled = true;
                document.getElementById("Fixed AV Delay").disabled = true;
                document.getElementById("Atrial Sensitivity").disabled = true;
                document.getElementById("Ventricular Sensitivity").disabled = false;
                document.getElementById("PVARP").disabled = true;
                document.getElementById("Activity Threshold").disabled = true;
                document.getElementById("Reaction Time").disabled = true;
                document.getElementById("Response Factor").disabled = true;
                document.getElementById("Recovery Time").disabled = true;

            })
            $("#DOO").click(function () {
                var mode = document.getElementById('mode');
                mode.innerHTML = $(this).val();
                document.getElementById("modeToServer").value = "DOO"
                document.getElementById("Lower Rate Limit").disabled = false;
                document.getElementById("Upper Rate Limit").disabled = false;
                document.getElementById("Atrial Amplitude").disabled = false;
                document.getElementById("Ventricular Amplitude").disabled = false;
                document.getElementById("Atrial Pulse Width").disabled = false;
                document.getElementById("Ventricular Pulse Width").disabled = false;
                document.getElementById("VRP").disabled = true;
                document.getElementById("ARP").disabled = true;
                document.getElementById("Maximum Sensor Rate").disabled = true;
                document.getElementById("Fixed AV Delay").disabled = false;
                document.getElementById("Atrial Sensitivity").disabled = true;
                document.getElementById("Ventricular Sensitivity").disabled = true;
                document.getElementById("PVARP").disabled = true;
                document.getElementById("Activity Threshold").disabled = true;
                document.getElementById("Reaction Time").disabled = true;
                document.getElementById("Response Factor").disabled = true;
                document.getElementById("Recovery Time").disabled = true;
            })
            $("#AOOR").click(function () {
                var mode = document.getElementById('mode');
                mode.innerHTML = $(this).val();
                document.getElementById("modeToServer").value = "AOOR"
                document.getElementById("Lower Rate Limit").disabled = false;
                document.getElementById("Upper Rate Limit").disabled = false;
                document.getElementById("Atrial Amplitude").disabled = false;
                document.getElementById("Ventricular Amplitude").disabled = true;
                document.getElementById("Atrial Pulse Width").disabled = false;
                document.getElementById("Ventricular Pulse Width").disabled = true;
                document.getElementById("VRP").disabled = true;
                document.getElementById("ARP").disabled = true;
                document.getElementById("Maximum Sensor Rate").disabled = false;
                document.getElementById("Fixed AV Delay").disabled = true;
                document.getElementById("Atrial Sensitivity").disabled = true;
                document.getElementById("Ventricular Sensitivity").disabled = true;
                document.getElementById("PVARP").disabled = true;
                document.getElementById("Activity Threshold").disabled = false;
                document.getElementById("Reaction Time").disabled = false;
                document.getElementById("Response Factor").disabled = false;
                document.getElementById("Recovery Time").disabled = false;
            })
            $("#AAIR").click(function () {
                var mode = document.getElementById('mode');
                mode.innerHTML = $(this).val();
                document.getElementById("modeToServer").value = "AAIR"
                document.getElementById("Lower Rate Limit").disabled = false;
                document.getElementById("Upper Rate Limit").disabled = false;
                document.getElementById("Atrial Amplitude").disabled = false;
                document.getElementById("Ventricular Amplitude").disabled = true;
                document.getElementById("Atrial Pulse Width").disabled = false;
                document.getElementById("Ventricular Pulse Width").disabled = true;
                document.getElementById("VRP").disabled = true;
                document.getElementById("ARP").disabled = false;
                document.getElementById("Maximum Sensor Rate").disabled = false;
                document.getElementById("Fixed AV Delay").disabled = true;
                document.getElementById("Atrial Sensitivity").disabled = false;
                document.getElementById("Ventricular Sensitivity").disabled = true;
                document.getElementById("PVARP").disabled = false;
                document.getElementById("Activity Threshold").disabled = false;
                document.getElementById("Reaction Time").disabled = false;
                document.getElementById("Response Factor").disabled = false;
                document.getElementById("Recovery Time").disabled = false;
            })
            $("#VOOR").click(function () {
                var mode = document.getElementById('mode');
                mode.innerHTML = $(this).val();
                document.getElementById("modeToServer").value = "VOOR"
                document.getElementById("Lower Rate Limit").disabled = false;
                document.getElementById("Upper Rate Limit").disabled = false;
                document.getElementById("Atrial Amplitude").disabled = true;
                document.getElementById("Ventricular Amplitude").disabled = false;
                document.getElementById("Atrial Pulse Width").disabled = true;
                document.getElementById("Ventricular Pulse Width").disabled = false;
                document.getElementById("VRP").disabled = true;
                document.getElementById("ARP").disabled = true;
                document.getElementById("Maximum Sensor Rate").disabled = false;
                document.getElementById("Fixed AV Delay").disabled = true;
                document.getElementById("Sensed AV Delay Offset").disabled = true;
                document.getElementById("Atrial Sensitivity").disabled = true;
                document.getElementById("Ventricular Sensitivity").disabled = true;
                document.getElementById("PVARP").disabled = true;
                document.getElementById("Activity Threshold").disabled = false;
                document.getElementById("Reaction Time").disabled = false;
                document.getElementById("Response Factor").disabled = false;
                document.getElementById("Recovery Time").disabled = false;
            })
            $("#VVIR").click(function () {
                var mode = document.getElementById('mode');
                mode.innerHTML = $(this).val();
                document.getElementById("modeToServer").value = "VVIR"
                document.getElementById("Lower Rate Limit").disabled = false;
                document.getElementById("Upper Rate Limit").disabled = false;
                document.getElementById("Atrial Amplitude").disabled = true;
                document.getElementById("Ventricular Amplitude").disabled = false;
                document.getElementById("Atrial Pulse Width").disabled = true;
                document.getElementById("Ventricular Pulse Width").disabled = false;
                document.getElementById("VRP").disabled = false;
                document.getElementById("ARP").disabled = true;
                document.getElementById("Maximum Sensor Rate").disabled = true;
                document.getElementById("Fixed AV Delay").disabled = true;
                document.getElementById("Atrial Sensitivity").disabled = true;
                document.getElementById("Ventricular Sensitivity").disabled = false;
                document.getElementById("PVARP").disabled = true;
                document.getElementById("Activity Threshold").disabled = false;
                document.getElementById("Reaction Time").disabled = false;
                document.getElementById("Response Factor").disabled = false;
                document.getElementById("Recovery Time").disabled = false;
            })
            $("#VDDR").click(function () {
                var mode = document.getElementById('mode');
                mode.innerHTML = $(this).val();
                document.getElementById("modeToServer").value = "VDDR"
                document.getElementById("Lower Rate Limit").disabled = false;
                document.getElementById("Upper Rate Limit").disabled = false;
                document.getElementById("Atrial Amplitude").disabled = true;
                document.getElementById("Ventricular Amplitude").disabled = false;
                document.getElementById("Atrial Pulse Width").disabled = true;
                document.getElementById("Ventricular Pulse Width").disabled = false;
                document.getElementById("VRP").disabled = false;
                document.getElementById("ARP").disabled = true;
                document.getElementById("Maximum Sensor Rate").disabled = false;
                document.getElementById("Fixed AV Delay").disabled = false;
                document.getElementById("Atrial Sensitivity").disabled = true;
                document.getElementById("Ventricular Sensitivity").disabled = false;
                document.getElementById("PVARP").disabled = true;
                document.getElementById("Activity Threshold").disabled = false;
                document.getElementById("Reaction Time").disabled = false;
                document.getElementById("Response Factor").disabled = false;
                document.getElementById("Recovery Time").disabled = false;
            })
            $("#DOOR").click(function () {
                var mode = document.getElementById('mode');
                mode.innerHTML = $(this).val();
                document.getElementById("modeToServer").value = "DOOR"
                document.getElementById("Lower Rate Limit").disabled = false;
                document.getElementById("Upper Rate Limit").disabled = false;
                document.getElementById("Atrial Amplitude").disabled = false;
                document.getElementById("Ventricular Amplitude").disabled = false;
                document.getElementById("Atrial Pulse Width").disabled = false;
                document.getElementById("Ventricular Pulse Width").disabled = false;
                document.getElementById("VRP").disabled = true;
                document.getElementById("ARP").disabled = true;
                document.getElementById("Maximum Sensor Rate").disabled = false;
                document.getElementById("Fixed AV Delay").disabled = false;
                document.getElementById("Atrial Sensitivity").disabled = true;
                document.getElementById("Ventricular Sensitivity").disabled = true;
                document.getElementById("PVARP").disabled = true;
                document.getElementById("Activity Threshold").disabled = false;
                document.getElementById("Reaction Time").disabled = false;
                document.getElementById("Response Factor").disabled = false;
                document.getElementById("Recovery Time").disabled = false;
            })
        })
    </script>
</head>
<body>
<div id="header">
    <img class="modeSelection" src="static/img/mode_selection.png">
    <%@ include file="/pages/common/login_success_menu.jsp" %>
</div>
<div id="modeMain">
    <div class="communication">
        connected
    </div>
    <div class="pacemakerID">
        pacemaker ID: 74426726
    </div>
    <div class="mode_wel_word">
        Dear <span class="um_span">${sessionScope.user.username}</span>, you are using mode <span id="mode"></span>
    </div>
    <div class="modeSelector1">
        <input type="button" id="AOO" value="AOO">
        <input type="button" id="AAI" value="AAI">
        <input type="button" id="VOO" value="VOO">
        <input type="button" id="VVI" value="VVI">
        <input type="button" id="DOO" value="DOO">
        <input type="button" id="AOOR" value="AOOR">
        <input type="button" id="AAIR" value="AAIR">
        <input type="button" id="VOOR" value="VOOR">
        <input type="button" id="VVIR" value="VVIR">
        <input type="button" id="DOOR" value="DOOR">
    </div>
    <div>
        <form action="modeServlet" method="post">
            <input type="hidden" name="action" value="storeMode">
            <input type="hidden" name="mode" id="modeToServer" value="">
            <div class="modeForm">
                Lower Rate Limit:
                <select class="itxt" id="Lower Rate Limit" name="Lower Rate Limit" disabled="disabled">
                    <c:forEach begin="30" end="50" step="5" var="i">
                        <option>${i}ppm</option>
                    </c:forEach>
                    <c:forEach begin="50" end="90" step="1" var="i">
                        <c:choose>
                            <c:when test="${i==60}">
                                <option selected="selected">${i}ppm</option>
                            </c:when>
                            <c:otherwise>
                                <option>${i}ppm</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:forEach begin="90" end="175" step="5" var="i">
                        <option>${i}ppm</option>
                    </c:forEach>
                </select><br/><br/>
                Upper Rate Limit:
                <select class="itxt" id="Upper Rate Limit" name="Upper Rate Limit" disabled="disabled" value="120ppm">
                    <c:forEach begin="50" end="175" step="5" var="i">
                        <c:choose>
                            <c:when test="${i==120}">
                                <option selected="selected">${i}ppm</option>
                            </c:when>
                            <c:otherwise>
                                <option>${i}ppm</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select><br/><br/>
                Atrial Amplitude:
                <select class="itxt" id="Atrial Amplitude" name="Atrial Amplitude" disabled="disabled" value="3.5V">
                    <c:forEach begin="1" end="50" step="1" var="i">
                        <c:choose>
                            <c:when test="${i==50}">
                                <option selected="selected">${String.format("%.1f", i*0.1)}V</option>
                            </c:when>
                            <c:otherwise>
                                <option>${String.format("%.1f", i*0.1)}V</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <option>OFF</option>
                </select><br/><br/>
                Ventricular Amplitude:
                <select class="itxt" id="Ventricular Amplitude" name="Ventricular Amplitude" disabled="disabled" value="3.5V">
                    <c:forEach begin="1" end="50" step="1" var="i">
                        <c:choose>
                            <c:when test="${i==50}">
                                <option selected="selected">${String.format("%.1f", i*0.1)}V</option>
                            </c:when>
                            <c:otherwise>
                                <option>${String.format("%.1f", i*0.1)}v</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <option>OFF</option>
                </select><br/><br/>
                Atrial Pulse Width:
                <select class="itxt" id="Atrial Pulse Width" name="Atrial Pulse Width" disabled="disabled" value="0.4ms">
                    <c:forEach begin="1" end="30" step="1" var="i">
                        <c:choose>
                            <c:when test="${i==1}">
                                <option selected="selected">${i}ms</option>
                            </c:when>
                            <c:otherwise>
                                <option>${i}ms</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select><br/><br/>
                Ventricular Pulse Width:
                <select class="itxt" id="Ventricular Pulse Width" name="Ventricular Pulse Width" disabled="disabled" value="0.4ms">
                    <c:forEach begin="1" end="30" step="1" var="i">
                        <c:choose>
                            <c:when test="${i==1}">
                                <option selected="selected">${i}ms</option>
                            </c:when>
                            <c:otherwise>
                                <option>${i}ms</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select><br/><br/>
                VRP:
                <select class="itxt" id="VRP" name="VRP" disabled="disabled" value="320ms">
                    <c:forEach begin="150" end="500" step="10" var="i">
                        <option>${i}ms</option>
                    </c:forEach>
                </select><br/><br/>
                ARP:
                <select class="itxt" id="ARP" name="ARP" disabled="disabled" value="250ms">
                    <c:forEach begin="150" end="500" step="10" var="i">
                        <option>${i}ms</option>
                    </c:forEach>
                </select><br/><br/>
                Maximum Sensor Rate:
                <select class="itxt" id="Maximum Sensor Rate" name="Maximum Sensor Rate" disabled="disabled">
                    <c:forEach begin="50" end="175" step="5" var="i">
                        <c:choose>
                            <c:when test="${i==120}">
                                <option selected="selected">${i}ppm</option>
                            </c:when>
                            <c:otherwise>
                                <option>${i}ppm</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select><br/><br/>
                Fixed AV Delay:
                <select class="itxt" id="Fixed AV Delay" name="Fixed AV Delay" disabled="disabled">
                    <c:forEach begin="70" end="300" step="10" var="i">
                        <c:choose>
                            <c:when test="${i==150}">
                                <option selected="selected">${i}ppm</option>
                            </c:when>
                            <c:otherwise>
                                <option>${i}ppm</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select><br/><br/>
                Atrial Sensitivity:
                <select class="itxt" id="Atrial Sensitivity" name="Atrial Sensitivity" disabled="disabled">
                    <c:forEach begin="0" end="50" step="5" var="i">
                        <c:choose>
                            <c:when test="${i==25}">
                                <option selected="selected">${String.format("%.1f", i*0.1)}mV</option>
                            </c:when>
                            <c:otherwise>
                                <option>${String.format("%.1f", i*0.1)}mV</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select><br/><br/>
                Ventricular Sensitivity:
                <select class="itxt" id="Ventricular Sensitivity" name="Ventricular Sensitivity" disabled="disabled">
                    <c:forEach begin="0" end="50" step="5" var="i">
                        <c:choose>
                            <c:when test="${i==25}">
                                <option selected="selected">${String.format("%.1f", i*0.1)}mV</option>
                            </c:when>
                            <c:otherwise>
                                <option>${String.format("%.1f", i*0.1)}mV</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select><br/><br/>
                PVARP:
                <select class="itxt" id="PVARP" name="PVARP" disabled="disabled">
                    <c:forEach begin="150" end="500" step="10" var="i">
                        <c:choose>
                            <c:when test="${i==250}">
                                <option selected="selected">${i}ppm</option>
                            </c:when>
                            <c:otherwise>
                                <option>${i}ppm</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select><br/><br/>
                Activity Threshold:
                <select class="itxt" id="Activity Threshold" name="Activity Threshold" disabled="disabled">
                    <option>V-Low</option>
                    <option>Low</option>
                    <option>Med-Low</option>
                    <option selected="selected">Med</option>
                    <option>Med-High</option>
                    <option>High</option>
                    <option>V-High</option>
                </select><br/><br/>
            </div>
            <div class="modeForm2">
                Reaction Time:
                <select class="itxt" id="Reaction Time" name="Reaction Time" disabled="disabled">
                    <option>10cc</option>
                    <c:forEach begin="10" end="50" step="10" var="i">
                        <c:choose>
                            <c:when test="${i==30}">
                                <option selected="selected">${i}sec</option>
                            </c:when>
                            <c:otherwise>
                                <option>${i}sec</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select><br/><br/>
                Response Factor:
                <select class="itxt" id="Response Factor" name="Response Factor" disabled="disabled">
                    <c:forEach begin="1" end="16" step="1" var="i">
                        <c:choose>
                            <c:when test="${i==8}">
                                <option selected="selected">${i}</option>
                            </c:when>
                            <c:otherwise>
                                <option>${i}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select><br/><br/>
                Recovery Time:
                <select class="itxt" id="Recovery Time" name="Recovery Time" disabled="disabled">
                    <c:forEach begin="2" end="16" step="1" var="i">
                        <c:choose>
                            <c:when test="${i==5}">
                                <option selected="selected">${i}min</option>
                            </c:when>
                            <c:otherwise>
                                <option>${i}min</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select><br/><br/>
                <input type="submit" value="Send data to DCM" id="submit">
            </div>
        </form>
    </div>

</div>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>
