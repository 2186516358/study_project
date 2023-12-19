package com.example.servlet.member;

import com.example.entity.MemberLevel;
import com.example.service.MemberLevelService;
import com.example.service.impl.MemberLevelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberLevelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";

        try {
//            MemberLevelDao dao = new MemberLevelDaoImpl();
            MemberLevelService memberService = new MemberLevelServiceImpl();
            List<MemberLevel> memberLevels = memberService.getAll();
            if(memberLevels == null) {
                throw new NullPointerException();
            }
            request.getSession().setAttribute("memberLevels", memberLevels);
            request.getRequestDispatcher("jsp/member/member.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            message = "获取资源失败";
            request.setAttribute("message", message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
