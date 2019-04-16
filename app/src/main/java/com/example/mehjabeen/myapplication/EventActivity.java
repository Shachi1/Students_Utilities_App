package com.example.mehjabeen.myapplication;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class EventActivity extends AppCompatActivity {

    private EventDBHelper db;
    EditText etNote;
    TextView tv;
    Button addEventButton, deleteEventButton, btn_datepicker;
    String formattedDateText;

    DatePickerDialog datePickerDialog;

    Calendar calToday;
    Calendar calSelectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        addEventButton = findViewById(R.id.addID);
        deleteEventButton = findViewById(R.id.deleteID);
        btn_datepicker = findViewById(R.id.btn_datepicker);

        etNote = (EditText) findViewById(R.id.noteID);
        tv = (TextView) findViewById(R.id.ii);
        db = new EventDBHelper(EventActivity.this);

        displayEventsFromDB();


        calToday = new GregorianCalendar();
        calSelectedDate = new GregorianCalendar();
        calToday.setTime(new Date());

        btn_datepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog = new DatePickerDialog(
                        EventActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                calSelectedDate.set(Calendar.YEAR, year);
                                calSelectedDate.set(Calendar.MONTH, month);
                                calSelectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                                calSelectedDate.set(Calendar.HOUR, 4);
                                calSelectedDate.set(Calendar.SECOND, 49);

                                calToday = calSelectedDate;

                                SimpleDateFormat sdf = new SimpleDateFormat("dd MMM, yyyy");
                                formattedDateText = sdf.format(calSelectedDate.getTime());
                            }
                        },
                        calToday.get(Calendar.YEAR),
                        calToday.get(Calendar.MONTH),
                        calToday.get(Calendar.DAY_OF_MONTH)
                );
                datePickerDialog.create();
                datePickerDialog.show();


            }
        });

        addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = etNote.getText().toString();
                db.insertEvent(formattedDateText+":  "+inputText);
                displayEventsFromDB();
                etNote.setText("");
            }
        });

        deleteEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteAllEvents();
                displayEventsFromDB();
            }
        });
    }

    void displayEventsFromDB() {
        List<EventBean> eventBeanList = db.getAllEvents();
        String eventNotes = "";
        for (EventBean eventBean : eventBeanList) {
            eventNotes =  eventNotes + eventBean.getEventNote() + "\n";
        }
        tv.setText(eventNotes);
    }
}

