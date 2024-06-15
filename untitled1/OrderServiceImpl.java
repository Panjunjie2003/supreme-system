package com.ssm.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssm.dao.OrderMapper;
import com.ssm.pojo.Order;
import com.ssm.service.OrderService;
import javax.swing.*;
import java.util.List;

//@Service标记的类专注于业务逻辑，此处定义orderService自动注入Spring容器，不需XML中定义Bean
@Service("orderService")
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order queryOrderByNum(int id) {
        return orderMapper.queryOrderByNum(id);
    }

    @Override
    public List<Order> queryOrderAll() {
        return orderMapper.queryOrderAll();
    }

    @Override
    public String addOrder(Order order){
        int  num = orderMapper.addOrder(order);
        if (num > 0)
            return "订单添加成功";
        else
            return "订单已经存在或添加失败";
    }

    @Override
    public String deleteOrder(int id){
        int num = orderMapper.deleteOrder(id);
        if (num > 0)
            return id+"号订单删除成功";
        else
            return id+"号订单不存在或删除失败";
    }

    public String updateOrder(int id, Integer count, Double money){
        int num = orderMapper.updateOrder(id,count,money);
        if (num > 0)
            return id+"号订单修改成功";
        else
            return id+"号订单不存在或修改失败";
    }
}
