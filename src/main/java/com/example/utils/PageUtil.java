package com.example.utils;


import com.example.entity.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class PageUtil<T> {
    /**
     * ������ҳ��
     * @param pageSize   һҳ��ʾ����������
     * @param listSize
     * @return
     */
    private int showPage(int pageSize, int listSize){
        return (listSize % pageSize == 0) ? (listSize / pageSize) : (listSize / pageSize + 1);
    }

    /**
     * ÿҳ��ʾ��һ����Ӧlist������
     * @param pageSize
     * @param pageCurrent
     * @return
     */
    private int pageStart(int pageSize, int pageCurrent){
        return pageCurrent * pageSize - pageSize;
    }

    /**
     * ��ȡ��ǰҳlist
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
     * ��ȡ��ǰҳ
     * @param request
     * @return
     */
    private int getPageCurrent(HttpServletRequest request){
        String pageCurrent = request.getParameter("pageCurrent");
        if (pageCurrent != null){
            return Integer.parseInt(request.getParameter("pageCurrent"));     //  ��ǰҳ
        }
        return 1;
    }

    /**
     * ��ȡPage��������
     * @param list    �Ҳ���ʾlist
     * @param pageSize    һҳ��ʾ��������
     * @param request
     * @return
     */
    public Page allPage(List<T> list, int pageSize, HttpServletRequest request){
        Page page = new Page();
        page.setPageSize(pageSize);
        page.setPageTotal(showPage(pageSize, list.size()));
        page.setPageCurrent(getPageCurrent(request));     //  ��ǰҳ
        return page;
    }
}
