package org.jclg.ems.service;

import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 钟祥
 * @since 2022-03-08
 */
public interface StudentService extends IService<Student> {
    public R getInfo(String userid);

    R getalllimt(String pagenum, String pagesize, String query);

    R getalllimtbyxy(String pagenum, String pagesize, String college);

    R getByUserid(String userid);

    R getinfodata();

    R getbyjy(String pagenum, String pagesize, String query);

    R getsex();

    R getjy();
}
