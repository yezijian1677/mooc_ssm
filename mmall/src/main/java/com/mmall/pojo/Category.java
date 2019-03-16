package com.mmall.pojo;

import lombok.*;

import java.util.Date;

@Data//getter setter
@AllArgsConstructor//所有参数的构造器
@NoArgsConstructor//无参构造
@ToString(exclude = "updateTime")//toString
@EqualsAndHashCode(of = "id")
public class Category {
    private Integer id;

    private Integer parentId;

    private String name;

    private Boolean status;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;


}