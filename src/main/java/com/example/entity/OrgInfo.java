package com.example.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class OrgInfo implements Serializable {
    private Integer id;
    private String orgTitle;
    private String orgbDetail;
    private byte[] orgPic;
    private Date createdate;
    private Integer showorder;
    private String ifshow;

    public OrgInfo() {
    }

    public OrgInfo(String orgTitle, Date createdate, Integer showorder,
                   String ifshow) {
        this.orgTitle = orgTitle;
        this.createdate = createdate;
        this.showorder = showorder;
        this.ifshow = ifshow;
    }

    public OrgInfo(String orgTitle, String orgbDetail, byte[] orgPic,
                   Date createdate, Integer showorder, String ifshow) {
        this.orgTitle = orgTitle;
        this.orgbDetail = orgbDetail;
        this.orgPic = orgPic;
        this.createdate = createdate;
        this.showorder = showorder;
        this.ifshow = ifshow;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgTitle() {
        return orgTitle;
    }

    public void setOrgTitle(String orgTitle) {
        this.orgTitle = orgTitle;
    }

    public String getOrgbDetail() {
        return orgbDetail;
    }

    public void setOrgbDetail(String orgbDetail) {
        this.orgbDetail = orgbDetail;
    }

    public byte[] getOrgPic() {
        return orgPic;
    }

    public void setOrgPic(byte[] orgPic) {
        this.orgPic = orgPic;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getShoworder() {
        return showorder;
    }

    public void setShoworder(Integer showorder) {
        this.showorder = showorder;
    }

    public String getIfshow() {
        return ifshow;
    }

    public void setIfshow(String ifshow) {
        this.ifshow = ifshow;
    }

    @Override
    public String toString() {
        return "OrgInfo{" +
                "id=" + id +
                ", orgTitle='" + orgTitle + '\'' +
                ", orgbDetail='" + orgbDetail + '\'' +
                ", orgPic=" + Arrays.toString(orgPic) +
                ", createdate=" + createdate +
                ", showorder=" + showorder +
                ", ifshow='" + ifshow + '\'' +
                '}';
    }
}
