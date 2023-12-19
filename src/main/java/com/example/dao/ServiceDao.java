package com.example.dao;

import com.example.entity.ServiceInfo;

import java.sql.ResultSet;
import java.util.List;

public interface ServiceDao {

    List<ServiceInfo> findAll();

    ServiceInfo findById(Integer id);

    List<ServiceInfo> getList(ResultSet rs);

}
