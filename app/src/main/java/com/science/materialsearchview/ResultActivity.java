package com.science.materialsearchview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.science.materialsearch.MaterialSearchView;
import com.science.materialsearch.adapter.SearchAdapter;

/**
 * @author 幸运Science
 * @description
 * @email chentushen.science@gmail.com,274240671@qq.com
 * @data 2016/9/23
 */

public class ResultActivity extends AppCompatActivity {

    private MaterialSearchView materialSearchView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        materialSearchView = (MaterialSearchView) findViewById(R.id.searchView);
        materialSearchView.setVersion(MaterialSearchView.VERSION_TOOLBAR);
        materialSearchView.setTextInput(getIntent().getStringExtra("query"));
        materialSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.e("TAG>>>>>>>>>>", "onQueryTextSubmit:" + query);
                return true;
            }
        });
        final SearchAdapter searchAdapter = materialSearchView.setAdapter();
        searchAdapter.setOnItemClickListener(new SearchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, String queryHistory) {
                Log.e("TAG>>>>>>>>>>", "onItemClick:" + queryHistory);
            }
        });
        materialSearchView.setOnMenuClickListener(new MaterialSearchView.OnMenuClickListener() {
            @Override
            public void onMenuClick() {
                finish();
            }
        });
    }
}
