<%@ page import="java.util.List" %>
<%@ page import="com.example.entity.ServiceInfo" %>
<%@ page import="com.example.entity.ServiceType" %>
<%@ page import="com.example.entity.Page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <title>专业服务</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
</head>
<body>
<%
    List<ServiceInfo> serviceInfos = (List<ServiceInfo>)request.getAttribute("serviceInfos");
    List<ServiceType> serviceTypes = (List<ServiceType>)request.getAttribute("serviceTypes");
    Page page1 = (Page)request.getAttribute("Page");
    Object message = request.getAttribute("message");
    if (message != null && message!=""){
%>
<script type="text/javascript">
    alert("<%=message%>")
</script>
<%}%>
<jsp:include page="../index/index-header.jsp"/>

<div ng-controller="activeCtrl" class="container" ng-init="getData()" style="margin-top: 20px">
    <div class="row">
        <div class="col-lg-4">
            <% for(int i = 0; i < serviceTypes.size(); i++){%>
                <ul class="list-group">
                    <h4><%=serviceTypes.get(i).getTypeTitle()%></h4>
                    <img src="<%=request.getContextPath()%>/images/case<%=i+1%>.jpg" alt="" class="img-responsive" style="height: 160px" />
                </ul>
            <%}%>
        </div>

        <div class="col-lg-8">
            <div class="media" ng-repeat="item in data">
                <% for(int i = 0; i < page1.getPageSize(); i++){%>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="media-left">
                                <a href="findSingleService?id=<%=serviceInfos.get(i).getId()%>&typeId=<%=serviceInfos.get(i).getServiceType()%>">
                                    <img class="media-object" width="64px" height="64px" src="<%=request.getContextPath()%>/images/serShowPic?id=<%=serviceInfos.get(i).getId()%>" alt="..." /></a>
                            </div>
                            <div class="media-body" >
                                <h4 class="media-heading"><%=serviceInfos.get(i).getSerTitle()%></h4>
                                <div style="width: 580px">
                                    <span style="text-overflow: ellipsis;display: -webkit-box;-webkit-line-clamp: 2;-webkit-box-orient: vertical;" ng-bind="sub.serDetail | limitTo:40"><%=serviceInfos.get(i).getSerDetail()%></span>
                                </div>
                            </div>
                            <div class="media-right">
                                <a href="findSingleService?id=<%=serviceInfos.get(i).getId()%>&typeId=<%=serviceInfos.get(i).getServiceType()%>" class="btn btn-zise">详细</a>
                            </div>
                        </div>
                    </div>
                <%}%>
                <div class="btn-group col-xs-offset-5">
                    <ul class="pagination">
                        <li><a href="findAllService?pageCurrent=<%=(page1.getPageCurrent()-1 <= 0)?(1):(page1.getPageCurrent()-1)%>">&laquo;</a></li>
                        <%for(int i = 1; i <= page1.getPageTotal(); i++){%>
                            <li><a href="findAllService?pageCurrent=<%=i%>"><%=i%></a></li>
                        <%}%>
                        <li><a href="findAllService?pageCurrent=<%=(page1.getPageCurrent() >= page1.getPageTotal())?(page1.getPageCurrent()):(page1.getPageCurrent()+1)%>">&raquo;</a></li>
                    </ul>
                </div>

            </div>
        </div>
    </div>
</div>
<jsp:include page="../index/index-foot.jsp"/>

<script rel="script" src="../../js/bootstrap.min.js"></script>
<script src="../../js/angular-cookies.js"></script>
</body>
</html>
