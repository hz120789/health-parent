package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CkeckitemService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/checkitem")
public class CheckitemController {
    @Reference
     CkeckitemService checkitemService;
    //新增
    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem){

        //调用dubbo服务
        try {
            checkitemService.add(checkItem);
            return new Result(true,MessageConstant.ADD_CHECKITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.ADD_CHECKITEM_FAIL);
        }
    }

    //分页查询
    @RequestMapping("/findPage")
   public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
       return checkitemService.findPage(queryPageBean.getQueryString(),queryPageBean.getCurrentPage(),
               queryPageBean.getPageSize());
    }

    //删除
    @RequestMapping("/delete")
    public Result delete(Integer id){
        try {
            int count = checkitemService.delete(id);
            if (count>0){
                return new Result(false,"存在引用，不能删除");
            }
            return new Result(true,MessageConstant.DELETE_CHECKITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.DELETE_CHECKITEM_FAIL);
        }
    }

    //编辑
    @RequestMapping("/edit")
    public Result edit(@RequestBody CheckItem checkItem){
        try {
            checkitemService.edit(checkItem);
            return new Result(true,MessageConstant.EDIT_CHECKGROUP_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.EDIT_CHECKGROUP_FAIL);
        }
    }

    //查询所有
    @RequestMapping("/findAll")
    public Result findAll(){
        try {
            List<CheckItem> checkItems = checkitemService.findAll();
            return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,checkItems);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_CHECKITEM_FAIL);
        }
    }

    @RequestMapping("/findById")
    public Result findById(Integer id){
        try {
            CheckItem checkItem=checkitemService.findById(id);
            return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.QUERY_CHECKITEM_FAIL);
        }
    }
}
