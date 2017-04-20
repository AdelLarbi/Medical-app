package com.app.yasmina.medical;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class CardContentAdapter extends RecyclerView.Adapter<CardContentAdapter.MyViewHolder> {

    private List<CardContent> cardList;

    CardContentAdapter(List<CardContent> cardList) {
        this.cardList = cardList;
    }

    class MyViewHolder extends ViewHolder {
        TextView title;
        TextView content;
        Typeface font;

        private MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.card_title);
            font = Typeface.createFromAsset(MenuActivity.assetManager, "fonts/Font-Medium.ttf");
            title.setTypeface(font);

            content = (TextView) view.findViewById(R.id.card_content);
            font = Typeface.createFromAsset(MenuActivity.assetManager, "fonts/Font-Regular.ttf");
            title.setTypeface(font);
        }
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
        holder.title.setText(cards.getTitle());
        holder.content.setText(cards.getInformations().get(0));
    }

    @Override
    public int getItemCount() {

        return cardList.size();
    }
}
