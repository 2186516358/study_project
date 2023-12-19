<%@ page contentType="text/html;charset=GBK" language="java" %>

<!DOCTYPE html>
<html ng-app="main">
<head>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/web.css"/>
</head>
<body>
<jsp:useBean id="memberInfo" class="com.example.entity.MemberInfo" scope="session"/>

  <div class="nav">
    <a href="#" style="text-decoration: none">
      <div>
        <img src="<%=request.getContextPath()%>/images/logo.png" class="logo" width="50px">
        &nbsp;&nbsp;
        <img src="<%=request.getContextPath()%>/images/banner.png" class="banner">
      </div>
    </a>
    <div class="tag">
      <div>
        <span class="glyphicon glyphicon-phone">联系电话</span>
      </div>
      <div id="login-btn" >
        <span id="span" class="glyphicon glyphicon-user"></span>
      </div>
      <div id="quit">
        <span id="quit-span">退出</span>
      </div>
    </div>
  </div>
  <div class="title" >
    <a href="<%=request.getContextPath()%>/index.jsp"><div>首 页</div></a>
    <a href="<%=request.getContextPath()%>/aboutUs"><div>关于我们</div></a>
    <a href="<%=request.getContextPath()%>/findAllActivity"><div>套餐及活动</div></a>
    <a href="<%=request.getContextPath()%>/findAllService"><div>专业服务</div></a>
    <a href="<%=request.getContextPath()%>/findAllOrg"><div>企业团队</div></a>
    <a href="<%=request.getContextPath()%>/findAllHouse"><div>房间介绍</div></a>
    <a href="<%=request.getContextPath()%>/findAllJob"><div>招贤纳士</div></a>
  </div>

<script src="../../js/jquery.js"></script>
<%
  if (memberInfo.getMemUsername() == null){
%>
    <script>
        $('#span').text("会员登录")
    </script>
<%}else{%>
    <script>
        $('#span').text("<jsp:getProperty name="memberInfo" property="memUsername"/>")
    </script>
<%}%>

<script type="text/javascript">
  $('#login-btn').click(function () {
    if($('#span').text() == "会员登录"){
    window.location.href='<%=request.getContextPath()%>/login.jsp'
  }else {
    location.href='jsp/user/user.jsp?username='+$('#span').text()
  }
})
  $('#quit').click(function (){
      if($('#span').text() != "会员登录") {
          window.location.href='quit'
      }
  })
</script>
</body>
</html>
