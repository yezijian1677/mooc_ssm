package demo6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:demo6.xml")
public class demo {

    @Resource(name = "productDao")
    private ProductDao productDao;

    @Test
    public void test() {
        productDao.delete();
        productDao.find();
        productDao.findOne();
        productDao.save();
        productDao.update();
    }
}
