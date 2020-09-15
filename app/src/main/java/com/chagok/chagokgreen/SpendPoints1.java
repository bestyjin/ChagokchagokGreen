package com.chagok.chagokgreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SpendPoints1 extends AppCompatActivity {
    ImageButton btn1;
    EditText et1;
    String spoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spend_points1);

        et1 = (EditText)findViewById(R.id.et1);
        spoint = et1.getText().toString();


        btn1 = (ImageButton)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SpendPoints1.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), ""+spoint+"포인트 사용!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
