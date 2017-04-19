package com.app.yasmina.medical;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CardContentAdapter adapter;
    private List<CardContent> cardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        cardList = new ArrayList<>();
        adapter = new CardContentAdapter(this, cardList);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        prepareCards();
    }

    private void prepareCards() {
        cardList.add(new CardContent(1, "Hello", "World !"));
        cardList.add(new CardContent(1, "Hello 2", "World ! 2"));
        cardList.add(new CardContent(1, "Hello 3", "World ! 3"));
        adapter.notifyDataSetChanged();
    }
}
