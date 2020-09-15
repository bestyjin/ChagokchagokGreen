package com.chagok.chagokgreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageButton mainmenubtn1, mainmenubtn2;
    TextView textname;
    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DBHelper(this);

        mainmenubtn1 = (ImageButton) findViewById(R.id.mainmenubtn1);
        mainmenubtn2 = (ImageButton) findViewById(R.id.mainmenubtn2);
        textname = (TextView)findViewById(R.id.textname);

        String name;
        name = mydb.getName();
        textname.setText(name);

        mainmenubtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ScanQR.class);
                startActivity(intent);
            }
        });

        mainmenubtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, myPoints.class);
                startActivity(intent);
            }
        });
    }
}