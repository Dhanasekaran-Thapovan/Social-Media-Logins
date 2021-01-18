package com.ds.thapovan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

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
        drawerfun();
        Integer frag = getIntent().getIntExtra(AppConstants.FRAGMENT_ID, 0);
        switch (frag) {
            case 1:
                setNewFragment(new FragmentHome(), "Home", false);
                break;
            case 2:
                setNewFragment(new FragmentProfile(), "Profile", false);
                break;
            case 3:
                setNewFragment(new FragmentDate(), "Date", false);
                break;
            case 4:
                setNewFragment(new FragmentAddUser(), "AddUSer", false);
                break;
        }

    }

    private void drawerfun() {
        menuDrawer = new ActionBarDrawerToggle(this, drawerLayout, homeActionBar, R.string.app_name, R.string.app_name);
        menuDrawer.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(this);
        menuDrawer.syncState();
    }

    @OnClick({R.id.nav_profile, R.id.nav_date, R.id.nav_add})
    public void onClick(View view) {
        Intent nxtIntent = null;
        switch (view.getId()) {
            case R.id.nav_profile:
                nxtIntent = new Intent(this, DashboardActivity.class).putExtra(AppConstants.FRAGMENT_ID, AppConstants.FRAGMENT_PROFILE);
                break;
            case R.id.nav_date:
                nxtIntent = new Intent(this, DashboardActivity.class).putExtra(AppConstants.FRAGMENT_ID, AppConstants.FRAGMENT_DATE);
                break;
            case R.id.nav_add:
                nxtIntent = new Intent(this, DashboardActivity.class).putExtra(AppConstants.FRAGMENT_ID, AppConstants.FRAGMENT_ADD_USER);
                break;
        }
        if (nxtIntent != null) {
            startActivity(nxtIntent);
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