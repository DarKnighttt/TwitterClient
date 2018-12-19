package com.projects.darknight.twitterclient.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.projects.darknight.twitterclient.R;
import com.projects.darknight.twitterclient.adapter.UsersAdapter;
import com.projects.darknight.twitterclient.pojo.User;

import java.util.Arrays;
import java.util.Collection;


public class SearchUsersActivity extends AppCompatActivity {

    private RecyclerView usersRecyclerView;
    private UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_users);

        initRecyclerView();
        searchUsers();
    }

    private void initRecyclerView(){
        usersRecyclerView = findViewById(R.id.users_recycler_view);
        usersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        usersAdapter = new UsersAdapter();
        usersRecyclerView.setAdapter(usersAdapter);
    }

    private Collection<User> getUsers() {
        return Arrays.asList(
                new User(1L, "https://wallpapercave.com/wp/hk5drEO.jpg", "Bruce Wayne",
                        "@batman", "The dark knight of Gotham.", "Gotham City", 79, 478900),
                new User(2L, "http://www.hdwallpapersfreedownload.com/uploads/large/super-heroes/return-of-superman.jpg", "Clark Kent",
                        "@superman", "The hope of the Earth.", "Metropolis", 46, 4900)
        );
    }

    private void searchUsers(){
        Collection<User> users = getUsers();
        usersAdapter.setItems(users);
    }
}
