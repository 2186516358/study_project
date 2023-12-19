package com.example.dao;

import com.example.entity.JobInfo;

import java.sql.ResultSet;
import java.util.List;

public interface JobDao {

    List<JobInfo> findAll();

    List<JobInfo> getList(ResultSet rs);

}
