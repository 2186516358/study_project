package com.example.servlet.org;

import com.example.dao.OrgDao;
import com.example.dao.impl.OrgDaoImpl;
import com.example.entity.OrgInfo;
import com.example.entity.Page;
import com.example.service.OrgService;
import com.example.service.impl.OrgServiceImpl;
import com.example.utils.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllOrg")
public class FindAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";

        try {
//            OrgDao dao = new OrgDaoImpl();
            OrgService orgService = new OrgServiceImpl();
            List<OrgInfo> list = orgService.getAll();
            PageUtil<OrgInfo> pageUtil = new PageUtil<>();
            if(list == null) {
                throw new NullPointerException();
            }
            Page page = pageUtil.allPage(list, 6, request);
            List<OrgInfo> currentPagelist =  pageUtil.getList(page, list);
            page.setPageSize(currentPagelist.size());

            request.getSession().setAttribute("list", list);
            request.getSession().setAttribute("orgInfos", currentPagelist);
            request.getSession().setAttribute("Page", page);
            request.getRequestDispatcher("jsp/org/org.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            message = "获取资源失败";
            request.getSession().setAttribute("message", message);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
