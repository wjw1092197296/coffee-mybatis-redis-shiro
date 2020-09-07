package com.my.coffee.mycontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: wangjw
 * @Date: 2019/8/13 10:51
 * @Description:
 */
@Controller
@RequestMapping("/my")
public class MyController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/myHello")
    @ResponseBody
    public String myHello(Model model){
        System.out.println("666666666");
        return "heloo";
    }

    @GetMapping("/myModel")
    public String myModel(Model model){
        model.addAttribute("2183402318490");
        return "777";
    }

}
