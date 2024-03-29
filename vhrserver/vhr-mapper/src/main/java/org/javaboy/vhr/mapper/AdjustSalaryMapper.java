package org.javaboy.vhr.mapper;


import org.javaboy.vhr.model.AdjustSalaryView;
import org.javaboy.vhr.model.InsertAdjustSalary;
import org.javaboy.vhr.model.UploadAdjustSalary;

import java.util.List;

/**
 * 调薪 数据层
 *
 * @author boluo
 */
public interface AdjustSalaryMapper {

    /**
     * 通过调薪id 删除调薪
     *
     * @param id 调薪id
     * @return 结果
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增调薪
     *
     * @param insertAdjustSalary 调薪信息
     * @return 结果
     */
    int insertAdjustSalary(InsertAdjustSalary insertAdjustSalary);

    /**
     * 通过调薪id 查询调薪
     *
     * @param id 调薪id
     * @return 调薪信息
     */
    AdjustSalaryView selectByPrimaryKey(Integer id);

    /**
     * 通过调薪id 修改调薪
     *
     * @param uploadAdjustSalary 调薪信息
     * @return 结果
     */
    int updateByPrimaryKey(UploadAdjustSalary uploadAdjustSalary);

    /**
     * 查询所有调薪
     *
     * @return 调薪集合
     */
    List<AdjustSalaryView> selectAll();

}