package com.example.service.impl;

import com.example.dao.HouseDao;
import com.example.dao.impl.HouseDaoImpl;
import com.example.entity.HouseInfo;
import com.example.service.HouseService;

import java.util.List;

public class HouseServiceImpl implements HouseService {

    private HouseDao houseDao = new HouseDaoImpl();

    @Override
    public List<HouseInfo> getAll() {
        return houseDao.findAll();
    }

    @Override
    public HouseInfo getById(Integer id) {
        return houseDao.findById(id);
    }
}
