package org.javaboy.vhr.controller.system.basic;

import org.javaboy.vhr.annotation.Log;
import org.javaboy.vhr.model.InsertJobLevel;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.UploadJobLevel;
import org.javaboy.vhr.service.JobNameService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * 职称等级
 *
 * @author 🍍
 * @date 2023/10/1
 */
@RestController
@RequestMapping("/system/basic/jobName")
@Validated
public class JobNameController {

    @Resource
    private JobNameService jobNameService;

    /**
     * 获取所有职称等级信息
     */
    @GetMapping("/")
    @Log("获取所有职称等级信息")
    public RespBean findAll() {
        return RespBean.ok(jobNameService.selectAll());
    }

    /**
     * 删除职称等级
     */
    @DeleteMapping("/delete/{id}")
    @Log("删除职称等级")
    public RespBean remove(@Min(value = 1, message = "id不合法")
                           @PathVariable("id") Integer id) {
        if (jobNameService.delete(id)) {
            return RespBean.ok();
        } else {
            return RespBean.error();
        }
    }

    /**
     * 修改职称等级
     */
    @PutMapping("/modify")
    @Log("修改职称等级")
    public RespBean modify(@RequestBody UploadJobLevel uploadJobLevel) {
        if (jobNameService.update(uploadJobLevel)) {
            return RespBean.ok();
        } else {
            return RespBean.error();
        }
    }

    /**
     * 新增职称等级
     */
    @PutMapping("/add")
    @Log("新增职称等级")
    public RespBean add(@RequestBody InsertJobLevel insertJobLevel) {
        if (jobNameService.insert(insertJobLevel)) {
            return RespBean.ok();
        } else {
            return RespBean.error();
        }
    }
}
