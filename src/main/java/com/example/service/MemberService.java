package com.example.service;

import com.example.entity.MemberInfo;

import java.sql.SQLException;

public interface MemberService {

    boolean insert(MemberInfo memberInfo) throws SQLException;

    boolean update(MemberInfo memberInfo) throws SQLException;

    MemberInfo getByName(String name) throws SQLException;

    MemberInfo getById(Integer id) throws SQLException;

}
