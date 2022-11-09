package org.jclg.ems.controller;


import org.jclg.ems.bean.College;
import org.jclg.ems.service.CollegeService;
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
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    CollegeService service;

    @RequestMapping("/getall")
    public Object getAll(){ return service.list(); }

}

