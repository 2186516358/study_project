<%@ page contentType="text/html;charset=GBK" language="java" %>
<jsp:include page="jsp/index/index-header.jsp"/>
<html>
<head></head>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/web.css"/>
<body>
<div class="container">

    <div class="row">
        <div class="col-sm-12">
            <label class="col-sm-12"><h2>会员注册</h2></label>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-7">
            <div class="row">
                <div class="col-sm-12">
                    <form action="member"  method="post">
                        <div class="form-group" style="height: 40px">
                            <label class="col-sm-2 control-label" for="txt_memberUserName">用户名：</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="txt_memberUserName" name="memUsername" placeholder="用户名" required />
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">
                            <label class="col-sm-2 control-label" for="txt_memberPassword">密码：</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="txt_memberPassword" name="memPassword" placeholder="密码" required />
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">

                            <label class="col-sm-2 control-label" for="txt_memberName">姓名：</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="txt_memberName" name="memName" placeholder="姓名" required />
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">

                            <label class="col-sm-2 control-label" for="txt_memberName">年龄：</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="txt_memberAge" name="memAge" placeholder="姓名" required />
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">
                            <label class="col-sm-2 control-label" for="select_memberSex">性别：</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="select_memberSex" name="memSex" required=""><option value="男">男</option><option value="女">女</option></select>
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">
                            <label class="col-sm-2 control-label" for="txt_memberTel">联系电话：</label>
                            <div class="col-sm-10">

                                <input type="tel" class="form-control" id="txt_memberTel" name="memTel" placeholder="联系电话" />
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">

                            <label class="col-sm-2 control-label" for="txt_memberPhone">手机：</label>
                            <div class="col-sm-10">

                                <input type="tel" class="form-control" id="txt_memberPhone" name="memPhone" placeholder="手机" required="" />
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">
                            <label class="col-sm-2 control-label" for="txt_memberEmail">电子邮箱：</label>
                            <div class="col-sm-10">

                                <input type="email" class="form-control" id="txt_memberEmail" name="memEmail" placeholder="email" required="" />
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">
                            <label class="col-sm-2 control-label" for="txt_memberAddress">家庭住址：</label>
                            <div class="col-sm-10">

                                <input type="text" class="form-control" id="txt_memberAddress" name="memAddress" placeholder="家庭住址" required="" />
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">
                            <label class="col-sm-2 control-label" for="file_memberPic">头像上传：</label>
                            <div class="col-sm-10">

                                <input type="file" class="form-control" id="file_memberPic" name="uploadPic" placeholder="头像上传" />
                            </div>
                        </div>
                        <div class="form-group" style="height: 40px">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="col-sm-12 btn btn-primary" >提交</button>
                            </div>
                        </div>
                        <jsp:setProperty name="member" property="*"/>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-xs-5">
            <img class="pull-right qr-code-size" src="images/erweima.png" alt="" />
        </div>
    </div>
</div>
<jsp:include page="jsp/index/index-foot.jsp"/>

</body>
</html>
