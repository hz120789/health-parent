package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 持久层Dao接口
 */
public interface CheckgroupDao {

    void add(CheckGroup checkGroup);

    void setCheckGroupAndCheckItem(@Param("checkitemId") Integer checkitemId,
                                   @Param("checkGroupId")Integer checkGroupId);

    Page<CheckGroup> findPage(@Param("queryString")String queryString);

    CheckGroup findById(@Param("id")Integer id);

    void edit(CheckGroup checkGroup);

    void deleteAssociation(Integer id);

    List<Integer> findCheckItemIdsByCheckGroupId(@Param("checkGroupid") Integer checkGroupId);

    List<CheckGroup> findAll();
}
