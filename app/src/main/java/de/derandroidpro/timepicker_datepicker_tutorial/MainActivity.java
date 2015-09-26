package de.derandroidpro.timepicker_datepicker_tutorial;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.TimeUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTime, btnDate;
    TextView tvTime, tvDate;

    TimePickerDialog timePickerDialog;
    DatePickerDialog datePickerDialog;

    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTime = (Button) findViewById(R.id.button);
        btnTime.setOnClickListener(this);
        btnDate = (Button) findViewById(R.id.button2);
        btnDate.setOnClickListener(this);

        tvTime = (TextView) findViewById(R.id.textView);
        tvDate = (TextView) findViewById(R.id.textView2);

    }


    @Override
    public void onClick(View v) {

        calendar = Calendar.getInstance();

        switch (v.getId()){

            case R.id.button:{

                timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        Calendar timeCalendar = Calendar.getInstance();
                        timeCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        timeCalendar.set(Calendar.MINUTE, minute);

                        String timestring = DateUtils.formatDateTime(MainActivity.this, timeCalendar.getTimeInMillis(), DateUtils.FORMAT_SHOW_TIME);
                        tvTime.setText("Uhrzeit: " + timestring);

                    }
                },calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), android.text.format.DateFormat.is24HourFormat(MainActivity.this));

                timePickerDialog.show();
                break;
            }

            case R.id.button2:{

                    datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                            Calendar dateCalendar = Calendar.getInstance();
                            dateCalendar.set(Calendar.YEAR, year);
                            dateCalendar.set(Calendar.MONTH, monthOfYear);
                            dateCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                            String dateString = DateUtils.formatDateTime(MainActivity.this, dateCalendar.getTimeInMillis(), DateUtils.FORMAT_SHOW_DATE);
                            tvDate.setText("Datum: " + dateString);

                        }
                    }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.show();
                break;
            }


        }

    }
}
