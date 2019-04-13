package com.example.mehjabeen.myapplication;

//import android.content.Context;
//import android.graphics.Color;
//import android.support.v7.app.ActionBar;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.github.sundeepk.compactcalendarview.CompactCalendarView;
//import com.github.sundeepk.compactcalendarview.domain.Event;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Locale;

public class EventActivity extends AppCompatActivity {


    CalendarView compactCalendar;
    EditText etNote;
    TextView tv;
    boolean isEventPresent = false;
    public static Pair<String,String> date;
//    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);



//        final ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(false);
//        actionBar.setTitle(null);
//
        etNote = (EditText) findViewById(R.id.noteID);
        tv = (TextView) findViewById(R.id.ii);

        compactCalendar = (CalendarView) findViewById(R.id.calendarID);
        compactCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView compactCalendar, int year, int month, int dayOfMonth) {
                month=month+1;
                etNote.setText("");
                String str = dayOfMonth +""+ month ;
                String str2 = etNote.getText().toString();
                date=new Pair <String, String> (str,str2);
                Toast.makeText(EventActivity.this,"No Event",Toast.LENGTH_LONG).show();
               // tv.setText(R.string.d144);

               // etNote.setText(dayOfMonth);


            }
        });

//        compactCalendar.setUseThreeLetterAbbreviation(true);
//
//
//        Event ev1 = new Event(Color.RED, 1477040400000L, "Teachers' Professional Day");
//        compactCalendar.addEvent(ev1);
//
//        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
//            @Override
//            public void onDayClick(Date dateClicked) {
//                Context context = getApplicationContext();
//
//                if (dateClicked.toString().compareTo("Fri Oct 21 00:00:00 AST 2016") == 0) {
//                    Toast.makeText(context, "Teachers' Professional Day", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(context, "No EventActivity Planned for that day", Toast.LENGTH_SHORT).show();
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

