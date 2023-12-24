package com.example.servlet.service;

import com.example.dao.ServiceDao;
import com.example.dao.impl.ServiceDaoImpl;
import com.example.entity.ServiceInfo;
import com.example.service.Service;
import com.example.service.impl.ServiceImpl;

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
        int id = Integer.parseInt((request.getParameter("id")));
        Service service = new ServiceImpl();
        ServiceInfo serviceInfo = service.getById(id);
        byte[] pic = serviceInfo.getSerPic();
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
