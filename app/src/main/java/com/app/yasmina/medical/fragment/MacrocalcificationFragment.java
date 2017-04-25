package com.app.yasmina.medical.fragment;


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
public class MacrocalcificationFragment extends Fragment {


    public MacrocalcificationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card_non_expandabale, container, false);

        TextView mTitle = (TextView) view.findViewById(R.id.tv_title);
        TextView mDescriptionOne = (TextView) view.findViewById(R.id.tv_description_1);
        TextView mDescriptionTwo = (TextView) view.findViewById(R.id.tv_description_2);
        ImageView mImage = (ImageView) view.findViewById(R.id.iv_image);

        mTitle.setText(getResources().getText(R.string.macro_title));
        mDescriptionOne.setText(getResources().getText(R.string.macro_description_one));
        mDescriptionTwo.setText(getResources().getText(R.string.macro_description_two));
        mImage.setImageResource(R.drawable.thyroide_blure_resize);

        // Inflate the layout for this fragment
        return view;
    }

}
