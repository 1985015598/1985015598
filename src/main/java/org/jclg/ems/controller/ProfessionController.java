package org.jclg.ems.controller;


import org.jclg.ems.bean.Permission;
import org.jclg.ems.bean.Profession;
import org.jclg.ems.service.ProfessionService;
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
@RequestMapping("/profession")
public class ProfessionController {
    @Autowired
    ProfessionService service;
    //查询所有
    @RequestMapping("/getall")
    public Object getAllProfession(){
        return service.list();
    }
    //根据id查找
    @RequestMapping("/getbyid")
    public Object getProffession(String id){  return service.getById(id);}

    //根据id删除
    @RequestMapping("/deletebyid")
    public Object deleteByIdProfession(String id){
        return service.removeById(id);
    }

    //添加
    @RequestMapping("/add")
    public Object insertProfession(Profession info){return service.saveOrUpdate(info);}

    @RequestMapping("/getbycollege")
    public Object getbycollege(String college){
        return service.getbycollege(college);
    }

}

