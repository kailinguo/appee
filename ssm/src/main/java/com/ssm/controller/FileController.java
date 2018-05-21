package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * Created by kailin.guo on 2018-05-21.
 */
@Controller
@RequestMapping("/ssm/file")
public class FileController {

    @RequestMapping(value = "/upload")
    public void uploadFile(HttpServletRequest request,
                           @RequestParam("file") CommonsMultipartFile files[]){

        ServletContext servletContext = request.getServletContext();
        //获取服务器下的upload目录
        String realPath = servletContext.getRealPath("/WEB-INF/upload");
        File filePath = new File(realPath);
        //如果目录不存在，则创建该目录
        if (!filePath.exists()) {
             filePath.mkdir();
         }
        if (files.length < 1) {
            System.out.println("未获取到文件或文件列表为空");
            return;
        }

        try {
            for (CommonsMultipartFile item : files) {
                //得到上传的文件名称，
                String filename = item.getOriginalFilename();
                System.out.println(filename);
                if (filename == null || filename.trim().equals("")) {
                    continue;
                }
                //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                filename = filename.substring(filename.lastIndexOf("\\") + 1);
                //得到上传文件的扩展名
                String fileExtName = filename.substring(filename.lastIndexOf(".") + 1);
                //如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
                System.out.println("上传的文件的扩展名是：" + fileExtName);
                //获取item中的上传文件的输入流
                InputStream in = item.getInputStream();
                //得到文件保存的名称
                String saveFilename = makeFileName(filename);
                //得到文件的保存目录
                String realSavePath = makePath(saveFilename, realPath);
                //创建一个文件输出流
                FileOutputStream out = new FileOutputStream(realSavePath + "\\" + saveFilename);
                //创建一个缓冲区
                byte buffer[] = new byte[1024];
                //判断输入流中的数据是否已经读完的标识
                int len = 0;
                //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                while ((len = in.read(buffer)) > 0) {
                    //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                    out.write(buffer, 0, len);
                }
                //关闭输入流
                in.close();
                //关闭输出流
                out.close();
                //删除处理文件上传时生成的临时文件
                //item.delete();
                System.out.println("文件上传成功！");
            }
        } catch (IOException e) {
            System.out.println("文件上传失败！！！");
        }

    }

    @RequestMapping(value = "/download")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam("fileName") String fileName) throws Exception {
        //得到要下载的文件名 23kok9283-92489-阿凡达.avi
        //上传的文件都是保存在/WEB-INF/upload目录下的子目录当中
        String fileSaveRootPath = request.getServletContext().getRealPath("/WEB-INF/upload");
        //通过文件名找出文件的所在目录
        String path = makePath(fileName, fileSaveRootPath);
        //得到要下载的文件
        File file = new File(path + "\\" + fileName);
        //如果文件不存在
        if(!file.exists()){
            System.out.println("您要下载的资源已被删除！！");
            return;
         }
        //处理文件名
        String realname = fileName.substring(fileName.indexOf("_") + 1);
        //设置响应头，控制浏览器下载该文件
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
        //读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(path + "\\" + fileName);
        //创建输出流
        OutputStream out = response.getOutputStream();
        //创建缓冲区
        byte buffer[] = new byte[1024];
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while((len=in.read(buffer))>0){
            //输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
         }
        //关闭文件输入流
        in.close();
        //关闭输出流
        out.close();

    }

    private String makeFileName(String filename){
        //为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
        return UUID.randomUUID().toString() + "_" + filename;
    }

    private String makePath(String filename, String savePath) {
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf; // 0--15
        int dir2 = (hashcode&0xf0)>>4; // 0-15
        String dir = savePath + "\\" + dir1 + "\\" + dir2;
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
        return dir;
    }
}
