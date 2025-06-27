package com.example.dogengp4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CeritaAdapter extends RecyclerView.Adapter<CeritaAdapter.ViewHolder> {
    private List<Story> storyList;
    private Context context;

    public CeritaAdapter(List<Story> storyList, Context context) {
        this.storyList = storyList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cerita, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Story story = storyList.get(position);
        holder.storyTitle.setText(story.getTitle());


        Glide.with(context)
                .load(story.getImage())
                .placeholder(R.drawable.dogeng8)
                .into(holder.storyCover);


        holder.layClick.setOnClickListener(v -> {
            Intent intent = new Intent(context, CeritaActivity.class);
            intent.putExtra(Constans.EXTRA_TITLE, story.getTitle());
            intent.putExtra(Constans.EXTRA_STORY_TEXT, story.getStoryText());
            intent.putExtra(Constans.EXTRA_AUDIO, story.getAudio());
            intent.putExtra(Constans.EXTRA_IMAGE, story.getImage());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView storyTitle;
        ImageView storyCover;
        CardView layClick;

        public ViewHolder(View itemView) {
            super(itemView);
            layClick = itemView.findViewById(R.id.layClick);
            storyTitle = itemView.findViewById(R.id.story_title);
            storyCover = itemView.findViewById(R.id.story_cover);
        }
    }
}
