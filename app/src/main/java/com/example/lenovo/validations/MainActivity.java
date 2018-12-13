package com.example.lenovo.validations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class MainActivity extends AppCompatActivity {

    private EditText name,password,mail,confirm,phone;
    private Button Submit;
    public AwesomeValidation awesomeValidation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        awesomeValidation= new AwesomeValidation(ValidationStyle.BASIC);



        updateUI();
        }


    private void updateUI(){

            name = findViewById(R.id.name);
            password=findViewById(R.id.password);
            confirm=findViewById(R.id.confirm);
            mail=findViewById(R.id.mail);
            phone=findViewById(R.id.phone);
            Submit=findViewById(R.id.submit);

        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";

            awesomeValidation.addValidation(MainActivity.this,R.id.name, "[a-zA-Z\\s]+", R.string.error);
            awesomeValidation.addValidation(MainActivity.this,R.id.password, regexPassword,  R.string.password);
            awesomeValidation.addValidation(MainActivity.this,R.id.mail,android.util.Patterns.EMAIL_ADDRESS,R.string.email);
            awesomeValidation.addValidation(MainActivity.this,R.id.phone,RegexTemplate.TELEPHONE,R.string.phone);
            awesomeValidation.addValidation(MainActivity.this,R.id.confirm,R.id.password,R.string.retypepass);
            Submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (awesomeValidation.validate()){
                        Toast.makeText(MainActivity.this,"Data received sucessfully",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
                    }

                }
            });

    }
}
