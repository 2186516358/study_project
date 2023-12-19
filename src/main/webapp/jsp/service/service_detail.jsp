<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <title>专业服务</title>
</head>
<body>
<jsp:include page="../index/index-header.jsp"/>
<jsp:useBean id="serviceInfo" class="com.example.entity.ServiceInfo" scope="session"/>
<jsp:useBean id="serviceType" class="com.example.entity.ServiceType" scope="session"/>
<div ng-controller="serviceInfoCtrl">
    <div class="row">
        <div class="col-xs-12" style="border-bottom: 1px solid lightgray; margin-bottom: 15px">
            <h1 class="text-center"><jsp:getProperty name="serviceInfo" property="serTitle"/></h1>
        </div>
    </div>
    <div class="row" style="margin-bottom: 15px">
        <div class="col-xs-12">
            <img src="<%=request.getContextPath()%>/images/serShowPic?id=<jsp:getProperty name="serviceInfo" property="id"/>" class="center-block"  style="width: 800px" />
        </div>
    </div>
    <div class="container">
        <dl class="dl-horizontal">
            <dt>
                服务名称：
            </dt>
            <dd>
                <jsp:getProperty name="serviceInfo" property="serTitle"/>
            </dd>
        </dl>
        <dl class="dl-horizontal">
            <dt>
                服务类型：
            </dt>
            <dd>
                <jsp:getProperty name="serviceType" property="typeTitle"/>
            </dd>
        </dl>
        <dl class="dl-horizontal">
            <dt>
                服务描述：
            </dt>
            <dd>
                <jsp:getProperty name="serviceInfo" property="serDetail"/>
            </dd>
        </dl>
    </div>
</div>
<jsp:include page="../index/index-foot.jsp"/>

</body>
</html>
