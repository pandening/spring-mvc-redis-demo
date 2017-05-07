<%--
  Created by IntelliJ IDEA.
  User: hujian
  Date: 2017/5/6
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove an user</title>
</head>
<body>
    <form id="remove_user" action="remove.do" method="post">
        User_Id:<input name="user_id" type="NUMBER"/><br/>
        <input type="submit" value="remove" name="remove">
    </form>
</body>
</html>
