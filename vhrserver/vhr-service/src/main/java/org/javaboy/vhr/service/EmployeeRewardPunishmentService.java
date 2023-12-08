package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.EmployeeRewardPunishmentMapper;
import org.javaboy.vhr.model.EmployeeRewardPunishment;
import org.javaboy.vhr.model.InsertEmployeeRewardPunishment;
import org.javaboy.vhr.model.UploadEmployeeRewardPunishment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 奖惩 业务层
 *
 * @author 🍍
 * @date 2023/10/1
 */
@Service
public class EmployeeRewardPunishmentService {

    @Resource
    private EmployeeRewardPunishmentMapper employeeRewardPunishmentMapper;

    /**
     * 所有奖惩集合
     *
     * @return 奖惩集合
     */
    public List<EmployeeRewardPunishment> selectAll() {
        List<EmployeeRewardPunishment> list = employeeRewardPunishmentMapper.selectAll();
        return list;
    }

    /**
     * 修改奖惩
     *
     * @param uploadEmployeeRewardPunishment 奖惩信息
     * @return 结果
     */
    public boolean update(UploadEmployeeRewardPunishment uploadEmployeeRewardPunishment) {
        return employeeRewardPunishmentMapper.updateByPrimaryKey(uploadEmployeeRewardPunishment) == 1;
    }


    /**
     * 删除奖惩
     *
     * @param id 奖惩id
     * @return 结果
     */
    public boolean delete(Integer id) {
        return employeeRewardPunishmentMapper.deleteByPrimaryKey(id) == 1;
    }


    /**
     * 新增奖惩
     *
     * @param insertEmployeeRewardPunishment 奖惩信息
     * @return 结果
     */
    public boolean insert(InsertEmployeeRewardPunishment insertEmployeeRewardPunishment) {
        // todo 需要删除
        if (insertEmployeeRewardPunishment.getCreateDate() == null) {
            insertEmployeeRewardPunishment.setCreateDate(new Date());
        }
        return employeeRewardPunishmentMapper.insertEmployeeRewardPunishment(insertEmployeeRewardPunishment) == 1;
    }

}
