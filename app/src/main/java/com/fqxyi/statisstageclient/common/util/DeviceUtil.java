package com.fqxyi.statisstageclient.common.util;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.fqxyi.network.util.LogUtil;

/**
 * @author ShenBF
 * @描述: 设备相关工具类
 * @date 2018/2/27
 */
public class DeviceUtil {

    private static int screenWidth;
    private static int screenHeight;

    /**
     * 获取设备屏幕宽度
     */
    public static int getScreenWidth(Context context) {
        if (screenWidth > 0) {
            return screenWidth;
        }
        getScreenWidthHeight(context);
        return screenWidth;
    }

    /**
     * 获取设备屏幕高度
     */
    public static int getScreenHeight(Context context) {
        if (screenHeight > 0) {
            return screenHeight;
        }
        getScreenWidthHeight(context);
        return screenHeight;
    }

    /**
     * 获取设备屏幕宽度和高度
     */
    private static void getScreenWidthHeight(Context context) {
        try {
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            if (wm != null && wm.getDefaultDisplay() != null) {
                Point point = new Point();
                wm.getDefaultDisplay().getSize(point);
                screenWidth = point.x;
                screenHeight = point.y;
            } else {
                DisplayMetrics dm = context.getResources().getDisplayMetrics();
                screenWidth = dm.widthPixels;
                screenHeight = dm.heightPixels;
            }
        } catch (Throwable e) {
            LogUtil.e(e);
        }
    }

}
