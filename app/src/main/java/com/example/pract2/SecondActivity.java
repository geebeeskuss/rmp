package com.example.pract2;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_lay);
        Bundle extras = getIntent().getExtras();
        String age = extras.getString("answer");

        TextView text3 = (TextView) findViewById(R.id.text3);
        ImageView sakura3 = (ImageView) findViewById(R.id.sakura3);
        TextView button3 = (TextView) findViewById(R.id.button3);
        text3.setText(" I will forgive you if you write an explanatory note");
        sakura3.setImageResource(R.drawable.sakura3);
        button3.setText(R.string.button_text);
        Button button = (Button) findViewById(R.id.button3);
        View.OnClickListener myButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(button.getContext(), "Meow moew!", Toast.LENGTH_SHORT).show();
                Log.i(TAG, "Кто-то мяукнул! На кнопку нажали");
                sendMessage("Sorry");
            }
        };
        button.setOnClickListener(myButtonClickListener);
    };
    private void sendMessage(String message){
        Intent data = new Intent();
        data.putExtra("result", message);
        setResult(RESULT_OK, data);
        finish();
    }


}