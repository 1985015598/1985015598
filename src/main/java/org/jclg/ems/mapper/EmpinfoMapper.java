package org.jclg.ems.mapper;

import org.apache.ibatis.annotations.Select;
import org.jclg.ems.bean.Empinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 钟祥
 * @since 2022-03-08
 */
public interface EmpinfoMapper extends BaseMapper<Empinfo> {
    @Select("select max(id) from empinfo")
    int getMax();
}
