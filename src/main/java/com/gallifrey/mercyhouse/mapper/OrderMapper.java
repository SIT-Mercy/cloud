package com.gallifrey.mercyhouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gallifrey.mercyhouse.bean.Order;
import com.gallifrey.mercyhouse.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Select("select * from m_order where uid=#{uid}")
    List<Order> selectByUid(int uid);


    //查询订单时，查询订单的用户信息
    @Select("select * from m_order")
    @Results(value = {
            @Result(column = "oid",property = "oid"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "gid",property = "gid"),
            @Result(column = "number",property = "number"),
            @Result(column = "uid",property = "user",javaType = User.class,
            one = @One(select = "com.gallifrey.mercyhouse.mapper.UserMapper.selectById"))
    })
    List<Order> selectAllOderAndUser();

}
