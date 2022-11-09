package org.jclg.ems.mapper;

import org.apache.ibatis.annotations.Select;
import org.jclg.ems.bean.Staff;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 钟祥
 * @since 2022-03-08
 */
public interface StaffMapper extends BaseMapper<Staff> {
    @Select("select staff.*,company.comname from staff,users,company where staff.userid=users.userid and users.account=#{store} \n" +
            "and staff.comid=company.id")
    Map<String,String> getByStore(String store);
    @Select("select s.comid from users u,staff s where u.account=#{token} and u.userid=s.userid ")
    Integer getcom(String token);
}
