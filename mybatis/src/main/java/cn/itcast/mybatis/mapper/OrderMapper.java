package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {

    Order queryOrderWithUserById(@Param("id") String id);

    Order queryOrderWithUserAndDetailById(@Param("id") String id);

    Order queryOrderWithUserAndItem(@Param("id") String id);

    Order queryOrder(@Param("id") String id);

}
