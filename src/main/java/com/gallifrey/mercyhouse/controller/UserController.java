package com.gallifrey.mercyhouse.controller;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gallifrey.mercyhouse.bean.User;
import com.gallifrey.mercyhouse.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController  {

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/user/{current}/{size}")
    public IPage getAllUserByPage(@PathVariable int current, @PathVariable int size){
        Page<User> page=new Page<>(current,size);
        IPage iPage=userMapper.selectPage(page,null);
        return iPage;
    }



    @GetMapping("/users")
    public List getAllUsers(){
        List<User> userList=userMapper.selectList(null);
        System.out.println(userList);
        return  userList;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") int id){

        return userMapper.selectById(id);
    }
    @GetMapping("/user/findAll")
    public List getAllUserAndOrder(){
       return userMapper.selectAllUserAndOrder();
    }



    @PostMapping("/user")
    public String insertUser(User user){
        int i=userMapper.insert(user);
        if(i>0){
            return "200OK";
        }else {
            return"插入失败";
        }

    }


    @PutMapping("/user")
    public String updateUser(User user){
        return "更新用户";
    }
    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable("id") int id){
        System.out.println(id);
        return "根据id删除用户";
    }
}
