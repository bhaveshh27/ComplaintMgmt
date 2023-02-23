package com.example.complaintmgmt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    TextView txtReg;
    EditText edNm,edPass;
    Button btnLogIn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtReg=findViewById(R.id.txtReg);
        edNm=findViewById(R.id.edUserName);
        edPass=findViewById(R.id.edPass);
        btnLogIn=findViewById(R.id.btnLog);
        txtReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginActivity.this,regActivity.class));
            }
        });
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=edNm.getText().toString();
                String password=edPass.getText().toString();
                Database db=new Database(getApplicationContext(),"IssueTrak",null,1);
                if(username.length()==0||password.length()==0){
                    Toast.makeText(getApplicationContext(),"Please Fill all details",Toast.LENGTH_SHORT).show();
                }else{
                    if(db.Login(username,password)==1){
                        Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("username",username);
                        editor.apply();
                        startActivity(new Intent(loginActivity.this,HomeActivity.class));
                    }else{
                        Toast.makeText(getApplicationContext(),"Invalid Username or Password",Toast.LENGTH_SHORT).show();
                }
                }

            }
        });


    }
}