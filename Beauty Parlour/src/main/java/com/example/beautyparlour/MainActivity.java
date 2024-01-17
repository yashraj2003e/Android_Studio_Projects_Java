package com.example.beautyparlour;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    EditText name;
    EditText phoneNum;

    EditText date1;

    CheckBox skinCare,hairCare,makeUp,hairCut;

    Button submitBtn,resultActivityBtn,particularDate;

    String date,time;

    Database db = new Database(this,"parlour2",null,1);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextText);
        phoneNum = findViewById(R.id.editTextNumber);
        particularDate = findViewById(R.id.button5);

        date1 = findViewById(R.id.editTextDate);

        skinCare = findViewById(R.id.checkBox);
        hairCare = findViewById(R.id.checkBox2);

        submitBtn = findViewById(R.id.button);y
        resultActivityBtn = findViewById(R.id.button2);

        particularDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String results = db.getParticularDay(date1.getText().toString());
                Intent in = new Intent(MainActivity.this, ActivityResult.class);
                in.putExtra("result",results);
                startActivity(in);
            }
        });



        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String services = "";

                if(skinCare.isChecked()) {
                    services+=skinCare.getText().toString()+",";
                }
                if(hairCare.isChecked()) {
                    services+=hairCare.getText().toString()+",";
                }

                db.insertData(name.getText().toString(),phoneNum.getText().toString(),services,time,date);
            }
        });

        resultActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,ActivityResult.class);
                String result = db.display();
                in.putExtra("result",result);
                startActivity(in);
            }
        });
    }

    public void setDate(View v) {
        Calendar c = Calendar.getInstance();
        int pYear = c.get(Calendar.YEAR);
        int pMonth = c.get(Calendar.MONTH);
        int pDate = c.get(Calendar.DATE);
        DatePickerDialog datePick = new DatePickerDialog(this, android.R.style.Theme_DeviceDefault_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date =  year + "/" + (month+1) + "/" + dayOfMonth;
            }
        },pYear,pMonth,pDate);

        datePick.show();
    }

    public void setTime(View v) {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePick = new TimePickerDialog(this, android.R.style.Theme_DeviceDefault_Dialog_Alert, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                time = hourOfDay + ":" + minute;
            }
        },hour,minute,true);

        timePick.show();
    }

}