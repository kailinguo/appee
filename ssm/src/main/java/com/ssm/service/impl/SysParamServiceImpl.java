package com.ssm.service.impl;


import com.ssm.common.annotation.BussiServiceLog;
import com.ssm.common.constant.SysConstant;
import com.ssm.service.SysParamService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by KaiLin.Guo on 2017-10-16.
 */
@Service
public class SysParamServiceImpl implements SysParamService {

    /**
     * 日志记录
     */
    private static final Logger LOGGER = Logger.getLogger(SysParamServiceImpl.class);

    @Override
    @BussiServiceLog(description = SysConstant.SYS_PARAM_EDIT, tableType = SysConstant.SYS_PARAM)
    public void edit(Integer paramKey, Integer paramValue) {
        LOGGER.info("success");
    }

}
