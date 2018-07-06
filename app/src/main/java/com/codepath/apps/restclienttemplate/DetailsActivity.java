package com.codepath.apps.restclienttemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class DetailsActivity extends AppCompatActivity {

    Tweet tweet;
    //views
    TextView tvNamen;
    TextView tvDetail;
    TextView tvMessage;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        //resolve objects
        tvNamen = (TextView) findViewById(R.id.tvNamen);
        tvDetail = (TextView) findViewById(R.id.tvDetail);
        tvMessage = (TextView) findViewById(R.id.tvMessage);

        //unwrap the intent data
        tweet = (Tweet) Parcels.unwrap(getIntent().getParcelableExtra(Tweet.class.getSimpleName()));

        //set the textviews
        tvNamen.setText(tweet.user.name);
        tvDetail.setText(tweet.body);
        tvMessage.setText(tweet.user.screenName);

    }
}
