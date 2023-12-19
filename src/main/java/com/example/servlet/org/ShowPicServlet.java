package com.example.servlet.org;

import com.example.dao.OrgDao;
import com.example.dao.impl.OrgDaoImpl;
import com.example.entity.OrgInfo;
import com.example.service.OrgService;
import com.example.service.impl.OrgServiceImpl;

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
//        OrgDao orgDao = new OrgDaoImpl();
        OrgService orgService = new OrgServiceImpl();
        OrgInfo orgInfo = orgService.getById(id);
        byte[] pic = orgInfo.getOrgPic();
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
