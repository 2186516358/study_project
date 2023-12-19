package com.example.dao;

import com.example.entity.ServiceType;

import java.sql.ResultSet;
import java.util.List;

public interface ServiceTypeDao {

    List<ServiceType> findTypeAll();

    ServiceType findByTypeId(Integer id);

    List<ServiceType> getTypeList(ResultSet rs);

}
