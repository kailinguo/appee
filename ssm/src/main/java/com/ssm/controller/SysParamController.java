package com.ssm.controller;

import com.ssm.service.SysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by KaiLin.Guo on 2018-03-20.
 */
@Controller
@RequestMapping("/ssm/sysParam")
public class SysParamController {
    @Autowired
    private SysParamService sysParamService;

    @ResponseBody
    @RequestMapping(value = "/edit")
    public String edit(Integer paramKey, Integer paramValue) {
        sysParamService.edit(paramKey, paramValue);
        return "success";
    }

}
