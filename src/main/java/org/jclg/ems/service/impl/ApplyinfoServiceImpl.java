package org.jclg.ems.service.impl;

import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.Applyinfo;
import org.jclg.ems.mapper.ApplyinfoMapper;
import org.jclg.ems.service.ApplyinfoService;
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
 * @since 2022-05-02
 */
@Service
public class ApplyinfoServiceImpl extends ServiceImpl<ApplyinfoMapper, Applyinfo> implements ApplyinfoService {

    @Autowired
    ApplyinfoMapper mapper;
    @Override
    public R add(Applyinfo info) {
        R r =new R();
        r.setData(mapper.insert(info));
        r.setCode(200);
        r.setMessage("发送成功！");
        return r;
    }

    @Override
    public R getalllimt(String userid,String pagenum, String pagesize, String query) {
        R r= new R();
        Integer num= null;
        num = num.parseInt(pagenum);
        Integer size=null;
        size= size.parseInt(pagesize);
        List<Map<String,String>> list = mapper.getalllimts(userid,(num - 1) * size, size, query);
        for (Map<String, String> l : list) {
            if(l.get("sta").equals("0")){
                l.put("sta1","未接收简历");
            }
            if(l.get("sta").equals("1")){
                l.put("sta1","已接收简历");
            }
            if(l.get("sta").equals("2")){
                l.put("sta1","发送录用邀请");
            }
            if(l.get("sta").equals("3")){
                l.put("sta1","已拒绝该学生");
            }
            if(l.get("sta").equals("4")){
                l.put("sta1","学生拒绝offer");
            }
            if(l.get("sta").equals("5")){
                l.put("sta1","学生接收offer");
            }
        }
        Map map = new HashMap();
        map.put("info",list);
        int getcount = mapper.getcount(userid,query);
        map.put("total",getcount);
        map.put("pagenum",num);
        r.setData(map);
        r.setCode(200);
        return r;
    }

    @Override
    public R jieshou(String sta) {
        R r= new R();
        r.setCode(200);
        r.setMessage("已发送offer");
        mapper.jieshou(sta);

        return r;
    }

    @Override
    public R jujue(String sta) {
        R r= new R();
        r.setCode(200);
        r.setMessage("已拒绝该学生");
        mapper.jujue(sta);
        return r;
    }

    @Override
    public R ckjl(String sta) {
        R r= new R();
        r.setCode(200);
        r.setMessage("已接收文件");
        Applyinfo applyinfo = mapper.selectById(sta);
        Integer num = null;
        num = num.parseInt(applyinfo.getSta());
        if(num<1)
        mapper.ckjl(sta);
        return r;
    }

    @Override
    public R getallbyst(String userid, String pagenum, String pagesize, String query) {
        R r= new R();
        Integer num= null;
        num = num.parseInt(pagenum);
        Integer size=null;
        size= size.parseInt(pagesize);
        List<Map<String,String>> list = mapper.getallbyst(userid,(num - 1) * size, size, query);
        for (Map<String, String> l : list) {
            if(l.get("sta").equals("0")){
                l.put("sta1","未发送简历");
            }
            if(l.get("sta").equals("1")){
                l.put("sta1","hr已查看简历");
            }
            if(l.get("sta").equals("2")){
                l.put("sta1","hr向你发出offer");
            }
            if(l.get("sta").equals("3")){
                l.put("sta1","hr拒绝了你");
            }
            if(l.get("sta").equals("4")){
                l.put("sta1","你已拒绝该offer");
            }
            if(l.get("sta").equals("5")){
                l.put("sta1","你已接收该offer");
            }
        }
        Map map = new HashMap();
        map.put("info",list);
        int getcount = mapper.getcountbyst(userid,query);
        map.put("total",getcount);
        map.put("pagenum",num);
        r.setData(map);
        r.setCode(200);
        return r;
    }

    @Override
    public R stjieshou(String sta) {
        R r= new R();
        r.setCode(200);
        r.setMessage("已接收该offer");
        mapper.stjieshou(sta);
        return r;
    }

    @Override
    public R stjujue(String sta) {
        R r= new R();
        r.setCode(200);
        r.setMessage("已拒绝该offer");
        mapper.stjujue(sta);
        return r;
    }
}

