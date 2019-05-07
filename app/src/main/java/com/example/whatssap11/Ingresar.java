package com.example.whatssap11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ingresar extends AppCompatActivity {
private Button btnIngresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);
    }
        public void sendMessage(View view){
        Intent intent = new Intent(this, MainActivity.class);

        EditText editText = findViewById(R.id.text_message);
        intent.putExtra("MESSAGE",  editText.getText().toString());

        startActivity(intent);
    }
}


