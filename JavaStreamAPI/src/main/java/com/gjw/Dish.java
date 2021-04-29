package com.gjw;

import lombok.Data;

/**
 * @author 郭经伟
 * @Date 2021/4/29
 * 菜肴
 **/
@Data
public class Dish {
    private String name;
    private boolean vegetarian;
    private Integer calories;
    private Type type;
    // getter and setter
}
