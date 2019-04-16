package com.example.mehjabeen.myapplication;


import android.content.Context;

public class SharedPreferenceManager {

    private static String LoginToken = "LoginToken";
    private static String RiderID = "RiderID";
    private static String RiderName = "RiderName";
    private static String UserGuideShown = "UserGuideShown";
    private static String LoadingroutineUri = "LoadingroutineUri";

    private static String readPreference(Context context, String preferenceName) {
        return context.getSharedPreferences(context.getResources().getString(R.string.app_name), Context.MODE_PRIVATE).getString(preferenceName, "");
    }

    private static void writePreference(Context context, String preferenceName, String value) {
        context.getSharedPreferences(context.getResources().getString(R.string.app_name), Context.MODE_PRIVATE).edit().putString(preferenceName, value).apply();
    }

    public static void saveRoutineImageUri(Context context, String imageUri){
        writePreference(context,LoadingroutineUri,imageUri);
    }
    public static String getRoutineImageUri(Context context){
        return readPreference(context, LoadingroutineUri);
    }
}