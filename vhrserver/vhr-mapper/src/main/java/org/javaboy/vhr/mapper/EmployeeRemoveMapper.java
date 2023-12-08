package org.javaboy.vhr.mapper;


import org.javaboy.vhr.model.EmployeeRemoveView;
import org.javaboy.vhr.model.InsertEmployeeRemove;
import org.javaboy.vhr.model.UploadEmployeeRemove;

import java.util.List;

/**
 * 调岗 数据层
 *
 * @author boluo
 */
public interface EmployeeRemoveMapper {
    /**
     * 删除调岗
     *
     * @param id 调岗id
     * @return 结果
     */
    int deleteByPrimaryKey(Integer id);


    /**
     * 新增调岗
     *
     * @param insertEmployeeRemove 调岗信息
     * @return 结果
     */
    int insertEmployeeRemove(InsertEmployeeRemove insertEmployeeRemove);


    /**
     * 通过调岗id 查询调岗
     *
     * @param id
     * @return 调岗信息
     */
    EmployeeRemoveView selectByPrimaryKey(Integer id);

    /**
     * 修改调岗
     *
     * @param uploadEmployeeRemove 调岗信息
     * @return 结果
     */
    int updateByPrimaryKey(UploadEmployeeRemove uploadEmployeeRemove);

    /**
     * 查询所有调岗信息
     *
     * @return 调岗集合
     */
    List<EmployeeRemoveView> selectAll();
}