package com.example.stephen.forelder;

import android.app.Fragment;
import android.content.Context;
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
        bundle.putString("category", strArg1);
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

        Bundle args = getArguments();
        String category = args.getString("category");

        Context context = getActivity().getApplicationContext();
        int id = context.getResources().getIdentifier("drawable/" + category + "_detail_1", null, context.getPackageName());
        Img = (ImageView) layout_right.findViewById(R.id.Img);
        Img.setImageResource(id);
        try {
            Bundle arguments = getArguments();
            String redMessage = arguments.getString("category", "");
            //txtRight.setText(redMessage);
        } catch (Exception e){
            Log.e("Red Bundle ERROR - ", "" + e.getMessage());
        }
        return layout_right;
    }
    @Override
    public void onMsgFromMainToFragment(Integer position) {
        Bundle args = getArguments();
        String category = args.getString("category");
        Context context = getActivity().getApplicationContext();
        if(position==1){
            int id = context.getResources().getIdentifier("drawable/" + category + "_detail_1", null, context.getPackageName());
            Img.setImageResource(id);
        }else if(position==2){
            int id = context.getResources().getIdentifier("drawable/" + category + "_detail_2", null, context.getPackageName());
            Img.setImageResource(id);
        }else{
            int id = context.getResources().getIdentifier("drawable/" + category + "_detail_3", null, context.getPackageName());
            Img.setImageResource(id);
        }
    }
}
