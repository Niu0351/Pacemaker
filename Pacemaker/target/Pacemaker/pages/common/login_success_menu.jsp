<!--
common tag for login_success,login,register,register_success
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="topRight" style="margin-top: 150px">
    <span>Glad to see<span class="um_span">${sessionScope.user.username}</span>come to our base!</span>
    <a href="userServlet?action=logout">Log out</a>
</div>

