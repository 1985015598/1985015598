package org.jclg.ems.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jclg.ems.bean.Permission;
import org.jclg.ems.bean.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 钟祥
 * @since 2022-03-08
 */
public interface UsersMapper extends BaseMapper<Users> {
    @Select("select * from users where account = #{account} and password=#{password}")
    public Users login(@Param("account") String account, @Param("password") String password);
    @Select("select * from users where account=#{account}")
    public Users findAccount(String account);
    @Select("select permission.* from users , role ,permission where users.account=#{account} and users.roleid=role.id \n" +
            "\n" +
            "and  INSTR(role.remark,'%'+permission.id+'%')")
    public List<Permission> getqx(String account);

//    @Select("select users.* from users where" +
//            " INSTR(users.account,#{query}) " +
//            "  LIMIT #{pagenum},#{pagesize}")
    @Select(" select u.userid,u.account,u.password,u.img,u.remark,u.onsta,r.name as rolename from users u,role r  where "+
    " u.roleid=r.id  and  INSTR(u.account,#{query}) "+
    " LIMIT #{pagenum},#{pagesize} ")
    public List<Map<String,String>> getalllimts(@Param("pagenum")Integer pagenum, @Param("pagesize") Integer pagesize, @Param("query") String query);

    @Select("select count(1) from users where " +
            "INSTR(users.account,#{query})")
    public int getcount(String query);
}
