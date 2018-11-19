package com.example.stephen.forelder;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        Bundle extras = getIntent().getExtras();
        String category = extras.getString("Category");

        ft = getFragmentManager().beginTransaction();
        leftFragment = FragmentLeft.newInstance(category);
        ft.replace(R.id.holder_left,leftFragment);
        ft.commit();

        ft = getFragmentManager().beginTransaction();
        rightFragment = FragmentRight.newInstance(category);
        ft.replace(R.id.holder_right,rightFragment);
        ft.commit();

        TextView title = (TextView)findViewById(R.id.title);
        TextView description = (TextView)findViewById(R.id.description);
        TextView dimension = (TextView)findViewById(R.id.dimension);
        TextView weight = (TextView)findViewById(R.id.weight);
        TextView material = (TextView)findViewById(R.id.material);

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
