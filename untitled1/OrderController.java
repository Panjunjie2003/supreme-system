package com.ssm.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ssm.pojo.Order;
import com.ssm.service.OrderService;
import java.util.List;

//@Controller设置该class为控制器,@RequestMapping设置结果映射地址
@Controller
@RequestMapping("/order")
public class OrderController {
//    定义并自动装配OrderService对象,并设置order的下一级映射地址
    @Autowired
    private OrderService orderService;
    @RequestMapping("/queryOrderByNum/{id}")
//    @ResponseBody将Java对象转为json格式数据，通过接口获取数据库信息文本表示
    @ResponseBody
    public Order queryOrderByNum(@PathVariable int id){
        Order order = orderService.queryOrderByNum(id);
        return order;
    }


    @RequestMapping("/queryOrderAll")
    @ResponseBody
    public List<Order> queryOrderAll(){
        return orderService.queryOrderAll();
    }


    @RequestMapping("/addOrder")
    @ResponseBody
    public String addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }


    @RequestMapping("/deleteOrder/{id}")
    @ResponseBody
    public String deleteOrder(@PathVariable int id){
        return orderService.deleteOrder(id);
    }


    @RequestMapping("/updateOrder/{id}/{count}/{money}")
    @ResponseBody
    public String updateOrder(@PathVariable("id") int id, @PathVariable("count") Integer count, @PathVariable("money") Double money) {
        return orderService.updateOrder(id, count, money);
    }
}
