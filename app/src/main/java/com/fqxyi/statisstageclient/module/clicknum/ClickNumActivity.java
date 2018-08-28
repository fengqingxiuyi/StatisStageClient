package com.fqxyi.statisstageclient.module.clicknum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.fqxyi.network.RequestManager;
import com.fqxyi.network.bean.ErrorBean;
import com.fqxyi.network.callback.IResponseCallback;
import com.fqxyi.network.tag.ReqTag;
import com.fqxyi.statisstageclient.R;
import com.fqxyi.statisstageclient.common.util.GsonUtil;
import com.fqxyi.statisstageclient.common.util.ToastUtils;
import com.fqxyi.statisstageclient.common.view.LoadingView;
import com.fqxyi.statisstageclient.module.clicknum.bean.ClickNumApiService;
import com.fqxyi.statisstageclient.module.clicknum.bean.ClickNumBean;

/**
 * @author ShenBF
 * @描述: ClickNumActivity
 * @date 2018/2/27
 */
public class ClickNumActivity extends AppCompatActivity {

    //findView
    WebView webView;
    //loading
    LoadingView loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_num);
        //findView
        webView = findViewById(R.id.web_view);
        WebSettings webSettings = webView.getSettings();
        //设置与Js交互的权限
        webSettings.setJavaScriptEnabled(true);
        //设置加载进来的页面自适应手机屏幕
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webView.loadUrl("http://vue.fqxyi.com/statisstagefe/");
        //loading
        loading = new LoadingView(this);
    }

    public void setEventOne(View view) {
        showLoading();
        RequestManager.get().async(
                RequestManager.get().create(ClickNumApiService.class).set("事件1"),
                new IResponseCallback<ClickNumBean>() {
                    @Override
                    public void onSuccess(ReqTag reqTag, ClickNumBean response) {
                        hideLoading();
                        ToastUtils.toast("response = " + GsonUtil.GsonToString(response));
                    }

                    @Override
                    public void onError(ReqTag reqTag, ErrorBean errorBean) {
                        hideLoading();
                        ToastUtils.toast("errorBean = " + GsonUtil.GsonToString(errorBean));
                    }
                }
        );
    }

    public void setEventTwo(View view) {
        showLoading();
        RequestManager.get().async(
                RequestManager.get().create(ClickNumApiService.class).set("事件2"),
                new IResponseCallback<ClickNumBean>() {
                    @Override
                    public void onSuccess(ReqTag reqTag, ClickNumBean response) {
                        hideLoading();
                        ToastUtils.toast("response = " + GsonUtil.GsonToString(response));
                    }

                    @Override
                    public void onError(ReqTag reqTag, ErrorBean errorBean) {
                        hideLoading();
                        ToastUtils.toast("errorBean = " + GsonUtil.GsonToString(errorBean));
                    }
                }
        );
    }

    public void setEventThree(View view) {
        showLoading();
        RequestManager.get().async(
                RequestManager.get().create(ClickNumApiService.class).set("事件3"),
                new IResponseCallback<ClickNumBean>() {
                    @Override
                    public void onSuccess(ReqTag reqTag, ClickNumBean response) {
                        hideLoading();
                        ToastUtils.toast("response = " + GsonUtil.GsonToString(response));
                    }

                    @Override
                    public void onError(ReqTag reqTag, ErrorBean errorBean) {
                        hideLoading();
                        ToastUtils.toast("errorBean = " + GsonUtil.GsonToString(errorBean));
                    }
                }
        );
    }

    /**
     * 刷新WebView
     */
    public void refresh(View view) {
        webView.reload();
    }

    private void showLoading() {
        if (loading != null && !loading.isShowing()) {
            loading.show();
        }
    }

    private void hideLoading() {
        if (loading != null) {
            loading.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loading = null;
    }

}
