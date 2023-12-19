<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <title>企业团队</title>
</head>
<body>
<jsp:include page="../index/index-header.jsp"/>
<jsp:useBean id="orgInfo" class="com.example.entity.OrgInfo" scope="session"/>

<div ng-controller="activeInfoCtrl">
    <div class="row">
        <div class="col-xs-12" style="border-bottom: 1px solid lightgray; margin-bottom: 15px">
            <h1 class="text-center"><jsp:getProperty name="orgInfo" property="orgTitle"/></h1>
        </div>
    </div>
    <div class="row" style="margin-bottom: 15px">
        <div class="col-xs-12">
            <img class="center-block" src="<%=request.getContextPath()%>/images/orgShowPic?id=<jsp:getProperty name="orgInfo" property="id"/>" style="width: 800px" ng-if="data.id" />
        </div>
    </div>
    <div class="container">
        <dl class="dl-horizontal">
            <dt>
                团队信息：
            </dt>
            <dd>
                <jsp:getProperty name="orgInfo" property="orgbDetail"/>
            </dd>
        </dl>
    </div>
</div>
<jsp:include page="../index/index-foot.jsp"/>

</body>
</html>
