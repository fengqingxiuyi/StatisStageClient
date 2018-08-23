package com.fqxyi.statisstageclient.common.util;

import android.text.TextUtils;
import android.widget.Toast;

import com.fqxyi.statisstageclient.common.global.GlobalUtils;

/**
 * @author ShenBF
 * @描述: Toast工具类
 * @date 2018/6/8
 */
public class ToastUtils {

    public static void toast(CharSequence text) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        Toast.makeText(GlobalUtils.appContext, text, Toast.LENGTH_SHORT).show();
    }

}
