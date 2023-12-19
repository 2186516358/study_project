package com.example.utils;


import com.example.entity.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class PageUtil<T> {
    /**
     * 计算总页数
     * @param pageSize   一页显示的内容数量
     * @param listSize
     * @return
     */
    private int showPage(int pageSize, int listSize){
        return (listSize % pageSize == 0) ? (listSize / pageSize) : (listSize / pageSize + 1);
    }

    /**
     * 每页显示第一条对应list的索引
     * @param pageSize
     * @param pageCurrent
     * @return
     */
    private int pageStart(int pageSize, int pageCurrent){
        return pageCurrent * pageSize - pageSize;
    }

    /**
     * 获取当前页list
     * @param page
     * @param list
     * @return
     */
    public List<T> getList(Page page, List<T> list) {
        List<T> arrayList = new ArrayList<T>();

        if(page.getPageCurrent() > 0) {
            int pageStart = pageStart(page.getPageSize(), page.getPageCurrent());

            for (int i = page.getPageSize(); i > 0; i--, pageStart++) {
                if ((pageStart) < list.size()) {
                    arrayList.add(list.get(pageStart));
                }
            }
            return arrayList;
        }
        return null;
    }

    /**
     * 获取当前页
     * @param request
     * @return
     */
    private int getPageCurrent(HttpServletRequest request){
        String pageCurrent = request.getParameter("pageCurrent");
        if (pageCurrent != null){
            return Integer.parseInt(request.getParameter("pageCurrent"));     //  当前页
        }
        return 1;
    }

    /**
     * 获取Page所有属性
     * @param list    右侧显示list
     * @param pageSize    一页显示内容数量
     * @param request
     * @return
     */
    public Page allPage(List<T> list, int pageSize, HttpServletRequest request){
        Page page = new Page();
        page.setPageSize(pageSize);
        page.setPageTotal(showPage(pageSize, list.size()));
        page.setPageCurrent(getPageCurrent(request));     //  当前页
        return page;
    }
}
