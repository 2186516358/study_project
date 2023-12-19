package com.example.dao.impl;


import com.example.dao.ServiceTypeDao;
import com.example.entity.ServiceType;
import com.example.utils.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeDaoImpl implements ServiceTypeDao {

    private Connection conn = DBHelper.getConn();
    private ResultSet rs;
    private PreparedStatement pstmt;


    @Override
    public List<ServiceType> findTypeAll() {
        List<ServiceType> list = new ArrayList<>();

        try {
            String sql = "select * from service_type";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                ServiceType serviceType = new ServiceType();
                serviceType.setId(rs.getInt(1));
                serviceType.setTypeTitle(rs.getString(2));
                serviceType.setCreatedate(rs.getDate(3));
                serviceType.setShoworder(rs.getInt(4));
                serviceType.setIfshow(rs.getString(5));
                list.add(serviceType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ServiceType findByTypeId(Integer id) {
        ServiceType serviceType = new ServiceType();
        try {
            String sql = "select * from service_type where ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                serviceType.setId(rs.getInt(1));
                serviceType.setTypeTitle(rs.getString(2));
                serviceType.setCreatedate(rs.getDate(3));
                serviceType.setShoworder(rs.getInt(4));
                serviceType.setIfshow(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceType;
    }

    @Override
    public List<ServiceType> getTypeList(ResultSet resultSet) {
        try {
            List<ServiceType> list = new ArrayList<>();

            while (resultSet.next()) {
                ServiceType serviceType = new ServiceType();
                serviceType.setId(resultSet.getInt(1));
                serviceType.setTypeTitle(resultSet.getString(2));
                serviceType.setCreatedate(resultSet.getDate(3));
                serviceType.setShoworder(resultSet.getInt(4));
                serviceType.setIfshow(resultSet.getString(5));
                list.add(serviceType);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
