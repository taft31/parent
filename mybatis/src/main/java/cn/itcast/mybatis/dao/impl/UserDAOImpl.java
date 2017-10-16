package cn.itcast.mybatis.dao.impl;

import cn.itcast.mybatis.dao.UserDAO;
import cn.itcast.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    private SqlSession sqlSession;

    public UserDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public User queryUserById(Long id) {
        return this.sqlSession.selectOne("UserDAOMapper.queryUserById", id);
    }

    @Override
    public List<User> queryUserAll() {
        return this.sqlSession.selectList("UserDAOMapper.queryUserAll");
    }

    @Override
    public void insertUser(User user) {
        this.sqlSession.insert("UserDAOMapper.insertUser", user);
        this.sqlSession.commit();
    }

    @Override
    public void updateUser(User user) {
        this.sqlSession.update("UserDAOMapper.updateUser", user);
        this.sqlSession.commit();
    }

    @Override
    public void deleteUserById(Long id) {
        this.sqlSession.insert("UserDAOMapper.deleteUserById", id);
        this.sqlSession.commit();
    }
}
