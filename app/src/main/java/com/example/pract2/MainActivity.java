package com.example.pract2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pract2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liner_lay);
        };
        public void button1Click(View view){
            EditText text = (EditText) findViewById(R.id.editText1);
            if (text.getText().toString().equals("Yes")) {
                Intent intent = new Intent(this, ThirdActivity.class);
                intent.putExtra("answer", "Yes");
                startActivity(intent);
            }
            else if(text.getText().toString().equals("No")){
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("answer", "No");
                mStartForResult.launch(intent);
            }
        };
        ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    String message="";
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        message = intent.getStringExtra("result");
                    }
                    else{
                        message ="Ошибка доступа";
                    }
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                }
            });

}