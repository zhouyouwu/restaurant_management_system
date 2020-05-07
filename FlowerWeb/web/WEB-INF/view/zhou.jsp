<%--
  Created by IntelliJ IDEA.
  User: 周
  Date: 2020/5/7
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>zhou</title>
</head>
<body>
<form action="register.action" method="post">
    <table>
        <span>用户id：</span><input type="text" value="8-11个字符" name="userId"
                                 onclick="if(value=='8-11个字符')value=''"><br/>
        <span>昵称：</span><input type="text" value="2-12个字符" name="username"
                               onclick="if(value=='2-12个字符')value=''"><br/>
        <span>密码：</span><input type="text" value="8-16个字符" name="password"
                               onclick="if(value=='8-16个字符')value=''"><br/>
        <span>确认密码：</span><input type="text" value="8-16个字符" name="password2"
                                 onclick="if(value=='8-16个字符'){value='';type='password'}"><br/>

        <input type="submit" value="注册" />
    </table>
</form>
</body>
</html>
