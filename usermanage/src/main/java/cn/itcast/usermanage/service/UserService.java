package cn.itcast.usermanage.service;

import cn.itcast.usermanage.pojo.EasyUIResult;

public interface UserService {

    /**
     *分页获取用户信息
     *@param pageNum 当前页码
     *@param pageSize 页容量
     */
    EasyUIResult queryEasyUIResult(Integer pageNum,Integer pageSize);
}
