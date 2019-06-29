package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.constant.RedisConstant;
import com.itheima.dao.SetmealDao;
import com.itheima.entity.PageResult;
import com.itheima.pojo.Setmeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisPool;

import java.util.List;

@Service(interfaceClass = SetmealService.class)
@Transactional
public class SetmealServiceImpl implements SetmealService {

    @Autowired
    SetmealDao setmealDao;
    @Autowired
    JedisPool jedisPool;
    @Override
    public void add(Integer[] checkgroupIds, Setmeal setmeal) {
        //保存套餐基本信息
        setmealDao.add(setmeal);
        //获取套餐主键循环保存
        Integer setmealId = setmeal.getId();
        setSetmealAndCheckGroup(checkgroupIds,setmealId);
        jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES,setmeal.getImg());
    }

    @Override
    public PageResult findPage(String queryString, Integer currentPage, Integer pageSize) {
        Page<Object> page = PageHelper.startPage(currentPage,pageSize);
        List<Setmeal> setmeals = setmealDao.findPage(queryString);
        return new PageResult(page.getTotal(),setmeals);
    }

    private void setSetmealAndCheckGroup(Integer[] checkgroupIds, Integer setmealId) {
        if (null != checkgroupIds && checkgroupIds.length > 0){
            for (Integer checkgroupId : checkgroupIds){
                setmealDao.setSetmealAndCheckGroup(checkgroupId,setmealId);
            }
        }
    }
}
