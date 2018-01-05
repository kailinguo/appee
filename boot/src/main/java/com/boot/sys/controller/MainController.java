package com.boot.sys.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by KaiLin.Guo on 2017-10-13.
 */
@RestController
@RequestMapping("/boot/sys")
public class MainController {

    @ApiOperation(value="main controller",notes="index")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "hello";
    }

}
