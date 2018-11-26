package com.imooc.ioc.demo1;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringDemo1 {

    /*
        传统开发模式
     */
    @Test
    public void demo0() {
         UserService userService = new UserServiceImpl();
         //设置属性
        //有属性的话要把UserService对象改为UserServiceImpl对象
        ((UserServiceImpl) userService).setName("小白");
         userService.sayHello();
    }

    @Test
    /**
     * 使用Spring的方式
     */
    public void demo2(){
//        创建Spring工厂
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        通过工厂获取类
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHello();

    }

    @Test
    public void demo3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringFood springFood = (SpringFood) applicationContext.getBean("foodService");
        System.out.println(springFood.toString());
    }

    /*
    * 读取磁盘中的配置文件
    * */
    @Test
    public void demo4(){
        ApplicationContext applicationContext  = new FileSystemXmlApplicationContext("D:\\applicationContext.xml");
        //        通过工厂获取类
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHello();
    }

    /*
        传统方式工厂类
     */
    @Test
    public void demo5(){
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.sayHello();
    }
}
