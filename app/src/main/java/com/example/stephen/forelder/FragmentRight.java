package com.example.stephen.forelder;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class FragmentRight extends Fragment implements FragmentCallbacks{
    Detail detail;
    ImageView Img;
    //String txtRight;
    public static FragmentRight newInstance(String strArg1){
        FragmentRight fragment = new FragmentRight();
        Bundle bundle = new Bundle();
        bundle.putString("arg1", strArg1);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(!((getActivity()) instanceof MainCallbacks)){
            throw new IllegalStateException("Activity must implement Callbacks");
        }
        detail = (Detail) getActivity();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstaceState){
        LinearLayout layout_right = (LinearLayout) inflater.inflate(R.layout.layout_right,null);
        Img = (ImageView) layout_right.findViewById(R.id.Img);
        Img.setImageResource(R.drawable.detail_1);
        try {
            Bundle arguments = getArguments();
            String redMessage = arguments.getString("arg1", "");
            //txtRight.setText(redMessage);
        } catch (Exception e){
            Log.e("Red Bundle ERROR - ", "" + e.getMessage());
        }
        return layout_right;
    }
    @Override
    public void onMsgFromMainToFragment(Integer position) {
        if(position==1){
            Img.setImageResource(R.drawable.detail_1);
        }else if(position==2){
            Img.setImageResource(R.drawable.detail_2);
        }else{
            Img.setImageResource(R.drawable.detail_3);
        }
    }
}
