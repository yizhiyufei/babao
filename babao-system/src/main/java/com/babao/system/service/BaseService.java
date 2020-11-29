package com.babao.system.service;

import com.babao.system.domain.BaseEntity;
import java.util.List;

/**
 * @ClassName : QuestionService
 * @Author : Administrator
 * @Date: 2020/11/2 23:31
 * @Description : 基础业务接口
 */

public interface BaseService<T extends BaseEntity> {

    public boolean add(T t);

    public List<T> getAll();

    public boolean del(Integer id);

    public void batchAdd(List<T> list);
}
