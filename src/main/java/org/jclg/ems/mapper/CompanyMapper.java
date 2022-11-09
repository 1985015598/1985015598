package org.jclg.ems.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jclg.ems.bean.Company;
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
public interface CompanyMapper extends BaseMapper<Company> {
    @Select(" select  company.* from company where "+
            "   INSTR(company.comname,#{query}) "+
            " LIMIT #{pagenum},#{pagesize} ")
    public List<Map<String,String>> getalllimts(@Param("pagenum")Integer pagenum, @Param("pagesize") Integer pagesize, @Param("query") String query);

    @Select("select count(1) from company where " +
            "INSTR(company.comname,#{query})")
    public int getcount(String query);
    @Select("select c.*,b.* from company c,business b \n" +
            "where c.id=#{id} and c.businfoid=b.id")
    Map<String,String> getCominfo(String id);
}
