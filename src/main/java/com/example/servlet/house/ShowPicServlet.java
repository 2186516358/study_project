package com.example.servlet.house;

import com.example.entity.HouseInfo;
import com.example.service.HouseService;
import com.example.service.impl.HouseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/houseShowPic")
public class ShowPicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HouseService houseService = new HouseServiceImpl();
        HouseInfo houseInfos = houseService.getById(id);
        byte[] pic = houseInfos.getHousePic();
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
