package com.example.servlet.member;

import com.example.dao.MemberDao;
import com.example.dao.impl.MemberDaoImpl;
import com.example.entity.MemberInfo;
import com.example.service.MemberService;
import com.example.service.impl.MemberServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//@WebServlet("/update")
public class UpdateMemberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setCharacterEncoding("GBK");
        String message = "";
        MemberInfo memberInfo = new MemberInfo();

        try {
//            MemberDao dao = new MemberDaoImpl();
            MemberService memberService = new MemberServiceImpl();
            memberInfo.setMemPassword(request.getParameter("memPassword"));
            memberInfo.setMemName(request.getParameter("memName"));
            memberInfo.setMemAge(request.getParameter("memAge"));
            memberInfo.setMemSex(request.getParameter("memSex"));
            memberInfo.setMemAddress(request.getParameter("memAddress"));
            memberInfo.setMemEmail(request.getParameter("memEmail"));
            memberInfo.setMemPhone(request.getParameter("memPhone"));
            int id = Integer.parseInt(request.getParameter("id"));
            memberInfo.setId(id);

            memberService.update(memberInfo);
            memberInfo = memberService.getById(id);
            message = "修改成功";
            request.setAttribute("memberInfo", memberInfo);
        } catch (SQLException e) {
            e.printStackTrace();
            message = "修改失败";
        }finally {
            request.setAttribute("message", message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
