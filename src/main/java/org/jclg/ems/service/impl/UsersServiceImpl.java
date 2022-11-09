package org.jclg.ems.service.impl;

import org.apache.catalina.User;
import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.Permission;
import org.jclg.ems.bean.PermissonNew;
import org.jclg.ems.bean.Users;
import org.jclg.ems.mapper.MetaMapper;
import org.jclg.ems.mapper.PermissionMapper;
import org.jclg.ems.mapper.PermissonNewMapper;
import org.jclg.ems.mapper.UsersMapper;
import org.jclg.ems.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 钟祥
 * @since 2022-03-08
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {
    @Autowired
    UsersMapper mapper;

    @Autowired
    MetaMapper metamapper;

    @Autowired
    PermissonNewMapper Permissonmapper;

    @Autowired
    R r;

    static  Users users1=new Users() ;

    @Override
    public R login(String account, String password) {
        R r =new R();
        Users users;
        users = mapper.findAccount(account);
        if (users == null) {
            r.setCode(200);
            r.setMessage("账号不存在，请先注册或检查您的账号");
            return r;
        } else if (users.getPassword().equals(password)) {
            Map map = new HashMap();
            map.put("token",account);
            r.setData(map);
            r.setCode(200);
            r.setMessage("登录成功");
        } else {
            r.setCode(200);
            r.setMessage("登录失败，请检查您输入的账号和密码");
        }
//                r.setData(o);
//                r.setCode(200);
//                r.setMessage("登录成功");
        return r;
    }

    @Override
    public R add(Users info) {
        R r= new R();
        r.setCode(200);
        Users users = mapper.findAccount(info.getAccount());
        if (users == null) {
            r.setData(mapper.insert(info));
            r.setMessage("添加成功");
            r.setCode(200);
            users1.setAccount(info.getAccount());
        } else {
            r.setCode(404);
            r.setMessage("已存在该用户");
            r.setData("error");
        }

        return r;
    }

    @Override
    public R addimg(MultipartFile file, HttpServletRequest req) {
        R r= new R();
        r.setCode(200);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat time = new SimpleDateFormat("HHmmss");
        String originNmae = file.getOriginalFilename();
        if (!(originNmae.endsWith(".png") || originNmae.endsWith(".jpg")||originNmae.endsWith(".JPG") || originNmae.endsWith(".PNG"))) {
            r.setMessage("文件类型不对");
            r.setCode(404);
            return r;
        }
        String format = sdf.format(new Date());
        String format2 = time.format(new Date());
        String realPath = "D:\\百度网盘下载文件\\we_are_youth_From昔冰_G\\vue_shop\\src\\assets\\image";
        File folder = new File(realPath);
        String split = originNmae.substring(originNmae.length()-4);
        String newName = format+format2+split.toLowerCase();
            try {
                file.transferTo(new File(folder,newName));
                r.setMessage("上传成功");
                r.setCode(200);
                r.setData(newName);
                Users newuser = mapper.findAccount(users1.getAccount());
                newuser.setImg(newName);
                mapper.updateById(newuser);
                users1=new Users();
            }catch (Exception e){
                r.setMessage("上传失败");
                r.setCode(404);
            }
        return r;
    }
    @Override
    public R getUser (String account){
        R r= new R();
        r.setCode(200);
        r.setData(mapper.findAccount(account));
        return r;
    }

    @Override
    public R getqx(String account) {
        R r= new R();
        List<Permission> getqx = mapper.getqx(account);
//        if(getqx.getRemark()!=null){
//            String[] split = getqx.getRemark().split(",");
//        }

        List list2 = new ArrayList();
        for (Permission p:getqx) {
            List<Map> list =new ArrayList<>();
             String[] split = p.getRemark().split(",");
             for(int i=0;i<split.length;i++){
                 Map map = new  HashMap();
                 map.put("id",i);
                 map.put("erji",split[i]);
                list.add(map);
             }
            Map map = new  HashMap();
             map.put("id",p.getId());
             map.put("permission",p.getPermission());
             map.put("children",list);
            list2.add(map);
        }
        System.out.println(list2);
        r.setData(list2);

        return r;
    }

    @Override
    public R getalllimt(String pagenum, String pagesize,String query) {
        R r= new R();
        Integer num= null;
        num = num.parseInt(pagenum);
        Integer size=null;
        size= size.parseInt(pagesize);
        List<Map<String,String>> list = mapper.getalllimts((num - 1) * size, size, query);
        Map map = new HashMap();
        map.put("info",list);
        int getcount = mapper.getcount(query);
//        int a=getcount%size;
//        getcount=getcount/size;
//        if(a>0)getcount++;
        map.put("total",getcount);
        map.put("pagenum",num);
        r.setData(map);
        r.setCode(200);
        return r;
    }

    @Override
    public R getMenus(String token) {
//        List<PermissonNew> list = Permissonmapper

        return null;
    }

    @Override
    public Object logout() {
        r.setCode(200);
        return r;
    }


}
