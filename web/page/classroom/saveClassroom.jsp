<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/14
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend>新增班级</legend>
    </fieldset>

    <!-- 表单开始 -->
    <form id="frm">
        <div class="layui-form-item" style="padding-left: 70px;">
            <div class="layui-inline">
                <p id="tip"></p>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">班级名称</label>
                <div class="layui-input-inline">
                    <input name="classroom.name" onfocus="clearTip();" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">创建时间</label>
                <div class="layui-input-inline">
                    <input type="date" name="classroom.createtime" class="layui-input">
                </div>
            </div>
        </div>

        <label class="layui-form-label">状态</label>
        <div class="layui-input-inline" style="padding-top: 10px;">
            <input type="radio" name="classroom.status" value="1" checked="checked" />启用
            <input type="radio" name="classroom.status" value="0" />禁用
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <input type="button" value="新增班级" onclick="saveClassroom();" class="layui-btn">
                <input type="reset" value="重置" class="layui-btn layui-btn-primary">
            </div>
        </div>
    </form>
    <!-- 表单结束 -->
</body>
</html>
<script>

    //新增班级
    function saveClassroom(){
        if(regex()){
            var url = "${pageContext.request.contextPath}/classroomControll_doSaveClassroom";
            var params = $("#frm").serialize();
            $.get(url,params,function(data){
                var valueDto = data.valueDto;
                if(valueDto.code==200){
                    $("#tip").text(valueDto.value).css("color","green");
                }else if(valueDto.code==500){
                    $("#tip").text(valueDto.message).css("color","red");;
                }

                $("#frm")[0].reset();
            },"json");
        }
        return;
    }

    function regex(){
        var name = document.getElementsByName("classroom.name")[0].value;
        var reg = /^[a-zA-Z0-9]{3,10}$/;
        if(!reg.test(name)){
            $("#tip").text("班级名称输入有误,不能为非法字符开头,长度范围4-10位").css("color","red");
            return false;
        }
        return true;
    }

    //清除提示信息
    function clearTip(){
        $("#tip").text("");
    }

</script>
