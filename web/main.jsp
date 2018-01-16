<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/11
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/layui/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/css/modules/layer/default/layer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/css/modules/laydate/default/laydate.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lay/modules/form.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lay/modules/layer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lay/modules/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lay/modules/layedit.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lay/modules/laydate.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">学生成绩管理系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    ${loginUser.username}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="">班级管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:loadPage('${pageContext.request.contextPath}/page/classroom/saveClassroom.jsp');">新增班级</a></dd>
                        <dd><a href="javascript:loadPage('${pageContext.request.contextPath}/page/classroom/classroomMain.jsp');">班级列表</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">列表一</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="">云市场</a></li>
                <li class="layui-nav-item"><a href="">发布商品</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div id="contentBody" style="padding: 15px;">内容主体区域</div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script>

    function loadPage(url){
        $("#contentBody").html("").load(url);
    }
</script>
</body>
</html>
