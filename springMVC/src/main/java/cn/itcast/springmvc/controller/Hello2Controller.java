package cn.itcast.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
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

    @RequestMapping(value="/show5/{userId}/{name}")
    public ModelAndView test05(@PathVariable("userId") String userId, @PathVariable("name") String name){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello");
        modelAndView.addObject("msg","SpringMVC，通配符 - **");
        System.out.println("userId:"+userId);
        System.out.println("name:"+name);
        return modelAndView;
    }

}
