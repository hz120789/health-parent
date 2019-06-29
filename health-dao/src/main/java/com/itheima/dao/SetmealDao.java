package com.itheima.dao;

import com.itheima.pojo.Setmeal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SetmealDao {

    void add(Setmeal setmeal);

    void setSetmealAndCheckGroup(@Param("checkgroupId") Integer checkgroupId,
                                  @Param("setmealId")Integer setmealId);

    List<Setmeal> findPage(@Param("queryString") String queryString);
}
