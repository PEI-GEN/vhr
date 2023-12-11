package org.javaboy.vhr.mapper;


import org.javaboy.vhr.model.EmployeeScoreHeaderStatistics;
import org.javaboy.vhr.model.EmployeeScoreStatistics;

import java.util.List;

/**
 * 员工积分统计 数据层
 *
 * @author 🍍
 * @date 2023/10/31
 */
public interface EmployeeScoreStatisticsMapper {
    /**
     * 查询页头数据
     *
     * @return 页头数据集合
     */
    EmployeeScoreHeaderStatistics selectHeaderData();

    /**
     * 查询奖惩统计数据
     *
     * @param days 最近多少天
     * @return 奖惩数据集合
     */
    List<EmployeeScoreStatistics> selectRewardPunishment(Integer days);
}
