package com.rest.mapper;

import com.rest.model.MenuTempt;
import com.rest.model.Resources;
import com.rest.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface ResourcesMapper extends MyMapper<Resources> {

    public List<Resources> queryAll();

    public List<Resources> loadUserResources(Map<String,Object> map);

    public List<Resources> queryResourcesListWithSelected(Integer rid);

    public List<MenuTempt> loadMenu1(Integer userId);

    public List<Resources> loadMenu2(Integer parentId);
}