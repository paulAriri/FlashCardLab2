package com.example.flashcardlab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String str1;
    String str2;
    TextView qView;
    TextView aView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qView = findViewById(R.id.flashCard_question);
        aView = findViewById(R.id.flashCard_answer);

        findViewById(R.id.flashCard_question).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                qView.setVisibility(v.INVISIBLE);
                aView.setVisibility(v.VISIBLE);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                MainActivity.this.startActivityForResult(intent,100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == RESULT_OK) {
            str1 = data.getExtras().getString("string1");
            str2 = data.getExtras().getString("string2");

            qView.setText(str1);
            aView.setText(str2);
        }
    }
}
