package com.babao.web.controller.system;

import com.babao.common.croe.controller.BaseController;
import com.babao.system.service.impl.DictDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 数据字典信息
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/dict/data")
public class DictDataController extends BaseController {
    private String prefix = "system/dict/data";

    @Autowired
    private DictDataServiceImpl dictDataService;

//    @RequiresPermissions("system:dict:view")
//    @GetMapping()
//    public String dictData()
//    {
//        return prefix + "/data";
//    }
//
//    @PostMapping("/list")
//    @RequiresPermissions("system:dict:list")
//    @ResponseBody
//    public TableDataInfo list(DictData dictData)
//    {
//        startPage();
//        List<DictData> list = dictDataService.selectDictDataList(dictData);
//        return getDataTable(list);
//    }
//
//    @Log(title = "字典数据", businessType = BusinessType.EXPORT)
//    @RequiresPermissions("system:dict:export")
//    @PostMapping("/export")
//    @ResponseBody
//    public AjaxResult export(DictData dictData)
//    {
//        List<DictData> list = dictDataService.selectDictDataList(dictData);
//        ExcelUtil<DictData> util = new ExcelUtil<DictData>(DictData.class);
//        return util.exportExcel(list, "字典数据");
//    }
//
//    /**
//     * 新增字典类型
//     */
//    @GetMapping("/add/{dictType}")
//    public String add(@PathVariable("dictType") String dictType, ModelMap mmap)
//    {
//        mmap.put("dictType", dictType);
//        return prefix + "/add";
//    }
//
//    /**
//     * 新增保存字典类型
//     */
//    @Log(title = "字典数据", businessType = BusinessType.INSERT)
//    @RequiresPermissions("system:dict:add")
//    @PostMapping("/add")
//    @ResponseBody
//    public AjaxResult addSave(@Validated DictData dict)
//    {
//        return toAjax(dictDataService.insertDictData(dict));
//    }
//
//    /**
//     * 修改字典类型
//     */
//    @GetMapping("/edit/{dictCode}")
//    public String edit(@PathVariable("dictCode") Long dictCode, ModelMap mmap)
//    {
//        mmap.put("dict", dictDataService.selectDictDataById(dictCode));
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存字典类型
//     */
//    @Log(title = "字典数据", businessType = BusinessType.UPDATE)
//    @RequiresPermissions("system:dict:edit")
//    @PostMapping("/edit")
//    @ResponseBody
//    public AjaxResult editSave(@Validated DictData dict)
//    {
//        return toAjax(dictDataService.updateDictData(dict));
//    }
//
//    @Log(title = "字典数据", businessType = BusinessType.DELETE)
//    @RequiresPermissions("system:dict:remove")
//    @PostMapping("/remove")
//    @ResponseBody
//    public AjaxResult remove(String ids)
//    {
//        return toAjax(dictDataService.deleteDictDataByIds(ids));
//    }
}
