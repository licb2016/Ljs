package com.lcb.ljs.ui.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lcb.ljs.R;
import com.lcb.ljs.base.BaseFragment;
import com.lcb.ljs.base.BaseMvpActivity;
import com.lcb.ljs.bean.BannerData;
import com.lcb.ljs.bean.BaseObjectBean;
import com.lcb.ljs.contract.MainContract;
import com.lcb.ljs.presenter.MainPresenter;
import com.lcb.ljs.ui.fragment.MainPagerFragment;
import com.lcb.ljs.util.ProgressDialog;
import com.lcb.ljs.util.StatusBarUtil;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author lcb
 */
public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {


    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.common_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.common_toolbar_title_tv)
    TextView mTitleTv;
    @BindView(R.id.main_floating_action_btn)
    FloatingActionButton mFloatingActionButton;
    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView mBottomNavigationView;
    @BindView(R.id.nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.fragment_group)
    FrameLayout mFrameGroup;

    private ArrayList<BaseFragment> mFragments;
    private TextView mUsTv;

    private MainPagerFragment mMainPagerFragment;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowTitleEnabled(false);
        mTitleTv.setText(getString(R.string.home_pager));
        StatusBarUtil.setStatusColor(getWindow(), ContextCompat.getColor(this, R.color.main_status_bar_blue), 1f);
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @OnClick({R.id.main_floating_action_btn})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_floating_action_btn:
                break;
            default:
                break;
        }
    }


    @Override
    public void onSuccess(BaseObjectBean bean) {
        Toast.makeText(this, bean.toString(), Toast.LENGTH_SHORT).show();
        Logger.d(bean.toString());
    }


    @Override
    public void onBannerSuccess(BannerData bean) {
//        if (bean.getData() != null) {
//            List<BannerData.DataBean> bannerDataList = bean.getData();
//            List<String> bannerImageList = new ArrayList<>();
//            List<String>  mBannerTitleList = new ArrayList<>();
//            for (BannerData.DataBean bannerData : bannerDataList) {
//                mBannerTitleList.add(bannerData.getTitle());
//                bannerImageList.add(bannerData.getImagePath());
//            }
//            //设置banner样式
//            mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
//            //设置图片加载器
//            mBanner.setImageLoader(new GlideImageLoader());
//            //设置图片集合
//            mBanner.setImages(bannerImageList);
//            //设置banner动画效果
//            mBanner.setBannerAnimation(Transformer.DepthPage);
//            //设置标题集合（当banner样式有显示title时）
//            mBanner.setBannerTitles(mBannerTitleList);
//            //设置自动轮播，默认为true
//            mBanner.isAutoPlay(true);
//            //设置轮播时间
//            mBanner.setDelayTime(bannerDataList.size() * 400);
//            //设置指示器位置（当banner模式中有指示器时）
//            mBanner.setIndicatorGravity(BannerConfig.CENTER);
//
//            //banner设置方法全部调用完毕时最后调用
//            mBanner.start();
//
//        }
    }

    @Override
    public void showLoading() {
        ProgressDialog.getInstance().show(this);
    }

    @Override
    public void hideLoading() {
        ProgressDialog.getInstance().dismiss();
    }

    @Override
    public void onError(Throwable throwable) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected void onViewCreated() {

    }

}
