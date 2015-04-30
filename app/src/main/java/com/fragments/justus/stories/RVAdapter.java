package com.fragments.justus.stories;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.StoryViewHolder> {

    public static class StoryViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        static TextView title;
        static TextView body;
        static ImageView Photo;

        StoryViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            title = (TextView)itemView.findViewById(R.id.person_name);
            body = (TextView)itemView.findViewById(R.id.person_age);
            Photo = (ImageView)itemView.findViewById(R.id.person_photo);
        }
    }

    List<Story> stories;

    RVAdapter(List<Story> stories){
        this.stories = stories;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public StoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main, viewGroup, false);
        StoryViewHolder pvh = new StoryViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(StoryViewHolder storyViewHolder, int i) {
        StoryViewHolder.title.setText(stories.get(i).title);
        StoryViewHolder.body.setText(stories.get(i).body);
        StoryViewHolder.Photo.setImageResource(stories.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }
}