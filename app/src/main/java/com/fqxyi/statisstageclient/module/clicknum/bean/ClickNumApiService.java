package com.fqxyi.statisstageclient.module.clicknum.bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author ShenBF
 * @描述: Api接口声明类
 * @date 2018/2/27
 */
public interface ClickNumApiService {

    @GET("/statisstageserver/set")
    Observable<ClickNumBean> set(@Query("name") String name);

    @GET("/statisstageserver/get")
    Observable<ClickNumBean> get(@Query("name") String name);

    @GET("/statisstageserver/del")
    Observable<ClickNumBean> del(@Query("name") String name);

}
