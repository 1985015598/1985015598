package org.jclg.ems.controller;


import org.jclg.ems.bean.Role;
import org.jclg.ems.bean.Users;
import org.jclg.ems.service.RoleService;
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
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService service;
    //查询所有
    @RequestMapping("/getall")
    public Object getAll(){ return service.list(); }
    //根据id查找
    @RequestMapping("/getbyid")
    public Object get(String id){  return service.getById(id);}
    //根据id删除
    @RequestMapping("/deletebyid")
    public Object deleteById(String id){
        return service.removeById(id);
    }
    //添加
    @RequestMapping("/add")
    public Object insert(Role info){return service.saveOrUpdate(info);}

}

