package com.fragments.justus.stories;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Main extends Activity {
    RecyclerView recyclerView;
    private List<Story>stories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


      recyclerView  = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(llm);

        initializeData();

    }

    class Story{
        String title;
        int photoId;
        String body;

        public Story(String title, String body, int photoId){
            this.body=body;
            this.photoId=photoId;
            this.title=title;

        }
    }




    private void initializeData(){
        stories = new ArrayList<>();
        stories.add(new Story("The maasai", "They occupy most of savanna lands", R.drawable.img1));
        stories.add(new Story("Mt Kilimanjaro", "The biggest mountain in Africa", R.drawable.img2));
        stories.add(new Story("Buffaloes", "One of the big five animals in the world", R.drawable.img3));
        stories.add(new Story("Cheeters", "Better stay away from them", R.drawable.img4));
        stories.add(new Story("waterbodies", "This becomes the playing ground in summer", R.drawable.img5));
        //set adapter
        RVAdapter adapter =new RVAdapter(stories);
        recyclerView.setAdapter(adapter);
    }
       
    public class RVAdapter extends RecyclerView.Adapter<RVAdapter.StoryViewHolder>{

        public RVAdapter(List<Story> stories) {
        }

        public class StoryViewHolder extends RecyclerView.ViewHolder {
            CardView cv;
            TextView title;
            TextView body;
            ImageView Photo;

            StoryViewHolder(View itemView) {
                super(itemView);
                cv = (CardView)itemView.findViewById(R.id.cv);
                title = (TextView)itemView.findViewById(R.id.person_name);
                body= (TextView)itemView.findViewById(R.id.person_age);
                Photo = (ImageView)itemView.findViewById(R.id.person_photo);
            }
        }
        @Override
        public int getItemCount() {
            return stories.size();
        }
        @Override
        public StoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main, viewGroup, false);
            StoryViewHolder pvh = new StoryViewHolder(v);
            return pvh;
        }
        @Override
        public void onBindViewHolder(StoryViewHolder storyViewHolder, int i) {
            storyViewHolder.title.setText(stories.get(i).title);
            storyViewHolder.body.setText(stories.get(i).body);
            storyViewHolder.Photo.setImageResource(stories.get(i).photoId);
        }
        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }

    }






}










