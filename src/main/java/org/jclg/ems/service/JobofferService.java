package org.jclg.ems.service;

import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.Joboffer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 钟祥
 * @since 2022-03-08
 */
public interface JobofferService extends IService<Joboffer> {

    R getalllimt(String comid, String pagenum, String pagesize, String query);

    R add(Joboffer info);

    R getall(String pagenum, String pagesize, String query);
}
