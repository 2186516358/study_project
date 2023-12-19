package com.example.servlet.house;

import com.example.dao.HouseDao;
import com.example.dao.impl.HouseDaoImpl;
import com.example.entity.HouseInfo;
import com.example.service.HouseService;
import com.example.service.impl.HouseServiceImpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findSingleHouse")
public class FindSingleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            HouseService houseService = new HouseServiceImpl();
//            HouseDao dao = new HouseDaoImpl();
            HouseInfo houseInfo = houseService.getById(id);
/*            if(houseInfos == null) {
                throw new NullPointerException();
            }
            HouseInfo houseInfo = houseInfos.get(0);*/

            request.getSession().setAttribute("houseInfo", houseInfo);
            request.getRequestDispatcher("jsp/house/house_detail.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            message = "获取资源失败";
            request.setAttribute("message", message);
            request.getRequestDispatcher("jsp/house/house.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
