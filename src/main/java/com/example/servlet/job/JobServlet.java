package com.example.servlet.job;

import com.example.dao.JobDao;
import com.example.dao.impl.JobDaoImpl;
import com.example.entity.JobInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllJob")
public class JobServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";

        try {
            JobDao dao = new JobDaoImpl();
            List<JobInfo> jobInfos = dao.findAll();
            if(jobInfos == null) {
                throw new NullPointerException();
            }
            request.setAttribute("jobInfos", jobInfos);
            request.getRequestDispatcher("jsp/job/job.jsp").forward(request, response);
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
