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
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "userid", type = IdType.AUTO)
    private Integer userid;

    private String account;

    private String password;

    private String img;

    private Integer roleid;

    private String onsta;

    private String remark;

}
