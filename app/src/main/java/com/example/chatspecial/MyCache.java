package com.example.chatspecial;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MyCache {
    public static void setName(Context context, String name){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("name", name);
        editor.commit();
    }
    public static String getUserFromCache(Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String name = preferences.getString("name", null);

        return name;
    }
}
