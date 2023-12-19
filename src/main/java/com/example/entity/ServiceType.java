package com.example.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ServiceType implements Serializable {
    private Integer id;
    private String typeTitle;
    private Date createdate;
    private Integer showorder;
    private String ifshow;
    private Set<ServiceInfo> serviceInfos = new HashSet<ServiceInfo>(0);

    public ServiceType(Integer id) {
        this.id = id;
    }

    public ServiceType() {
    }

    public ServiceType(String typeTitle, Date createdate, Integer showorder,
                       String ifshow) {
        this.typeTitle = typeTitle;
        this.createdate = createdate;
        this.showorder = showorder;
        this.ifshow = ifshow;
    }

    public ServiceType(String typeTitle, Date createdate, Integer showorder,
                       String ifshow, Set<ServiceInfo> serviceInfos) {

        this.typeTitle = typeTitle;
        this.createdate = createdate;
        this.showorder = showorder;
        this.ifshow = ifshow;
        this.serviceInfos = serviceInfos;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
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

    public Set<ServiceInfo> getServiceInfos() {
        return serviceInfos;
    }

    public void setServiceInfos(Set<ServiceInfo> serviceInfos) {
        this.serviceInfos = serviceInfos;
    }

    @Override
    public String toString() {
        return "ServiceType{" +
                "id=" + id +
                ", typeTitle='" + typeTitle + '\'' +
                ", createdate=" + createdate +
                ", showorder=" + showorder +
                ", ifshow='" + ifshow + '\'' +
                ", serviceInfos=" + serviceInfos +
                '}';
    }
}
