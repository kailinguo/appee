package com.ssm.common.annotation;

import java.lang.annotation.*;

/**
 * Created by KaiLin.Guo on 2018-03-20.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BussiServiceLog {
    /**
     * 日志描述
     */
    String description()  default "";

    /**
     * 操作表类型
     */
    int tableType() default 0;
}
