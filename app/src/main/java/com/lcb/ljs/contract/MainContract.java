package com.lcb.ljs.contract;


import com.lcb.ljs.base.BaseView;
import com.lcb.ljs.bean.BannerData;
import com.lcb.ljs.bean.BaseObjectBean;
import com.lcb.ljs.bean.LoginBean;

import io.reactivex.Flowable;

public interface MainContract {
    interface Model {
        /**
         * 登陆
         *
         * @param username 用户名
         * @param password 密码
         * @return 登录数据
         */
        Flowable<BaseObjectBean<LoginBean>> login(String username, String password);


        /**
         * 获取Banner数据
         *
         * @return Banner数据
         */
        Flowable<BannerData> getBanner();
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(BaseObjectBean<LoginBean> bean);

        void onBannerSuccess(BannerData bean);
    }

    interface Presenter {
        /**
         * 登陆
         *
         * @param username 用户名
         * @param password 密码
         */
        void login(String username, String password);

        /**
         * 获取Banner数据
         */
        void getBanner();
    }
}
