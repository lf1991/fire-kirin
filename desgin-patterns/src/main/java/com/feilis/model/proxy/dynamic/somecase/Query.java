package com.feilis.model.proxy.dynamic.somecase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName GET
 * @Description TODO GET请求接口
 * @Author lf199
 * @Date 2020/10/20 10:01
 * @Version V1.0
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Query {
    String value();
}
