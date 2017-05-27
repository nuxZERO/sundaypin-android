package me.cafecode.android.sundaypin.data;

import android.content.SharedPreferences;

/**
 * Created by Natthawut Hemathulin on 5/9/2017 AD.
 * Email: natthawut1991@gmail.com
 */

public class PreferenceManager implements PreferenceManagerInterface {


    public static final String LOGGED_IN = "logged_in";

    private SharedPreferences mSharedPreferences;

    public PreferenceManager(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    public SharedPreferences getSharedPreferences() {
        return mSharedPreferences;
    }

    @Override
    public void setLoggedIn(boolean isLoggedIn) {
        mSharedPreferences.edit().putBoolean(LOGGED_IN, isLoggedIn).apply();
    }

    @Override
    public boolean isLoggedIn() {
        return mSharedPreferences.getBoolean(LOGGED_IN, false);
    }

}
