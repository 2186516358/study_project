package com.example.service.impl;

import com.example.dao.ServiceTypeDao;
import com.example.dao.impl.ServiceTypeDaoImpl;
import com.example.entity.ServiceType;
import com.example.service.ServiceTypeService;

import java.util.List;

public class ServiceTypeServiceImpl implements ServiceTypeService {

    private ServiceTypeDao serviceTypeDao = new ServiceTypeDaoImpl();

    @Override
    public List<ServiceType> getTypeAll() {
        return serviceTypeDao.findTypeAll();
    }

    @Override
    public ServiceType getByTypeId(Integer id) {
        return serviceTypeDao.findByTypeId(id);
    }
}
