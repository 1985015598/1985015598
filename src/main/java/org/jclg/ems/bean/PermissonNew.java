package org.jclg.ems.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author 钟祥
 * @since 2022-04-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PermissonNew implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("parentId")
    private String parentId;

    private String title;

    private String path;

    private String icon;

    @TableField("sortNumber")
    private String sortNumber;

    private String status;

    private String component;

    private Meta meta;

    private String by1;


}
