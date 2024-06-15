package com.ssm.dao;
import org.apache.ibatis.annotations.*;
import com.ssm.pojo.Order;
import java.util.List;

public interface OrderMapper {
//    使用SQL语句，根据id查询该id的信息
    @Select("select * from orders where id=#{id}")
    @Results(id="orderMap", value={
            @Result(id=true, property="id", column="id"),
            @Result(property="number", column="number"),
            @Result(property="member_id", column="member_id"),
            @Result(property="product_name", column="product_name"),
            @Result(property="count", column="count"),
            @Result(property="money", column="money"),
            @Result(property="addTime", column="addTime")})
    public Order queryOrderByNum(int id);


//    使用SQL语句查询该表全部信息
    @Select("select * from orders")
    @ResultMap(value="orderMap")
    public List<Order> queryOrderAll();


//    使用SQL语句向表插入字段
    @Insert("insert into orders(number, member_id, product_name, count, money,addTime) "
            + "values(#{number}, #{member_id}, #{product_name}, #{count}, #{money},#{addTime})")
    public int addOrder(Order order);


//    使用SQL语句,根据id删除字段信息
    @Delete("delete from orders where id=#{id}")
    public int deleteOrder(int id);


//    使用SQL语句,根据id修改字段信息
    @Update("update orders set count=#{count}, money=#{money} where id=#{id}")
    public int updateOrder(@Param(value="id") int id, @Param(value="count") Integer count,
                           @Param(value="money") Double money);
}
