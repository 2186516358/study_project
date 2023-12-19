package com.example.dao;

import com.example.entity.MemberLevel;

import java.sql.ResultSet;
import java.util.List;

public interface MemberLevelDao {

    List<MemberLevel> findAll();

    MemberLevel findById(Integer id);

    List<MemberLevel> getList(ResultSet rs);

}
