package cn.itcast.usermanage.mapper;

import cn.itcast.usermanage.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     *根据id获得user信息
     * @param id
     * */
    User queryUserById(Long id);

    List<User> queryUsersByPage(@Param("start")Integer start,@Param("pageSize")Integer pageSize);
}
