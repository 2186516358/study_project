package com.example.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class ServiceInfo implements Serializable {
    private Integer id;
    private Long serviceType;
    private String serTitle;
    private String serDetail;
    private byte[] serPic;
    private Date createdate;
    private Integer showorder;
    private String ifshow;

    public ServiceInfo() {
    }

    public ServiceInfo(Long serviceType, String serTitle,
                       Date createdate, Integer showorder, String ifshow) {

        this.serviceType = serviceType;
        this.serTitle = serTitle;
        this.createdate = createdate;
        this.showorder = showorder;

        this.ifshow = ifshow;
    }

    public ServiceInfo(Long serviceType, String serTitle,
                       String serDetail, byte[] serPic, Date createdate,
                       Integer showorder, String ifshow) {
        this.serviceType = serviceType;
        this.serTitle = serTitle;
        this.serDetail = serDetail;
        this.serPic = serPic;
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

    public Long getServiceType() {
        return serviceType;
    }

    public void setServiceType(Long serviceType) {
        this.serviceType = serviceType;
    }

    public String getSerTitle() {
        return serTitle;
    }

    public void setSerTitle(String serTitle) {
        this.serTitle = serTitle;
    }

    public String getSerDetail() {
        return serDetail;
    }

    public void setSerDetail(String serDetail) {
        this.serDetail = serDetail;
    }

    public byte[] getSerPic() {
        return serPic;
    }

    public void setSerPic(byte[] serPic) {
        this.serPic = serPic;
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
        return "ServiceInfo{" +
                "id=" + id +
                ", serviceType=" + serviceType +
                ", serTitle='" + serTitle + '\'' +
                ", serDetail='" + serDetail + '\'' +
                ", serPic=" + Arrays.toString(serPic) +
                ", createdate=" + createdate +
                ", showorder=" + showorder +
                ", ifshow='" + ifshow + '\'' +
                '}';
    }
}
