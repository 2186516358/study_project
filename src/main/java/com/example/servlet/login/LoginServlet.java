package com.example.servlet.login;

import com.example.entity.ActivityInfo;
import com.example.entity.HouseInfo;
import com.example.entity.MemberInfo;
import com.example.entity.ServiceInfo;
import com.example.service.ActivityService;
import com.example.service.HouseService;
import com.example.service.MemberService;
import com.example.service.Service;
import com.example.service.impl.ActivityServiceImpl;
import com.example.service.impl.HouseServiceImpl;
import com.example.service.impl.MemberServiceImpl;
import com.example.service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        request.setCharacterEncoding("GBK");
        response.setCharacterEncoding("GBK");

        try{
            HouseService houseService = new HouseServiceImpl();
            Service service = new ServiceImpl();
            ActivityService activityService = new ActivityServiceImpl();


            List<HouseInfo> houseInfos = houseService.getAll();
            List<ServiceInfo> serviceInfos = service.getAll();
            List<ActivityInfo> activityInfos = activityService.getAll();

            if(houseInfos != null && serviceInfos != null && activityInfos != null){
                request.getSession().setAttribute("houseInfos",houseInfos );
                request.getSession().setAttribute("serviceInfos", serviceInfos);
                request.getSession().setAttribute("activityInfos",activityInfos);
            }

            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username == null || password == null){
                throw new NullPointerException();
            }
            MemberInfo memberInfo = new MemberInfo();
            memberInfo.setMemUsername(username);

            MemberService memberService = new MemberServiceImpl();
            memberInfo = memberService.getByName(username);

            if(memberInfo.getId() != null){
                if(memberInfo.getMemPassword().equals(password)){
                    request.getSession().setAttribute("memberInfo", memberInfo);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }else {
                    message = "µÇÂ¼Ê§°Ü";
                    request.getSession().setAttribute("message", message);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }else {
                message = "ÓÃ»§²»´æÔÚ";
                request.setAttribute("message", message);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        }catch (Exception e){
            e.printStackTrace();
            message = "µÇÂ¼Ê§°Ü";
            request.setAttribute("message", message);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
