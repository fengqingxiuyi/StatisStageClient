package com.fqxyi.statisstageclient;

import android.app.Application;

import com.fqxyi.network.RequestManager;
import com.fqxyi.network.callback.IInterceptorCallback;
import com.fqxyi.statisstageclient.common.constant.API;
import com.fqxyi.statisstageclient.common.global.GlobalUtils;
import com.fqxyi.statisstageclient.common.interceptor.HeaderInterceptor;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;

/**
 * @author ShenBF
 * @描述: Application
 * @date 2018/2/27
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        GlobalUtils.appContext = getApplicationContext();

        RequestManager.get().init(this, API.API_BASE, new IInterceptorCallback() {
            @Override
            public List<Interceptor> getInterceptorList() {
                List<Interceptor> interceptorList = new ArrayList<>();
                interceptorList.add(new HeaderInterceptor(GlobalUtils.appContext));
                return interceptorList;
            }
        });
    }

}
