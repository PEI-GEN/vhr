package org.javaboy.vhr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 部门 实体
 *
 * @author boluo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Department implements Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 父部门id
     */
    private Integer parentId;
    /**
     * 部门路径
     */
    private String depPath;
    /**
     * 是否开启
     */
    private Boolean enabled;
    /**
     * 是否父部门
     */
    private Boolean isParent;
    /**
     * 子部门
     */
    private List<Department> children;

    public Department(String cellValue) {

    }
}