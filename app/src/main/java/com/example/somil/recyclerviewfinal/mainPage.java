package com.example.somil.recyclerviewfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Somil on 2/18/2018.
 */

public class mainPage extends AppCompatActivity {

    EditText login,password;
    Button signin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        login=(EditText)findViewById(R.id.login);
        password=(EditText)findViewById(R.id.password);
        signin=(Button)findViewById(R.id.signin);
        signin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(login.getText().toString().equals("admin")&& password.getText().toString().equals("admin"))
                        {
                            Intent i=new Intent(mainPage.this,MainActivity.class);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Wrong Credentials",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

    }
}
