package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.pojo.Setmeal;

public interface SetmealService {

    void add(Integer[] checkgroupIds, Setmeal setmeal);

    PageResult findPage(String queryString, Integer currentPage, Integer pageSize);
}
