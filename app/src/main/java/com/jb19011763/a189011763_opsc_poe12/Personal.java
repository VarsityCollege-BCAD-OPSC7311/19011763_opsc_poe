package com.jb19011763.a189011763_opsc_poe12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Personal extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef1 = database.getReference("personal");

    Button btnSubmit;
    EditText etHeight, etWeight, etCalorieIntake, etWeightGoal, etUpdateWeight;
    PersonalInfo o;
    String enteredHeight, enteredWeight, enteredCalories;
    Button barGraph;
    Button btnUpdate;
    PersonalInfo snap;
    String KEY = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        btnSubmit = findViewById(R.id.BtnSubmit);
        etHeight = findViewById(R.id.Height);
        etWeight = findViewById(R.id.Weight);
        etCalorieIntake = findViewById(R.id.CalorieIntake);
        etWeightGoal = findViewById(R.id.WeightGoal);
        btnUpdate = findViewById(R.id.btnUpdate);
        etUpdateWeight = findViewById(R.id.editTextNumberDecimal);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String HeightPush = etHeight.getText().toString().trim();
                String WeightPush = etWeight.getText().toString().trim();
                String CaloriesPush = etCalorieIntake.getText().toString().trim();

                /**
                 o = new PersonalInfo(HeightPush,WeightPush);
                 myRef1.push().setValue(o, CaloriesPush);


                 Intent sendIntent = new Intent(Intent.ACTION_SEND);
                 sendIntent.setType("text/plain");
                 startActivity(Intent.createChooser(sendIntent, "Info saved.."));
                 */

                HashMap<String, Object> personalInfo = new HashMap<String, Object>();
                String key = (KEY == null) ?  myRef1.child("personal").push().getKey() : KEY;
                KEY = key;

                PersonalInfo pI = new PersonalInfo(etHeight.getText().toString().trim(), etWeight.getText().toString().trim(), etCalorieIntake.getText().toString().trim(), etWeightGoal.getText().toString().trim());
                snap = pI;
                Map<String, Object> childUpdates = new HashMap<>();
                childUpdates.put("/personal/" + key, pI.toMap());
                myRef1.updateChildren(childUpdates).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Write was successful!
                        // ...
                        Toast.makeText(Personal.this,"Successfully committed data to Firebase", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Write failed
                        // ...
                    }
                });;
            }


        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object> personalInfo = new HashMap<String, Object>();
                //String key = myRef1.child("personal").push().getKey();
                //PersonalInfo pI = new PersonalInfo(etHeight.getText().toString().trim(), etWeight.getText().toString().trim(), etCalorieIntake.getText().toString().trim(), etWeightGoal.getText().toString().trim());
                snap.Weight = "" + (Double.parseDouble(snap.Weight)+Double.parseDouble(etUpdateWeight.getText().toString().trim()));
                Map<String, Object> childUpdates = new HashMap<>();
                childUpdates.put("/personal/" + KEY, snap.toMap());
                myRef1.updateChildren(childUpdates).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Write was successful!
                        // ...
                        Toast.makeText(Personal.this,"Successfully updates data to Firebase", Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Write failed
                        // ...
                    }
                });;
            }
        });


    }
}


