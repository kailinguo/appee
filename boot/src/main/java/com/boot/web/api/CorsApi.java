package com.boot.web.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by KaiLin.Guo on 2017-10-13.
 * use filter cross
 */
@RestController
@RequestMapping("/boot/api")
public class CorsApi {

    @ApiOperation(value="for ajax cros cross",notes="api")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String index() {
        return "use cros cross";
    }

}
