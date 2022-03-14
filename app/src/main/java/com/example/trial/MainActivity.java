package com.example.trial;



import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URI;


public class MainActivity extends AppCompatActivity {
    private Button btn;
    private ImageView iv;

    int SELECT_IMAGE_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = findViewById(R.id.button);
        iv = findViewById(R.id.pickedImage);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i, "Title"), SELECT_IMAGE_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int reqCode, int resCode, @Nullable Intent data){
        super.onActivityResult(reqCode, resCode, data);
        if(reqCode==1){
            Uri uri = data.getData();
            iv.setImageURI(uri);


        }
    }

    }
