package org.javaboy.vhr.controller.system.basic;

import org.javaboy.vhr.annotation.Log;
import org.javaboy.vhr.model.*;
import org.javaboy.vhr.service.DepartmentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 部门信息
 *
 * @author 🍍
 * @date 2023/10/1
 */
@RestController
@RequestMapping("/system/basic/department")
@Validated
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    /**
     * 所有部门
     */
    @GetMapping("/root")
    @Log("查询所有部门")
    public List<Department> findDepartment() {
        return departmentService.selectAllDepart(-1);
    }

    /**
     * 添加部门
     */

    @PutMapping("/add")
    @Log("添加部门")
    public RespBean add(@Valid @RequestBody InsertRequestDepartment insertDepartment) {
        if (departmentService.addDepartment(insertDepartment)) {
            return RespBean.ok();
        }
        return RespBean.error();
    }

    /**
     * 删除部门
     */
    @Log("删除部门")
    @DeleteMapping("/delete")
    public RespBean remove(@Valid @RequestBody DeleteRequestDepartment deleteRequestDepartment) {
        if (departmentService.deleteDepartment(deleteRequestDepartment)) {
            return RespBean.ok();
        }
        return RespBean.error();
    }

    /**
     * 关闭的部门
     */
    @GetMapping("/enabled")
    @Log("关闭部门")
    public RespBean findDisabledDepartment() {
        return RespBean.ok(departmentService.selectAllDepWithDisabled());
    }

    /**
     * 修改部门
     */
    @PutMapping("/modify")
    @Log("修改部门")
    public RespBean modify(@Valid @RequestBody UploadDepartment uploadDepartment) {
        if (departmentService.update(uploadDepartment)) {
            return RespBean.ok();
        } else {
            return RespBean.error();
        }
    }

    /**
     * 部门名查询部门
     */
    @GetMapping("/search/{name}")
    @Log("部门名查询部门")
    public RespBean findByName(@PathVariable("name") String name) {
        return RespBean.ok(departmentService.selectByName(name));
    }

    /**
     * 所有部门
     */
    @GetMapping("/")
    @Log("查询所有部门")
    public RespBean findAll() {
        return RespBean.ok(departmentService.selectAll());
    }
}
