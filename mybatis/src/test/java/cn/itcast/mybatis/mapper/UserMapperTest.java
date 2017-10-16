package cn.itcast.mybatis.mapper;


import cn.itcast.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserMapperTest {
    private UserMapper userMapper;

    SqlSession sqlSession = null;
    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void setUp() throws Exception {


        String resourceName = "mybatis-config.xml";

        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resourceName),"development");
            sqlSession = sqlSessionFactory.openSession(true);
            userMapper = sqlSession.getMapper(UserMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryUserById() throws Exception {

        System.out.println("userMapper:"+userMapper);

        User user = this.userMapper.queryUserById(1L);

        System.out.println(user);

    }

    @Test
    public void queryUserAll() throws Exception {

        List<User> users = this.userMapper.queryUserAll();

        for (User user : users) {
            System.out.println("==============================");
            System.out.println("user:" + user);
        }
    }

    @Test
    public void insertUser() throws Exception {

        User user = new User();

        user.setUserName("zbz");
        user.setPassword("zbz123");
        user.setName("张柏芝");
        user.setAge(33);
        user.setSex(2);
        user.setBirthday(new Date());

        this.userMapper.insertUser(user);

        this.sqlSession.commit();
        this.sqlSession.close();
        System.out.println("user:"+user);
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

        this.userMapper.updateUser(user);

    }

    @Test
    public void deleteUserById() throws Exception {

        this.userMapper.deleteUserById(7L);
    }

    @Test
    public void testQueryByTableName(){
        List<User> users = this.userMapper.queryUserByTableName("tb_user");
        for (User user : users) {
            System.out.println("========================");
            System.out.println(user);
        }
    }

    @Test
    public void testLogin(){
        User user = this.userMapper.login("zbz","zbz123");
        System.out.println("user:"+user);
    }

    @Test
    public void testLoginMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("userName","zbz");
        map.put("password","zbz123");

        User user = this.userMapper.loginMap(map);

        System.out.println("user:"+user);
    }

    @Test
    public void testQueryUserListByUserName(){
        List<User> users = this.userMapper.queryUserListByUserName("zhang");
        System.out.println("====================");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryUserListByUserNameOrAge(){
        List<User> users = this.userMapper.queryUserListByUserNameOrAge("ldh",50L);
        System.out.println("====================");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryUserListLikeUserNameAndAge(){
        List<User> users = this.userMapper.queryUserListLikeUserNameAndAge("ldh",50L);
        for (User user : users) {
            System.out.println("===========");
            System.out.println("user:"+user);
        }
    }

    @Test
    public void testUpdateUserIfPropertyNotNull(){
        User user = new User();
        user.setId(10L);
        user.setUserName("lm");
        user.setPassword("lm123");
        //user.setName("黎明");
        user.setSex(2);
        user.setAge(30);
        user.setBirthday(new Date());

        this.userMapper.updateUserIfPropertyNotNull(user);
        this.sqlSession.commit();
    }

    @Test
    public void testQueryUserListByIds(){
        List<User> users = this.userMapper.queryUserListByIds(new Long[]{1L,2L,3L,10L});
        for (User user : users) {
            System.out.println("=============");
            System.out.println("user:"+user);
        }
    }

    @Test
    public void testCache(){
        User user1 = this.userMapper.queryUserById(10L);
        System.out.println("user1:"+user1);
        System.out.println("=======================");
        //sqlSession.clearCache();

        User user = new User();
        user.setId(10L);
        user.setName("谢霆锋");

        this.userMapper.updateUserIfPropertyNotNull(user);
        User user2 = this.userMapper.queryUserById(10L);

        System.out.println("user2:"+user2);
    }

    @Test
    public void testCache2(){
        System.out.println("===========第一次查询==========");
        User user1 = this.userMapper.queryUserById(10L);
        System.out.println("user1:"+user1);
        System.out.println("===============第二次查询================");
        //先关闭sqlSession
        this.sqlSession.close();
        SqlSession sqlSession1 = this.sqlSessionFactory.openSession(true);
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);

        User user = new User();
        user.setName("任达华");

        userMapper1.updateUserIfPropertyNotNull(user);
        User user2 = userMapper1.queryUserById(10L);
        System.out.println("user2:"+user2);


    }
}