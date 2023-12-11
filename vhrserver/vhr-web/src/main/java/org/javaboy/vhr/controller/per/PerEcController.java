package org.javaboy.vhr.controller.per;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.javaboy.vhr.annotation.Log;
import org.javaboy.vhr.model.InsertEmployeeRewardPunishment;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.UploadEmployee;
import org.javaboy.vhr.model.UploadEmployeeRewardPunishment;
import org.javaboy.vhr.service.EmployeeRewardPunishmentService;
import org.javaboy.vhr.service.EmployeeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * 奖惩信息
 *
 * @author 🍍
 * @date 2023/10/1
 */
@RestController
@RequestMapping("/per/ec")
@Validated
public class PerEcController {

    @Resource
    private EmployeeRewardPunishmentService employeeRewardPunishmentService;
    @Resource
    private EmployeeService employeeService;

    /**
     * 奖惩信息分页
     */
    @GetMapping("/{pageNum}/{pageSize}")
    @Log("查询奖惩信息分页")
    public RespBean findByPage(@Min(value = 1, message = "页码不能小于1")
                               @PathVariable("pageNum") Integer pageNum,
                               @Range(min = 1, max = 10, message = "页大小必须在1-10之间")
                               @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return RespBean.ok(new PageInfo<>(employeeRewardPunishmentService.selectAll()));
    }

    /**
     * 修改奖惩信息
     */
    @PutMapping("/modify")
    @Log("修改奖惩信息")
    public RespBean modify(@Valid @RequestBody UploadEmployeeRewardPunishment uploadEmployeeRewardPunishment) {
        if (employeeRewardPunishmentService.update(uploadEmployeeRewardPunishment)) {
            return RespBean.ok();
        }
        return RespBean.error();
    }

    /**
     * 删除奖惩信息
     */
    @DeleteMapping("/delete/{id}")
    @Log("删除奖惩信息")
    public RespBean removeOne(@Min(value = 1, message = "id不能小于1")
                              @PathVariable("id") Integer id) {
        if (employeeRewardPunishmentService.delete(id)) {
            return RespBean.ok();
        }
        return RespBean.error();
    }

    /**
     * 新增奖惩信息
     */
    @PutMapping("/add/{workId}")
    @Log("新增奖惩信息")
    public RespBean addOne(@Valid @RequestBody InsertEmployeeRewardPunishment insertEmployeeRewardPunishment,
                           @Length(min = 8, max = 8, message = "员工号长度必须为8位")
                           @PathVariable("workId") String workId) {
        UploadEmployee employee = employeeService.selectEmployeeByWorkId(workId);
        if (employee == null) {
            return RespBean.error("员工号不存在");
        }
        insertEmployeeRewardPunishment.setEmployeeId(employee.getId());
        if (employeeRewardPunishmentService.insert(insertEmployeeRewardPunishment)) {
            return RespBean.ok();
        }
        return RespBean.error();
    }
}
