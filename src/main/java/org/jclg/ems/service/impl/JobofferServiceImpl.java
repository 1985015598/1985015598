package org.jclg.ems.service.impl;

import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.Company;
import org.jclg.ems.bean.Joboffer;
import org.jclg.ems.mapper.JobofferMapper;
import org.jclg.ems.service.JobofferService;
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
public class JobofferServiceImpl extends ServiceImpl<JobofferMapper, Joboffer> implements JobofferService {
    @Autowired
    JobofferMapper mapper;
    @Autowired
    R r;

    @Override
    public R getalllimt(String comid,String pagenum, String pagesize, String query) {
        R r= new R();
        Integer num= null;
        num = num.parseInt(pagenum);
        Integer size=null;
        size= size.parseInt(pagesize);
//        Integer comid1=null;
//        comid1=comid1.parseInt(comid);
        List<Map<String,String>> list = mapper.getalllimts(comid,(num - 1) * size, size, query);
        Map map = new HashMap();
        map.put("info",list);
        int getcount = mapper.getcount(comid,query);
        map.put("total",getcount);
        map.put("pagenum",num);
        r.setData(map);
        r.setCode(200);
        return r;
    }
    public R add(Joboffer info) {
        R r= new R();
        r.setData( mapper.insert(info));
        r.setCode(200);
        r.setMessage("添加成功");
        return r;
    }

    @Override
    public R getall(String pagenum, String pagesize, String query) {
        R r= new R();
        Integer num= null;
        num = num.parseInt(pagenum);
        Integer size=null;
        size= size.parseInt(pagesize);
        List<Map<String,String>> list = mapper.getall((num - 1) * size, size, query);
        Map map = new HashMap();
        map.put("info",list);
        int getcount = mapper.getcount1(query);
        map.put("total",getcount);
        map.put("pagenum",num);
        r.setData(map);
        r.setCode(200);
        return r;
    }
}
