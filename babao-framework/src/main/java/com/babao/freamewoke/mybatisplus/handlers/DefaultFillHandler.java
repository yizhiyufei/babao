package com.babao.freamewoke.mybatisplus.handlers;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 默认值字段自动填充
 */
@Component
public class DefaultFillHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        fillStrategy(metaObject, "createBy", 0);
        fillStrategy(metaObject, "updateBy", 0);
        this.fillStrategy(metaObject, "createTime", new Date());
        this.fillStrategy(metaObject, "updateTime", new Date());
        fillStrategy(metaObject, "remark", "");
        fillStrategy(metaObject, "deleted", 0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        fillStrategy(metaObject, "updateBy", 0);
        fillStrategy(metaObject, "updateTime", new Date());
    }
}
