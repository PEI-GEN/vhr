package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.EmployeeTrainView;
import org.javaboy.vhr.model.InsertEmployeeTrain;
import org.javaboy.vhr.model.UploadEmployeeTrain;

import java.util.List;

/**
 * 培训 数据层
 *
 * @author boluo
 */
public interface EmployeeTrainMapper {

    /**
     * 通过id 删除培训
     *
     * @param id
     * @return 结果
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增培训
     *
     * @param insertEmployeeTrain 培训信息
     * @return 结果
     */
    int insertEmployeeTrain(InsertEmployeeTrain insertEmployeeTrain);

    /**
     * 通过id 查询培训
     *
     * @param id 培训id
     * @return 培训信息
     */
    EmployeeTrainView selectByPrimaryKey(Integer id);

    /**
     * 修改培训
     *
     * @param uploadEmployeeTrain 培训信息
     * @return 结果
     */
    int updateByPrimaryKey(UploadEmployeeTrain uploadEmployeeTrain);

    /**
     * 查询所有培新 包含员工信息
     *
     * @return 培训集合
     */
    List<EmployeeTrainView> selectAll();

}