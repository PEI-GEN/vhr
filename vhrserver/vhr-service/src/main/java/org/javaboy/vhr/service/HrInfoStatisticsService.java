package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.HrInfoStatisticsMapper;
import org.javaboy.vhr.model.HrInfoStatistics;
import org.javaboy.vhr.model.TableStaData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 在线人数 业务层
 *
 * @author 🍍
 * @date 2023/10/26
 */
@Service
public class HrInfoStatisticsService {
    @Resource
    private HrInfoStatisticsMapper hrInfoStatisticsMapper;

    /**
     * 新增在线人数
     *
     * @param hrInfoStatistics 在线人数信息
     * @return 结果
     */
    public boolean insertOnlineCount(HrInfoStatistics hrInfoStatistics) {
        return hrInfoStatisticsMapper.insertOnlineCount(hrInfoStatistics) == 1;
    }

    /**
     * 最近在线人数统计
     *
     * @return 在线人数信息统计
     */
    public TableStaData<HrInfoStatistics> selectRecentOnline(Integer days) {
        return new TableStaData<>(hrInfoStatisticsMapper.selectRecentOnline(days));
    }

    /**
     * 查询操作员个数
     *
     * @return 操作员个数
     */
    public Integer selectHrCount() {
        return hrInfoStatisticsMapper.selectHrCount();
    }

    /**
     * 查询操作员操作次数
     *
     * @return 操作次数
     */
    public Integer selectOperateCount() {
        return hrInfoStatisticsMapper.selectOperateCount();
    }

    /**
     * 查询操作员登录统计
     *
     * @return 操作员登录统计集合
     */
    public TableStaData<HrInfoStatistics> selectRecentLogin(Integer days) {
        return new TableStaData<>(hrInfoStatisticsMapper.selectRecentLogin(days));
    }

}
