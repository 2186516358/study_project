package com.example.service.impl;

import com.example.dao.OrgDao;
import com.example.dao.impl.OrgDaoImpl;
import com.example.entity.OrgInfo;
import com.example.service.OrgService;

import java.util.List;

public class OrgServiceImpl implements OrgService {

    private OrgDao orgDao = new OrgDaoImpl();

    @Override
    public List<OrgInfo> getAll() {
        return orgDao.findAll();
    }

    @Override
    public OrgInfo getById(Integer id) {
        return orgDao.findById(id);
    }
}
