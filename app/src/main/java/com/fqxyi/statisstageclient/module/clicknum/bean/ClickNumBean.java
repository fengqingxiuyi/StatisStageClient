package com.fqxyi.statisstageclient.module.clicknum.bean;

import java.util.List;

/**
 * @author ShenBF
 * @描述: ClickNumBean
 * @date 2018/2/27
 */
public class ClickNumBean {

    public int resultCode;
    public String resultMessage;
    public DataBean data;

    public static class DataBean {
        public String name;
        public List<DateBeanBean> dateBean;

        public static class DateBeanBean {
            public String date;
            public int num;
        }
    }

}
