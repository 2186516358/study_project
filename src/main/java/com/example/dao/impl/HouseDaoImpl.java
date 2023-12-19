package com.example.dao.impl;


import com.example.dao.HouseDao;
import com.example.entity.HouseInfo;
import com.example.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HouseDaoImpl implements HouseDao {
    private final Connection CONN = DBHelper.getConn();
    private ResultSet rs;

    @Override
    public List<HouseInfo> findAll() {
        List<HouseInfo> houseInfos = new ArrayList<>();
        try {
            String sql = "select * from house_info";
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            rs = pstmt.executeQuery(sql);
            while (rs.next()) {
                HouseInfo houseInfo = new HouseInfo();
                houseInfo.setId(rs.getInt(1));
                houseInfo.setHouseTitle(rs.getString(2));
                houseInfo.setHousePrice(rs.getFloat(3));
                houseInfo.setHouseDetail(rs.getString(4));
                houseInfo.setHousePic(rs.getBytes(5));
                houseInfo.setCreatedate(rs.getDate(6));
                houseInfo.setShoworder(rs.getInt(7));
                houseInfo.setIfshow(rs.getString(8));
                houseInfos.add(houseInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return houseInfos;
    }

    @Override
    public HouseInfo findById(Integer id) {

        HouseInfo houseInfo = new HouseInfo();
        try {
            String sql = "select * from house_info where ID = ?";
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                houseInfo.setId(rs.getInt(1));
                houseInfo.setHouseTitle(rs.getString(2));
                houseInfo.setHousePrice(rs.getFloat(3));
                houseInfo.setHouseDetail(rs.getString(4));
                houseInfo.setHousePic(rs.getBytes(5));
                houseInfo.setCreatedate(rs.getDate(6));
                houseInfo.setShoworder(rs.getInt(7));
                houseInfo.setIfshow(rs.getString(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return houseInfo;
    }

    @Override
    public List<HouseInfo> getList(ResultSet resultSet) {
        List<HouseInfo> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                HouseInfo houseInfo = new HouseInfo();

                houseInfo.setId(resultSet.getInt(1));
                houseInfo.setHouseTitle(resultSet.getString(2));
                houseInfo.setHousePrice(resultSet.getFloat(3));
                houseInfo.setHouseDetail(resultSet.getString(4));
                houseInfo.setHousePic(resultSet.getBytes(5));
                houseInfo.setCreatedate(resultSet.getDate(6));
                houseInfo.setShoworder(resultSet.getInt(7));
                houseInfo.setIfshow(resultSet.getString(8));
                list.add(houseInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
