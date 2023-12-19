package com.example.service.impl;

import com.example.dao.MemberDao;
import com.example.dao.impl.MemberDaoImpl;
import com.example.entity.MemberInfo;
import com.example.service.MemberService;

import java.sql.SQLException;

public class MemberServiceImpl implements MemberService {

    private MemberDao memberDao = new MemberDaoImpl();

    @Override
    public boolean insert(MemberInfo memberInfo) throws SQLException {
        int rowCount = memberDao.insert(memberInfo);
        return rowCount > 0;
    }

    @Override
    public boolean update(MemberInfo memberInfo) throws SQLException {
        int rowCount = memberDao.update(memberInfo);
        return rowCount > 0;
    }

    @Override
    public MemberInfo getByName(String name) throws SQLException {
        return memberDao.findByName(name);
    }

    @Override
    public MemberInfo getById(Integer id) throws SQLException {
        return memberDao.findById(id);
    }
}
