package com.example.dao.impl;

import com.example.dao.OrgDao;
import com.example.entity.OrgInfo;
import com.example.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrgDaoImpl implements OrgDao {

    private final Connection CONN = DBHelper.getConn();
    private ResultSet rs;

    @Override
    public List<OrgInfo> findAll() {
        List<OrgInfo> list = new ArrayList<>();

        try {
            String sql = "select * from org_info";
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                OrgInfo orgInfo = new OrgInfo();

                orgInfo.setId(rs.getInt(1));
                orgInfo.setOrgTitle(rs.getString(2));
                orgInfo.setOrgbDetail(rs.getString(3));
                orgInfo.setOrgPic(rs.getBytes(4));
                orgInfo.setCreatedate(rs.getDate(5));
                orgInfo.setShoworder(rs.getInt(6));
                orgInfo.setIfshow(rs.getString(7));
                list.add(orgInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public OrgInfo findById(Integer id) {

        OrgInfo orgInfo = new OrgInfo();
        try {
            String sql = "select * from org_info where ID = ?";
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                orgInfo.setId(rs.getInt(1));
                orgInfo.setOrgTitle(rs.getString(2));
                orgInfo.setOrgbDetail(rs.getString(3));
                orgInfo.setOrgPic(rs.getBytes(4));
                orgInfo.setCreatedate(rs.getDate(5));
                orgInfo.setShoworder(rs.getInt(6));
                orgInfo.setIfshow(rs.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orgInfo;
    }

    @Override
    public List<OrgInfo> getList(ResultSet resultSet) {
        try {
            List<OrgInfo> list = new ArrayList<>();

            while (rs.next()) {
                OrgInfo orgInfo = new OrgInfo();

                orgInfo.setId(resultSet.getInt(1));
                orgInfo.setOrgTitle(resultSet.getString(2));
                orgInfo.setOrgbDetail(resultSet.getString(3));
                orgInfo.setOrgPic(resultSet.getBytes(4));
                orgInfo.setCreatedate(resultSet.getDate(5));
                orgInfo.setShoworder(resultSet.getInt(6));
                orgInfo.setIfshow(resultSet.getString(7));
                list.add(orgInfo);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
