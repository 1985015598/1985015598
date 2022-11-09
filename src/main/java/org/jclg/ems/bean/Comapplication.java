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
public class Comapplication implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "applicant", type = IdType.AUTO)
    private Integer applicant;

    private String comname;

    private String comsize;

    private String comindo;

    private String recneed;

    private String time;

    private String sta;

    private String remark;


}
