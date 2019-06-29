package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckgroupDao;
import com.itheima.entity.PageResult;
import com.itheima.pojo.CheckGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(interfaceClass = CheckgroupService.class)
@Transactional
public class CheckgroupServiceImp implements CheckgroupService {
    @Autowired
    CheckgroupDao checkgroupDao;
    @Override
    public void add(CheckGroup checkGroup, Integer[] checkitemIds) {
        //插入检查组基本信息并返回id
        checkgroupDao.add(checkGroup);
        Integer checkGroupId = checkGroup.getId();
        //使用检查组id和页面输入的检查项id集合然后使用循环一条一条插入
        setCheckGroupAndCheckItm(checkitemIds,checkGroupId);
    }

    @Override
    public PageResult findPage(Integer pageSize, Integer currentPage, String queryString) {
        //使用分页插件
        PageHelper.startPage(currentPage,pageSize);
        Page<CheckGroup> page = checkgroupDao.findPage(queryString);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public CheckGroup findById(Integer id) {
        return checkgroupDao.findById(id);
    }

    @Override
    public void edit(CheckGroup checkGroup, Integer[] checkitemIds) {
        //修改检查组基本信息
        checkgroupDao.edit(checkGroup);
        //删除检查组原来关联的检查项
        checkgroupDao.deleteAssociation(checkGroup.getId());
        //插入新的关联关系
        setCheckGroupAndCheckItm(checkitemIds,checkGroup.getId());
    }

    @Override
    public List<Integer> findCheckItemIdsByCheckGroupId(Integer checkGroupId) {
        //根据checkGroupId 查询t_checkgroup_checkitem
        return checkgroupDao.findCheckItemIdsByCheckGroupId(checkGroupId);
    }

    @Override
    public List<CheckGroup> findAll() {

        return checkgroupDao.findAll();
    }

    private void setCheckGroupAndCheckItm(Integer[] checkitemIds, Integer checkGroupId) {
        if (checkitemIds != null && checkitemIds.length > 0){
          for  (Integer checkitemId : checkitemIds){
              checkgroupDao.setCheckGroupAndCheckItem(checkitemId,checkGroupId);
          }
        }
    }
}
