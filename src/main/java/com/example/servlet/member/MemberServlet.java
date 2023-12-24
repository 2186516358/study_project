package com.example.servlet.member;

import com.example.dao.MemberDao;
import com.example.dao.impl.MemberDaoImpl;
import com.example.entity.MemberInfo;
import com.example.entity.MemberLevel;
import com.example.service.MemberService;
import com.example.service.impl.MemberServiceImpl;
import com.example.utils.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
    String message = "";

    private File[] uploadPic;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("GBK");
        response.setCharacterEncoding("GBK");

        try {
            String username = request.getParameter("username");
            if(username != null){
                MemberInfo memberInfo = new MemberInfo();
                memberInfo.setMemUsername(username);

                MemberService memberService = new MemberServiceImpl();
                memberInfo = memberService.getByName(username);
                if(memberInfo == null) {
                    throw new NullPointerException();
                }

                request.getSession().setAttribute("memberInfo", memberInfo);
                request.getRequestDispatcher("jsp/user/user.jsp").forward(request, response);
            }
        }catch (Exception e){
            e.printStackTrace();
            message = "资源获取失败";
            request.setAttribute("message", message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setCharacterEncoding("GBK");
        try{
            MemberDao dao = new MemberDaoImpl();
            MemberInfo memberInfo = new MemberInfo();
            memberInfo.setMemPassword(request.getParameter("memPassword"));
            memberInfo.setMemName(request.getParameter("memName"));
            memberInfo.setMemAge(request.getParameter("memAge"));
            memberInfo.setMemSex(request.getParameter("memSex"));
            memberInfo.setMemAddress(request.getParameter("memAddress"));
            memberInfo.setMemEmail(request.getParameter("memEmail"));
            memberInfo.setMemPhone(request.getParameter("memPhone"));
            memberInfo.setMemUsername(request.getParameter("memUsername"));
            memberInfo.setMemberLevel(new MemberLevel(1));
            Date currentTime = new Date();
            memberInfo.setRegTime(currentTime);
            memberInfo.setMemScore((float) 0);
            if (uploadPic != null) {
                memberInfo.setMemPic(Util.file2byte(uploadPic[0]));
            }
            if (dao.findByName(memberInfo.getMemName()).getId() == null) {
                dao.insert(memberInfo);
                message = "注册成功";
            } else {
                message = "用户已存在";
            }
        }catch (Exception e){
            e.printStackTrace();
            message = "操作失败";
        }finally {
            request.setAttribute("message", message);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
