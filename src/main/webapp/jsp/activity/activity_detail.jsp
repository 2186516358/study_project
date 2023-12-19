<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <title>套餐及活动</title>
</head>
<body>
<jsp:include page="../index/index-header.jsp"/>
<jsp:useBean id="activity" class="com.example.entity.ActivityInfo" scope="session"/>

<div ng-controller="activeInfoCtrl">
    <div class="row">
        <div class="col-xs-12" style="border-bottom: 1px solid lightgray; margin-bottom: 15px">
            <h1 class="text-center"><jsp:getProperty name="activity" property="actTitle"/></h1>
            <h3 class="text-center" style="color: #898989"><jsp:getProperty name="activity" property="actExtra"/></h3>
        </div>
    </div>
    <div class="row" style="margin-bottom: 15px">
        <div class="col-xs-12">
            <img class="center-block" src="<%=request.getContextPath()%>/images/actShowPic?id=<jsp:getProperty name="activity" property="id"/>" style="width: 800px" ng-if="data.id" />
        </div>
    </div>
    <div class="container">
        <dl class="dl-horizontal">
            <dt>
                活动名称：
            </dt>
            <dd>
                <jsp:getProperty name="activity" property="actTitle"/>
            </dd>
        </dl>
        <dl class="dl-horizontal" ng-if="data.actPrice">
            <dt>
                套餐及活动价格：
            </dt>
            <dd>
                <jsp:getProperty name="activity" property="actPrice"/>
            </dd>
        </dl>
        <dl class="dl-horizontal" ng-if="data.actDetail">
            <dt>
                活动描述：
            </dt>
            <dd>
                <jsp:getProperty name="activity" property="actDetail"/>
            </dd>
        </dl>
    </div>
</div>
<jsp:include page="../index/index-foot.jsp"/>

</body>
</html>
