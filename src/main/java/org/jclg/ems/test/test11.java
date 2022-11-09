package org.jclg.ems.test;

import org.jclg.ems.bean.Profession;
import org.jclg.ems.dao.ProfessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.PrimitiveIterator;
@RestController
public class test11 {
    @Autowired
     public ProfessionDao dao;
    @RequestMapping("/hello")
    public Object hello(){
        return  "hello";
    }
    @RequestMapping("/hello2")
    public Object hello2(){
        List<Profession> professions = dao.selectList(null);
        return  professions;
    }


}
