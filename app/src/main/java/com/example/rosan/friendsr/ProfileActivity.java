package com.example.rosan.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    TextView nameTitle;
    ImageView imageView;
    TextView friendDescription;
    RatingBar ratingBar;
    SharedPreferences prefs;
    Friend friend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initiate view
        nameTitle = findViewById(R.id.nameTitle);
        imageView = findViewById(R.id.imageView);
        friendDescription = findViewById(R.id.friendDescription);
        ratingBar = findViewById(R.id.ratingBar);

        // Retrieve friend from MainActivity
        Intent intent = getIntent();
        friend = (Friend) intent.getSerializableExtra("clickedFriend");

        // SharedPreferences to retrieve stored data (ratings)
        prefs = getSharedPreferences("settings",MODE_PRIVATE);
        Float aStoredFloat = prefs.getFloat(friend.getName(),0);

        // Check if something is stored. If so: set the Rating
        if (aStoredFloat != 0){
            friend.setRating(aStoredFloat);
            ratingBar.setRating(aStoredFloat);
        }

        // Fill Views with friend getters
        nameTitle.setText(friend.getName());
        imageView.setImageResource(friend.getDrawableId());
        friendDescription.setText(friend.getBio());

        // Set OnRatingBarChangeListener
        addListenerOnRatingBar();
    }

    public void addListenerOnRatingBar() {
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                // Save in Friend Class
                friend.setRating(rating);
                // Save in SharedPreferences
                SharedPreferences.Editor editor = prefs.edit();
                editor.putFloat(friend.getName(),rating);
                editor.apply();
            }
        });
    }


}
