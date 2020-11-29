package com.babao.system.service.impl;

import com.babao.system.domain.pojo.DictData;
import com.babao.system.mapper.DictDataMapper;
import com.babao.system.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典 业务层处理
 * 
 * @author ruoyi
 */
@Service("dictDataService")
public class DictDataServiceImpl implements BaseService<DictData> {
    @Autowired
    private DictDataMapper dictDataMapper;

    @Override
    public boolean add(DictData dictData) {
        return false;
    }

    @Override
    public List<DictData> getAll() {
        return null;
    }

    @Override
    public boolean del(Integer id) {
        return false;
    }

    @Override
    public void batchAdd(List<DictData> list) {

    }

    /**
     * 根据条件分页查询字典数据
     * 
     * @param dictData 字典数据信息
     * @return 字典数据集合信息
     */
//    @Override
//    public List<DictData> selectDictDataList(DictData dictData)
//    {
//        return dictDataMapper.selectDictDataList(dictData);
//    }
//
//    /**
//     * 根据字典类型和字典键值查询字典数据信息
//     *
//     * @param dictType 字典类型
//     * @param dictValue 字典键值
//     * @return 字典标签
//     */
//    @Override
//    public String selectDictLabel(String dictType, String dictValue)
//    {
//        return dictDataMapper.selectDictLabel(dictType, dictValue);
//    }
//
//    /**
//     * 根据字典数据ID查询信息
//     *
//     * @param dictCode 字典数据ID
//     * @return 字典数据
//     */
//    @Override
//    public DictData selectDictDataById(Long dictCode)
//    {
//        return dictDataMapper.selectDictDataById(dictCode);
//    }
//
//    /**
//     * 批量删除字典数据
//     *
//     * @param ids 需要删除的数据
//     * @return 结果
//     */
//    @Override
//    public int deleteDictDataByIds(String ids)
//    {
//        int row = dictDataMapper.deleteDictDataByIds(Convert.toStrArray(ids));
//        if (row > 0)
//        {
//            DictUtils.clearDictCache();
//        }
//        return row;
//    }
//
//    /**
//     * 新增保存字典数据信息
//     *
//     * @param dictData 字典数据信息
//     * @return 结果
//     */
//    @Override
//    public int insertDictData(DictData dictData)
//    {
//        dictData.setCreateBy(ShiroUtils.getLoginName());
//        int row = dictDataMapper.insertDictData(dictData);
//        if (row > 0)
//        {
//            DictUtils.clearDictCache();
//        }
//        return row;
//    }
//
//    /**
//     * 修改保存字典数据信息
//     *
//     * @param dictData 字典数据信息
//     * @return 结果
//     */
//    @Override
//    public int updateDictData(DictData dictData)
//    {
//        dictData.setUpdateBy(ShiroUtils.getLoginName());
//        int row = dictDataMapper.updateDictData(dictData);
//        if (row > 0)
//        {
//            DictUtils.clearDictCache();
//        }
//        return row;
//    }
//
//    @Override
//    public boolean add(DictData dictData) {
//        return false;
//    }
//
//    @Override
//    public List<DictData> getAll() {
//        return null;
//    }
//
//    @Override
//    public boolean del(Integer id) {
//        return false;
//    }
}
