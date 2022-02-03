package com.lance.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    //@Secured("ROLE_role2")
    //@PreAuthorize("hasRole('role2')")
    @RequestMapping("/index")
    public String index(){
        System.out.println("index !!!");
        return "redirect:index.html";
    }

    @RequestMapping("/toError")
    public String error(){
        System.out.println("error !!!");
        return "redirect:error.html";
    }

    @GetMapping("/demo")
    public String demo(){
        System.out.println("demo !!!");
        return "demo";
    }
}
