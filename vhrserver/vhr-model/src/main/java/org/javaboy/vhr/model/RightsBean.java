package org.javaboy.vhr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 权限 实体
 *
 * @author @1352955539(boluo)
 * @date 2021/2/8 - 13:12
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RightsBean {
    /**
     * 权限id
     */
    private Integer[] ids;
    /**
     * 角色id
     */
    private Integer roleId;
}
