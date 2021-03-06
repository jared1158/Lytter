package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

import java.util.List;


/**
 * Created by jared1158 on 7/2/18.
 */

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder> {
    static List<Tweet> mTweets;

    static Context context;
    //pass in the tweets array in the constructor
    public TweetAdapter(List<Tweet> tweets) {
        mTweets = tweets;
    }
    //for each row, inflate the layout and cache references into viewholder

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View tweetView = inflater.inflate(R.layout.item_tweet, parent, false);
        ViewHolder viewHolder = new ViewHolder(tweetView);
        return viewHolder;
    }

    //bind the values based on the position of the element

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get the data according to the position
        Tweet tweet = mTweets.get(position);

        //populate the views according to this data
        holder.tvUsername.setText(tweet.user.name);
        holder.tvBody.setText(tweet.body);
        holder.tvRelativeDate.setText(ParseRelativeDate.getRelativeTimeAgo(tweet.createdAt));
        holder.tvHandle.setText(tweet.user.screenName);

        Glide.with(context).load(tweet.user.profileImageUrl).into(holder.ivProfileImage);
    }

    //create viewholder class

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ImageView ivProfileImage;
        public TextView tvUsername;
        public TextView tvBody;
        public TextView tvRelativeDate;
        public TextView tvHandle;

        public ViewHolder(View itemView) {
            super(itemView);

            //perform findViewById lookups

            ivProfileImage = (ImageView) itemView.findViewById(R.id.ivProfileImage);
            tvUsername = (TextView) itemView.findViewById(R.id.tvUserName);
            tvBody = (TextView) itemView.findViewById(R.id.tvBody);
            tvRelativeDate = (TextView) itemView.findViewById(R.id.tvRelativeDate);
            tvHandle = (TextView) itemView.findViewById(R.id.tvHandle);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition(); // gets item position
            if (position != RecyclerView.NO_POSITION) { // Check if an item was deleted, but the user clicked it before the UI removed it
                Tweet tweet = mTweets.get(position);
                // We can access the data within the views
                Intent i = new Intent(context, DetailsActivity.class);
                i.putExtra(Tweet.class.getSimpleName(), Parcels.wrap(tweet));

                //show activity
                context.startActivity(i);

            }



        }







}

    public int getItemCount() {
        return mTweets.size();
    }
}
