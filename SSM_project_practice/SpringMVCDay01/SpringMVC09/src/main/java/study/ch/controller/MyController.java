package study.ch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import study.ch.Service.MyService;

/**
 *在springmvc容器中
 */
@Controller
public class MyController {

    @Autowired
    MyService myService;

    public MyController(){
        System.out.println("MyController...");
    }
}
