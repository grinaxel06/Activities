package com.example.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;

import com.example.activities.databinding.AnotherActivityBinding;

public class AnotherActivity extends Activity implements View.OnClickListener {

    private static final int CAMERA_REQUEST_CODE = 2;
    private static final int FORM_RESULT_CODE = 1;
    AnotherActivityBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AnotherActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.photo.setOnClickListener(this);
        binding.back.setOnClickListener(this);
        Intent intent=getIntent();
        binding.loginText.setText("Привет,"+ intent.getStringExtra("Login"));
        Log.i("INFO", intent.getStringExtra("Login"));





    }


    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.photo:
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
                break;

            case R.id.back:
                finish();
                break;


        }



    }


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v("RESULT", "requesCode = "+requestCode+" resultCode = "+resultCode);
        if(resultCode==RESULT_OK){
            switch(requestCode){
                case FORM_RESULT_CODE:
                    Log.i("INFO",data.getData().toString());
                    break;
                case CAMERA_REQUEST_CODE:
                    if(data!=  null){
                        Log.i("INFO",data.getData().toString());
                        Bitmap thumbnail=(Bitmap) data.getExtras().get("data");
                        binding.image.setImageBitmap(thumbnail);
                    }
                    else{
                        Log.e("PROBLEM","data==null");
                    }
            }

        }

    }


}