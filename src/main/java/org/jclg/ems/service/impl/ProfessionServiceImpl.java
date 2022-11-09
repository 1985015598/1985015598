package org.jclg.ems.service.impl;

import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.Profession;
import org.jclg.ems.mapper.ProfessionMapper;
import org.jclg.ems.service.ProfessionService;
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
public class ProfessionServiceImpl extends ServiceImpl<ProfessionMapper, Profession> implements ProfessionService {
    @Autowired
    ProfessionMapper mapper;
    @Override
    public R getbycollege(String college) {
        R r = new R();
        r.setCode(200);
        r.setData(mapper.getbycollege(college));
        return r;
    }
}
