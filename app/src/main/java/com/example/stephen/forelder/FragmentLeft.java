package com.example.stephen.forelder;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class FragmentLeft extends Fragment{
    Detail detail;
    Context contex = null;
    String message = "";

    public static FragmentLeft newInstance(String strArg){
        FragmentLeft fragment = new FragmentLeft();
        Bundle args = new Bundle();
        args.putString("strArg1", strArg);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        try{
            contex = getActivity();
            detail = (Detail)getActivity();
        }catch (IllegalStateException e){
            throw new IllegalStateException("Main Activity must implement Callbacks");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        LinearLayout view_layout_left = (LinearLayout) inflater.inflate(R.layout.layout_left, null);
        ImageButton ImgButton1 = (ImageButton) view_layout_left.findViewById(R.id.detail_1);
        ImageButton ImgButton2 = (ImageButton) view_layout_left.findViewById(R.id.detail_2);
        ImageButton ImgButton3 = (ImageButton) view_layout_left.findViewById(R.id.detail_3);

        ImgButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detail.onMsgFromFragToMain(1);
            }
        });

        ImgButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detail.onMsgFromFragToMain(2);
            }
        });

        ImgButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detail.onMsgFromFragToMain(3);
            }
        });
        return view_layout_left;
    }

}
