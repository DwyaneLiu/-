<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登陆界面</title>

    <link rel="stylesheet" type="text/css" href="WEB-Page/Login/login.css"/>
    <script type="text/javascript" src="WEB-Page/Login/login.js"></script>
</head>

<body>
<div id="login_frame">

    <p id="image_logo"><img src="WEB-Page/Login/images/login/fly.png"></p>

    <form action="login" method="post">

        <p><label class="label_input">用户名</label><input type="text" id="username" name = "username" class="text_field" value="${username}"/></p>
        <p><label class="label_input">密码</label><input type="text" id="password" name="password" class="text_field" value="${password}"/></p>

        <div id="login_control">
            <input type="submit" id="btn_login" value="登陆"/>
            <a  id="btn_register" href="http://localhost:8080/NewsSystem/Register.jsp">注册</a>
             <td><font color="red">${error}</font></td>
        </div>
    </form>
</div>

</body>
</html>