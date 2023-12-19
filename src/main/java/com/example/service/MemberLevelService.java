package com.example.service;

import com.example.entity.MemberLevel;

import java.util.List;

public interface MemberLevelService {

    List<MemberLevel> getAll();

    MemberLevel getById(Integer id);

}
