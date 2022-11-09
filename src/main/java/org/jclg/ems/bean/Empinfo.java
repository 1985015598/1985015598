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
 * @since 2022-03-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Empinfo implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String incompany;

    private String inplace;

    private String insition;

    private String insta;

    private String remark;


}
