package com.fragments.justus.stories;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justus on 4/30/15.
 */
public class RecyclerViewActivity extends Activity {
    private List<Story> stories;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recycler_view);

        rv =(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        stories = new ArrayList<>();
        stories.add(new Story("The maasai", "They occupy most of savanna lands", R.drawable.img1));
        stories.add(new Story("Mt Kilimanjaro", "The biggest mountain in Africa", R.drawable.img2));
        stories.add(new Story("Buffaloes", "One of the big five animals in the world", R.drawable.img3));
        stories.add(new Story("Cheeters", "Better stay away from them", R.drawable.img4));
        stories.add(new Story("waterbodies", "This becomes the playing ground in summer", R.drawable.img5));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(stories);
        rv.setAdapter(adapter);
    }
}
