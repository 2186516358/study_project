package com.example.service.impl;

import com.example.dao.ActivityDao;
import com.example.dao.impl.ActivityDaoImpl;
import com.example.entity.ActivityInfo;
import com.example.service.ActivityService;

import java.sql.ResultSet;
import java.util.List;

public class ActivityServiceImpl implements ActivityService {


    private ActivityDao activityDao = new ActivityDaoImpl();

    @Override
    public List<ActivityInfo> getAll() {
        return activityDao.findAll();
    }

    @Override
    public ActivityInfo getById(Integer id) {
        return activityDao.findById(id);
    }

    @Override
    public List<ActivityInfo> getList(ResultSet rs) {
        return activityDao.getList(rs);
    }
}
