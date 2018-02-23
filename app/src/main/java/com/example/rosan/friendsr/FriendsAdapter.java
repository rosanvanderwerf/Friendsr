package com.example.rosan.friendsr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/* Created by rosan on 22-2-2018. */

public class FriendsAdapter extends ArrayAdapter<Friend> {
    private Context context;
    private ArrayList friends;
    private int resource;

    // Initiate Views
    public TextView friendName;
    public ImageView friendImage;

    // Constructor
    public FriendsAdapter(Context context, int resource, ArrayList<Friend> friends) {
        super(context, resource, friends);
        this.context = context;
        this.resource = resource;
        this.friends = friends;
    }

    @NonNull
    @Override
    public View getView(int i, View v, @NonNull ViewGroup parent) {
        // Create instance of Friend
        Friend friend = getItem(i);
        // Apply layout: grid_item.xml
        if (v == null) {
            v = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // Find Views
        friendName = v.findViewById(R.id.friendName);
        friendImage = v.findViewById(R.id.friendImage);

        // Assert that friend is not null, and set name and image
        assert friend != null;
        friendName.setText(friend.getName());
        friendImage.setImageResource(friend.getDrawableId());

        return v;
    }
}
