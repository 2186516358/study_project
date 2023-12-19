<%@ page import="java.util.List" %>
<%@ page import="com.example.entity.JobInfo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <title>招贤纳士</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />

</head>
<body>
<%
    List<JobInfo> jobInfos = (List<JobInfo>)request.getAttribute("jobInfos");
%>
<jsp:include page="../index/index-header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-xs-12" style="margin-top: 30px; margin-bottom: 15px; border-bottom: 1px solid lightgray">
            <h1>欢迎加入我们</h1>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div ng-controller="jobCtrl" ng-init="getData()">
                    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                        <%for(int i = 0; i < jobInfos.size(); i++){%>
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" >
                                    <h4 class="panel-title"><%=jobInfos.get(i).getJobTitle()%></h4>
                                </div>
                                <div class="panel-body">
                                    <p><%=jobInfos.get(i).getJobDetail()%></p>
                                </div>
                            </div>
                        <%}%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../index/index-foot.jsp"/>
</body>
</html>
