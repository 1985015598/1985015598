package org.jclg.ems.service.impl;

import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.Empinfo;
import org.jclg.ems.mapper.EmpinfoMapper;
import org.jclg.ems.service.EmpinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 钟祥
 * @since 2022-03-08
 */
@Service
public class EmpinfoServiceImpl extends ServiceImpl<EmpinfoMapper, Empinfo> implements EmpinfoService {
    @Autowired
    EmpinfoMapper mapper;
    @Override
    public R add(Empinfo info) {
        R r = new R();
        r.setCode(200);
        mapper.insert(info);
        r.setData(mapper.getMax());
        return r;
    }
}
