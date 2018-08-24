package com.fqxyi.statisstageclient.module.clicknum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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

    private static final String NAME_CLICK_NUM = "NAME_CLICK_NUM";

    //loading
    LoadingView loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_num);
        //loading
        loading = new LoadingView(this);
    }

    public void setClickNum(View view) {
        showLoading();
        RequestManager.get().async(
                RequestManager.get().create(ClickNumApiService.class).set(NAME_CLICK_NUM),
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

    public void getClickNum(View view) {
        showLoading();
        RequestManager.get().async(
                RequestManager.get().create(ClickNumApiService.class).get(NAME_CLICK_NUM),
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

    public void delClickNum(View view) {
        showLoading();
        RequestManager.get().async(
                RequestManager.get().create(ClickNumApiService.class).del(NAME_CLICK_NUM),
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
