
package com.example.mehjabeen.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class EventDBHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "events";
    public static final String COLUMN_ID = "event_id";
    public static final String COLUMN_NOTE = "event_note";

    public static final String DATABASE_NAME = "events_db";
    public static final int DATABASE_VERSION = 1;

    public EventDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTableSQL = "CREATE TABLE " + TABLE_NAME + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NOTE + " TEXT)";
        sqLiteDatabase.execSQL(createTableSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public Long insertEvent(String note) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NOTE, note);
        Long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();

        return result;
    }

    public List<EventBean> getAllEvents() {
        List<EventBean> eventBeanList = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();

        Cursor cursor = database.rawQuery(
                "SELECT * FROM " + TABLE_NAME,
                null
        );

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            EventBean eventBean = new EventBean();
            eventBean.setEventID(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
            eventBean.setEventNote(cursor.getString(cursor.getColumnIndex(COLUMN_NOTE)));
            eventBeanList.add(eventBean);
            cursor.moveToNext();
        }

        database.close();
        return eventBeanList;
    }
//    public EventBean getEventByID(Integer eventID) {
//        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
//        String sql = "SELECT * FROM  " + TABLE_NAME + "  WHERE  " + COLUMN_ID + " = " + eventID;
//        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
//        EventBean eventBean = new EventBean();
//        eventBean.setEventID(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
//        eventBean.setEventNote(cursor.getString(cursor.getColumnIndex(COLUMN_NOTE)));
//        return eventBean;
//    }

    public void deleteAllEvents(){
        SQLiteDatabase database = getWritableDatabase();
        database.delete(
                TABLE_NAME,
                null,
                null
        );
    }
}
