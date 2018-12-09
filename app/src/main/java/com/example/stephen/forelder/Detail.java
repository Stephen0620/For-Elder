package com.example.stephen.forelder;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
        String TAG = "Detail.java";
        Log.i(TAG, "category: "+ category);

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

        if (category.equals("category_1")){
            title.setText("點春/福賀卡");
            description.setText("新年新氣象，利用簡單點點標籤，即可完成一幅喜氣的賀卡。");
            dimension.setText("20.5 X 20.5 cm");
        } else if(category.equals("category_2")) {
            title.setText("不織布名牌");
            description.setText("透過簡單黏貼可以加強手部和腦部的運作，也可以增加親子之間的時光。");
            dimension.setText("11.5 X 8 cm");
        } else if(category.equals("category_3")) {
            title.setText("包粽鑰匙圈");
            description.setText("小巧可愛的粽子香包，包裹著所有的祝福心意，願收到的人事事如意，考試高中。");
            dimension.setText("20.5 X 20.5 cm (吊環: 5 cm)");
        } else if(category.equals("category_4")) {
            title.setText("包粽鑰匙圈");
            description.setText("小巧可愛的粽子香包，包裹著所有的祝福心意，願收到的人事事如意，考試高中。");
            dimension.setText("20.5 X 20.5 cm (吊環: 5 cm)");
        } else if(category.equals("category_5")) {
            title.setText("馬賽克相框");
            description.setText("方方、圓圓小磁磚再利用修剪、拼貼讓創意無限延伸，貼出屬於自己的相框。");
            dimension.setText("194.5 X 152.5 X 11.21 cm");
        } else if(category.equals("category_6")) {
            title.setText("彩繪枕頭套");
            description.setText("專門的布用畫筆讓自我的想像力飛翔，彩繪出屬於自己的個人創作。");
            dimension.setText("45 X 45 cm");
        } else if(category.equals("category_7")) {
            title.setText("毛線聖誕樹");
            description.setText("溫暖的毛線，透過白膠和簡單的纏繞，完成一顆又一顆的小小聖誕樹，溫暖你我的心中。");
            dimension.setText("6 X 14 cm");
        } else if(category.equals("category_8")) {
            title.setText("史萊姆珍珠奶茶鑰匙圈");
            description.setText("簡單的膠水幻化成繽紛夢幻的珍珠奶茶化身為可愛的鑰匙圈。");
            dimension.setText("3.5 X 2.5 X 3.36cm");
        } else if(category.equals("category_9")) {
            title.setText("翻轉小夜燈");
            description.setText("神奇的小夜燈，利用簡單的翻轉方式，為你的黑夜點亮一盞燈。");
            dimension.setText("14 X 4.7 cm");
        } else if(category.equals("category_10")) {
            title.setText("芭蕾舞者捲捲畫");
            description.setText("美麗的芭蕾舞者圖案加上簡單的紙條，捲阿捲的就完成一幅美麗的畫作。");
            dimension.setText("28 X 20 cm");
        } else if(category.equals("category_11")) {
            title.setText("紮染背袋");
            description.setText("紅色、紫色、綠色，把袋子隨意綁出不同的造型，出來的顏色效果也不同。");
            dimension.setText("39.2 X 30.5 cm (提袋: 52 cm)");
        } else if(category.equals("category_12")) {
            title.setText("藺草杯墊");
            description.setText("傳統藺草，簡單黏貼的方式，搭配自己中意的紙膠袋，化身為一個實用的防水小杯墊。");
            dimension.setText("11.5 X 11 cm");
        }else {
            title.setText("藺草杯墊");
            description.setText("傳統藺草，簡單黏貼的方式，搭配自己中意的紙膠袋，化身為一個實用的防水小杯墊。");
            dimension.setText("11.5 X 11 cm");
        }
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
