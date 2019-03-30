package com.example.showbilibili;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ListsAdapter extends RecyclerView.Adapter<ListsAdapter.ViewHolder> {
    private Context mContext;
    private List<Lists> mListsList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView videoPic;
        TextView videoTitle;
        TextView upUser;
        TextView playAndReview;
        public ViewHolder(View view){
            super(view);
            cardView=(CardView)view;
            videoPic=(ImageView) view.findViewById(R.id.video_pic);
            videoTitle=(TextView) view.findViewById(R.id.video_title);
            upUser=(TextView) view.findViewById(R.id.up_user);
            playAndReview=(TextView) view.findViewById(R.id.play_and_review);
        }
    }
    public ListsAdapter(List<Lists> listsList){
        mListsList=listsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if(mContext==null){
            mContext=viewGroup.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.list_item,
                viewGroup,false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final Lists list=mListsList.get(i);
        String playAndReview="播放："+list.getPlay()+"  弹幕："+list.getVideo_review();
        Log.d("Adapter","Glide");
        Glide.with(mContext)
                .load(list.getPic())
                .fitCenter()
                .into(viewHolder.videoPic);
        Log.d("Adapter",list.getPic());
        viewHolder.videoTitle.setText(list.getTitle());
        viewHolder.upUser.setText(list.getAuthor());
        viewHolder.playAndReview.setText(playAndReview);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),PlayVideo.class);
                intent.putExtra("videoSite",list.getAid());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListsList.size();
    }
}
