package com.example.stephen.forelder;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Detail extends AppCompatActivity implements MainCallbacks{

    FragmentTransaction ft;
    FragmentLeft leftFragment;
    FragmentRight rightFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.title_bar));

        ft = getFragmentManager().beginTransaction();
        leftFragment = FragmentLeft.newInstance("Left Fragment");
        ft.replace(R.id.holder_left,leftFragment);
        ft.commit();

        ft = getFragmentManager().beginTransaction();
        rightFragment = FragmentRight.newInstance("Right Fragment");
        ft.replace(R.id.holder_right,rightFragment);
        ft.commit();

        Button purchase = (Button)findViewById(R.id.purchase);
        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://happyelder.com.tw/HappyShop/";
                Intent website = new Intent(Intent.ACTION_VIEW);
                website.setData(Uri.parse(url));
                startActivity(website);
            }
        });
    }

    @Override
    public void onMsgFromFragToMain(Integer position) {
        rightFragment.onMsgFromMainToFragment(position);
    }
}
