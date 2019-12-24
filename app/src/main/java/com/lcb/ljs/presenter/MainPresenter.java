package com.lcb.ljs.presenter;

import com.lcb.ljs.base.BasePresenter;
import com.lcb.ljs.bean.BannerData;
import com.lcb.ljs.bean.BaseObjectBean;
import com.lcb.ljs.bean.LoginBean;
import com.lcb.ljs.contract.MainContract;
import com.lcb.ljs.model.MainModel;
import com.lcb.ljs.net.RxScheduler;

import io.reactivex.functions.Consumer;


/**
 * @author lcb
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private MainContract.Model model;

    public MainPresenter() {
        model = new MainModel();
    }

    @Override
    public void login(String username, String password) {

        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.login(username, password)
                .compose(RxScheduler.<BaseObjectBean<LoginBean>>Flo_io_main())
                .as(mView.<BaseObjectBean<LoginBean>>bindAutoDispose())
                .subscribe(new Consumer<BaseObjectBean<LoginBean>>() {
                    @Override
                    public void accept(BaseObjectBean<LoginBean> bean) throws Exception {
                        mView.onSuccess(bean);
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }

    @Override
    public void getBanner() {
        //View是否绑定 如果没有绑定，就不执行网络请求
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        model.getBanner()
                .compose(RxScheduler.<BannerData>Flo_io_main())
                .as(mView.<BannerData>bindAutoDispose())
                .subscribe(new Consumer<BannerData>() {
                    @Override
                    public void accept(BannerData bean) throws Exception {
                        mView.onBannerSuccess(bean);
                        mView.hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onError(throwable);
                        mView.hideLoading();
                    }
                });
    }
}
