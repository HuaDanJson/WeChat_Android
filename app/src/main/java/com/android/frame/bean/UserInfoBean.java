package com.android.frame.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jason on 2017/12/4.
 */

public class UserInfoBean {

    /**
     * profile-image : http://img2.findthebest.com/sites/default/files/688/media/images/Mingle_159902_i0.png
     * avatar : http://info.thoughtworks.com/rs/thoughtworks2/images/glyph_badge.png
     * nick : John Smith
     * username : jsmith
     */

    @SerializedName("profile-image") private String profileimage;
    private String avatar;
    private String nick;
    private String username;

    public String getProfileimage() { return profileimage;}

    public void setProfileimage(String profileimage) { this.profileimage = profileimage;}

    public String getAvatar() { return avatar;}

    public void setAvatar(String avatar) { this.avatar = avatar;}

    public String getNick() { return nick;}

    public void setNick(String nick) { this.nick = nick;}

    public String getUsername() { return username;}

    public void setUsername(String username) { this.username = username;}

    @Override
    public String toString() {
        return "UserInfoBean{" + "profileimage='" + profileimage + '\'' + ", avatar='" + avatar + '\'' + ", nick='" + nick + '\'' + ", username='" + username + '\'' + '}';
    }
}
