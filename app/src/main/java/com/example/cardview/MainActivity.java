package com.example.cardview;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardview.Adapter.RowAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycle;
    LinearLayoutManager manager;
    RowAdapter adapter;
    int currentitems,totalitems,lastitem;
    ArrayList<String> list;
    ProgressBar bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycle=(RecyclerView)findViewById(R.id.recycle);
        bar=(ProgressBar)findViewById(R.id.bar);

        String[] a={"1","1","1","1","1"};
        list=new ArrayList(Arrays.asList(a));

        manager=new LinearLayoutManager(this);
        recycle.setLayoutManager(manager);
        adapter=new RowAdapter(this,list);
        recycle.setAdapter(adapter);

        recycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                currentitems=manager.getChildCount();
                totalitems=manager.getItemCount();
                lastitem=manager.findLastVisibleItemPosition();

                if(lastitem==totalitems-1){

                    data();

                }
            }
        });

    }

    private void data(){

        bar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                for(int i=1;i<=5;i++){

                    list.add("1");
                    adapter.notifyDataSetChanged();
                    bar.setVisibility(View.GONE);
                }
            }
        },1000);



    }


}
