package com.gallifrey.mercyhouse.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data
public class User {
    @TableId(type = IdType.AUTO)
    private int id;
    private String username;
    private String password;

    @TableField(exist = false)
    private List<Order> orderList;
}
