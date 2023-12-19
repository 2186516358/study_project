<%@ page import="java.util.List" %>
<%@ page import="com.example.entity.MemberLevel" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<MemberLevel> memberLevels =  (List<MemberLevel>)request.getSession().getAttribute("memberLevels");
%>
<jsp:include page="../index/index-header.jsp"/>
<div class="container">
    <div class="room" ng-controller="roomCtrl" ng-init="getList()">
        <img src="<%=request.getContextPath()%>/images/slider2.png" style="margin-bottom: 10px" />
        <div class="row">
            <div class="content">
                <div class="col-lg-8" style="width: 100%">
                    <div class="media">
                        <%for(int i = 0; i < memberLevels.size(); i++){%>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <div class="media-body">
                                        <p class="media-heading"><%=memberLevels.get(i).getLevelTitle()%></p>
                                    </div>
                                </div>
                                <div class="panel-collapse">
                                    <div class="media-left" style="float: left">
                                        <img class="media-object" width="180px" height="180px" src="<%=request.getContextPath()%>/images/levelShowPic?id=<%=memberLevels.get(i).getId()%>" alt="..." />
                                    </div>
                                    <div class="panel-body">
                                        <h3>ª·‘±”≈ª›:</h3>
                                        <p><%=memberLevels.get(i).getLevelDetail()%></p>
                                    </div>
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
