import cn.itcast.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MyBatisTest {

    public static void main(String[] args) {
        SqlSession sqlSession = null;

        String resourceName = "mybatis-config.xml";

        try {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resourceName));
            sqlSession = sqlSessionFactory.openSession();

            User user = sqlSession.selectOne("UserMapper.queryUserById", 1L);

            System.out.println("user:" + user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != sqlSession) {
                sqlSession.commit();
                sqlSession.close();
            }
        }
    }
}
