package com.example.service;

import com.example.entity.ServiceType;

import java.util.List;

public interface ServiceTypeService {

    List<ServiceType> getTypeAll();

    ServiceType getByTypeId(Integer id);

}
