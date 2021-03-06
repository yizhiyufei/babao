package com.babao.system.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
    /** 搜索值 */
//    private String searchValue;

    //主键
    @TableId(type = IdType.AUTO)
    private Integer id;

    /** 创建者 */
    @TableField(fill = FieldFill.INSERT)
    private Integer createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /** 更新者 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer updateBy;

    /** 更新时间 */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /** 备注 */
    @TableField(fill = FieldFill.INSERT)
    private String remark;


    @TableLogic//逻辑删除
    @TableField(select = false,fill = FieldFill.INSERT)//查询的时候不显示
    private Integer deleted;

}
