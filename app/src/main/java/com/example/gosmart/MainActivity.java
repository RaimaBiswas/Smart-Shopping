package com.example.gosmart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.gosmart.R.drawable.icon;

public class MainActivity extends AppCompatActivity {

    public String Username;
    public String password,name,p,name1,p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //giving a reference to the username and password Input and Log in Button and icon image
        Button logIn=(Button)findViewById(R.id.logIn);

        ImageView iconImage=(ImageView)findViewById(R.id.iconImage);
        iconImage.setImageResource(icon);


        name="Raima";
        p="12345";
        name1="Lubna";
        p1="54321";
    }

    public void onClickLogIn(View view) {
        final EditText user=(EditText)findViewById(R.id.nameInput);
        final EditText pass=(EditText)findViewById(R.id.passwordInput);

        Username=user.getText().toString();
        password=pass.getText().toString();

        if (((Username.equals(name)) && (password.equals(p))) || ((Username.equals(name1)) && (password.equals(p1))))

        {
            Intent i = new Intent(this, Main2Activity.class);
            //sending the username
            EditText nameInput = (EditText) findViewById(R.id.nameInput);
            String nameData = nameInput.getText().toString();//get the input in the editText
            i.putExtra("LogInMessage", nameData);//get extra information and store in appleMessage

            startActivity(i);
        }
        else{
            Toast.makeText(MainActivity.this, "Incorrect Username & Password", Toast.LENGTH_LONG).show();
        }
    }
}