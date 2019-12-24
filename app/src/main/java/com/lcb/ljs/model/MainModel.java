package com.lcb.ljs.model;


import com.lcb.ljs.bean.BannerData;
import com.lcb.ljs.bean.BaseObjectBean;
import com.lcb.ljs.bean.LoginBean;
import com.lcb.ljs.contract.MainContract;
import com.lcb.ljs.net.RetrofitClient;

import io.reactivex.Flowable;

public class MainModel implements MainContract.Model {

    @Override
    public Flowable<BaseObjectBean<LoginBean>> login(String username, String password) {
        return RetrofitClient.getInstance().getApi().login(username, password);
    }


    @Override
    public Flowable<BannerData> getBanner() {
        return RetrofitClient.getInstance().getApi().getBanner();
    }

}
