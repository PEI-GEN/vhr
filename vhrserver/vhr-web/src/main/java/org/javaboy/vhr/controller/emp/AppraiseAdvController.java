package org.javaboy.vhr.controller.emp;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.javaboy.vhr.annotation.Log;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.AppraiseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 考评信息
 *
 * @author 🍍
 * @date 2023/10/1
 */
@RestController
@RequestMapping("/emp/adv/app")
@Validated
public class AppraiseAdvController {

    @Resource
    private AppraiseService appraiseService;

    /**
     * 考评分页
     */
    @GetMapping("/{pageNum}/{pageSize}")
    @Log("查询考评分页")
    public RespBean findByPage(@Min(value = 1, message = "页码不能小于1")
                               @PathVariable("pageNum") Integer pageNum,
                               @Min(value = 1, message = "页大小不能小于1")
                               @Max(value = 10, message = "页大小不能大于10")
                               @PathVariable("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return RespBean.ok(new PageInfo<>(appraiseService.selectAll()));
    }
}
