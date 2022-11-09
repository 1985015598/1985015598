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
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String userid;

    private String name;

    private String sex;

    private Integer age;

    private String classes;

    private Integer professionid;

    private Integer collegeid;

    private String grayears;

    private String phone;

    private Integer dreposid;

    private Integer empinfoid;

    private String remark;


}
