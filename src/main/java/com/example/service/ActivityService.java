package com.example.service;

import com.example.entity.ActivityInfo;

import java.sql.ResultSet;
import java.util.List;

public interface ActivityService {

    List<ActivityInfo> getAll();

    ActivityInfo getById(Integer id);

    List<ActivityInfo> getList(ResultSet rs);

}
