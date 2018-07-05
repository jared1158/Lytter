package com.codepath.apps.restclienttemplate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;
import org.parceler.Parcels;

import cz.msebera.android.httpclient.Header;


public class ComposeActivity extends AppCompatActivity {

    private TwitterClient client;
    EditText etCompose = (EditText) findViewById(R.id.etCompose);
    String message = etCompose.getText().toString();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
    }



    // ActivityNamePrompt.java -- launched for a result
    public void onSubmit(View v) {
        client = TwitterApp.getRestClient(getApplicationContext());


        client.sendTweet(message, new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                //EditText etCompose = (EditText) findViewById(R.id.etCompose);

                // Prepare data intent
                Intent data = new Intent(ComposeActivity.this, TimelineActivity.class);

                // Pass relevant data back as a result
                data.putExtra("post", Parcels.wrap(etCompose.getText().toString()));
                data.putExtra("code", 200); // ints work too

                // Activity finished ok, return the data
                setResult(RESULT_OK, data); // set result code and bundle data for response
                finish(); // closes the activity, pass data to parent
            }
        });



    }







}
