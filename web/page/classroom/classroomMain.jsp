<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/14
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend>班级列表</legend>
    </fieldset>

    <div class="layui-form">
        <table id="tab" class="layui-table">
            <colgroup>
                <col width="150">
                <col width="150">
                <col width="200">
                <col>
            </colgroup>
            <thead>
            <tr>
                <th>序号</th>
                <th>班级名称</th>
                <th>创建日期</th>
                <th>状态</th>
                <th>管理</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</body>
</html>
<script type="text/javascript">

    window.onload = loadData();

    function loadData(page){
        var url = "${pageContext.request.contextPath}/classroomControll_findClassroomForPage?pageBean.cpage=1";
        $.get(url,null,function(data){
            var allNum =data.pageBean.allNum;		//总数据条数
            var showNum = data.pageBean.showNum;	//显示数据条数
            var allPage = data.pageBean.allPage;	//总页数
            var cpage = data.pageBean.cpage;		//当前页

            //定义上一页,下一页的变量页数
            var upPage = cpage>1?cpage-1:1;
            var downPage = cpage<allPage?cpage+1:allPage;

            $.each(data.pageBean.result,function(i,v){
                var opt = "<tr>";
                    opt += "<td><input name='check1' type='checkbox'/></td>";
                    opt += "<td>"+((cpage-1)*showNum+(i+1))+"</td>";
                    opt += "<td>"+v.name+"</td>";
                    opt += "<td>"+v.createtime+"</td>";
                    opt += "<td>"+(v.status==1?'启用':'禁用')+"</td>";
                    opt += "<td>管理</td>";
                    opt += "</tr>";

                $("#tab tbody").append(opt);
            });
        });
    }

</script>
