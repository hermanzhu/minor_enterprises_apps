package com.fss.qdnewsproject1.fragment;


import com.fss.qdnewsproject1.R;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ContentFragment extends Fragment{
	String text = null;

    public ContentFragment() {
    }

    public ContentFragment(String text) {
        Log.e("fss.qdnews", text);
        this.text = text;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Log.e("fss.qdnews", "onCreate:"+text);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("fss.qdnews", "onCreateView:"+ text);
        //inflater the layout 
        View view = inflater.inflate(R.layout.fragment_text, null);
        TextView textView =(TextView)view.findViewById(R.id.textView);
        if(!TextUtils.isEmpty(text)) {
            textView.setText(text);
        }
        return view;
    }

    @Override
    public void onDestroy() {
        Log.e("fss.qdnews", "onDestroy:"+ text);
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e("fss.qdnews", "onDetach:"+ text);
        super.onDetach();
    }

    @Override
    public void onPause() {
        Log.e("fss.qdnews", "onPause:"+ text);
        super.onPause();
    }

    @Override
    public void onResume() {
        Log.e("fss.qdnews", "onResume:"+ text);
        super.onResume();
    }

    @Override
    public void onStart() {
        Log.e("fss.qdnews", "onStart:"+ text);
        super.onStart();
    }

    @Override
    public void onStop() {
        Log.e("fss.qdnews", "onStop:"+ text);
        super.onStop();
    }

}
