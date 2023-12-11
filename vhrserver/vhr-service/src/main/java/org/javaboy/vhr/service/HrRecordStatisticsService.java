package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.HrRecordStatisticsMapper;
import org.javaboy.vhr.model.TableStaData;
import org.javaboy.vhr.model.WrapHrRecordStatistics;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 人事记录统计 业务层
 *
 * @author 🍍
 * @date 2023/10/30
 */
@Service
public class HrRecordStatisticsService {
    @Resource
    private HrRecordStatisticsMapper hrRecordStatisticsMapper;


    /**
     * 获取人事记录
     *
     * @param days 天数
     * @return 人事记录统计集合
     */
    public TableStaData<WrapHrRecordStatistics> selectAll(Integer days) {
        return new TableStaData<>(hrRecordStatisticsMapper.selectAll(days));
    }
}
