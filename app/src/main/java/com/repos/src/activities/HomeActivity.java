package com.repos.src.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.repos.src.R;
import com.repos.src.fragments.RepositoriesListFragmentBuilder;

import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setActionBar();

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_repos_container);

        if (fragment == null) {
            RepositoriesListFragmentBuilder filteredChantsFragmentBuilder = new RepositoriesListFragmentBuilder();
            fragment = filteredChantsFragmentBuilder.build();

            fm.beginTransaction()
                    .add(R.id.fragment_repos_container, fragment)
                    .commit();
        }
    }

    public void setActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.home_activity_actionbar_layout);
        View actionBarCustomView = actionBar.getCustomView();
        ButterKnife.bind(this, actionBarCustomView);
        setActionbarFeatures(actionBarCustomView, actionBar);
    }

    public void setActionbarFeatures(View customView, ActionBar actionBar) {
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        Toolbar parent = (Toolbar) customView.getParent();
        parent.setContentInsetsAbsolute(0, 0);
    }
}
