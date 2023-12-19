package com.example.dao.impl;

import com.example.dao.ActivityDao;
import com.example.entity.ActivityInfo;
import com.example.utils.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDaoImpl implements ActivityDao {
    private final Connection CONN = DBHelper.getConn();
    private ResultSet rs;

    @Override
    public List<ActivityInfo> findAll() {

        List<ActivityInfo> activityInfos = new ArrayList<>();

        try {
            String sql = "select * from activity_info";
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ActivityInfo activityInfo = new ActivityInfo();
                activityInfo.setId(rs.getInt(1));
                activityInfo.setActTitle(rs.getString(2));
                activityInfo.setActExtra(rs.getString(3));
                activityInfo.setActDetail(rs.getString(4));
                activityInfo.setActPic(rs.getBytes(5));
                activityInfo.setActPrice(rs.getFloat(6));
                activityInfo.setStartDate(rs.getDate(7));
                activityInfo.setEndDate(rs.getDate(8));
                activityInfo.setCreatedate(rs.getDate(9));
                activityInfo.setShoworder(rs.getInt(10));
                activityInfo.setIfshow(rs.getString(11));
                activityInfos.add(activityInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return activityInfos;
    }

    @Override
    public ActivityInfo findById(Integer id) {

        ActivityInfo activityInfo = new ActivityInfo();
        try {
            String sql = "select * from activity_info where ID = ?";
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                activityInfo.setId(rs.getInt(1));
                activityInfo.setActTitle(rs.getString(2));
                activityInfo.setActExtra(rs.getString(3));
                activityInfo.setActDetail(rs.getString(4));
                activityInfo.setActPic(rs.getBytes(5));
                activityInfo.setActPrice(rs.getFloat(6));
                activityInfo.setStartDate(rs.getDate(7));
                activityInfo.setEndDate(rs.getDate(8));
                activityInfo.setCreatedate(rs.getDate(9));
                activityInfo.setShoworder(rs.getInt(10));
                activityInfo.setIfshow(rs.getString(11));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return activityInfo;
    }

    @Override
    public List<ActivityInfo> getList(ResultSet resultSet) {

        List<ActivityInfo> list = new ArrayList<>();

        try {
            while (resultSet.next()) {
                ActivityInfo activityInfo = new ActivityInfo();
                activityInfo.setId(resultSet.getInt(1));
                activityInfo.setActTitle(resultSet.getString(2));
                activityInfo.setActExtra(resultSet.getString(3));
                activityInfo.setActDetail(resultSet.getString(4));
                activityInfo.setActPic(resultSet.getBytes(5));
                activityInfo.setActPrice(resultSet.getFloat(6));
                activityInfo.setStartDate(resultSet.getDate(7));
                activityInfo.setEndDate(resultSet.getDate(8));
                activityInfo.setCreatedate(resultSet.getDate(9));
                activityInfo.setShoworder(resultSet.getInt(10));
                activityInfo.setIfshow(resultSet.getString(11));
                list.add(activityInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
