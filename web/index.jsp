<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/12
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layui/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.9.min.js"></script>
</head>
<body>
    <div class="loginbox">
        <h2>用户登录</h2>
        <div class="frombox">
        <s:form action="loginControll_doLogin" method="post" onsubmit="return checkForm();">
            <div style="color: red;">
            <s:actionerror/>
            </div>
            <div id="usernameTip" style="color: red;" class="layui-form-item"></div>
            <div class="layui-form-item">
                <div class="layui-input-inline">
                    <s:textfield name="user.username" placeholder="请输入用户名" onmousedown="clearError(1);" class="layui-input"/>
                </div>
            </div>
            <div id="passwordTip" style="color: red;" class="layui-form-item"></div>
            <div class="layui-form-item">
                <%--<label class="layui-form-label">密码框</label>--%>
                <div class="layui-input-inline">
                    <s:password name="user.password" type="password" placeholder="请输入密码" onmousedown="clearError(2);" class="layui-input"/>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-inline">
                    <s:submit value="登录" class="layui-btn layui-btn-normal layui-anim-scale loginBtn"/>
                </div>
            </div>
        </s:form>
        </div>
    </div>
</body>
</html>
<script>

    //检查登录信息
    function checkForm(){
        var flag = true;
        var username = document.getElementsByName("user.username")[0].value;
        var password = document.getElementsByName("user.password")[0].value;
        var reg = /^[1-9a-zA-Z]{5,12}$/;
        if(!reg.test(username)){
            document.getElementById("usernameTip").innerHTML="输入有误,长度为6-12位";
            flag = false;
        }

        if(!reg.test(password)){
            document.getElementById("passwordTip").innerHTML="输入有误,长度为6-12位";
            flag = false;
        }

        return flag;
    }

    //清除错误信息
    function clearError(num){
        switch (num){
            case 1:
                document.getElementById("usernameTip").innerHTML=null;
                break;
            case 2:
                document.getElementById("passwordTip").innerHTML=null;
                break;
        }
    }
    
</script>
