package demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
* Bean作用范围测试
* */
public class SpringDemo3 {
    @Test
    public void demo1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person1 = (Person) applicationContext.getBean("person");
        Person person2 = (Person) applicationContext.getBean("person");


        /**
         * 默认singleton
         * singgleton单例的，获取几次都是同一个对象
         * prototype 多例的，每次get重新new一次对象， Spring整合struct2用到多例
         */
        System.out.println(person1);
        System.out.println(person2);
    }

    @Test
    public void demo2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Man man = (Man) applicationContext.getBean("man");

        System.out.println(man);
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
