package com.boot.web.controller;

import com.boot.web.entity.JsonPTo;
import com.boot.web.service.JsonPService;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by KaiLin.Guo on 2017-10-13.
 * use jsonp cross
 */
@RestController
@RequestMapping("/boot/web")
public class JsonPController {

    @Autowired
    private JsonPService jsonPService;

    @ApiOperation(value="for ajax jsonp cross",notes="callback")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testJonp(String callback) {
        List<JsonPTo> list = jsonPService.testJsonp();
        JSONArray jsonArray = JSONArray.fromObject(list);
        String result = jsonArray.toString();
        if (callback != null) {
            result = callback + "(" + result + ")";
        }

        return result;
    }

}
