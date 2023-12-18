package org.javaboy.vhr.controller.system.basic;

import org.javaboy.vhr.annotation.Log;
import org.javaboy.vhr.model.InsertPosition;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.UploadPosition;
import org.javaboy.vhr.service.PositionTwoService;
import org.javaboy.vhr.utils.CheckUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * 职位信息
 *
 * @author 🍍
 * @date 2023/10/1
 */

@RestController
@RequestMapping("/system/basic/job")
@Validated
public class PositionTwoController {

    @Resource
    private PositionTwoService positionTwoService;

    /**
     * 查询所有职位
     */
    @GetMapping("/")
    @Log("查询所有职位")
    public RespBean findAllPos() {
        return RespBean.ok(positionTwoService.selectAllPosition());
    }

    /**
     * 通过id 返回职位
     */
    @GetMapping("/byId/{id}")
    @Log("通过id查询职位")
    public RespBean findPosById(@Min(value = 1, message = "id必须大于0")
                                @PathVariable("id") Integer id) {
        return RespBean.ok(positionTwoService.selectPositionById(id));
    }

    /**
     * 删除职位
     */
    @DeleteMapping("/delete/{id}")
    @Log("删除职位")
    public RespBean remove(@Min(value = 1, message = "id必须大于0")
                           @PathVariable("id") Integer id) {
        if (positionTwoService.delete(id)) {
            return RespBean.ok();
        } else {
            return RespBean.error();
        }
    }

    /**
     * 新增职位
     */
    @PutMapping("/add")
    @Log("新增职位")
    public RespBean add(@Valid @RequestBody InsertPosition insertPosition) {
        if (CheckUtil.isNotNull(positionTwoService.findByName(insertPosition.getName()))) {
            return RespBean.error("职位名称已存在");
        }
        insertPosition.setEnabled(true);
        if (positionTwoService.insert(insertPosition)) {
            return RespBean.ok();
        } else {
            return RespBean.error();
        }
    }

    /**
     * 批量删除职位
     */
    @DeleteMapping("/delete/many/")
    @Log("批量删除职位")
    public RespBean deleteMany(@Size(min = 1, message = "id不能为空")
                               @RequestBody Integer[] ids) {
        if (positionTwoService.deleteMany(ids)) {
            return RespBean.ok();
        } else {
            return RespBean.error();
        }
    }

    /**
     * 修改职位
     */
    @PutMapping("/modify")
    @Log("修改职位")
    public RespBean modify(@Valid @RequestBody UploadPosition uploadPosition) {
        if (positionTwoService.update(uploadPosition)) {
            return RespBean.ok();
        } else {
            return RespBean.error();
        }
    }
}
