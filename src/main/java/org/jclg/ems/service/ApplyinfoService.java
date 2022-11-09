package org.jclg.ems.service;

import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.Applyinfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 钟祥
 * @since 2022-05-02
 */
public interface ApplyinfoService extends IService<Applyinfo> {

    R add(Applyinfo info);

    R getalllimt(String userid,String pagenum, String pagesize, String query);

    R jieshou(String sta);

    R jujue(String sta);

    R ckjl(String sta);

    R getallbyst(String userid, String pagenum, String pagesize, String query);

    R stjieshou(String id);

    R stjujue(String id);
}
