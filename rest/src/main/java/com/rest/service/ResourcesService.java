package com.rest.service;

import com.github.pagehelper.PageInfo;
import com.rest.model.MenuTempt;
import com.rest.model.Resources;

import java.util.List;
import java.util.Map;

/**
 * Created by yangqj on 2017/4/25.
 */
public interface ResourcesService extends IService<Resources> {
    PageInfo<Resources> selectByPage(Resources resources, int start, int length);

    List<Resources> queryAll();

    List<Resources> loadUserResources(Map<String,Object> map);

    List<Resources> queryResourcesListWithSelected(Integer rid);

    String loadMenu(Integer userId);
}
