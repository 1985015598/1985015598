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
public class Joboffer implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userid;

    private Integer comid;

    private String position;

    private String workplace;

    private String expreq;

    private String edureq;

    private String jobreq;

    private String jobwel;

    private String time;

    private String sta;

    private String remark;


}
