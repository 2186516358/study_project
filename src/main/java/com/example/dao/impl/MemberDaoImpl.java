package com.example.dao.impl;

import com.example.dao.MemberDao;
import com.example.entity.MemberInfo;
import com.example.utils.DBHelper;
import com.example.utils.Util;

import java.sql.*;

public class MemberDaoImpl implements MemberDao {

    private final Connection CONN = DBHelper.getConn();
    private ResultSet rs;

    @Override
    public int insert(MemberInfo memberInfo) throws SQLException {
        int rowCount = 0;
        try{
            Statement state = CONN.createStatement();
            String sql = "insert into member_info (MEM_USERNAME, MEM_PASSWORD, LEVEL_ID, MEM_NAME, MEM_AGE, MEM_SEX, MEM_ADDRESS, MEM_TEL, MEM_PHONE, MEM_EMAIL, REG_TIME, CARD_NO, STATUS, MEM_SCORE,MEM_PIC) value ('" +
                    memberInfo.getMemUsername() + "','"+
                    memberInfo.getMemPassword() + "','" +
                    memberInfo.getMemberLevel().getId() + "','" +
                    memberInfo.getMemName() + "','" +
                    memberInfo.getMemAge() + "','" +
                    memberInfo.getMemSex() + "','" +
                    memberInfo.getMemAddress() + "','" +
                    memberInfo.getMemTel() + "','" +
                    memberInfo.getMemPhone() + "','" +
                    memberInfo.getMemEmail() + "','" +
                    Util.changeDate(memberInfo.getRegTime()) + "','" +
                    memberInfo.getCardNo() + "','" +
                    memberInfo.getStatus() + "','" +
                    memberInfo.getMemScore() + "','" +
                    memberInfo.getMemPic() + "')";

            state.executeUpdate(sql);

        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
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
        }/* finally {
            CONN.close();
        }*/
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
