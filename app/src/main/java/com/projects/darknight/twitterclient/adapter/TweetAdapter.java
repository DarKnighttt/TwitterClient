package com.projects.darknight.twitterclient.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.projects.darknight.twitterclient.PicassoCircleTransformation;
import com.projects.darknight.twitterclient.R;
import com.projects.darknight.twitterclient.pojo.Tweet;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.TweetViewHolder>{

    private static final String TWITTER_RESPONSE_FORMAT = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
    private static final String MONTH_DAY_FORMAT = "MMM d";


    private List<Tweet> tweetList = new ArrayList<>();

    class TweetViewHolder extends RecyclerView.ViewHolder{
        private ImageView userImageView;
        private TextView userNameTextView;
        private TextView userNickNameTextView;
        private TextView tweetCreationDate;
        private TextView tweetContentTextView;
        private ImageView tweetImageView;
        private TextView tweetRetweetTextView;
        private TextView tweetLikesTextView;

        public TweetViewHolder(View itemView) {
            super(itemView);
            userImageView = itemView.findViewById(R.id.tweet_user_image);
            userNameTextView = itemView.findViewById(R.id.tweet_user_name);
            userNickNameTextView = itemView.findViewById(R.id.tweet_user_nick_name);
            tweetCreationDate = itemView.findViewById(R.id.tweet_creation_date);
            tweetContentTextView = itemView.findViewById(R.id.tweet_text);
            tweetImageView = itemView.findViewById(R.id.tweet_image);
            tweetRetweetTextView = itemView.findViewById(R.id.tweet_retweet_count);
            tweetLikesTextView = itemView.findViewById(R.id.tweet_like_count);
        }

        public void bind(Tweet tweet){
            userNameTextView.setText(tweet.getUser().getName());
            userNickNameTextView.setText(tweet.getUser().getNickName());
            tweetContentTextView.setText(tweet.getText());
            tweetRetweetTextView.setText(String.valueOf(tweet.getRetweetCount()));
            tweetLikesTextView.setText(String.valueOf(tweet.getLikesCount()));

            String creationDateFormaatted = getFormattedDate(tweet.getCreationDate());
            tweetCreationDate.setText(creationDateFormaatted);

            Picasso.get().load(tweet.getUser().getImgUrl()).transform(new PicassoCircleTransformation()).into(userImageView);

            String tweetPhotoUrl = tweet.getImageUrl();
            Picasso.get().load(tweetPhotoUrl).into(tweetImageView);
            tweetImageView.setVisibility(tweetPhotoUrl!= null ? View.VISIBLE : View.GONE);
        }
    }

    private String getFormattedDate(String rawDate) {
        SimpleDateFormat utcFormat = new SimpleDateFormat(TWITTER_RESPONSE_FORMAT, Locale.ROOT);
        SimpleDateFormat displayedFromat = new SimpleDateFormat(MONTH_DAY_FORMAT, Locale.getDefault());

        try {
            Date date = utcFormat.parse(rawDate);
            return  displayedFromat.format(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public void setItems(Collection<Tweet> tweets){
        tweetList.addAll(tweets);
        notifyDataSetChanged();
    }

    public  void clearItems(){
        tweetList.clear();
    }

    @NonNull
    @Override
    public TweetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tweet_item, parent, false);
        return new TweetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TweetViewHolder holder, int position) {
        holder.bind(tweetList.get(position));
    }

    @Override
    public int getItemCount() {
        return tweetList.size();
    }
}
