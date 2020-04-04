package com.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hero {
    //增加id属性
    private int id;
    private String name;
    private float hp;
    private int damage;

}