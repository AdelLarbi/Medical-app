package com.app.yasmina.medical;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

class CardContentAdapter extends RecyclerView.Adapter<CardContentAdapter.MyViewHolder> {

    private final Typeface FONT_REGULAR = Typeface.createFromAsset(MenuActivity.assetManager,
            "fonts/Font-Regular.ttf");
    private final Typeface FONT_MEDIUM = Typeface.createFromAsset(MenuActivity.assetManager,
            "fonts/Font-Medium.ttf");

    private List<CardContent> cardList;

    CardContentAdapter(List<CardContent> cardList) {
        this.cardList = cardList;
    }

    class MyViewHolder extends ViewHolder {
        private TextView cardTitle;
        private TextView cardText;

        private RelativeLayout cardContentLayout;

        private MyViewHolder(View view) {
            super(view);

            cardTitle = (TextView) view.findViewById(R.id.card_header);
            cardText = (TextView) view.findViewById(R.id.card_text);

            cardTitle.setTypeface(FONT_REGULAR);
            cardText.setTypeface(FONT_REGULAR);

            cardContentLayout = (RelativeLayout) view.findViewById(R.id.card_content);
            cardContentLayout.setVisibility(View.GONE);

            cardTitle.setOnClickListener(changeContentVisibility);
            cardContentLayout.setOnClickListener(hideContent);
        }
    }

    private View.OnClickListener changeContentVisibility = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            View content = getContentView(view);

            if (content.isShown()) {
                ((TextView) view).setTypeface(FONT_REGULAR);
                content.setVisibility(View.GONE);
            } else {
                ((TextView) view).setTypeface(FONT_MEDIUM);
                content.setVisibility(View.VISIBLE);
            }
        }
    };

    private View getContentView(View view) {
        ViewGroup parent = (ViewGroup) view.getParent();

        return parent.getChildAt(1);
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

        return (TextView) parent.getChildAt(0);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CardContent cards = cardList.get(position);
        holder.cardTitle.setText(cards.getTitle());
        holder.cardText.setText(cards.getInformations().get(0));
    }

    @Override
    public int getItemCount() {

        return cardList.size();
    }
}
