package org.javaboy.vhr.mapper;


import org.javaboy.vhr.model.SalaryTableSearch;
import org.javaboy.vhr.model.SalaryTableView;

import java.util.List;

/**
 * 工资表 数据层
 *
 * @author 🍍
 * @date 2023/10/22
 */
public interface SalaryTableMapper {

    /**
     * 查询所有工资表
     *
     * @return 工资表集合
     */
    List<SalaryTableView> selectAll(SalaryTableSearch salaryTableSearch);

}
