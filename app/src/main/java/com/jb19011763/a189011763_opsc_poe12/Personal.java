package com.jb19011763.a189011763_opsc_poe12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Personal extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef1 = database.getReference("orders");

    Button btnSubmit;
    EditText etHeight, etWeight, etCalorieIntake, etWeightGoal;
    PersonalInfo o;
    String enteredHeight, enteredWeight, enteredCalories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        btnSubmit = findViewById(R.id.BtnSubmit);
        etHeight = findViewById(R.id.Height);
        etWeight = findViewById(R.id.Weight);
        etCalorieIntake = findViewById(R.id.CalorieIntake);
        etWeightGoal = findViewById(R.id.WeightGoal);


        btnSubmit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String HeightPush = etHeight.getText().toString().trim();
                String WeightPush = etWeight.getText().toString().trim();
                String CaloriesPush = etCalorieIntake.getText().toString().trim();

                o = new PersonalInfo(HeightPush,WeightPush);
                myRef1.push().setValue(o, CaloriesPush);


                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, "Info saved.."));

            }

            
        });


    }
}


