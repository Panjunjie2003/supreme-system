package com.ssm.service;
import com.ssm.pojo.Order;
import java.util.List;

public interface OrderService {
    public Order queryOrderByNum(int id);

    public List<Order> queryOrderAll();

    public String addOrder(Order order);

    public String deleteOrder(int id);

    public String updateOrder(int id, Integer count, Double money);
}
