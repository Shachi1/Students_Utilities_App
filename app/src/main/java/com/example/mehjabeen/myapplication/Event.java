package com.example.mehjabeen.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

//import com.github.sundeepk.compactcalendarview.CompactCalendarView;
//import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Event extends AppCompatActivity {

    CalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
//
//        final ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(false);
//        actionBar.setTitle(null);
//
//        compactCalendar = (CalendarView) findViewById(R.id.calendarID);
//       // compactCalendar.setUseThreeLetterAbbreviation(true);
//
//
//       // Event ev1 = new Event(Color.RED, 1477040400000L, "Teachers' Professional Day");
//       // compactCalendar.addEvent(ev1);
//
//        compactCalendar.setListener(new CalendarView.CompactCalendarViewListener() {
//            @Override
//            public void onDayClick(Date dateClicked) {
//                Context context = getApplicationContext();
//
//                if (dateClicked.toString().compareTo("Fri Oct 21 00:00:00 AST 2016") == 0) {
//                    Toast.makeText(context, "Teachers' Professional Day", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(context, "No Events Planned for that day", Toast.LENGTH_SHORT).show();
//                }
//
//
//            }
//
//            @Override
//            public void onMonthScroll(Date firstDayOfNewMonth) {
//                actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
//            }
//        });
    }
}

