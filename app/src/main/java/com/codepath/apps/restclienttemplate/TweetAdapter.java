package com.codepath.apps.restclienttemplate;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jared1158 on 7/2/18.
 */

public class TweetAdapter {

    //pass in the tweets array in the constructor

    //for each row, inflate the layout and cache references into viewholder

    //bind the values based on the position of the element

    //create viewholder class

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivProfileImage;
        public TextView tvUsername;
        public TextView tvBody;

        public ViewHolder(View itemView) {
            super(itemView);

            //perform findViewById lookups

            ivProfileImage = (ImageView) itemView.findViewById(R.id.ivProfileImage);
            tvUsername = (TextView) itemView.findViewById(R.id.tvUserName);
        }
    }
}
