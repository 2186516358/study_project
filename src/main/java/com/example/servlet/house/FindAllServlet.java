package com.example.servlet.house;

import com.example.dao.HouseDao;
import com.example.dao.impl.HouseDaoImpl;
import com.example.entity.HouseInfo;
import com.example.entity.Page;
import com.example.service.HouseService;
import com.example.service.impl.HouseServiceImpl;
import com.example.utils.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllHouse")
public class FindAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        try {
            HouseService houseService = new HouseServiceImpl();
            List<HouseInfo> list = houseService.getAll();
            PageUtil<HouseInfo> pageUtil = new PageUtil<>();
            if(list == null) {
                throw new NullPointerException();
            }
            Page page = pageUtil.allPage(list, 10, request);
            List<HouseInfo> currentPagelist =  pageUtil.getList(page, list);
            page.setPageSize(currentPagelist.size());

            request.setAttribute("list", list);
            request.setAttribute("houseInfos", currentPagelist);
            request.setAttribute("Page", page);
            request.getRequestDispatcher("jsp/house/house.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            message = "获取资源失败";
            request.setAttribute("message", message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
