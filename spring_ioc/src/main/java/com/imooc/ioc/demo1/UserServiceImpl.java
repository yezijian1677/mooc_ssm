package com.imooc.ioc.demo1;

public class UserServiceImpl implements UserService {

    //添加属性
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sayHello() {
        System.out.println("hello Spring" + name);
    }
}
