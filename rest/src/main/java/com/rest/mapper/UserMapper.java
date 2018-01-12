package com.rest.mapper;

import com.rest.model.User;
import com.rest.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends MyMapper<User> {
}