package com.sanket.funplay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sanket.funplay.Java_FIles.LocaleHelper;

public class Splash extends AppCompatActivity {

    DatabaseReference databaseReference;
    Button login;
    EditText pass;
    ImageView image1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pass = findViewById(R.id.pd1);
        login = findViewById(R.id.lb1);
        image1 = findViewById(R.id.logo_splash);

        image1.setVisibility(View.VISIBLE);

        LocaleHelper l1 = new LocaleHelper(Splash.this);
        SharedPreferences sp1 = PreferenceManager.getDefaultSharedPreferences(Splash.this);
        if (sp1.getString("app_langy","english").equals("english"))
            l1.setAppLocale("en");
        else if (sp1.getString("app_langy","english").equals("marathi"))
            l1.setAppLocale("mr");
        else if (sp1.getString("app_langy","hindi").equals("marathi"))
            l1.setAppLocale("hi");

        databaseReference = FirebaseDatabase.getInstance().getReference("Login");


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Login_class lc1 = dataSnapshot.getValue(Login_class.class);

                if (lc1.getLock_mode().equals("OFF") || lc1.getLock_mode().equals("off"))
                {
                    splashit();
                }
                else {
                    image1.setVisibility(View.INVISIBLE);
                    pass.setVisibility(View.VISIBLE);
                    login.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Login_class lc1 = dataSnapshot.getValue(Login_class.class);

                        if (lc1.getLock_mode().equals("ON") || lc1.getLock_mode().equals("on"))
                        {
                            if(pass.getText().toString().equals(lc1.getPassword()))
                            {
                                startActivity(new Intent(Splash.this,MainActivity.class));
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


    }

    private void splashit() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                finishAffinity();
                startActivity(new Intent(Splash.this,MainActivity.class));
            }
        },2000);
    }
}
