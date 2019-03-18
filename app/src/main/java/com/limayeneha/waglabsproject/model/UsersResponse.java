package com.limayeneha.waglabsproject.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by limayeneha on 3/11/19.
 */

public class UsersResponse {

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("items")
    @Expose
    private List<User> items;

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<User> getItems() {
        return items;
    }

    public void setItems(List<User> items) {
        this.items = items;
    }
}
