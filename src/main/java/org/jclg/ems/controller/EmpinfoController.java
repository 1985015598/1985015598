package org.jclg.ems.controller;


import org.jclg.ems.bean.Empinfo;
import org.jclg.ems.bean.Users;
import org.jclg.ems.service.EmpinfoService;
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
@RequestMapping("/empinfo")
public class EmpinfoController {
    @Autowired
    EmpinfoService service;

    @RequestMapping("/getbyid")
    public Object get(String id){ return service.getById(id);}

    @RequestMapping("/update")
    public Object update(Empinfo info){
        return service.updateById(info);
    }

    @RequestMapping("/add")
    public Object add(Empinfo info){
        return service.add(info);
    }

}

