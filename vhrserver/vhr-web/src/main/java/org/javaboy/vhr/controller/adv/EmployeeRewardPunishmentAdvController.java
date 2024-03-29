package org.javaboy.vhr.controller.adv;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.javaboy.vhr.annotation.Log;
import org.javaboy.vhr.model.EmployeeRewardPunishment;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.EmployeeRewardPunishmentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * 奖惩信息
 *
 * @author 🍍
 * @date 2023/10/1
 */

@RestController
@RequestMapping("/emp/adv/c")
@Validated
public class EmployeeRewardPunishmentAdvController {
    @Resource
    private EmployeeRewardPunishmentService employeeRewardPunishmentService;


    /**
     * 奖惩分页
     */
    @GetMapping("/{pageNum}/{pageSize}")
    @Log("查询奖惩分页")
    public RespBean findByPage(@Min(value = 1, message = "页码不能小于1")
                               @PathVariable("pageNum") Integer pageNum,
                               @Min(value = 1, message = "页大小不能小于1")
                               @Max(value = 10, message = "页大小不能大于10")
                               @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<EmployeeRewardPunishment> list = employeeRewardPunishmentService.selectAll();
        PageInfo<EmployeeRewardPunishment> pageInfo = new PageInfo<>(list);
        return RespBean.ok(pageInfo);
    }
}