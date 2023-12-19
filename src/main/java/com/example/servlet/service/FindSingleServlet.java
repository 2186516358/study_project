package com.example.servlet.service;

import com.example.dao.ServiceDao;
import com.example.dao.ServiceTypeDao;
import com.example.dao.impl.ServiceDaoImpl;
import com.example.dao.impl.ServiceTypeDaoImpl;
import com.example.entity.ServiceInfo;
import com.example.entity.ServiceType;
import com.example.service.ServiceTypeService;
import com.example.service.impl.ServiceTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findSingleService")
public class FindSingleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";

        try {
            ServiceDao dao = new ServiceDaoImpl();
//            ServiceTypeDao serviceTypeDao = new ServiceTypeDaoImpl();
            ServiceTypeService service = new ServiceTypeServiceImpl();
            int id = Integer.parseInt(request.getParameter("id"));
            int typeId = Integer.parseInt((request.getParameter("typeId")));

            ServiceInfo serviceInfo = dao.findById(id);
            ServiceType serviceType = service.getByTypeId(typeId);
/*            ServiceInfo serviceInfo = list.get(0);
            ServiceType serviceType = serviceTypes.get(0);*/

            request.getSession().setAttribute("serviceInfo", serviceInfo);
            request.getSession().setAttribute("serviceType", serviceType);
            request.getRequestDispatcher("jsp/service/service_detail.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            message = "获取资源失败";
            request.setAttribute("message", message);
            request.getRequestDispatcher("jsp/service/service.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
