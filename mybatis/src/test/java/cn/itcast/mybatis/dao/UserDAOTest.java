package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.dao.impl.UserDAOImpl;
import cn.itcast.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;


public class UserDAOTest {
    private UserDAO userDAO;

    @Before
    public void setUp() throws Exception {

        SqlSession sqlSession = null;
        String resourceName = "mybatis-config.xml";

        try {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resourceName));
            sqlSession = sqlSessionFactory.openSession();
            userDAO = new UserDAOImpl(sqlSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryUserById() throws Exception {

        User user = this.userDAO.queryUserById(1L);

        System.out.println(user);

    }

    @Test
    public void queryUserAll() throws Exception {

        List<User> users = this.userDAO.queryUserAll();

        for (User user : users) {
            System.out.println("==============================");
            System.out.println("user:" + user);
        }
    }

    @Test
    public void insertUser() throws Exception {

        User user = new User();

        user.setUserName("ldh");
        user.setPassword("ldh123");
        user.setName("刘德华");
        user.setAge(50);
        user.setSex(1);
        user.setBirthday(new Date());

        this.userDAO.insertUser(user);

    }

    @Test
    public void updateUser() throws Exception {

        User user = new User();
        user.setId(7L);
        user.setUserName("zxy");
        user.setPassword("zxy123");
        user.setName("张学友");
        user.setAge(50);
        user.setSex(1);
        user.setBirthday(new Date());

        this.userDAO.updateUser(user);

    }

    @Test
    public void deleteUserById() throws Exception {

        this.userDAO.deleteUserById(7L);
    }

}