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

    // Footer content : information's rank
    private final int TITLE = 0;
    private final int IMAGE_TITLE_ONE = 1;
    private final int IMAGE_TITLE_TWO = 2;
    private final int TEXT_ONE = 3;
    private final int TEXT_TWO = 4;
    private final int IMAGE_ONE = 0;
    private final int IMAGE_TWO = 1;

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

        // First Card
        headerText = (String) getResources().getText(R.string.hypo_one_header);
        footerTexts[TITLE] = (String) getResources().getText(R.string.hypo_one_footer_title);
        footerTexts[TEXT_ONE] = (String) getResources().getText(R.string.hypo_one_footer_text_one);
        footerTexts[TEXT_TWO] = (String) getResources().getText(R.string.hypo_one_footer_text_two);
        footerImages[IMAGE_TWO] = ContextCompat.getDrawable(getContext(), R.drawable.gonglion);
        cardList.add(new CardContent(headerText, footerTexts, footerImages));

        /*
        // TODO: Second Card
        headerText = (String) getResources().getText(R.string.hypo_two_header);
        // FIXME: header_bis
        footerTexts[TITLE] = (String) getResources().getText(R.string.hypo_two_footer_title);
        footerTexts[TEXT_ONE] = (String) getResources().getText(R.string.hypo_two_footer_text_one);
        footerTexts[TEXT_TWO] = (String) getResources().getText(R.string.hypo_two_footer_text_two);
        footerImages[IMAGE_TWO] = ContextCompat.getDrawable(getContext(), R.drawable.);
        cardList.add(new CardContent(headerText, footerTexts, footerImages));
        */

        // FIXME: var names
        String headerText2;
        String[] footerTexts2 = new String[5];
        Drawable[] footerImages2 = new Drawable[2];

        // TODO: Third Card
        headerText2 = (String) getResources().getText(R.string.hypo_three_header);
        footerTexts2[TITLE] = (String) getResources().getText(R.string.hypo_three_footer_title);
        footerTexts2[IMAGE_TITLE_ONE] = (String) getResources().getText(R.string.hypo_three_footer_image_title_one);
        footerTexts2[IMAGE_TITLE_TWO] = (String) getResources().getText(R.string.hypo_three_footer_image_title_two);
        footerTexts2[TEXT_ONE] = (String) getResources().getText(R.string.hypo_three_footer_text_one);
        footerTexts2[TEXT_TWO] = (String) getResources().getText(R.string.hypo_three_footer_text_two);
        footerImages2[IMAGE_ONE] = ContextCompat.getDrawable(getContext(), R.drawable.thyroide);
        footerImages2[IMAGE_TWO] = ContextCompat.getDrawable(getContext(), R.drawable.gonglion);
        cardList.add(new CardContent(headerText2, footerTexts2, footerImages2));

        adapter.notifyDataSetChanged();
    }
}