package org.jclg.ems.controller;


import org.jclg.ems.bean.Company;
import org.jclg.ems.bean.Staff;
import org.jclg.ems.bean.Users;
import org.jclg.ems.service.StaffService;
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
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    StaffService service;
    @RequestMapping("/getbystore")
    public Object getinfo(String store){  return service.getByStore(store);}

    @RequestMapping("/getbyid")
    public Object get(String id){  return service.getById(id);}

    @RequestMapping("/update")
    public Object update(Staff info){
        return service.updateById(info);
    }

    @RequestMapping("/getcom")
    public Object getUser(String token){ return service.getCom(token);}

    @RequestMapping("/addfp")
    public Object insert(Staff info){
        return service.add(info);
    }
}

