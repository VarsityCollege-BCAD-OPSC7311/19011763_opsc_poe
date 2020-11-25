package com.jb19011763.a189011763_opsc_poe12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Conversion extends AppCompatActivity {

    EditText EnterKgs;
    TextView KgsTitle, PoundsTitle, PoundsDisplay;
    Button btn_convert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        KgsTitle = findViewById(R.id.KgsTitle);
        EnterKgs = findViewById(R.id.EnterKgs);
        PoundsTitle = findViewById(R.id.PoundsTitle);
        PoundsDisplay = findViewById(R.id.PoundsDisplay);
        btn_convert = findViewById(R.id.btn_convert);

        //Click event for button
        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calling ConvertMethod Method

                ConvertMethod();


            }
        });





    }

    private void ConvertMethod() {
        //Method converts kgs to pounds
        //displays in textview

        String valueEnteredKilo = EnterKgs.getText().toString();

        //Converting string to number

        double Kilo = Double.parseDouble(valueEnteredKilo);

        //converting kilo to pounds
        double pounds = Kilo * 2.205;

        //Displaying value in PoundsDisplay
        PoundsDisplay.setText(""+ pounds);


    }
}