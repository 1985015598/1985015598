package org.jclg.ems.controller;


import org.jclg.ems.bean.Comapplication;
import org.jclg.ems.bean.Company;
import org.jclg.ems.service.ComapplicationService;
import org.jclg.ems.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 钟祥
 * @since 2022-03-08
 */
@RestController
@RequestMapping("/comapplication")
public class ComapplicationController {
    @Autowired
    ComapplicationService service;

    @RequestMapping("/add")
    public Object insert(Comapplication info){
        return service.save(info);
    }

    @RequestMapping("/getcountbysta")
    public Object getcountbysta(){
        return service.getcountbysta();
    }
    @RequestMapping("/getall")
    public Object get(){
        return service.getallbysta();
    }
    @RequestMapping("/tycom")
    public Object tycom(String applicant) {
        return service.tycom(applicant);
    }

    @RequestMapping("/jjcom")
    public Object jjcom(String applicant) {
        return service.jjcom(applicant);
    }

}

