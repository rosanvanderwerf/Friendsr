package com.example.rosan.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initiate Views
        GridView gridView = findViewById(R.id.gridView);
        gridView.setOnItemClickListener(new GridItemClickListener());

        // ArrayList with Friend(s)
        ArrayList<Friend> friends = new ArrayList<>();

        // Create instances of Class Friend
        final Friend friend1 = new Friend("Eleven", "Millie Bobby Brown", getResources().getIdentifier(
                "eleven", "drawable", MainActivity.this.getPackageName()));
        Friend friend2 = new Friend("Mike", "Finn Wolfhard", getResources().getIdentifier(
                "mike", "drawable", MainActivity.this.getPackageName()));
        Friend friend3 = new Friend("Dustin", "Gaten Matarazzo", getResources().getIdentifier(
                "dustin", "drawable", MainActivity.this.getPackageName()));
        Friend friend4 = new Friend("Lucas", "Caleb McLaughlin", getResources().getIdentifier(
                "lucas", "drawable", MainActivity.this.getPackageName()));
        Friend friend5 = new Friend("Will", "Noah Schnapp", getResources().getIdentifier(
                "will", "drawable", MainActivity.this.getPackageName()));
        Friend friend6 = new Friend("Nancy", "Natalia Dyer", getResources().getIdentifier(
                "nancy", "drawable", MainActivity.this.getPackageName()));
        Friend friend7 = new Friend("Jonathan", "Carlie Heaton", getResources().getIdentifier(
                "jonathan", "drawable", MainActivity.this.getPackageName()));
        Friend friend8 = new Friend("Steve", "Joe Keery", getResources().getIdentifier(
                "steve", "drawable", MainActivity.this.getPackageName()));
        Friend friend9 = new Friend("Barbara","Shannon Purser", getResources().getIdentifier(
                "barbara", "drawable", MainActivity.this.getPackageName()));
        Friend friend10 = new Friend("Jim", "David Harbour", getResources().getIdentifier(
                "jim", "drawable", MainActivity.this.getPackageName()));
        Friend friend11 = new Friend("Joyce", "Winona Ryder", getResources().getIdentifier(
                "joyce", "drawable", MainActivity.this.getPackageName()));
        Friend friend12 = new Friend("Martin","Matthieuw Modine", getResources().getIdentifier(
                "martin", "drawable", MainActivity.this.getPackageName()));

        // Add all of the above friends in the ArrayList
        Collections.addAll(friends, friend1, friend2, friend3, friend4, friend5,
                friend6, friend7, friend8, friend9, friend10, friend11, friend12);

       // Set the Adapter
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        gridView.setAdapter(adapter);
    }

    // Set Listener on the GridView
    private class GridItemClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
            // Create Friend instance to add to (next) intent
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);
            // Create new intent, and go to next/second activity
            Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
            intent.putExtra("clickedFriend", clickedFriend);
            startActivity(intent);
        }
    }


}
