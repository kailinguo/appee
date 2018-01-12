package com.rest.mapper;

import com.rest.model.UserRole;
import com.rest.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserRoleMapper extends MyMapper<UserRole> {
    public List<Integer> findUserIdByRoleId(Integer roleId);
}