package com.example.dao.impl;

import com.example.dao.MemberLevelDao;
import com.example.entity.MemberLevel;
import com.example.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberLevelDaoImpl implements MemberLevelDao {

    private static final Connection CONN = DBHelper.getConn();
    private ResultSet rs;

    @Override
    public List<MemberLevel> findAll() {
        List<MemberLevel> list = new ArrayList<>();
        try {
            String sql = "select * from member_level";
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                MemberLevel memberLevel = new MemberLevel();

                memberLevel.setId(rs.getInt(1));
                memberLevel.setLevelTitle(rs.getString(2));
                memberLevel.setLevelDetail(rs.getString(3));
                memberLevel.setLevelPic(rs.getBytes(4));
                list.add(memberLevel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public MemberLevel findById(Integer id) {
        MemberLevel memberLevel = new MemberLevel();

        try {
            String sql = "select * from member_level where ID = ?";
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                memberLevel.setId(rs.getInt(1));
                memberLevel.setLevelTitle(rs.getString(2));
                memberLevel.setLevelDetail(rs.getString(3));
                memberLevel.setLevelPic(rs.getBytes(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return memberLevel;
    }

    @Override
    public List<MemberLevel> getList(ResultSet resultSet) {
        try {
            List<MemberLevel> list = new ArrayList<>();

            while (resultSet.next()) {
                MemberLevel memberLevel = new MemberLevel();

                memberLevel.setId(resultSet.getInt(1));
                memberLevel.setLevelTitle(resultSet.getString(2));
                memberLevel.setLevelDetail(resultSet.getString(3));
                memberLevel.setLevelPic(resultSet.getBytes(4));
                list.add(memberLevel);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
