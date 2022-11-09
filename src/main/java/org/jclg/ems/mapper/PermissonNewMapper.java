package org.jclg.ems.mapper;

import org.apache.ibatis.annotations.Select;
import org.jclg.ems.Ret.R;
import org.jclg.ems.bean.PermissonNew;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 钟祥
 * @since 2022-04-15
 */
public interface PermissonNewMapper extends BaseMapper<PermissonNew> {
    @Select("select * from permisson_new p , meta m where p")
    public R getMenus(String token);


}
