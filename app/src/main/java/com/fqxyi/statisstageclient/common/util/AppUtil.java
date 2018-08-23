package com.fqxyi.statisstageclient.common.util;

import android.content.Context;
import android.content.pm.PackageManager;

import com.fqxyi.network.util.LogUtil;

/**
 * @author ShenBF
 * @描述: App信息获取类
 * @date 2018/2/27
 */
public class AppUtil {

    /**
     * 当前版本
     */
    public static String getAppVersion(Context context) {
        String version = "";
        try {
            version = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.e(e);
        }
        return version;
    }

    /**
     * 当前版本号
     */
    public static int getAppVersionCode(Context context) {
        int version = 1;
        try {
            version = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.e(e);
        }
        return version;
    }

}
