package org.jclg.ems.service.impl;

import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.Company;
import org.jclg.ems.mapper.CompanyMapper;
import org.jclg.ems.service.CompanyService;
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
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

    @Autowired
    R r;
    @Autowired
    CompanyMapper mapper;


    @Override
    public R getalllimt(String pagenum, String pagesize, String query) {
        R r= new R();
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
    public R add(Company info) {
        R r= new R();
        r.setData( mapper.insert(info));
        r.setCode(200);
        r.setMessage("添加成功");
        return r;
    }

    @Override
    public R getCominfo(String id) {
        R r= new R();
        r.setData( mapper.getCominfo(id));
        r.setCode(200);
        r.setMessage("查询成功");
        return r;
    }
}
