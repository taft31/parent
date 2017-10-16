package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class OrderMapperTest {
    private OrderMapper orderMapper;

    SqlSession sqlSession = null;
    SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void setUp() throws Exception {
        String resourceName = "mybatis-config.xml";

        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resourceName),"development");
            sqlSession = sqlSessionFactory.openSession(true);
            orderMapper = sqlSession.getMapper(OrderMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryOrderWithUserById() throws Exception {
        Order order = this.orderMapper.queryOrderWithUserById("20140921001");
        System.out.println("order:"+order);
    }


    @Test
    public void queryOrderWithUserAndDetailById() throws Exception {
        System.out.println("orderMapper:"+orderMapper);
        Order order = this.orderMapper.queryOrderWithUserAndDetailById("20140921001");
        System.out.println("order:"+order);
    }

    @Test
    public void queryOrderWithUserAndItem() throws Exception {
        System.out.println("orderMapper:"+orderMapper);
        Order order = this.orderMapper.queryOrderWithUserAndItem("20140921001");
        System.out.println("order:"+order);
    }

    @Test
    public void queryOrder() throws Exception {
        Order order = this.orderMapper.queryOrder("20140921001");
        //System.out.println("order:"+order);


        System.out.println(order.getOrderNumber());

        System.out.println(order.getUser());
    }

}