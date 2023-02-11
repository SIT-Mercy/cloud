package com.gallifrey.mercyhouse.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("m_order")
public class Order {
    private int oid;
    private int uid;
    private String gid;
    private int number;

    @TableField(exist = false)
    private User user;

}
