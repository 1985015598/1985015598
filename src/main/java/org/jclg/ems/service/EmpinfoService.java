package org.jclg.ems.service;

import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.Empinfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 钟祥
 * @since 2022-03-08
 */
public interface EmpinfoService extends IService<Empinfo> {

    R add(Empinfo info);
}
