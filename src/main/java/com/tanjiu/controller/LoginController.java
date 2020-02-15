package com.tanjiu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @author 叹久
 * @create 2020-02-15 13:15
 */

@Controller
public class LoginController {
    @RequestMapping("/user/logins")
    @ResponseBody
    public String login(){
        return "ok";
    }

    @RequestMapping("/user/login")
//    @ResponseBody
    public String login(@RequestParam("username")  String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){
//        System.out.println("执行了");
        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("loginUser",username);
            //登陆成功后，重定向到列表页面，需要在mvcconfig里面配置请求路径跳转
            return "redirect:/main.html";
        }else{
//            System.out.println("执行失败了");
            // 告诉用户登陆失败
            model.addAttribute("msg","用户名或者密码错误");
            return "index";
        }
    }

    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }

}
