package com.app.yasmina.medical.activity;

import android.graphics.Typeface;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.yasmina.medical.R;
import com.app.yasmina.medical.fragment.NoduleHypoFragment;
import com.app.yasmina.medical.other.CardContent;

import java.util.List;

public class CardContentAdapter extends RecyclerView.Adapter<CardContentAdapter.MyViewHolder> {

    private final Typeface FONT_REGULAR = Typeface.createFromAsset(DrawerActivity.assetManager,
            "fonts/Font-Regular.ttf");
    private final Typeface FONT_MEDIUM = Typeface.createFromAsset(DrawerActivity.assetManager,
            "fonts/Font-Medium.ttf");

    private List<CardContent> cardList;

    public CardContentAdapter(List<CardContent> cardList) {
        this.cardList = cardList;
    }

    class MyViewHolder extends ViewHolder {
        private TextView mCardHeaderTitle;
        private TextView mCardFooterTitle;
        private TextView mCardImageTitleOne;
        private TextView mCardImageTitleTwo;
        private TextView mCardFooterTextOne;
        private TextView mCardFooterTextTwo;

        private ImageView mCardHeaderImageArrow;
        private ImageView mCardImageOne;
        private ImageView mCardImageTwo;

        private RelativeLayout mCardFooterMainLayout;
        private FrameLayout mCardFooterFrameLayoutOne;
        private FrameLayout mCardFooterFrameLayoutTwo;

        private MyViewHolder(View view) {
            super(view);

            mCardHeaderTitle = (TextView) view.findViewById(R.id.tv_card_header_title);
            mCardFooterTitle = (TextView) view.findViewById(R.id.tv_card_footer_title);
            mCardImageTitleOne = (TextView) view.findViewById(R.id.tv_card_image_title_one);
            mCardImageTitleTwo = (TextView) view.findViewById(R.id.tv_card_image_title_two);
            mCardFooterTextOne = (TextView) view.findViewById(R.id.tv_card_footer_text_one);
            mCardFooterTextTwo = (TextView) view.findViewById(R.id.tv_card_footer_text_two);

            mCardHeaderImageArrow = (ImageView) view.findViewById(R.id.iv_card_header_arrow);
            mCardImageOne = (ImageView) view.findViewById(R.id.iv_card_image_one);
            mCardImageTwo = (ImageView) view.findViewById(R.id.iv_card_image_two);

            mCardHeaderTitle.setTypeface(FONT_REGULAR);
            mCardFooterTitle.setTypeface(FONT_REGULAR);
            mCardImageTitleOne.setTypeface(FONT_REGULAR);
            mCardImageTitleTwo.setTypeface(FONT_REGULAR);
            mCardFooterTextOne.setTypeface(FONT_REGULAR);
            mCardFooterTextTwo.setTypeface(FONT_REGULAR);

            mCardFooterFrameLayoutOne = (FrameLayout) view.findViewById(R.id.fl_frame_one);
            mCardFooterFrameLayoutTwo = (FrameLayout) view.findViewById(R.id.fl_frame_two);
            mCardFooterMainLayout = (RelativeLayout) view.findViewById(R.id.rl_card_footer_main_layout);
            mCardFooterMainLayout.setVisibility(View.GONE);

            mCardHeaderTitle.setOnTouchListener(touchListener);
            mCardFooterMainLayout.setOnClickListener(hideContent);
        }
    }

    private View.OnTouchListener touchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View view, MotionEvent event) {

            // Simulate pressed state on the card view.
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    // do FEED-BACK only
                    view.setPressed(true);
                    break;

                case MotionEvent.ACTION_UP:
                    // stop FEED-BACK Then EXPAND
                    view.setPressed(false);
                    changeContentVisibility(view);
                    break;

                case MotionEvent.ACTION_CANCEL:
                    // stop FEED-BACK and don't EXPAND
                    view.setPressed(false);
                    break;
            }

            // Pass all events through to the host view.
            return true;
        }
    };

    private void changeContentVisibility(View view) {
        View content = getContentView(view);

        if (content.isShown()) {
            ((TextView) view).setTypeface(FONT_REGULAR);
            content.setVisibility(View.GONE);
        } else {
            ((TextView) view).setTypeface(FONT_MEDIUM);
            content.setVisibility(View.VISIBLE);
        }
    }

    private View getContentView(View view) {
        ViewGroup parent = (ViewGroup) view.getParent();

        // 2 is the rank of tv_card_header_title in the xml file
        return parent.getChildAt(2);
    }

    private View.OnClickListener hideContent = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            getHeaderTextView(view).setTypeface(FONT_REGULAR);
            view.setVisibility(View.GONE);
        }
    };

    private TextView getHeaderTextView(View view) {
        ViewGroup parent = (ViewGroup) view.getParent();

        return (TextView) parent.getChildAt(1);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_card_expandable, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        CardContent cards = cardList.get(position);

        holder.mCardHeaderTitle.setText(cards.getHeaderTitle());
        holder.mCardFooterTitle.setText(cards.getFooterTitle());
        holder.mCardImageTitleOne.setText(cards.getImageTitleOne());
        holder.mCardImageTitleTwo.setText(cards.getImageTitleTwo());
        holder.mCardFooterTextOne.setText(cards.getFooterTextOne());
        holder.mCardFooterTextTwo.setText(cards.getFooterTextTwo());

        holder.mCardImageOne.setImageDrawable(cards.getImageOne());
        holder.mCardImageTwo.setImageDrawable(cards.getImageTwo());

        if ((String.valueOf(cards.getImageOne())).equals("null")) {
            holder.mCardFooterFrameLayoutOne.setVisibility(View.GONE);
            holder.mCardImageTitleTwo.setVisibility(View.GONE);
        }

        if ((String.valueOf(cards.getImageTwo())).equals("null")) {

            // If there is no image to load, hide the container frame
            holder.mCardFooterFrameLayoutOne.setVisibility(View.GONE);
            holder.mCardFooterFrameLayoutTwo.setVisibility(View.GONE);

        } else if ((String.valueOf(cards.getImageOne())).equals("null")) {

            // If there is only one image to load, hide its title and the frame of the second one
            holder.mCardFooterFrameLayoutOne.setVisibility(View.GONE);
            holder.mCardImageTitleTwo.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {

        return cardList.size();
    }
}
