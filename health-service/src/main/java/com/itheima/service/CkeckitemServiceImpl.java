package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CkeckitemDao;
import com.itheima.entity.PageResult;
import com.itheima.pojo.CheckItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(interfaceClass = CkeckitemService.class)
@Transactional
public class CkeckitemServiceImpl implements CkeckitemService {

    @Autowired
    CkeckitemDao ckeckitemDao;
    @Override
    public void add(CheckItem checkItem) {

        ckeckitemDao.add(checkItem);
    }

    @Override
    public PageResult findPage(String queryString, Integer currentPage, Integer pageSize) {
        //使用分页插件
        PageHelper.startPage(currentPage,pageSize);
        Page<CheckItem> page=ckeckitemDao.findPage(queryString);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public int delete(Integer id) {
        //企业不是真删除，是修改状态，不可见
        /**
         * 查询一下是否存在引用
         */
       Integer count = ckeckitemDao.findCountByCheckItemId(id);
        if (count>0) {
            return count;
        }
        ckeckitemDao.delete(id);
        return 0;
    }

    @Override
    public void edit(CheckItem checkItem) {
        ckeckitemDao.edit(checkItem);
    }

    @Override
    public List<CheckItem> findAll() {
        return ckeckitemDao.findAll();
    }

    @Override
    public CheckItem findById(Integer id) {

        return ckeckitemDao.findById(id);
    }
}
