<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <title>个人主页</title>
</head>
<body>
<jsp:include page="../index/index-header.jsp"/>
<jsp:useBean id="memberInfo" class="com.example.entity.MemberInfo" scope="session"/>

<div class="container" ng-controller="userCtrl" ng-init="getUser()">
    <img src="<%=request.getContextPath()%>/images/slider2.png" alt="" style="width: 100%" />
    <h2>欢迎回来</h2><jsp:getProperty name="memberInfo" property="memName"/>
    <hr />
    <h3>个人资料</h3>
    <form action="update?id=<jsp:getProperty name="memberInfo" property="id"/>" method="post">
        <div class="row">
            <div class="col-xs-3 text-right" style="font-weight: 300">
                用户名:
            </div>
            <div class="col-xs-9 text-left">
                <jsp:getProperty name="memberInfo" property="memUsername"/>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3 text-right" style="font-weight: 300">
                姓名:
            </div>
            <div class="col-xs-9 text-left">
                <input type="text" name="memName" required="" value="<jsp:getProperty name="memberInfo" property="memName"/>">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3 text-right" style="font-weight: 300">
                年龄:
            </div>
            <div class="col-xs-9 text-left">
                <input type="text" name="memAge" required="" value="<jsp:getProperty name="memberInfo" property="memAge"/>">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3 text-right" style="font-weight: 300">
                性别:
            </div>
            <div class="col-xs-9 text-left">
                <input name="memSex" type="radio" value="男" required="" />男
                <input name="memSex" type="radio" value="女" required="" />女
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3 text-right" style="font-weight: 300">
                家庭地址:
            </div>
            <div class="col-xs-9 text-left">
                <input type="text" name="memAddress" required="" value="<jsp:getProperty name="memberInfo" property="memAddress"/>">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3 text-right" style="font-weight: 300">
                邮箱:
            </div>
            <div class="col-xs-9 text-left">
                <input type="text" name="memEmail" required="" value="<jsp:getProperty name="memberInfo" property="memEmail"/>">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3 text-right" style="font-weight: 300">
                电话:
            </div>
            <div class="col-xs-9 text-left">
                <input type="text" name="memPhone" required="" value="<jsp:getProperty name="memberInfo" property="memPhone"/>">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3 text-right" style="font-weight: 300">
                密码:
            </div>
            <div class="col-xs-9 text-left">
                <input type="text" name="memPassword" required="" value="<jsp:getProperty name="memberInfo" property="memPassword"/>">
            </div>
        </div>
        <div style="height: 40px">
            <div class="col-sm-offset-2 col-sm-10">
                <button style="width: 100px;float: right" type="submit" class="col-sm-12 btn btn-primary" >修改并提交</button>
            </div>
        </div>
    </form>

</div>
<jsp:include page="../index/index-foot.jsp"/>

</body>
</html>
