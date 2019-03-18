package com.limayeneha.waglabsproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Created by limayeneha on 3/11/19.
 */

public class User {

    @SerializedName("display_name")
    @Expose
    private String displayName;

    @SerializedName("profile_image")
    @Expose
    private String profileImage;

    @SerializedName("badge_counts")
    @Expose
    private Map<String, String> badges = null;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Map<String, String> getBadges() {
        return badges;
    }

    public void setBadges(Map<String, String> badges) {
        this.badges = badges;
    }
}
