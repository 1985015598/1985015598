package org.jclg.ems.controller;


import org.jclg.ems.bean.Applyinfo;
import org.jclg.ems.bean.Company;
import org.jclg.ems.service.ApplyinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 钟祥
 * @since 2022-05-02
 */
@RestController
@RequestMapping("/applyinfo")
public class ApplyinfoController {
    @Autowired
    ApplyinfoService service;

    @RequestMapping("/add")
    public Object insert(Applyinfo info) {
        return service.add(info);
    }

    @RequestMapping("/getalllimt")
    public Object getalllimt(String userid, String pagenum, String pagesize, String query) {
        return service.getalllimt(userid, pagenum, pagesize, query);
    }

    @RequestMapping("/getallbyst")
    public Object getallbyst(String userid, String pagenum, String pagesize, String query) {
        return service.getallbyst(userid, pagenum, pagesize, query);
    }

    @RequestMapping("/stjieshou")
    public Object stjieshou(String id) {
        return service.stjieshou(id);
    }

    @RequestMapping("stjujue")
    public Object stjujue(String id) {
        return service.stjujue(id);
    }

    @RequestMapping("/jieshou")
    public Object jieshou(String id) {
        return service.jieshou(id);
    }

    @RequestMapping("/jujue")
    public Object jujue(String id) {
        return service.jujue(id);
    }

    @RequestMapping("/ckjl")
    public Object ckjl(String id) {
        return service.ckjl(id);
    }
}

