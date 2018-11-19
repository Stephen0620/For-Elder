package com.example.stephen.forelder;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class List extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.title_bar));

        if(Build.VERSION.SDK_INT<16){
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }else{
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_VISIBLE;
            decorView.setSystemUiVisibility(uiOptions);
        }

        ImageButton list_1 = (ImageButton) findViewById(R.id.list_1);
        final Intent intent = new Intent(this,Detail.class);
        list_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Category", "category_1");
                startActivity(intent);
            }
        });

        ImageButton list_2 = (ImageButton) findViewById(R.id.list_2);
        list_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Category", "category_2");
                startActivity(intent);
            }
        });

        ImageButton list_3 = (ImageButton) findViewById(R.id.list_3);
        list_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Category", "category_3");
                startActivity(intent);
            }
        });

        ImageButton list_4 = (ImageButton) findViewById(R.id.list_4);
        list_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Category", "category_4");
                startActivity(intent);
            }
        });

        ImageButton list_5 = (ImageButton) findViewById(R.id.list_5);
        list_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Category", "category_5");
                startActivity(intent);
            }
        });

        ImageButton list_6 = (ImageButton) findViewById(R.id.list_6);
        list_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Category", "category_6");
                startActivity(intent);
            }
        });

        ImageButton list_7 = (ImageButton) findViewById(R.id.list_7);
        list_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Category", "category_7");
                startActivity(intent);
            }
        });

        ImageButton list_8 = (ImageButton) findViewById(R.id.list_8);
        list_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Category", "category_8");
                startActivity(intent);
            }
        });

        ImageButton list_9 = (ImageButton) findViewById(R.id.list_9);
        list_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Category", "category_9");
                startActivity(intent);
            }
        });

        ImageButton list_10 = (ImageButton) findViewById(R.id.list_10);
        list_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Category", "category_10");
                startActivity(intent);
            }
        });

        ImageButton list_11 = (ImageButton) findViewById(R.id.list_11);
        list_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Category", "category_11");
                startActivity(intent);
            }
        });

        ImageButton list_12 = (ImageButton) findViewById(R.id.list_12);
        list_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("Category", "category_12");
                startActivity(intent);
            }
        });
    }
}
