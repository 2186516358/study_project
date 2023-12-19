package com.example.dao.impl;

import com.example.dao.ServiceDao;
import com.example.entity.ServiceInfo;
import com.example.utils.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ServiceDaoImpl implements ServiceDao {

    private final Connection CONN = DBHelper.getConn();
    private ResultSet rs;


    @Override
    public List<ServiceInfo> findAll() {
        List<ServiceInfo> list = new ArrayList<>();
        try {
            String sql = "select * from service_info";
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ServiceInfo serviceInfo = new ServiceInfo();
                serviceInfo.setId(rs.getInt(1));
                serviceInfo.setServiceType(rs.getLong(2));
                serviceInfo.setSerTitle(rs.getString(3));
                serviceInfo.setSerDetail(rs.getString(4));
                serviceInfo.setSerPic(rs.getBytes(5));
                serviceInfo.setCreatedate(rs.getDate(6));
                serviceInfo.setShoworder(rs.getInt(7));
                serviceInfo.setIfshow(rs.getString(8));
                list.add(serviceInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ServiceInfo findById(Integer id) {
        ServiceInfo serviceInfo = new ServiceInfo();
        try {
            String sql = "select * from service_info where ID = ?";
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                serviceInfo.setId(rs.getInt(1));
                serviceInfo.setServiceType(rs.getLong(2));
                serviceInfo.setSerTitle(rs.getString(3));
                serviceInfo.setSerDetail(rs.getString(4));
                serviceInfo.setSerPic(rs.getBytes(5));
                serviceInfo.setCreatedate(rs.getDate(6));
                serviceInfo.setShoworder(rs.getInt(7));
                serviceInfo.setIfshow(rs.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceInfo;
    }

    @Override
    public List<ServiceInfo> getList(ResultSet rs) {
        try {
            List<ServiceInfo> list = new ArrayList<>();

            while (rs.next()) {
                ServiceInfo serviceInfo = new ServiceInfo();

                serviceInfo.setId(rs.getInt(1));
                serviceInfo.setServiceType(rs.getLong(2));
                serviceInfo.setSerTitle(rs.getString(3));
                serviceInfo.setSerDetail(rs.getString(4));
                serviceInfo.setSerPic(rs.getBytes(5));
                serviceInfo.setCreatedate(rs.getDate(6));
                serviceInfo.setShoworder(rs.getInt(7));
                serviceInfo.setIfshow(rs.getString(8));
                list.add(serviceInfo);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
