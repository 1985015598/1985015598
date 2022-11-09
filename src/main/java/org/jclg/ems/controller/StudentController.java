package org.jclg.ems.controller;


import org.jclg.ems.bean.Student;
import org.jclg.ems.service.StudentService;
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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService service;
    @RequestMapping("/getinfo")
    public Object getStudentInfo(String userid){
     return   service.getInfo(userid);
    }
    @RequestMapping("/getalllimt")
    public Object getalllimt(String pagenum,String pagesize,String query){ return service.getalllimt(pagenum,pagesize,query);}

    @RequestMapping("/getalllimtbyxy")
    public Object getalllimtbyxy(String pagenum,String pagesize,String college){ return service.getalllimtbyxy(pagenum,pagesize,college);}

    @RequestMapping("/getbyid")
    public Object get(String id){
        return service.getById(id);
    }

    @RequestMapping("/getbyuserid")
    public Object getByuserid(String userid){
        return service.getByUserid(userid);
    }

    @RequestMapping("/add")
    public Object add(Student info){
        return service.save(info);
    }

    @RequestMapping("/getinfodata")
    public Object getinfodata(){
        return service.getinfodata();
    }
    @RequestMapping("update")
    public Object update(Student info){
        return service.updateById(info);
    }
    @RequestMapping("delete")
    public Object delete(String id){
        return service.removeById(id);
    }
    @RequestMapping("getbyjy")
    public Object getbyjy(String pagenum,String pagesize,String query){
        return service.getbyjy(pagenum,pagesize,query);
    }
    @RequestMapping("getsex")
    public Object getsex(){
        return service.getsex();
    }
    @RequestMapping("getjy")
    public Object getjy(){
        return service.getjy();
    }
}

