package com.feilis.model.proxy.dynamic.somecase;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Observable;

/**
 * @ClassName RequestHandler
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/20 10:22
 * @Version V1.0
 */
public class RequestHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Annotation[] annotations = method.getAnnotations();//获取方法注解
        if (annotations == null || annotations.length == 0) return null;

        Annotation annotation = annotations[0];

        if (annotation instanceof GET) {
            GET get = (GET) annotation;
        }
        return null;
    }

    /**
     * 功能描述: <br> 请求处理机制
     * 〈〉
     *
     * @Param: [method, get, params]
     * @Return: java.util.Observable
     * @Author: lf199
     * @Date: 2020/10/20 10:26
     */
    private Observable handleGetRequest(Method method, GET get, Object[] params) {
        String url = get.value();
        Type genericType = method.getGenericReturnType();
        Parameter[] parameters = method.getParameters();

        ParameterizedType parameterizedType = (ParameterizedType) genericType;
        Class returnGenericClazz = null;
        if (parameterizedType != null) {
            Type[] types = parameterizedType.getActualTypeArguments();
            for (int i = 0; i < types.length; i++) {
                Class cls = (Class) types[i];
                returnGenericClazz = cls;
                break;
            }
        }

        //解析请求参数，然后拼接到url
        if (params != null) {
            url += "?";
            for (int i = 0; i < params.length; i++) {
                Query query = parameters[i].getAnnotation(Query.class);
                url += query.value() + "=" + params[0].toString();
                if (i < params.length - 1) {
                    url += "&";
                }
            }
        }


        return null;
    }
}
