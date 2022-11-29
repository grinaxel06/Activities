package com.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import com.example.activities.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;
    protected String a;
    protected String b;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(this);
        a= binding.login.getText().toString();
        b=binding.password.getText().toString();
    }


    @Override
    public void onClick(View view) {
            switch (view.getId()) {

                case R.id.button:
                    if ((binding.login.getText().toString().equals("rickroll@gmail.com") && binding.password.getText().toString().equals("RickAstley") )|| (binding.password.getText().toString().length() > 8 && binding.login.getText().toString().indexOf('@') != -1)) {
                        Log.i("INFO", a + ' ' + b);
                        Intent intent = new Intent(this, AnotherActivity.class);
                        intent.putExtra("Login",binding.login.getText().toString() );
                        startActivity(intent);
                        binding.Error.setText("");
                    } else {
                        binding.Error.setText("Неправильный логин или пароль");
                        Log.e("PROBLEM", binding.login.getText().toString()+ ' ' + binding.password.getText().toString());

                    }
                    break;
            }

    }
}