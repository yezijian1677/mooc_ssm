package demo2;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
* 测试Bean的实例化的三种方式
* */
public class SpringDemo2 {
    @Test
    public void demo1(){
        //创建工程
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
    }

    @Test
    public void demo2(){
        //创建工程
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");
    }

    @Test
    public void demo3(){
        //创建工程
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Bean3 bean3 = (Bean3) applicationContext.getBean("bean3");
    }
}
