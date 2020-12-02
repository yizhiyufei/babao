package com.babao.system.service.impl;

import com.babao.system.domain.pojo.Question;
import com.babao.system.domain.pojo.TestPaper;
import com.babao.system.service.BaseService;

import java.util.List;

/**
 * 试卷业务
 */
public class TestPaperService implements BaseService<TestPaper>{
    @Override
    public boolean add(TestPaper testPaper) {
        return false;
    }

    @Override
    public List<TestPaper> getAll() {
        return null;
    }

    @Override
    public boolean del(Integer id) {
        return false;
    }

    @Override
    public void batchAdd(List<TestPaper> list) {

    }
}
