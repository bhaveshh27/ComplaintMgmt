package com.example.complaintmgmt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView txtUsername;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txtUsername=findViewById(R.id.txtUsername);
        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","").toString();
        txtUsername.setText("Welcome "+username+"!");
        CardView exit;
        exit=findViewById(R.id.CardLogoff);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this,loginActivity.class));
                finish();
            }
        });
        CardView addComplaint;
        addComplaint=findViewById(R.id.CardAddComplaint);
        addComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,addComplaintactivity.class));
            }
        });
        CardView viewComplaint;
        viewComplaint=findViewById(R.id.CardViewComplaint);
        viewComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,viewComplaintActivity.class));
            }
        });
        CardView feedback;
        feedback=findViewById(R.id.CardFeedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,feedbackActivity.class));
            }
        });

    }
}

























