package org.javaboy.vhr.controller.salary;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.javaboy.vhr.annotation.Log;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.SalaryTableSearch;
import org.javaboy.vhr.model.SalaryTableView;
import org.javaboy.vhr.service.SalaryTableService;
import org.javaboy.vhr.utils.ExportImportExcelUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * 工资报表
 *
 * @author 🍍
 * @date 2023/10/22
 */

@RestController
@RequestMapping("/sal/table")
public class SalaryTableController {

    @Resource
    private SalaryTableService salaryTableService;

    /**
     * 返回所有工资表
     */
    @PostMapping("/{pageNum}/{pageSize}")
    @Log("查询所有工资表")
    public RespBean findPage(@PathVariable("pageNum") Integer pageNum,
                             @PathVariable("pageSize") Integer pageSize,
                             @RequestBody SalaryTableSearch salaryTableSearch) {
        PageHelper.startPage(pageNum, pageSize);
        return RespBean.ok(new PageInfo<>(salaryTableService.selectAll(salaryTableSearch)));
    }

    /**
     * 导出员工的工资表
     */
    @PostMapping("/export")
    @Log("导出员工的工资表")
    public ResponseEntity<byte[]> exportSalaryTable(@RequestBody SalaryTableSearch salaryTableSearch) {
        List<SalaryTableView> salaryTableViews = salaryTableService.selectAll(salaryTableSearch);
        try {
            return ExportImportExcelUtil.exportSalaryTable(salaryTableViews);
        } catch (IOException e) {
            return null;
        }
    }
}
