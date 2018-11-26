package demo4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:demo4.xml")
public class SpringDemo4 {
//    注入
    @Resource(name = "studentDaoProxy")
    private StudentDao studentDao;

    @Test
    public void demo1(){
        studentDao.find();
        studentDao.save();
        studentDao.update();
        studentDao.delete();
    }
}
