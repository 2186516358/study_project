package com.example.service;

import com.example.entity.ServiceInfo;

import java.util.List;

public interface Service {

    List<ServiceInfo> getAll();

    ServiceInfo getById(Integer id);

}
