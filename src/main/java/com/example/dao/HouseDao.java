package com.example.dao;

import com.example.entity.HouseInfo;

import java.sql.ResultSet;
import java.util.List;

public interface HouseDao {
    List<HouseInfo> findAll();

    HouseInfo findById(Integer id);

    List<HouseInfo> getList(ResultSet rs);


}
