package com.example.service;

import com.example.entity.HouseInfo;

import java.util.List;

public interface HouseService {

    List<HouseInfo> getAll();

    HouseInfo getById(Integer id);

}
