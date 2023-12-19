package com.example.servlet.member;

import com.example.dao.MemberLevelDao;
import com.example.dao.impl.MemberLevelDaoImpl;
import com.example.entity.MemberLevel;
import com.example.service.MemberLevelService;
import com.example.service.impl.MemberLevelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ShowPicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
//        MemberLevelDao memberLevelDao = new MemberLevelDaoImpl();
        MemberLevelService memberLevelService = new MemberLevelServiceImpl();
        MemberLevel memberLevel = memberLevelService.getById(id);
        byte[] pic = memberLevel.getLevelPic();
        OutputStream outs = response.getOutputStream();
        if (pic != null) {
            outs.write(pic);
            outs.flush();
            outs.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
