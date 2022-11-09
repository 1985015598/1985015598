package org.jclg.ems.controller;


import org.jclg.ems.bean.Company;
import org.jclg.ems.bean.Joboffer;
import org.jclg.ems.service.JobofferService;
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
@RequestMapping("/joboffer")
public class JobofferController {
    @Autowired
    JobofferService service;

    @RequestMapping("/getall")
    public Object getall(String pagenum,String pagesize,String query){ return service.getall(pagenum,pagesize,query);}
    @RequestMapping("/getalllimt")

    public Object getalllimt(String comid,String pagenum,String pagesize,String query){ return service.getalllimt(comid,pagenum,pagesize,query);}

    @RequestMapping("/deletebyid")
    public Object deleteById(String id){
        return service.removeById(id);
    }

    @RequestMapping("/update")
    public Object update(Joboffer info){
        return service.updateById(info);
    }

    @RequestMapping("/getbyid")
    public Object get(String id){  return service.getById(id);}

    @RequestMapping("/add")
    public Object insert(Joboffer info){
        return service.add(info);
    }
}

