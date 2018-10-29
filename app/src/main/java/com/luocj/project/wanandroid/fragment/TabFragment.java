package com.luocj.project.wanandroid.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luocj.project.wanandroid.R;

public class TabFragment extends Fragment {

    private View inflate;
    private TextView tv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_tab_fragment, container, false);
        return inflate;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tv = inflate.findViewById(R.id.tv_tab_fragment);
    }

    @Override
    public void onResume() {
        super.onResume();

        Bundle arguments = getArguments();
        if (arguments!=null){
            String key = arguments.getString("key");
            if (key!=null){
                tv.setText(key);
            }
        }

    }

    public static TabFragment getInstance(String msg) {
        Bundle bundle = new Bundle();
        bundle.putString("key", msg);

        TabFragment fm = new TabFragment();
        fm.setArguments(bundle);
        return fm;
    }

}
