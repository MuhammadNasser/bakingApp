package com.udacity.android.bakingapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.udacity.android.bakingapp.fragments.RecipesFragment;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_RECIPE_ITEM = "recipe_item";
    ProgressBar progressBar;
    TextView textViewTitle;
    public static boolean isTabletView = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        FragmentManager fragmentManager = getSupportFragmentManager();
        RecipesFragment recipesFragment = new RecipesFragment();
        if (findViewById(R.id.frameLayoutTablet) != null) {
            isTabletView = true;
            fragmentManager.beginTransaction()
                    .replace(R.id.frameLayoutTablet, recipesFragment)
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, recipesFragment)
                    .commit();
        }

        setToolBar();
    }

    private void setToolBar() {

        Toolbar toolBar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolBar);

        textViewTitle = (TextView) findViewById(R.id.tv_title);

        setActivityTitle(R.string.app_name);
    }

    public void setActivityTitle(int title) {
        if (textViewTitle != null) {
            textViewTitle.setText(title);
        }
    }

    public void isLoading(boolean isLoading) {
        progressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);
    }

}