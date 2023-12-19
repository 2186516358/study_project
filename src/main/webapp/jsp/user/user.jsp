<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <title>������ҳ</title>
</head>
<body>
<jsp:include page="../index/index-header.jsp"/>
<jsp:useBean id="memberInfo" class="com.example.entity.MemberInfo" scope="session"/>

<div class="container" ng-controller="userCtrl" ng-init="getUser()">
    <img src="<%=request.getContextPath()%>/images/slider2.png" alt="" style="width: 100%" />
    <h2>��ӭ����</h2><jsp:getProperty name="memberInfo" property="memName"/>
    <hr />
    <h3>��������</h3>
    <form action="update?id=<jsp:getProperty name="memberInfo" property="id"/>" method="post">
        <div class="row">
            <div class="col-xs-3 text-right" style="font-weight: 300">
                �û���:
            </div>
            <div class="col-xs-9 text-left">
                <jsp:getProperty name="memberInfo" property="memUsername"/>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3 text-right" style="font-weight: 300">
                ����:
            </div>
            <div class="col-xs-9 text-left">
                <input type="text" name="memName" required="" value="<jsp:getProperty name="memberInfo" property="memName"/>">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3 text-right" style="font-weight: 300">
                ����:
            </div>
            <div class="col-xs-9 text-left">
                <input type="text" name="memAge" required="" value="<jsp:getProperty name="memberInfo" property="memAge"/>">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3 text-right" style="font-weight: 300">
                �Ա�:
            </div>
            <div class="col-xs-9 text-left">
                <input name="memSex" type="radio" value="��" required="" />��
                <input name="memSex" type="radio" value="Ů" required="" />Ů
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3 text-right" style="font-weight: 300">
                ��ͥ��ַ:
            </div>
            <div class="col-xs-9 text-left">
                <input type="text" name="memAddress" required="" value="<jsp:getProperty name="memberInfo" property="memAddress"/>">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3 text-right" style="font-weight: 300">
                ����:
            </div>
            <div class="col-xs-9 text-left">
                <input type="text" name="memEmail" required="" value="<jsp:getProperty name="memberInfo" property="memEmail"/>">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3 text-right" style="font-weight: 300">
                �绰:
            </div>
            <div class="col-xs-9 text-left">
                <input type="text" name="memPhone" required="" value="<jsp:getProperty name="memberInfo" property="memPhone"/>">
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3 text-right" style="font-weight: 300">
                ����:
            </div>
            <div class="col-xs-9 text-left">
                <input type="text" name="memPassword" required="" value="<jsp:getProperty name="memberInfo" property="memPassword"/>">
            </div>
        </div>
        <div style="height: 40px">
            <div class="col-sm-offset-2 col-sm-10">
                <button style="width: 100px;float: right" type="submit" class="col-sm-12 btn btn-primary" >�޸Ĳ��ύ</button>
            </div>
        </div>
    </form>

</div>
<jsp:include page="../index/index-foot.jsp"/>

</body>
</html>
