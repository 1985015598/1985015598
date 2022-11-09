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
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String img;

    private String comname;

    private String cominfo;

    private String comindo;

    private String comaddress;

    private Integer businfoid;

    private String remark;


}
