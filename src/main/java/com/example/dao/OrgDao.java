package com.example.dao;

import com.example.entity.OrgInfo;

import java.sql.ResultSet;
import java.util.List;

public interface OrgDao {
    List<OrgInfo> findAll();

    OrgInfo findById(Integer id);

    List<OrgInfo> getList(ResultSet rs);
}
