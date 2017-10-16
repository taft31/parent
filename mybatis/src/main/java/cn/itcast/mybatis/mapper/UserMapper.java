package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> queryUserListByIds(@Param("ids")Long[] ids);

    void updateUserIfPropertyNotNull(User user);

    List<User> queryUserListLikeUserNameAndAge(@Param("userName")String userName,@Param("age") Long age);

    List<User> queryUserListByUserNameOrAge(@Param("userName")String userName,@Param("age") Long age);

    List<User> queryUserListByUserName(@Param("userName")String userName);

    //多个参数时，最好用map，不需要指定param
    User loginMap(Map<String,Object> map);

    User login(@Param("userName") String userName,@Param("password") String password);

    List<User> queryUserByTableName(@Param("tableName") String tableName);

    /**
     * @param id
     * 根据id 获取用户信息
     * */
    User queryUserById(Long id);

    /**
     * 查询所有用户
     * */
    List<User> queryUserAll();


    /**
     * @param user
     *
     * 新增用户
     * */
    void insertUser(User user);

    /**
     *@param user
     * 修改用户信息
     * */
    void updateUser(User user);


    /**
     * @param id
     * 根据id删除用户
     * */

    void deleteUserById(Long id);
}
