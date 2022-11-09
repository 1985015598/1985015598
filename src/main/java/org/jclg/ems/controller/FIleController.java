package org.jclg.ems.controller;

import org.jclg.ems.Ret.R;
import org.jclg.ems.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/oss")
public class FIleController {
    @Autowired
    private FileService service;
    @Autowired
    private R r;

    @RequestMapping("uploadFile")
    public R uploadFile(MultipartFile file){
        String url =service.uploadFileOss(file);
        r.setData(url);
        return r;
    }


}
