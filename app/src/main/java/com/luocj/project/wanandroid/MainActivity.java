package com.luocj.project.wanandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.luocj.project.wanandroid.activity.BaseActivity;
import com.luocj.project.wanandroid.fragment.HomeFragment;
import com.luocj.project.wanandroid.fragment.MineLoginFragment;
import com.luocj.project.wanandroid.fragment.ProjectFragment;
import com.luocj.project.wanandroid.fragment.MineFragment;
import com.luocj.project.wanandroid.fragment.TiXiFragment;
import com.luocj.project.wanandroid.utils.Constants;
import com.luocj.project.wanandroid.utils.SPUtils;
import com.tencent.bugly.crashreport.CrashReport;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String url = "http://api.tianapi.com/social/?key=861a794733dd2b057e415d822bef9586&num=1";
    private FrameLayout container;
    private ImageView home;
    private ImageView tixi;
    private ImageView hot;
    private ImageView mine;
    private ArrayList<Fragment> fragments;
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    private static final int FOUTH = 4;
    private int currentTab = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SPUtils.putBoolean(MainActivity.this, Constants.LOGIN, false);
        initView();

    }

    private void initView() {
        container = findViewById(R.id.fl_container);
        home = findViewById(R.id.iv_home);
        tixi = findViewById(R.id.iv_tixi);
        hot = findViewById(R.id.iv_hot);
        mine = findViewById(R.id.iv_mine);
        home.setOnClickListener(this);
        tixi.setOnClickListener(this);
        hot.setOnClickListener(this);
        mine.setOnClickListener(this);

        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new TiXiFragment());
        fragments.add(new ProjectFragment());
        fragments.add(new MineFragment());
        fragments.add(new MineLoginFragment());

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fl_container, fragments.get(ZERO));
        currentTab = ZERO;
        home.setSelected(true);
        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.iv_home:
                changeTab(ZERO);
                break;
            case R.id.iv_tixi:
                changeTab(ONE);
                break;
            case R.id.iv_hot:
                changeTab(TWO);
                break;
            case R.id.iv_mine:
                if (!SPUtils.getBoolean(MainActivity.this, Constants.LOGIN, false)) {
                    changeTab(THREE);
                } else {
                    changeTab(FOUTH);
                }

                break;

        }

    }

    public void changeTab(int index) {
        if (currentTab == index) {
            return;
        }
        Fragment fragment = fragments.get(index);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (!fragment.isAdded()) {
            ft.add(R.id.fl_container, fragment);
        }

        ft.hide(fragments.get(currentTab));
        ft.show(fragments.get(index));
        changeTabStatus(currentTab, false);
        currentTab = index;
        changeTabStatus(currentTab, true);
        if (!this.isFinishing()) {
            ft.commitAllowingStateLoss();
        }
    }

    private void changeTabStatus(int currentTab, boolean isSelect) {
        switch (currentTab) {
            case ZERO:
                home.setSelected(isSelect);
                break;
            case ONE:
                tixi.setSelected(isSelect);
                break;
            case TWO:
                hot.setSelected(isSelect);
                break;
            case THREE:
                mine.setSelected(isSelect);
                break;
            case FOUTH:
                mine.setSelected(isSelect);
                break;

        }
    }
}
