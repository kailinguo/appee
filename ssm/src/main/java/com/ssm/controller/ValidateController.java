package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by KaiLin.Guo on 2017-12-29.
 */
@Controller
@RequestMapping("/validate")
public class ValidateController {

    @RequestMapping(value = "/code")
    public void validateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        generator vCode = new generator(100,30,4,100);
        HttpSession session = request.getSession();
        session.setAttribute("validateCode", vCode.getCode());
        vCode.write(response.getOutputStream());
    }
}
