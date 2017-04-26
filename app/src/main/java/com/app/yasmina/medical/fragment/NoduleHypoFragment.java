package com.app.yasmina.medical.fragment;


import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.yasmina.medical.R;
import com.app.yasmina.medical.activity.CardContent;
import com.app.yasmina.medical.activity.CardContentAdapter;

import java.util.ArrayList;
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

        View view = inflater.inflate(R.layout.content_drawer, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_cards_in_fragment);

        // The application's asset manager. Helper for font customisation
        assetManager = view.getContext().getAssets();

        cardList = new ArrayList<>();
        adapter = new CardContentAdapter(cardList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        prepareCards();

        // Inflate the layout for this fragment
        return view;
    }

    private void prepareCards() {
        cardList.add(new CardContent(1, "Kyste", "World !"));
        cardList.add(new CardContent(2, "Macrocalcification isolée", "World ! 2"));
        cardList.add(new CardContent(3, "Nodule hyper-échogène", "World ! 3"));
        cardList.add(new CardContent(4, "Nodule iso-échogène", "World ! 3"));
        cardList.add(new CardContent(5, "Nodule hypo-échogène", "World ! 3"));

        adapter.notifyDataSetChanged();
    }
}
