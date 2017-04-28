package com.app.yasmina.medical.fragment;


import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.yasmina.medical.R;
import com.app.yasmina.medical.other.CardContent;
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
        String headerText;
        String[] footerTexts = new String[5];
        Drawable[] footerImages = new Drawable[2];

        headerText = (String) getResources().getText(R.string.hypo_one_header);
        footerTexts[0] = (String) getResources().getText(R.string.hypo_one_footer_title);
        footerTexts[3] = (String) getResources().getText(R.string.hypo_one_footer_text_one);
        footerTexts[4] = (String) getResources().getText(R.string.hypo_one_footer_text_two);
        footerImages[0] = ContextCompat.getDrawable(getContext(), R.drawable.gonglion);

        cardList.add(new CardContent(headerText, footerTexts, footerImages));

        adapter.notifyDataSetChanged();
    }
}
