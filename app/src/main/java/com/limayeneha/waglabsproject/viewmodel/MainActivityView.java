package com.limayeneha.waglabsproject.viewmodel;

import com.limayeneha.waglabsproject.model.User;

import java.util.List;

/**
 * Created by limayeneha on 3/13/19.
 */

public interface MainActivityView extends IView  {

    void load(List<User> userList);
}
