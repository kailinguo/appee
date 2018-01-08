package com.diner.service;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.diner.model.Admin;

@Mapper
public interface AdminService {

	@Select("SELECT * FROM `diner`.`admin` where userName = #{userName} and password = #{password} and state = 1;")
	Admin findByNameAndPassword(Admin admin);

	@Insert("INSERT INTO `diner`.`admin` (`id`, `userName`, `password`, `realName`, `age`, `phoneNumber`, `headPicture`, `addDate`, `updateDate`, `state`) VALUES (null, #{userName}, #{password}, #{realName}, #{age}, #{phoneNumber}, #{headPicture}, now(), now(), 1);")
	int insert(Admin admin);

}
