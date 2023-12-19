package com.example.dao.impl;


import com.example.dao.JobDao;
import com.example.entity.JobInfo;
import com.example.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobDaoImpl implements JobDao {
    private final Connection CONN = DBHelper.getConn();
    private ResultSet rs;

    @Override
    public List<JobInfo> findAll() {
        List<JobInfo> jobs = new ArrayList<>();
        try {
            String sql = "select * from job_info";
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                JobInfo jobInfo = new JobInfo();

                jobInfo.setId(rs.getInt(1));
                jobInfo.setJobTitle(rs.getString(2));
                jobInfo.setJobDetail(rs.getString(3));
                jobInfo.setCreatedate(rs.getDate(4));
                jobInfo.setShoworder(rs.getInt(5));
                jobInfo.setIfshow(rs.getString(6));
                jobs.add(jobInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jobs;
    }

    @Override
    public List<JobInfo> getList(ResultSet resultSet) {
        List<JobInfo> list = new ArrayList<>();
        try {

            while (resultSet.next()) {
                JobInfo jobInfo = new JobInfo();

                jobInfo.setId(resultSet.getInt(1));
                jobInfo.setJobTitle(resultSet.getString(2));
                jobInfo.setJobDetail(resultSet.getString(3));
                jobInfo.setCreatedate(resultSet.getDate(4));
                jobInfo.setShoworder(resultSet.getInt(5));
                jobInfo.setIfshow(resultSet.getString(6));
                list.add(jobInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
