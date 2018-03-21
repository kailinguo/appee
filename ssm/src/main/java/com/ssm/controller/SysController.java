package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by KaiLin.Guo on 2018-03-20.
 */
@Controller
@RequestMapping("/ssm/sys")
public class SysController {

    @RequestMapping(value = "/home")
    public String home() {
        return "index";
    }

}
