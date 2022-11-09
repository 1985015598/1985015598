package org.jclg.ems.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 钟祥
 * @since 2022-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PermissonXin implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String permission;

    private String children;

    private String path;

    private String childrenid;

    private String by1;

    private String by2;

    private String by3;


}
