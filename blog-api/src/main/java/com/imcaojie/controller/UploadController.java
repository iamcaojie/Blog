package com.imcaojie.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author caojie
 * @className UploadController
 * @description
 **/
public class UploadController extends BaseController {

    public Object upload(
            @RequestParam("type") String type,
            MultipartFile file,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse
    ){
        String originalFilename = file.getOriginalFilename();

        return null;
    }
}
