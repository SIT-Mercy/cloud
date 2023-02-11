package com.gallifrey.mercyhouse.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@RestController
public class FileUploadController {
    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public String upload(String nickname, MultipartFile photo, HttpServletRequest request)throws IOException{
        System.out.println(photo.getOriginalFilename());
        System.out.println(photo.getContentType());

        String path=request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        SaveFile(photo,path);
        return "200OK";
        }

    public void SaveFile(MultipartFile photo,String path) throws IOException{
        File dir=new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }
        File file=new File(path+photo.getOriginalFilename());
        photo.transferTo(file);
    }

}
