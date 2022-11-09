package org.jclg.ems.controller;


import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.Business;
import org.jclg.ems.bean.Company;
import org.jclg.ems.bean.Empinfo;
import org.jclg.ems.service.BusinessService;
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
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    BusinessService service;


    @RequestMapping("/getbyid")
    public Object get(String id){
        if(id==null||id.equals("")){
            R r = new R();
            r.setCode(200);
            r.setMessage("暂无详情");
            return r;
        }
        return service.getById(id);
    }
    @RequestMapping("/update")
    public Object update(Business info){
        return service.updateById(info);
    }

    @RequestMapping("/add")
    public Object add(Business info){
        return service.add(info);
    }
}

