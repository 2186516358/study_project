package com.example.servlet.antivity;

import com.example.entity.ActivityInfo;
import com.example.entity.Page;
import com.example.service.ActivityService;
import com.example.service.impl.ActivityServiceImpl;
import com.example.utils.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllActivity")
public class FindAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String message = "";
        try {
            ActivityService activityService = new ActivityServiceImpl();
            List<ActivityInfo> list = activityService.getAll();
            if(list == null) {
                throw new NullPointerException();
            }
            PageUtil<ActivityInfo> pageUtil = new PageUtil<>();

            Page page = pageUtil.allPage(list, 3, request);
            List<ActivityInfo> currentPagelist =  pageUtil.getList(page, list);
            page.setPageSize(currentPagelist.size());

            request.setAttribute("list", list);
            request.setAttribute("activityInfos", currentPagelist);
            request.setAttribute("Page", page);
            request.getRequestDispatcher("jsp/activity/activity.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            message = "获取资源失败";
            request.setAttribute("message", message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
