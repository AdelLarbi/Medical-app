package com.app.yasmina.medical.fragment;


import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.yasmina.medical.R;
import com.app.yasmina.medical.activity.CardContent;
import com.app.yasmina.medical.activity.CardContentAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoduleHypoFragment extends Fragment {

    private CardContentAdapter adapter;
    private List<CardContent> cardList;
    static public AssetManager assetManager;

    public NoduleHypoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card_non_expandabale, container, false);
    }

}
