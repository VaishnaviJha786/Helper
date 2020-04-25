package com.example.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    EditText msg;
    Button btn;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        msg=findViewById(R.id.msg);
        textToSpeech= new TextToSpeech(this,this);
    }

    @Override
    public void onInit(int status) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message=msg.getText().toString();
                textToSpeech.speak(message,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
    }
}
