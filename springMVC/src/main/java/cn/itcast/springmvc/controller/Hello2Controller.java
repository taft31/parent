package cn.itcast.springmvc.controller;

import cn.itcast.springmvc.model.User;
import cn.itcast.springmvc.model.UserVO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping(value = "hello")
@Controller
public class Hello2Controller {
    @RequestMapping(value="/show1.do")
    public ModelAndView test01(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("msg","SpringMVC的第一个注解程序");
        return modelAndView;
    }

    @RequestMapping(value="/sss?/show2.do")
    public ModelAndView test02(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("msg","SpringMVC,通配符 - ?");
        return modelAndView;
    }

    @RequestMapping(value="/aa*/show3.do")
    public ModelAndView test03(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("msg","SpringMVC，通配符 - *");
        return modelAndView;
    }

    @RequestMapping(value="/**/show4.do")
    public ModelAndView test04(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("msg","SpringMVC，通配符 - **");
        return modelAndView;
    }

    @RequestMapping(value="/show5/{id}/{name}")
    public ModelAndView test05(@PathVariable("id") Long id, @PathVariable("name") String name){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("msg","SpringMVC，占位符的映射，{placeHolderName}");
        System.out.println("id:"+id);
        System.out.println("name:"+name);
        return modelAndView;
    }

    @RequestMapping(value = "/show6",method = RequestMethod.POST)
    public ModelAndView test06(){
        ModelAndView mv = new ModelAndView();

        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping(value = "/show7",method = {RequestMethod.POST,RequestMethod.DELETE})
    public ModelAndView test07(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping(value = "/show8",params = "id")
    public ModelAndView test08(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","参数中必须含有id");
        return mv;
    }

    @RequestMapping(value = "/show9",params = "!id")
    public ModelAndView test09(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","参数中必须不包含id");
        return mv;
    }

    @RequestMapping(value = "/show10",params = "id=10086")
    public ModelAndView test10(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","参数中id必须为10086");
        return mv;
    }

    @RequestMapping(value = "/show11",params = "id!=10086")
    public ModelAndView test11(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","参数中id必须不为10086");
        return mv;
    }

    @RequestMapping(value = "/show12",params = {"id","name"})
    public ModelAndView test12(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg","参数中必须包含id及name");
        return mv;
    }

    @RequestMapping(value = "show13")
    public ModelAndView test13(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(request.toString()+"<br/>");
        stringBuilder.append(response.toString()+"<br/>");
        stringBuilder.append(session.toString()+"<br/>");

        modelAndView.addObject("msg","Servlet:原生参数:<br/>"+stringBuilder);

        return modelAndView;
    }


    @RequestMapping(value = "show14")
    public String test14(Model model, ModelMap modelMap){
        model.addAttribute("msg","SpringMVC特有对象");
        modelMap.addAttribute("msg","SpringMVC特有对象之子实现");
        return "hello";
    }

    @RequestMapping(value="show15/{id}")
    public String test15(@PathVariable(value = "id") String id){
        System.out.println("参数的id："+id);
        return "hello";
    }


    @RequestMapping(value="show16")
    public String test16(Model model,@RequestParam(value = "id") String id){
        System.out.println("参数的id："+id);
        model.addAttribute("msg","基本参数限定");
        return "hello";
    }

    @RequestMapping(value="show17")
    public String test17(Model model,@RequestParam(value = "id",required = false) String id){
        System.out.println("参数的id："+id);
        model.addAttribute("msg","基本参数限定不是必须需要型");
        return "hello";
    }

    @RequestMapping(value="show18")
    public String test18(Model model,@RequestParam(value = "id",required = false,defaultValue = "牛大牛家的牛二牛") String id){
        System.out.println("参数的id："+id);
        model.addAttribute("msg","基本参数限定不是必须需要型");
        return "hello";
    }

    @RequestMapping(value="show19")
    public String test19(@CookieValue("JSESSIONID") String JSessionId,Model model){
        System.out.println("cookie的Id："+JSessionId);
        model.addAttribute("msg","获取cookieId:"+JSessionId);
        return "hello";
    }

    @RequestMapping(value="show20")
    @ResponseStatus(HttpStatus.OK)
    public void test20(@RequestParam("name")String name,@RequestParam("age") Long age,@RequestParam("isMarry") Boolean isMarry,@RequestParam("income") String income,@RequestParam("interests")String[] interests){
        StringBuilder stb = new StringBuilder();
        stb.append("name:"+name+"<br/>");
        stb.append("age:"+age+"<br/>");
        stb.append("isMarry:"+isMarry+"<br/>");
        stb.append("income:"+income+"<br/>");
        stb.append("interests:"+ Arrays.toString(interests)+"<br/>");
        System.out.println("用户信息："+stb.toString());
    }

    @RequestMapping(value="show21")
    @ResponseStatus(HttpStatus.OK)
    public void test21(User user){
        System.out.println("用户信息："+user);
    }

    @RequestMapping(value="show22")
    public String test22(Model model,UserVO users){
        model.addAttribute("接收参数：",users);
        System.out.println("用户个数："+users.getUsers().toString());
        System.out.println("用户信息："+ users);
        return "hello";
    }

    @RequestMapping(value="show23")
    public String test23(Model model){
        List<User> users = new ArrayList<>();
        toMapUser(users);
        model.addAttribute("users",users);
        return "users";
    }

    @RequestMapping(value="show24")
    @ResponseBody
    public List<User> test24(){
        List<User> users = new ArrayList<>();
        toMapUser(users);
        return users;
    }

    public void toMapUser(List<User> users) {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(10086+i);
            user.setUserName("jack ma"+i);
            user.setName("马云"+i);
            user.setAge(50+1);
            users.add(user);
        }
    }
}
