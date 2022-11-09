package org.jclg.ems.service.impl;

import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.Comapplication;
import org.jclg.ems.mapper.ComapplicationMapper;
import org.jclg.ems.service.ComapplicationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ComapplicationServiceImpl extends ServiceImpl<ComapplicationMapper, Comapplication> implements ComapplicationService {

    @Autowired
    ComapplicationMapper mapper;
    @Override
    public R getcountbysta() {
        R r= new R();
        r.setData(mapper.getcountbysta() );
        r.setCode(200);
        return r;
    }

    @Override
    public R getallbysta() {
        R r= new R();
        r.setCode(200);
        List<Map<String,String>> list = mapper.getallbysta();
        for (Map<String, String> l : list) {
            if(l.get("sta").equals("0")){
                l.put("sta1","未处理");
            }
            if(l.get("sta").equals("1")){
                l.put("sta1","已驳回申请");
            }
            if(l.get("sta").equals("2")){
                l.put("sta1","已同意申请");
            }
        }
        r.setData(list);
        return r;
    }

    @Override
    public R tycom(String applicant) {
        R r= new R();
        r.setCode(200);
        r.setMessage("已同意该申请");
        mapper.tycom(applicant);
        return r;
    }

    @Override
    public R jjcom(String applicant) {
        R r= new R();
        r.setCode(200);
        r.setMessage("已拒绝该申请");
        mapper.jjcom(applicant);
        return r;
    }
}
