package com.projects.darknight.twitterclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class UserInfoActivity extends AppCompatActivity {

    private ImageView userImage;
    private TextView userName;
    private TextView userNickName;
    private TextView userDescription;
    private TextView userLocation;
    private TextView userFollowingCount;
    private TextView userFollowersCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        userImage = findViewById(R.id.userImage);
        userName = findViewById(R.id.userName);
        userNickName = findViewById(R.id.userNickName);
        userDescription = findViewById(R.id.userDescription);
        userLocation = findViewById(R.id.userLocation);
        userFollowingCount = findViewById(R.id.userFollowingCount);
        userFollowersCount = findViewById(R.id.userFollowersCount);

        Picasso.get().load("https://ae01.alicdn.com/kf/HTB1kDP6KVXXXXbuXFXXq6xXFXXXN/Batman-DC.jpg_640x640.jpg")
                .transform(new PicassoCircleTransformation())
                .into(userImage);
    }
}
