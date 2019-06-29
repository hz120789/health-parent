package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.pojo.CheckGroup;

import java.util.List;

public interface CheckgroupService {
    void add(CheckGroup checkGroup,Integer[] checkitemIds );

    PageResult findPage(Integer pageSize, Integer currentPage, String queryString);

    CheckGroup findById(Integer id);

    void edit(CheckGroup checkGroup, Integer[] checkitemIds);

    List<Integer> findCheckItemIdsByCheckGroupId(Integer checkGroupId);

    List<CheckGroup> findAll();
}
