package cn.itcast.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

}
