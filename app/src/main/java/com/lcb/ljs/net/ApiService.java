package com.lcb.ljs.net;



import com.lcb.ljs.bean.BannerData;
import com.lcb.ljs.bean.BaseObjectBean;
import com.lcb.ljs.bean.LoginBean;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * @author lcb
 */
public interface ApiService {

    /**
     * 登陆
     * http://www.wanandroid.com/user/login
     *
     * @param username user name
     * @param password password
     * @return 登陆数据
     */
    @POST("user/login")
    @FormUrlEncoded
    Flowable<BaseObjectBean<LoginBean>> login(@Field("username") String username,
                                              @Field("password") String password);


    /**
     * https://www.wanandroid.com/banner/json
     *
     * @return Banner数据
     */
    @GET("banner/json")
    Flowable<BannerData> getBanner();

}
