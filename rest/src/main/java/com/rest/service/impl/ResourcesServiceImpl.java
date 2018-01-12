package com.rest.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.rest.mapper.ResourcesMapper;
import com.rest.model.MenuTempt;
import com.rest.model.Resources;
import com.rest.model.User;
import com.rest.service.ResourcesService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yangqj on 2017/4/25.
 */
@Service("resourcesService")
public class ResourcesServiceImpl extends BaseService<Resources> implements ResourcesService {
   @Resource
    private ResourcesMapper resourcesMapper;

    @Override
    public PageInfo<Resources> selectByPage(Resources resources, int start, int length) {
        int page = start/length+1;
        Example example = new Example(Resources.class);
        //分页查询
        PageHelper.startPage(page, length);
        List<Resources> userList = selectByExample(example);
        return new PageInfo<>(userList);
    }

    @Override
    public List<Resources> queryAll(){
        return resourcesMapper.queryAll();
    }

    @Override
    @Cacheable(cacheNames="resources",key="#map['userid'].toString()+#map['type']")
    public List<Resources> loadUserResources(Map<String, Object> map) {
        return resourcesMapper.loadUserResources(map);
    }

    @Override
    public List<Resources> queryResourcesListWithSelected(Integer rid) {
        return resourcesMapper.queryResourcesListWithSelected(rid);
    }

    @Override
    @Cacheable(cacheNames="menuList",key="#userId")
    public String loadMenu(Integer userId) {
        StringBuilder result = new StringBuilder();

        List<MenuTempt> tempts = resourcesMapper.loadMenu1(userId);
        for (MenuTempt tempt : tempts) {
            StringBuilder buffer = new StringBuilder();

            result.append("<li>");
            result.append("<a href=\"").append(tempt.getResurl()).append("\"><i class=\"fa fa-envelope\"></i> <span class=\"nav-label\">")
            .append(tempt.getName());
            List<Resources> resources = resourcesMapper.loadMenu2(tempt.getId());
            if (resources != null && !resources.isEmpty()) {
                // 下拉效果
                result.append("</span><span class=\"fa arrow\">");
                result.append("</span></a>");

                result.append("<ul class=\"nav nav-second-level collapse\">");
                for (Resources re : resources) {
                    buffer.append("<li>");
                    buffer.append("<a href=\"").append(re.getResurl()).append("\"><i class=\"fa fa-envelope\"></i> <span class=\"nav-label\">")
                            .append(re.getName()).append("</span></a>");
                    buffer.append("</li>");
                }
                result.append(buffer);
                result.append("</ul>");
            } else {
                result.append("</span></a>");
            }

            result.append("</li>");
        }

        return result.toString();
    }
}
