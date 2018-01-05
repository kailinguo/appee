package com.boot.web.dao;

import com.boot.web.entity.JsonPTo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by KaiLin.Guo on 2017-10-16.
 */
@Mapper
public interface JsonPMapper {

    List<JsonPTo> testJsonp();

}
