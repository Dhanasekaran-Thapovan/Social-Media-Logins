package com.ds.thapovan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardActivity extends AppCompatActivity implements DrawerLayout.DrawerListener {

    private AppPreferences preferences;
    private ActionBarDrawerToggle menuDrawer;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.home_actionbar)
    Toolbar homeActionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        preferences = new AppPreferences(this);
        setSupportActionBar(homeActionBar);
        drawerfun();
        setFragment(1);

    }

    private void drawerfun() {
        menuDrawer = new ActionBarDrawerToggle(this, drawerLayout, homeActionBar, R.string.app_name, R.string.app_name);
        menuDrawer.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(this);
        menuDrawer.syncState();
    }

    @OnClick({R.id.nav_home,R.id.nav_profile, R.id.nav_userinfo, R.id.nav_add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nav_home:
                setFragment(1);
                break; 
                case R.id.nav_profile:
                setFragment(AppConstants.FRAGMENT_PROFILE);
                break;
            case R.id.nav_userinfo:
                setFragment(AppConstants.FRAGMENT_DATE);
                break;
            case R.id.nav_add:
                setFragment(AppConstants.FRAGMENT_ADD_USER);
                break;
        }
        drawerLayout.closeDrawers();

    }
    public void setFragment(Integer fragmentId){
        switch (fragmentId) {
            case 1:
                setNewFragment(new FragmentHome(), "Home", false);
                getSupportActionBar().setTitle(R.string.home);
                break;
            case 2:
                setNewFragment(new FragmentProfile(), "Profile", false);
                getSupportActionBar().setTitle(R.string.profile);
                break;
            case 3:
                setNewFragment(new FragmentDate(), "UserInfo", false);
                getSupportActionBar().setTitle(R.string.user_info);
                break;
            case 4:
                setNewFragment(new FragmentAddUser(), "AddUSer", false);
                getSupportActionBar().setTitle(R.string.add_user);
                break;
        }

    }


    @Override
    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

    }

    @Override
    public void onDrawerOpened(@NonNull View drawerView) {

    }

    @Override
    public void onDrawerClosed(@NonNull View drawerView) {

    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }

    private void setNewFragment(Fragment fragment, String title, Boolean addBackStack) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.flayout, fragment);
        if (addBackStack) transaction.addToBackStack(title);
        transaction.commit();
    }
}