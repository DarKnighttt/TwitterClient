package com.projects.darknight.twitterclient.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.projects.darknight.twitterclient.PicassoCircleTransformation;
import com.projects.darknight.twitterclient.R;
import com.projects.darknight.twitterclient.adapter.TweetAdapter;
import com.projects.darknight.twitterclient.pojo.Tweet;
import com.projects.darknight.twitterclient.pojo.User;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.Collection;

public class UserInfoActivity extends AppCompatActivity {

    private ImageView userImage;
    private TextView userName;
    private TextView userNickName;
    private TextView userDescription;
    private TextView userLocation;
    private TextView userFollowingCount;
    private TextView userFollowersCount;

    private RecyclerView tweetsRecyclerView;
    private TweetAdapter tweetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        userImage = findViewById(R.id.tweet_user_image);
        userName = findViewById(R.id.tweet_user_name);
        userNickName = findViewById(R.id.tweet_user_nick_name);
        userDescription = findViewById(R.id.user_description);
        userLocation = findViewById(R.id.user_location);
        userFollowingCount = findViewById(R.id.user_following_count);
        userFollowersCount = findViewById(R.id.user_followers_count);

        loadUserInfo();
        initRecyclerView();
        loadTweets();

    }

    private Collection<Tweet> getTweets() {
        return Arrays.asList(
                new Tweet(getUser(), 1L, "Thu Dec 13 07:31:08 +0000 2017", "Очень длинное описание твита 1",
                        4L, 4L, "https://www.w3schools.com/w3css/img_fjords.jpg"),
                new Tweet(getUser(), 2L, "Thu Dec 12 07:31:08 +0000 2017", "Очень длинное описание твита 2",
                        5L, 5L, "https://www.w3schools.com/w3images/lights.jpg"),
                new Tweet(getUser(), 3L, "Thu Dec 11 07:31:08 +0000 2017", "Очень длинное описание твита 3",
                        6L, 6L, "https://www.w3schools.com/css/img_mountains.jpg")
        );
    }

    private void loadTweets(){
        Collection<Tweet> tweets = getTweets();
        tweetAdapter.setItems(tweets);
    }

    private void initRecyclerView(){
        tweetsRecyclerView = findViewById(R.id.tweets_recycler_view);
        tweetsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tweetAdapter = new TweetAdapter();
        tweetsRecyclerView.setAdapter(tweetAdapter);
    }

    private void loadUserInfo() {
        User user = getUser();
        displayUserInfo(user);
    }

    private void displayUserInfo(User user) {
        Picasso.get().load(user.getImgUrl())
                .transform(new PicassoCircleTransformation())
                .into(userImage);
        userName.setText(user.getName());
        userNickName.setText(user.getNickName());
        userDescription.setText(user.getDescription());
        userLocation.setText(user.getLocation());
        String followingCount = String.valueOf(user.getFollowingCount());
        userFollowingCount.setText(followingCount);
        String followersCount = String.valueOf(user.getFollowersCount());
        userFollowersCount.setText(followersCount);
    }

    private User getUser() {
        return new User(1L, "https://ae01.alicdn.com/kf/HTB1kDP6KVXXXXbuXFXXq6xXFXXXN/Batman-DC.jpg_640x640.jpg", "Bruce Wayne",
                "@batman", "The dark knight of Gotham.", "Gotham City", 79, 478900);
    }
}
