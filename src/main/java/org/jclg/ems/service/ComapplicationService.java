package org.jclg.ems.service;

import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.Comapplication;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 钟祥
 * @since 2022-03-08
 */
public interface ComapplicationService extends IService<Comapplication> {

    R getcountbysta();

    R getallbysta();

    R tycom(String applicant);

    R jjcom(String applicant);
}
