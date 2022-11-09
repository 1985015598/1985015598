package org.jclg.ems.service;

import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 钟祥
 * @since 2022-03-08
 */
public interface UsersService extends IService<Users> {
    public R login(String account, String passowrd);

    public R add(Users info);

    public R addimg(MultipartFile file, HttpServletRequest req);

    public R getUser(String account);

    public R getqx(String account);

    public R getalllimt(String pagenum,String pagesize,String query);

    public R getMenus(String token);

    Object logout();
}
