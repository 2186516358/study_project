package com.example.dao.impl;

import com.example.dao.MemberDao;
import com.example.entity.MemberInfo;
import com.example.utils.DBHelper;

import java.sql.*;

public class MemberDaoImpl implements MemberDao {

    private final Connection CONN = DBHelper.getConn();
    private ResultSet rs;

    @Override
    public int insert(MemberInfo memberInfo) throws SQLException {
        int rowCount = 0;
        try {
            String sql =
                    "insert into member_info " +
                            "(MEM_USERNAME, MEM_PASSWORD, LEVEL_ID, " +
                            "MEM_NAME, MEM_AGE, MEM_SEX, MEM_ADDRESS, " +
                            "MEM_TEL, MEM_PHONE, MEM_EMAIL, REG_TIME, " +
                            "CARD_NO, STATUS, MEM_SCORE,MEM_PIC) " +
                            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            pstmt.setString(1, memberInfo.getMemUsername());
            pstmt.setString(2, memberInfo.getMemPassword());
            pstmt.setObject(3, memberInfo.getMemberLevel());
            pstmt.setString(4, memberInfo.getMemName());
            pstmt.setString(5, memberInfo.getMemAge());
            pstmt.setString(6, memberInfo.getMemSex());
            pstmt.setString(7, memberInfo.getMemAddress());
            pstmt.setString(8, memberInfo.getMemTel());
            pstmt.setString(9, memberInfo.getMemPhone());
            pstmt.setString(10, memberInfo.getMemEmail());
            pstmt.setDate(11, memberInfo.getRegTime());
            pstmt.setString(12, memberInfo.getCardNo());
            pstmt.setString(13, memberInfo.getStatus());
            pstmt.setFloat(14, memberInfo.getMemScore());
            pstmt.setBytes(15, memberInfo.getMemPic());
            rowCount = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CONN.close();
        }
        return rowCount;
    }

    @Override
    public int update(MemberInfo memberInfo) throws SQLException {

        int rowCount = 0;
        try {
            String sql = "update member_info set " +
                    "(MEM_NAME, MEM_AGE, MEM_SEX, MEM_ADDRESS, MEM_EMAIL, MEM_PHONE, MEM_PASSWORD) " +
                    "values (?, ?, ?, ?, ?, ?, ?) where ID = ?";
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            pstmt.setString(1, memberInfo.getMemName());
            pstmt.setString(2, memberInfo.getMemAge());
            pstmt.setString(3, memberInfo.getMemSex());
            pstmt.setString(4, memberInfo.getMemAddress());
            pstmt.setString(5, memberInfo.getMemEmail());
            pstmt.setString(6, memberInfo.getMemPhone());
            pstmt.setString(7, memberInfo.getMemPassword());
            rowCount = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CONN.close();
        }
        return rowCount;
    }

    @Override
    public MemberInfo findByName(String name) throws SQLException {
        MemberInfo memberInfo = new MemberInfo();
        try {
            String sql = "select * from member_info where MEM_USERNAME = ?";
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                memberInfo.setId(rs.getInt(1));
                memberInfo.setMemUsername(rs.getString(2));
                memberInfo.setMemPassword(rs.getString(3));
                memberInfo.setMemName(rs.getString(5));
                memberInfo.setMemAge(rs.getString(6));
                memberInfo.setMemSex(rs.getString(7));
                memberInfo.setMemAddress(rs.getString(8));
                memberInfo.setMemPhone(rs.getString(10));
                memberInfo.setMemEmail(rs.getString(11));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONN.close();
        }
        return memberInfo;
    }

    @Override
    public MemberInfo findById(Integer id) throws SQLException {
        MemberInfo memberInfo = new MemberInfo();

        try {
            String sql = "select * from member_info where ID = ?";
            PreparedStatement pstmt = CONN.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                memberInfo.setId(rs.getInt(1));
                memberInfo.setMemUsername(rs.getString(2));
                memberInfo.setMemPassword(rs.getString(3));
                memberInfo.setMemName(rs.getString(5));
                memberInfo.setMemAge(rs.getString(6));
                memberInfo.setMemSex(rs.getString(7));
                memberInfo.setMemAddress(rs.getString(8));
                memberInfo.setMemPhone(rs.getString(10));
                memberInfo.setMemEmail(rs.getString(11));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            CONN.close();
        }
        return memberInfo;
    }

    @Override
    public MemberInfo getList(ResultSet rs) throws SQLException {
        MemberInfo memberInfo = new MemberInfo();

        while (rs.next()) {
            memberInfo.setId(rs.getInt(1));
            memberInfo.setMemUsername(rs.getString(2));
            memberInfo.setMemPassword(rs.getString(3));
            memberInfo.setMemName(rs.getString(5));
            memberInfo.setMemAge(rs.getString(6));
            memberInfo.setMemSex(rs.getString(7));
            memberInfo.setMemAddress(rs.getString(8));
            memberInfo.setMemPhone(rs.getString(10));
            memberInfo.setMemEmail(rs.getString(11));
        }

        return memberInfo;
    }
}
