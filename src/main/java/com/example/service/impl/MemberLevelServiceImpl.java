package com.example.service.impl;

import com.example.entity.MemberLevel;
import com.example.service.MemberLevelService;

import java.util.List;

public class MemberLevelServiceImpl implements MemberLevelService {

    private MemberLevelService memberLevelService = new MemberLevelServiceImpl();

    @Override
    public List<MemberLevel> getAll() {
        return memberLevelService.getAll();
    }

    @Override
    public MemberLevel getById(Integer id) {
        return memberLevelService.getById(id);
    }
}
