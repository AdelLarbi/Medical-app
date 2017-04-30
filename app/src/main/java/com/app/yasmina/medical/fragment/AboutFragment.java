package com.app.yasmina.medical.fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.yasmina.medical.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about, container, false);

        TextView mNames = (TextView) view.findViewById(R.id.tv_about_names);
        TextView mSectionOne = (TextView) view.findViewById(R.id.tv_about_section_one);
        TextView mSectionTwo = (TextView) view.findViewById(R.id.tv_about_section_two);

        Typeface FONT_REGULAR = Typeface.createFromAsset(view.getContext().getAssets(),
                "fonts/Font-Regular.ttf");

        mNames.setTypeface(FONT_REGULAR);
        mSectionOne.setTypeface(FONT_REGULAR);
        mSectionTwo.setTypeface(FONT_REGULAR);

        // Inflate the layout for this fragment
        return view;
    }

}
