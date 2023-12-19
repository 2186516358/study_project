package com.example.service.impl;

import com.example.dao.JobDao;
import com.example.dao.impl.JobDaoImpl;
import com.example.entity.JobInfo;
import com.example.service.JobService;

import java.util.List;

public class JobServiceImpl implements JobService {

    private JobDao jobDao = new JobDaoImpl();

    @Override
    public List<JobInfo> getAll() {
        return jobDao.findAll();
    }
}
