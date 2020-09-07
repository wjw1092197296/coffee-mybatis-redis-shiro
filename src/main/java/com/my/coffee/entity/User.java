package com.my.coffee.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Auther: wangjw
 * @Date: 2019/8/21 15:31
 * @Description:user信息
 */
@Accessors(chain = true)
@Data
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
}
