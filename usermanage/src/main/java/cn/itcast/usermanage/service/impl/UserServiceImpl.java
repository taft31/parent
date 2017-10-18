package cn.itcast.usermanage.service.impl;

import cn.itcast.usermanage.mapper.UserMapper;
import cn.itcast.usermanage.pojo.EasyUIResult;
import cn.itcast.usermanage.pojo.User;
import cn.itcast.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public EasyUIResult queryEasyUIResult(Integer pageNum, Integer pageSize) {
        List<User> userList =  userMapper.queryUsersByPage((pageNum-1)*pageSize,pageSize);
        EasyUIResult easyUIResult = new EasyUIResult();
        easyUIResult.setTotal(15L);
        easyUIResult.setRows(userList);
        return easyUIResult;
    }
}
