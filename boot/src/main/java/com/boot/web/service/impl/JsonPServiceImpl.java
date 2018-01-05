package com.boot.web.service.impl;

import com.boot.web.dao.JsonPMapper;
import com.boot.web.entity.JsonPTo;
import com.boot.web.service.JsonPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by KaiLin.Guo on 2017-10-16.
 */
@Service
public class JsonPServiceImpl implements JsonPService {

    @Autowired
    private JsonPMapper jsonPMapper;

    @Override
    public List<JsonPTo> testJsonp() {
        List<JsonPTo> sysParams = jsonPMapper.testJsonp();

        return sysParams;
    }

}
