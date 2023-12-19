package com.example.servlet.antivity;

import com.example.dao.ActivityDao;
import com.example.dao.impl.ActivityDaoImpl;
import com.example.entity.ActivityInfo;
import com.example.service.ActivityService;
import com.example.service.impl.ActivityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findSingleActivity")
public class FindSingleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        request.setCharacterEncoding("GBK");
        response.setCharacterEncoding("GBK");

        try {
            ActivityService activityService = new ActivityServiceImpl();
//            ActivityDao dao = new ActivityDaoImpl();
            int id = Integer.parseInt(request.getParameter("id"));

            ActivityInfo act = activityService.getById(id);
/*            if(list == null) {
                throw new NullPointerException();
            }
            ActivityInfo act = list.get(0);*/
            request.getSession().setAttribute("activity", act);

            request.getRequestDispatcher("jsp/activity/activity_detail.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            message = "获取资源失败";
            request.setAttribute("message", message);
            request.getRequestDispatcher("jsp/activity/activity.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
