package com.projects.darknight.twitterclient.pojo;

public class User {

    private Long id;
    private String imgUrl;
    private String name;
    private String nickName;
    private String description;
    private String location;
    private int followingCount;
    private int followersCount;

    public User(Long id, String imgUrl, String name, String nickName, String description, String location, int followingCount, int followersCount) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.nickName = nickName;
        this.description = description;
        this.location = location;
        this.followingCount = followingCount;
        this.followersCount = followersCount;
    }

    public Long getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (followingCount != user.followingCount) return false;
        if (followersCount != user.followersCount) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (imgUrl != null ? !imgUrl.equals(user.imgUrl) : user.imgUrl != null) return false;
        if (!name.equals(user.name)) return false;
        if (!nickName.equals(user.nickName)) return false;
        if (description != null ? !description.equals(user.description) : user.description != null)
            return false;
        return location != null ? location.equals(user.location) : user.location == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        result = 31 * result + name.hashCode();
        result = 31 * result + nickName.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + followingCount;
        result = 31 * result + followersCount;
        return result;
    }
}
