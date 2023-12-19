package com.example.service;

import com.example.entity.OrgInfo;

import java.util.List;

public interface OrgService {

    List<OrgInfo> getAll();

    OrgInfo getById(Integer id);

}
