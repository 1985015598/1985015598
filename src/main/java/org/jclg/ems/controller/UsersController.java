package org.jclg.ems.controller;

import com.sun.deploy.security.MSCryptoDSASignature;
import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.Users;
import org.jclg.ems.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 钟祥
 * @since 2022-03-08
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService service;
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
    public Object insert(Users info){return service.add(info);}
    @RequestMapping("/login")
    public Object login(Users info){
        return service.login(info.getAccount(),info.getPassword());
    }

    @RequestMapping("/addimg")
    public Object insert(MultipartFile file, HttpServletRequest req){return service.addimg(file,req);}
    @RequestMapping("/getuser")
    public Object getUser(String token){ return service.getUser(token);}

    @RequestMapping("/getqx")
    public Object getqx(String account){ return service.getqx(account);}

    @RequestMapping("/getalllimt")
    public Object getalllimt(String pagenum,String pagesize,String query){ return service.getalllimt(pagenum,pagesize,query);}

    @RequestMapping("/update")
    public Object update(Users info){
        return service.updateById(info);
    }

    @RequestMapping("/getmenu")
    public Object getMenus(String token){ return null;}

    @RequestMapping("/logout")
    public Object logout(){ return service.logout();}
}

