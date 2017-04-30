package com.app.yasmina.medical.fragment;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.yasmina.medical.R;
import com.app.yasmina.medical.activity.CardContentAdapter;
import com.app.yasmina.medical.other.CardContent;
import com.app.yasmina.medical.other.INonExpandableCard;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class NonExpandableCardFragment extends Fragment implements INonExpandableCard {

    protected CardContentAdapter adapter;
    protected List<CardContent> cardList;

    private final int CARDS_COUNT = 3;
    protected final int FOOTER_TEXTS_COUNT = 5;
    protected final int FOOTER_IMAGES_COUNT = 2;

    protected final int CARD_ONE = 0;
    protected final int CARD_TWO = 1;
    protected final int CARD_THREE = 2;

    protected final int TITLE = 0;
    protected final int IMAGE_TITLE_ONE = 1;
    protected final int IMAGE_TITLE_TWO = 2;
    protected final int TEXT_ONE = 3;
    protected final int TEXT_TWO = 4;

    protected final int IMAGE_ONE = 0;
    protected final int IMAGE_TWO = 1;

    protected String[] cardHeaderText = new String[CARDS_COUNT];
    protected String[][] cardFooterTexts = new String[CARDS_COUNT][FOOTER_TEXTS_COUNT];
    protected Drawable[][] cardFooterImages  = new Drawable[CARDS_COUNT][FOOTER_IMAGES_COUNT];

    public NonExpandableCardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.content_drawer, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_cards_in_fragment);

        cardList = new ArrayList<>();
        adapter = new CardContentAdapter(cardList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        prepareCards();

        // Inflate the layout for this fragment
        return view;
    }
}
