package com.ssm.controller;

import com.ssm.common.pdf.FlyingSaucerPdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Date;

/**
 * Created by KaiLin.Guo on 2018-05-10.
 */
@Controller
@RequestMapping("/ssm/pdf")
public class PdfController {

    @Autowired
    private FlyingSaucerPdf flyingSaucerPdf;

    @RequestMapping(value = "/down")
    public void downPdf(HttpServletResponse response) {
        try {
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;filename="
                    + new String("deal confirmation".getBytes("GBK"), "ISO8859-1") + "[" + new Date() + "].pdf");
            OutputStream os = response.getOutputStream();
            String html = flyingSaucerPdf.getPdfContent();
            html = String.format(html, "成交了", 200);
            flyingSaucerPdf.generate(html, "", os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
