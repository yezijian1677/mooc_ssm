import com.damu.entity.Users;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestDemo {

//    使用junit
    @Test
    public void testDemo01() throws IOException {
        String resource = "mybatis.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        //打开数据库之间的会话
        SqlSession session = factory.openSession();
        List<Users> ulist = session.selectList("usersList");

        for (Users user: ulist) {
            System.out.println(user);
        }
     session.close();
    }

}
