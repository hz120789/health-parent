package com.itheima.service;

import com.itheima.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

public interface OrdersettingService {
    void editNumberByDate(OrderSetting orderSetting);

    List<Map> getOrderSettingByDate(String dateStr);

    void add(List<OrderSetting> orderSettings);
}
