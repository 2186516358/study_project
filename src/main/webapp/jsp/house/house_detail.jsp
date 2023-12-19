<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <title>房间介绍</title>
</head>
<body>
<jsp:include page="../index/index-header.jsp"/>
<jsp:useBean id="houseInfo" class="com.example.entity.HouseInfo" scope="session"/>

<div ng-controller="activeInfoCtrl">
    <div class="row" style="margin-bottom: 15px">
        <div class="col-xs-12">
            <img class="center-block" src="<%=request.getContextPath()%>/images/houseShowPic?id=<jsp:getProperty name="houseInfo" property="id"/>" style="width: 800px" ng-if="data.id" />
        </div>
    </div>
    <div class="container">
        <dl class="dl-horizontal">
            <dt>
                房间名称：
            </dt>
            <dd>
                <jsp:getProperty name="houseInfo" property="houseTitle"/>
            </dd>
        </dl>
        <dl class="dl-horizontal">
            <dt>
                房间价格：
            </dt>
            <dd>
                <jsp:getProperty name="houseInfo" property="housePrice"/>
            </dd>
        </dl>
        <dl class="dl-horizontal">
            <dt>
                房间描述：
            </dt>
            <dd>
                <jsp:getProperty name="houseInfo" property="houseDetail"/>
            </dd>
        </dl>
    </div>
</div>
<jsp:include page="../index/index-foot.jsp"/>

</body>
</html>
