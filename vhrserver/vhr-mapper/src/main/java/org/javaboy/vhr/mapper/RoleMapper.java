package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.InsertRole;
import org.javaboy.vhr.model.RightsBean;
import org.javaboy.vhr.model.Role;
import org.javaboy.vhr.model.UploadRole;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(UploadRole record);

    List<Role> getAllRoles();

    Role selectByName(String roleName);

    List<Role> selectAllRole();

    List<Integer> selectRightsByRoleId(Integer roleId);

    int insertRole(InsertRole insertRole);


    int deleteRightsByRoleId(Integer roleId);

    int insertRightsByRoleId(RightsBean rightsBean);

    int selectRightsCountByRoleId(Integer roleId);
}