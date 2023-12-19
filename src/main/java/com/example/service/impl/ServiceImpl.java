package com.example.service.impl;

import com.example.dao.ServiceDao;
import com.example.dao.impl.ServiceDaoImpl;
import com.example.entity.ServiceInfo;
import com.example.service.Service;

import java.util.List;

public class ServiceImpl implements Service {

    private ServiceDao serviceDao = new ServiceDaoImpl();

    @Override
    public List<ServiceInfo> getAll() {
        return serviceDao.findAll();
    }

    @Override
    public ServiceInfo getById(Integer id) {
        return serviceDao.findById(id);
    }
}
