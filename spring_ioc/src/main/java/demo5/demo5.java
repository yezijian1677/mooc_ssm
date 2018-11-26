package demo5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:demo5.xml")
public class demo5 {
    @Resource(name = "customerDaoProxy")
    private CustomerDao customerDao;

    @Test
    public void demo1(){
        customerDao.find();
        customerDao.delete();
        customerDao.save();
        customerDao.update();
    }
}
