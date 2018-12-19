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
import com.projects.darknight.twitterclient.pojo.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private List<User> userList = new ArrayList<>();

    class UsersViewHolder extends RecyclerView.ViewHolder{

        private ImageView userImageView;
        private TextView userNameTextView;
        private TextView userNickNameTextView;

        public UsersViewHolder(View itemView) {
            super(itemView);
            userImageView = itemView.findViewById(R.id.user_image);
            userNameTextView = itemView.findViewById(R.id.user_name);
            userNickNameTextView = itemView.findViewById(R.id.user_nick_name);
        }

        private void bind (User user){
            Picasso.get().load(user.getImgUrl()).transform(new PicassoCircleTransformation()).into(userImageView);
            userNameTextView.setText(user.getName());
            userNickNameTextView.setText(user.getNickName());
        }
    }


    public void setItems(Collection<User> users){
        userList.addAll(users);
        notifyDataSetChanged();
    }

    public  void clearItems(){
        userList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item_view, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        holder.bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
