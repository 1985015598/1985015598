package org.jclg.ems.service.impl;

import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.Staff;
import org.jclg.ems.mapper.StaffMapper;
import org.jclg.ems.service.StaffService;
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
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService {
    @Autowired
    StaffMapper mapper;
    @Override
    public R getByStore(String store) {
        R r = new R();
        r.setData(mapper.getByStore(store));
        r.setCode(200);
        return r;
    }

    @Override
    public R getCom(String token) {
        R r = new R();
        r.setData(mapper.getcom(token));
        r.setCode(200);
        return r;
    }

    @Override
    public R add(Staff info) {
        R r = new R();
        r.setData( mapper.insert(info));
        r.setCode(200);
        r.setMessage("添加成功");
        return r;
    }
}
