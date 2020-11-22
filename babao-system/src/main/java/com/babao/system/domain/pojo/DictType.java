package com.babao.system.domain.pojo;

import com.babao.system.domain.BaseEntity;
import lombok.Data;

/**
 * 字典类型表 sys_dict_type
 * 
 * @author ruoyi
 */
@Data
public class DictType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 字典主键 */
    private Long dictId;

    /** 字典名称 */
    private String dictName;

    /** 字典类型 */
    private String dictType;

    /** 状态（0正常 1停用） */
    private String status;


}
