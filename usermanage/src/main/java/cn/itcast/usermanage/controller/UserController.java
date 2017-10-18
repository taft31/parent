package cn.itcast.usermanage.controller;

import cn.itcast.usermanage.pojo.EasyUIResult;
import cn.itcast.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "users")
    public String toUser(){
        return "users";
    }

    @ResponseBody
    @RequestMapping("list")
    public EasyUIResult queryUsersByPage(@RequestParam("page")Integer pageNum, @RequestParam("rows")Integer PageSize){
        return this.userService.queryEasyUIResult(pageNum,PageSize);
    }
}
