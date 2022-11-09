package org.jclg.ems.mapper;

import org.apache.ibatis.annotations.Select;
import org.jclg.ems.bean.Profession;
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
public interface ProfessionMapper extends BaseMapper<Profession> {
    @Select("select * from profession where college=#{college}")
    List<Map<String, String>> getbycollege(String college);
}
