package org.jclg.ems.controller;


import org.jclg.ems.service.DreposService;
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
@RequestMapping("/drepos")
public class DreposController {
    @Autowired
    DreposService service;

    @RequestMapping("/getbyid")
    public Object get(String id){ return service.getById(id);}

}

