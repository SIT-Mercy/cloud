package com.gallifrey.mercyhouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gallifrey.mercyhouse.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
//    //查询所有用户
//    @Select("select* from user")
//    public List<User> getAllUsers();
//
//    //查询某个id的用户
//    @Select("Select * from user where id=#{id}")
//    public User getUser(int id);
//
//    //添加用户
//    @Insert("insert into user (username,password)values(#{username},#{password})")
//    public int addUser(User user);

    // 查询用户及其所有的订单
    @Select("select * from user")
    @Results(
            {
                    @Result(column = "id",property = "id"),
                    @Result(column = "username",property = "username"),
                    @Result(column = "password",property = "password"),
                    @Result(column = "id",property = "orderList",javaType = List.class,
                    many = @Many(select = "com.gallifrey.mercyhouse.mapper.OrderMapper.selectByUid")
                    )
            }
    )
    List<User> selectAllUserAndOrder();
}
