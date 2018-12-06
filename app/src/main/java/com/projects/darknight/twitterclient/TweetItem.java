package com.projects.darknight.twitterclient;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class TweetItem extends AppCompatActivity {

    private ImageView userImage;
    private ImageView contentImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tweet_item);

        userImage = findViewById(R.id.userImage);
        contentImage = findViewById(R.id.contentImage);

        Picasso.get().load("https://ae01.alicdn.com/kf/HTB1kDP6KVXXXXbuXFXXq6xXFXXXN/Batman-DC.jpg_640x640.jpg")
                .transform(new PicassoCircleTransformation())
                .into(userImage);

        Picasso.get().load("http://www.gcap.ir/wp-content/uploads/2016/12/Buy-Batman-Arkham-Knight-Premium-Edition-GCap.ir_.jpg")
                .into(contentImage);
    }
}
