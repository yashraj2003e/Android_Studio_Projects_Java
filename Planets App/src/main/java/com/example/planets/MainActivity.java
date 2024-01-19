package com.example.planets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    Spinner selectPlanet;
    TextView showZodiac;
    Button submit;
    String selectedPlanet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectPlanet = findViewById(R.id.spinner);
        showZodiac = findViewById(R.id.textView2);
        submit = findViewById(R.id.button);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.planetss));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectPlanet.setAdapter(adapter);
        selectPlanet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedPlanet = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void DisplayPlanetDetails(View v) {
        showZodiac.setText(selectedPlanet);
    }


}