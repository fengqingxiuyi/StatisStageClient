package com.fqxyi.statisstageclient.common.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.fqxyi.statisstageclient.R;

/**
 * @author ShenBF
 * @描述: LoadingView
 * @date 2018/2/27
 */
public class LoadingView extends Dialog {

    public LoadingView(Context context) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_loading);
    }
}
