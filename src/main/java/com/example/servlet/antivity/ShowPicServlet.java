package com.example.servlet.antivity;

import com.example.dao.ActivityDao;
import com.example.dao.impl.ActivityDaoImpl;
import com.example.entity.ActivityInfo;
import com.example.service.ActivityService;
import com.example.service.impl.ActivityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class ShowPicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ActivityService activityService = new ActivityServiceImpl();
        ActivityInfo activityInfo = activityService.getById(id);
        byte[] pic = activityInfo.getActPic();
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
