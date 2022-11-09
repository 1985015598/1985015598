package org.jclg.ems.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jclg.ems.bean.Joboffer;
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
public interface JobofferMapper extends BaseMapper<Joboffer> {
    @Select("select j.*,c.* from joboffer j,company c\n " +
            "            where  j.comid=c.id and j.comid=#{comid}\n " +
            "              and  INSTR(j.position,#{query}) \n" +
            " LIMIT #{pagenum},#{pagesize} ")
    List<Map<String, String>> getalllimts(@Param("comid")String comid,@Param("pagenum")Integer pagenum, @Param("pagesize") Integer pagesize, @Param("query") String query);
    @Select("select count(1) from joboffer where comid=#{comid1} \n" +
            "and  INSTR(joboffer.position,#{query}) ")
    int getcount(@Param("comid1")String comid1,@Param("query")String query);
    @Select("select j.*,c.*,s.name as hr from joboffer j,company c,staff s\n " +
            "            where  j.comid=c.id and \n " +
            "            s.userid=j.userid  and              " +
            "             INSTR(j.position,#{query}) \n" +
            " LIMIT #{pagenum},#{pagesize} ")
    List<Map<String, String>> getall(@Param("pagenum")Integer pagenum, @Param("pagesize") Integer pagesize, @Param("query") String query);
    @Select("select count(1) from joboffer  where \n" +
            "  INSTR(joboffer.position,#{query}) ")
    int getcount1(String query);
}
