package com.rest.mapper;

import com.rest.model.Role;
import com.rest.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RoleMapper extends MyMapper<Role> {
    public List<Role> queryRoleListWithSelected(Integer id);
}