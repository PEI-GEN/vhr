package org.javaboy.vhr.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 部门请求 实体
 *
 * @author boluo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteRequestDepartment {
    /**
     * 父部门id
     */
//    @NotNull(message = "父部门id不能为空")
    private Integer parentId;
    /**
     * 父部门路径
     */
//    @NotNull(message = "父部门路径不能为空")
    private String parentDepPath;
    /**
     * 是否是父部门
     */
    private Boolean parentIsParent;
    /**
     * 子部门id
     */
    private Integer childrenId;
    /**
     * 子部门名字
     */
    private String childrenName;
    /**
     * 子部门是否开启
     */
    private Boolean childrenEnabled;
}
