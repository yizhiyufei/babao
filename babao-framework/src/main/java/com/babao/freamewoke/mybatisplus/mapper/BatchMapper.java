package com.babao.freamewoke.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.Collection;

public interface BatchMapper<T> extends BaseMapper<T> {
    Integer insertBatchSomeColumn(Collection<T> entityList);
}
