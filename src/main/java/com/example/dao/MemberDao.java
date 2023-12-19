package com.example.dao;

import com.example.entity.MemberInfo;

import javax.sound.midi.MetaMessage;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface MemberDao {


    int insert(MemberInfo memberInfo) throws SQLException;

    int update(MemberInfo memberInfo) throws SQLException;

    MemberInfo findByName(String name) throws SQLException;

    MemberInfo findById(Integer id) throws SQLException;

    MemberInfo getList(ResultSet rs) throws SQLException;

}
