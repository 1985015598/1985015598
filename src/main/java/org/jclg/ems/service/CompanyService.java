package org.jclg.ems.service;

import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.Company;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 钟祥
 * @since 2022-03-08
 */
public interface CompanyService extends IService<Company> {

    R getalllimt(String pagenum, String pagesize, String query);

    R add(Company info);

    R getCominfo(String id);
}
