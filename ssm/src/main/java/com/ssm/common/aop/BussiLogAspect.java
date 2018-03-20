package com.ssm.common.aop;

import com.ssm.common.annotation.BussiServiceLog;
import com.ssm.dao.BussiLogDao;
import com.ssm.model.BussiLog;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by KaiLin.Guo on 2018-03-20.
 */
@Aspect
@Component
@SuppressWarnings("rawtypes")
public class BussiLogAspect {

    @Autowired
    private BussiLogDao bussiLogDao;

    /**
     * 日志记录
     */
    private static final Logger LOGGER = Logger.getLogger(BussiLogAspect.class);

    /**
     * Service层切点
     */
    @Pointcut("@annotation(com.ssm.common.annotation.BussiServiceLog)")
    public void serviceAspect() {

    }

    /**
     * 获取注解参数，记录日志
     * @param joinPoint
     */
    @After("serviceAspect()")
    public void doServiceLog(JoinPoint joinPoint) {
        LOGGER.info("日志记录");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取用户信息
        try {
            //数据库日志
            BussiLog bussiLog = new BussiLog();
            bussiLog.setTableNo(getServiceMthodTableType(joinPoint));
            //获取日志描述信息
            String description = getServiceMthodDescription(joinPoint);
            bussiLog.setOpUser("gkl");
            bussiLog.setRemark(bussiLog.getOpUser() + description);
            bussiLog.setContent(getServiceMthodParams(joinPoint));
            bussiLog.setCreatedTime(new Date());
            bussiLogDao.save(bussiLog);
        }  catch (Exception e) {
            LOGGER.error("异常信息:{}", e);
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于service层注解
     * @param joinPoint
     * @return
     * @throws Exception
     */
    private String getServiceMthodDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for(Method method : methods) {
            if(method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if(clazzs.length == arguments.length) {
                    description = method.getAnnotation(BussiServiceLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

    /**
     * 获取注解中对方法的数据表类型 用于service层注解
     * @param joinPoint
     * @return
     * @throws Exception
     */
    private int getServiceMthodTableType(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        int tableType = 0;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    tableType = method.getAnnotation(BussiServiceLog.class).tableType();
                    break;
                }
            }
        }
        return tableType;
    }

    /**
     * 获取json格式的参数
     * @param joinPoint
     * @return
     * @throws Exception
     */
    private String getServiceMthodParams(JoinPoint joinPoint)
            throws Exception {
        Object[] arguments = joinPoint.getArgs();
        String params = JSONArray.fromObject(arguments).toString();
        return params;
    }

}
