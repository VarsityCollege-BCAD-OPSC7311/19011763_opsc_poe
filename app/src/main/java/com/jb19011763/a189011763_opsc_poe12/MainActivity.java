package com.jb19011763.a189011763_opsc_poe12;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("orders");

    EditText email, password;
    Button login, register;
    private FirebaseAuth mAuth;
    FirebaseUser currentuser;
    String enteredEmail;
    String enteredPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.EmailField);
        password = findViewById(R.id.PasswordField);
        login = findViewById(R.id.LoginButton);
        register = findViewById(R.id.RegisterButton);
<<<<<<< HEAD
        currentuser = mAuth.getInstance().getCurrentUser();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        //findViewById(R.id.btn_BarGraph).setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View v) {
           //     startActivity(new Intent(getApplicationContext(), BarGraph.class));
           // }

       // });
=======
        currentuser = mAuth.getCurrentUser();



        findViewById(R.id.btn_BarGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BarGraph.class));
            }

        });
>>>>>>> 92885e8e773f3b7d7d4356b4022a424ec3fdf3f9


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                enteredEmail = email.getText().toString().trim();
                myRef.push().setValue(enteredEmail);

                 enteredPassword = password.getText().toString().trim();
                myRef.push().setValue(enteredPassword);

                mAuth.createUserWithEmailAndPassword(enteredEmail, enteredPassword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {




                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this,
                                            "User " + mAuth.getCurrentUser().getEmail() + "Successfully registered", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(MainActivity.this,
                                            "Error, No Registration.", Toast.LENGTH_SHORT).show();
                                }

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredEmail = email.getText().toString().trim();
                String enteredPassword = password.getText().toString().trim();

                mAuth.signInWithEmailAndPassword((enteredEmail), enteredPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Logged in"
                                    + mAuth.getCurrentUser().getEmail() + "successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
<<<<<<< HEAD

=======
>>>>>>> 92885e8e773f3b7d7d4356b4022a424ec3fdf3f9
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

<<<<<<< HEAD
        //FirebaseUser currentuser = mAuth.getCurrentUser();
=======
        FirebaseUser currentuser = mAuth.getCurrentUser();
>>>>>>> 92885e8e773f3b7d7d4356b4022a424ec3fdf3f9

        if (currentuser != null) {
            Toast.makeText(this, "You are already logged in" + mAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
        }
    }
}

