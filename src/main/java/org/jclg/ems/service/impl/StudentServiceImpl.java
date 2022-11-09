package org.jclg.ems.service.impl;

import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.Student;
import org.jclg.ems.mapper.StudentMapper;
import org.jclg.ems.mapper.UsersMapper;
import org.jclg.ems.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 钟祥
 * @since 2022-03-08
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Autowired
    StudentMapper mapper;

    @Override
    public R getInfo(String userid) {
        R r = new R();
        r.setCode(200);
        r.setData(mapper.getInfo(userid));
        return r;
    }

    @Override
    public R getalllimt(String pagenum, String pagesize, String query) {
        R r=new R();
        Integer num= null;
        num = num.parseInt(pagenum);
        Integer size=null;
        size= size.parseInt(pagesize);
        List<Map<String,String>> list = mapper.getalllimts((num - 1) * size, size, query);
        Map map = new HashMap();
        map.put("info",list);
        int getcount = mapper.getcount(query);
        map.put("total",getcount);
        map.put("pagenum",num);
        r.setData(map);
        r.setCode(200);
        return r;
    }

    @Override
    public R getalllimtbyxy(String pagenum, String pagesize, String college) {
        R r=new R();
        Integer num= null;
        num = num.parseInt(pagenum);
        Integer size=null;
        size= size.parseInt(pagesize);
        List<Map<String,String>> list = mapper.getalllimtbyxy((num - 1) * size, size, college);
        Map map = new HashMap();
        map.put("info",list);
        int getcount = mapper.getcountbyxy(college);
        map.put("total",getcount);
        map.put("pagenum",num);
        r.setData(map);
        r.setCode(200);
        return r;
    }

    @Override
    public R getByUserid(String userid) {
        R r=new R();
        r.setCode(200);
        r.setData(mapper.getByuserid(userid));
        return r;
    }

    @Override
    public R getinfodata() {
        R r=new R();
        r.setCode(200);
        Map map = new HashMap();
        int studentCount = mapper.getStudentCount();
        int comCount = mapper.getComCount();
        int getgz = mapper.getgz();
        int getgw = mapper.getgw();
        map.put("studentCount",studentCount);
        map.put("comCount",comCount);
        map.put("getgz",getgz);
        map.put("getgw",getgw);
        r.setData(map);
        return r;
    }

    @Override
    public R getbyjy(String pagenum, String pagesize, String query) {
        R r=new R();
        Integer num= null;
        num = num.parseInt(pagenum);
        Integer size=null;
        size= size.parseInt(pagesize);
        List<Map<String,String>> list = mapper.getbyjy((num - 1) * size, size, query);
        Map map = new HashMap();
        map.put("info",list);
        int getcount = mapper.getcount(query);
        map.put("total",getcount);
        map.put("pagenum",num);
        r.setData(map);
        r.setCode(200);
        return r;
    }

    @Override
    public R getsex() {
        R r=new R();
        r.setCode(200);
        Map map = new HashMap();
        int nan=mapper.getnan();
        int nv=mapper.getnv();
        map.put("nan",nan);
        map.put("nv",nv);
        map.put("count",nan+nv);
        r.setData(map);
        return r;
    }

    @Override
    public R getjy() {
        R r=new R();
        r.setCode(200);
        Map map = new HashMap();
        int gz=mapper.getgz();
        int count=mapper.getStudentCount();
        int wgz=count-gz;
        map.put("gz",gz);
        map.put("wgz",wgz);
        map.put("count",count);
        r.setData(map);
        return r;
    }
}
