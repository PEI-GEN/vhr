package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.JobNameMapper;
import org.javaboy.vhr.model.InsertJobLevel;
import org.javaboy.vhr.model.JobLevel;
import org.javaboy.vhr.model.UploadJobLevel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.print.attribute.standard.JobName;
import java.util.List;

/**
 * 职称等级 业务层
 *
 * @author 🍍
 * @date 2023/10/1
 */
@Service
public class JobNameService {

    @Resource
    private JobNameMapper jobNameMapper;

    /**
     * 查询所有职称等级
     *
     * @return 职称等级集合
     */
    public List<JobLevel> selectAll() {
        return jobNameMapper.selectAll();
    }

    /**
     * 新增职称等级
     *
     * @param insertJobLevel 职称等级信息
     * @return 结果
     */
    public boolean insert(InsertJobLevel insertJobLevel) {
        return jobNameMapper.insertJobLevel(insertJobLevel) == 1;
    }

    /**
     * 修改职称等级
     *
     * @param uploadJobLevel 职称等级信息
     * @return 结果
     */
    public boolean update(UploadJobLevel uploadJobLevel) {
        return jobNameMapper.updateByPrimaryKey(uploadJobLevel) == 1;
    }

    /**
     * 删除职称等级
     *
     * @param id 职称等级id
     * @return 结果
     */
    public boolean delete(Integer id) {
        return jobNameMapper.deleteByPrimaryKey(id) == 1;
    }
}
