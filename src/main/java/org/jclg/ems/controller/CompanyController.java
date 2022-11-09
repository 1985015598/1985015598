package org.jclg.ems.controller;


import org.jclg.ems.bean.Company;
import org.jclg.ems.bean.Role;
import org.jclg.ems.bean.Users;
import org.jclg.ems.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 钟祥
 * @since 2022-03-08
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyService service;


    @RequestMapping("/getalllimt")
    public Object getalllimt(String pagenum,String pagesize,String query){ return service.getalllimt(pagenum,pagesize,query);}

    @RequestMapping("/deletebyid")
    public Object deleteById(String id){
        return service.removeById(id);
    }

    @RequestMapping("/update")
    public Object update(Company info){
        return service.updateById(info);
    }

    @RequestMapping("/getbyid")
    public Object get(String id){  return service.getById(id);}

    @RequestMapping("/add")
    public Object insert(Company info){
        return service.add(info);
    }

    @RequestMapping("/cominfo")
    public Object getComfnfo(String  id){
        return service.getCominfo(id);
    }

}

