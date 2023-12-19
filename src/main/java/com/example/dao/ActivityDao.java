package com.example.dao;

import com.example.entity.ActivityInfo;

import java.sql.ResultSet;
import java.util.List;

public interface ActivityDao {

    List<ActivityInfo> findAll();

    ActivityInfo findById(Integer id);

    List<ActivityInfo> getList(ResultSet rs);

}
