package com.example.servlet.org;

import com.example.dao.OrgDao;
import com.example.dao.impl.OrgDaoImpl;
import com.example.entity.OrgInfo;
import com.example.service.OrgService;
import com.example.service.impl.OrgServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findSingleOrg")
public class FindSingleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            OrgService orgService = new OrgServiceImpl();
            OrgInfo orgInfo = orgService.getById(id);
/*
            if(orgInfo == null) {
                throw new NullPointerException();
            }
            OrgInfo orgInfo = orgInfos.get(0);
*/

            request.getSession().setAttribute("orgInfo", orgInfo);
            request.getRequestDispatcher("jsp/org/org_detail.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            message = "获取资源失败";
            request.setAttribute("message", message);
            request.getRequestDispatcher("jsp/org/org.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
