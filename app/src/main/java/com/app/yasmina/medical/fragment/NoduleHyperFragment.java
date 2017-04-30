package com.app.yasmina.medical.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.app.yasmina.medical.R;
import com.app.yasmina.medical.other.CardContent;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoduleHyperFragment extends NonExpandableCardFragment {

    public NoduleHyperFragment() {
        // Required empty public constructor
    }

    @Override
    public void prepareCards() {

        final int CARDS_COUNT = 2;

        // First Card
        cardHeaderText[CARD_ONE] = (String) getResources().getText(R.string.hyp_one_header);
        cardFooterTexts[CARD_ONE][TITLE] = (String) getResources().getText(R.string.hyp_one_footer_title);
        cardFooterTexts[CARD_ONE][TEXT_ONE] = (String) getResources().getText(R.string.hyp_one_footer_text_one);
        cardFooterTexts[CARD_ONE][TEXT_TWO] = (String) getResources().getText(R.string.hyp_one_footer_text_two);
        cardFooterImages[CARD_ONE][IMAGE_TWO] = ContextCompat.getDrawable(getContext(), R.drawable.nodule_iso_absence);

        // Second Card
        cardHeaderText[CARD_TWO] = (String) getResources().getText(R.string.hyp_two_header);
        // TODO: header_bis
        cardFooterTexts[CARD_TWO][TITLE] = (String) getResources().getText(R.string.hyp_two_footer_title);
        cardFooterTexts[CARD_TWO][TEXT_ONE] = (String) getResources().getText(R.string.hyp_two_footer_text_one);
        cardFooterTexts[CARD_TWO][TEXT_TWO] = (String) getResources().getText(R.string.hyp_two_footer_text_two);

        for (int i = 0; i < CARDS_COUNT; i++) {
            cardList.add(new CardContent(cardHeaderText[i], cardFooterTexts[i], cardFooterImages[i]));
        }

        adapter.notifyDataSetChanged();
    }
}
