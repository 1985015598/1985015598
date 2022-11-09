package org.jclg.ems.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.jclg.ems.bean.Comapplication;
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
public interface ComapplicationMapper extends BaseMapper<Comapplication> {
    @Select("select count(1) from comapplication where comapplication.sta=0")
    int getcountbysta();
    @Select("select * from comapplication ORDER BY sta")
    List<Map<String, String>> getallbysta();
    @Update("UPDATE  comapplication  set sta=2 where comapplication.applicant=#{applicant}")
    void tycom(String applicant);
    @Update("UPDATE  comapplication  set sta=1 where comapplication.applicant=#{applicant}")
    void jjcom(String applicant);
}
