<%@ page import="java.util.List" %>
<%@ page import="com.example.entity.HouseInfo" %>
<%@ page import="com.example.entity.Page" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <title>房间介绍</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/web.css"/>
</head>
<body>
<jsp:include page="../index/index-header.jsp"/>
<%
    List<HouseInfo> list = (List<HouseInfo>)request.getAttribute("list");
    List<HouseInfo> houseInfos = (List<HouseInfo>)request.getAttribute("houseInfos");
    Page page1 = (Page)request.getAttribute("Page");
    Object message = request.getAttribute("message");
    if (message != null && message!=""){
%>
<script type="text/javascript">
    alert("<%=message%>")
</script>
<%}%>
<script type="text/javascript">
    mOut=function (a) {
        switch (a){
            case 0:$('#house_detail').text("<%=list.get(0).getHouseDetail()%>");
                    $('#house_pic').attr('src', "<%=request.getContextPath()%>/images/houseShowPic?id=<%=list.get(0).getId()%>");break;
            case 1:$('#house_detail').text("<%=list.get(1).getHouseDetail()%>");
                    $('#house_pic').attr('src', "<%=request.getContextPath()%>/images/houseShowPic?id=<%=list.get(1).getId()%>");break;
            case 2:$('#house_detail').text("<%=list.get(2).getHouseDetail()%>");
                    $('#house_pic').attr('src', "<%=request.getContextPath()%>/images/houseShowPic?id=<%=list.get(2).getId()%>");break;
            case 3:$('#house_detail').text("<%=list.get(3).getHouseDetail()%>");
                    $('#house_pic').attr('src', "<%=request.getContextPath()%>/images/houseShowPic?id=<%=list.get(3).getId()%>");break;
        }
    }
</script>
<div class="container">
    <div class="room" ng-controller="roomCtrl" ng-init="getList()">
        <img src="<%=request.getContextPath()%>/images/slider2.png" style="margin-bottom: 10px" />
        <div class="row">
            <div class="content col-lg-5">
                <div class="col-xs-8">
                    <div ng-if="active">
                        <img id="house_pic" src="<%=request.getContextPath()%>/images/houseShowPic?id=<%=list.get(0).getId()%>" alt="" class="img-thumbnail" height="209px" />
                        <p id="house_detail" ng-bind="active.houseTitle"><%=list.get(0).getHouseDetail()%></p>
                    </div>
                </div>
                <div class="col-xs-4">
                    <%for(int i = 0; i <= 3; i++){%>
                        <ul class="list-group" style="margin-bottom:6px">
                            <li class="list-group-item" ng-repeat="item in data | limitTo:4" ng-class="{\'list-group-item-info\':isActive(item)}">
                                <a onclick="mOut(<%=i%>)"><img src="<%=request.getContextPath()%>/images/houseShowPic?id=<%=list.get(i).getId()%>" alt="" class="img-responsive" style="height: 80px" /></a>
                            </li>
                        </ul>
                    <%}%>
                </div>
            </div>

            <div class="content col-lg-7">
                <% for(int i = 0; i < page1.getPageSize(); i++){ %>
                <ul class="list-group" style="margin-bottom:1px">
                    <li class="list-group-item">
                        <a href="findSingleHouse?id=<%=houseInfos.get(i).getId()%>" class="row">
                            <span class="pull-left targe">[房间介绍] <%=houseInfos.get(i).getHouseTitle()%></span>
                            <span class="pull-right date"><%=houseInfos.get(i).getCreatedate()%> &nbsp;&nbsp;</span>
                        </a>
                    </li>
                </ul>
                <% } %>
            </div>
        </div>

        <div class="btn-group col-xs-offset-5">
            <ul class="pagination">
                <li><a href="findAllHouse?pageCurrent=<%=(page1.getPageCurrent()-1 <= 0)?(1):(page1.getPageCurrent()-1)%>">&laquo;</a></li>
                <%for(int i = 1; i <= page1.getPageTotal(); i++){%>
                    <li><a href="findAllHouse?pageCurrent=<%=i%>"><%=i%></a></li>
                <%}%>
                <li><a href="findAllHouse?pageCurrent=<%=(page1.getPageCurrent() >= page1.getPageTotal())?(page1.getPageCurrent()):(page1.getPageCurrent()+1)%>">&raquo;</a></li>
            </ul>
        </div>
    </div>
</div>
<jsp:include page="../index/index-foot.jsp"/>
</body>

</html>
