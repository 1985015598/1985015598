package org.jclg.ems.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.jclg.ems.bean.Applyinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 钟祥
 * @since 2022-05-02
 */
public interface ApplyinfoMapper extends BaseMapper<Applyinfo> {
    @Select("select a.*,st.*,s.*,j.* from staff s,student st,joboffer j,applyinfo a,company c\n" +
            "where j.userid=#{userid} and a.jobofferid=j.id and c.id=j.comid and s.comid=c.id and st.userid=a.studentid\n" +
            "and  INSTR(a.sta,#{query})\n" +
            "LIMIT #{pagenum},#{pagesize}")
    public List<Map<String,String>> getalllimts(@Param("userid")String userid,@Param("pagenum")Integer pagenum, @Param("pagesize") Integer pagesize, @Param("query") String query);
    @Select("select count(1) from staff s,student st,joboffer j,applyinfo a,company c\n" +
            "where j.userid=#{userid} and a.jobofferid=j.id and c.id=j.comid and s.comid=c.id and st.userid=a.studentid\n" +
            "and  INSTR(a.sta,#{query})\n" +
            "")
    int getcount(@Param("userid")String userid,@Param("query")String query);
    @Update("\n" +
            "UPDATE  applyinfo  set sta=2 where applyinfo.id=#{sta}")
    int jieshou(String sta);
    @Update("UPDATE  applyinfo  set sta=3 where applyinfo.id=#{sta}")
    int jujue(String sta);
    @Update("UPDATE  applyinfo  set sta=1 where applyinfo.id=#{sta}")
    int ckjl(String sta);
    @Select("select a.*,s.*,j.*,c.* from staff s,student st,joboffer j,applyinfo a,company c\n" +
            "where a.studentid=#{userid}  and a.jobofferid=j.id  and c.id=j.comid and s.comid=c.id and st.userid=a.studentid\n" +
            "and  INSTR(a.sta,#{query})\n" +
            "LIMIT  #{pagenum},#{pagesize}\n")
    public List<Map<String,String>> getallbyst(@Param("userid")String userid,@Param("pagenum")Integer pagenum, @Param("pagesize") Integer pagesize, @Param("query") String query);
    @Select("select count(1) from staff s,student st,joboffer j,applyinfo a,company c\n" +
            "where a.studentid=#{userid} and a.jobofferid=j.id and c.id=j.comid and s.comid=c.id and st.userid=a.studentid\n" +
            "and  INSTR(a.sta,#{query})\n" +
            "")
    int getcountbyst(@Param("userid")String userid,@Param("query")String query);
    @Update("UPDATE  applyinfo  set sta=5 where applyinfo.id=#{sta}")
    int stjieshou(String sta);
    @Update("UPDATE  applyinfo  set sta=4 where applyinfo.id=#{sta}")
    int stjujue(String sta);
}
