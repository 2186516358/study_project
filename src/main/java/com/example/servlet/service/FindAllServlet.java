package com.example.servlet.service;

import com.example.dao.ServiceDao;
import com.example.dao.ServiceTypeDao;
import com.example.dao.impl.ServiceDaoImpl;
import com.example.dao.impl.ServiceTypeDaoImpl;
import com.example.entity.Page;
import com.example.entity.ServiceInfo;
import com.example.entity.ServiceType;
import com.example.service.ServiceTypeService;
import com.example.service.impl.ServiceTypeServiceImpl;
import com.example.utils.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllService")
public class FindAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";

        try {
            ServiceDao dao = new ServiceDaoImpl();
//            ServiceTypeDao serviceTypeDao = new ServiceTypeDaoImpl();
            ServiceTypeService service = new ServiceTypeServiceImpl();
            List<ServiceInfo> serviceInfos = dao.findAll();
            List<ServiceType> serviceTypes = service.getTypeAll();
            PageUtil<ServiceInfo> pageUtil = new PageUtil<>();

            if(serviceTypes == null || serviceInfos == null) {
                throw new NullPointerException();
            }
            Page page = pageUtil.allPage(serviceInfos, 6, request);
            List<ServiceInfo> currentPagelist =  pageUtil.getList(page, serviceInfos);
            page.setPageSize(currentPagelist.size());

            request.setAttribute("Page", page);
            request.setAttribute("serviceInfos", currentPagelist);
            request.setAttribute("serviceTypes", serviceTypes);
            request.getRequestDispatcher("jsp/service/service.jsp").forward(request, response);
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
