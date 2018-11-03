package com.xiao.compatstatusbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by desaco on 2018/10/25.
 */

public class TestNextFragment extends Fragment {

    public static TestNextFragment getInstance(String paramsType){
        TestNextFragment fragment = new TestNextFragment();

        Bundle bundle = new Bundle();
        bundle.putString("DATA",paramsType);
        fragment.setArguments(bundle);

        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout,null);

        Bundle bundle = getArguments();
        String data = bundle.getString("DATA");
        //show_tv
        TextView showTv = (TextView)view.findViewById(R.id.show_tv);
        showTv.setText(data);

        return view;
    }
}
