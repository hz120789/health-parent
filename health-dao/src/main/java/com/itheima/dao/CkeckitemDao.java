package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CkeckitemDao {

    void add(CheckItem checkItem);

    Page<CheckItem> findPage(@Param("queryString") String queryString);

    void delete(@Param("id") Integer id);

    Integer findCountByCheckItemId(@Param("id") Integer id);

    void edit(CheckItem checkItem);

    List<CheckItem> findAll();

    CheckItem findById(@Param("id")Integer id);
}
