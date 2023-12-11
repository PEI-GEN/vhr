package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.EmployeeScoreStatisticsMapper;
import org.javaboy.vhr.model.EmployeeScoreHeaderStatistics;
import org.javaboy.vhr.model.EmployeeScoreStatistics;
import org.javaboy.vhr.model.TableStaData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 员工积分统计 业务层
 *
 * @author 🍍
 * @date 2023/10/31
 */
@Service
public class EmployeeScoreStatisticsService {
    @Resource
    private EmployeeScoreStatisticsMapper employeeScoreStatisticsMapper;

    /**
     * 查询页头数据
     *
     * @return 页头数据集合
     */
    public EmployeeScoreHeaderStatistics selectHeaderData() {
        return employeeScoreStatisticsMapper.selectHeaderData();
    }

    /**
     * 查询奖惩统计
     *
     * @return 奖惩统计集合
     */
    public TableStaData<EmployeeScoreStatistics> selectRewardPunishment(Integer days) {
        return new TableStaData<>(employeeScoreStatisticsMapper.selectRewardPunishment(days));
    }
}
