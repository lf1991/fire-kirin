package com.feilis.model.proxy.dynamic.somecase;


import java.util.Observable;

/**
 * @ClassName ApiService
 * @Description TODO
 * @Author lf199
 * @Date 2020/10/20 10:12
 * @Version V1.0
 */
public interface ApiService {

    @POST("http://www.baidu.com/login")
    Observable login(@Query("userName") String userName, @Query("password") String password);


    @GET("http://www.baidu.com/checkupdate")
    Observable checkUpdate(@Query("version") String version);
}
