package com.app.yasmina.medical.activity;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.app.yasmina.medical.R;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private CardContentAdapter adapter;
    private List<CardContent> cardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        cardList = new ArrayList<>();
        adapter = new CardContentAdapter(cardList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        prepareCards();
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
