package com.github.challenge.ui.profile.adapter;


import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.github.challenge.ui.profile.adapter.UserViewType.HEADER;
import static com.github.challenge.ui.profile.adapter.UserViewType.OTHER;

@IntDef({HEADER, OTHER})
@Retention(RetentionPolicy.SOURCE)
public @interface UserViewType {

    /**
     * User Profile
     */
    int HEADER = 0;


    /**
     * Repository
     */
    int OTHER = 1;
}

