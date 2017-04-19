package com.app.yasmina.medical;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class CardContentAdapter extends RecyclerView.Adapter<CardContentAdapter.MyViewHolder> {

    private Context mContext;
    private List<CardContent> cardList;

    public CardContentAdapter(Context mContext, List<CardContent> cardList) {
        this.mContext = mContext;
        this.cardList = cardList;
    }

    class MyViewHolder extends ViewHolder {
        TextView title;
        TextView content;

        public MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.card_title);
            content = (TextView) view.findViewById(R.id.card_content);

            /* TextView txt = (TextView) findViewById(R.id.info_text);
                Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Font-Regular.ttf");
                txt.setTypeface(font); */
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
