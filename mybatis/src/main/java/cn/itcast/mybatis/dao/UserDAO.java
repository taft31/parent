package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.pojo.User;

import java.util.List;

public interface UserDAO {

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
