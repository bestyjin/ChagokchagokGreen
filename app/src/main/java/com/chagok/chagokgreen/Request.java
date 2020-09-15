package com.chagok.chagokgreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Request extends AppCompatActivity {

    ImageButton req,requestmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        req = (ImageButton) findViewById(R.id.req);
        requestmsg = (ImageButton) findViewById(R.id.requestmsg);

        req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"가게에 포인트 적립을 요청하였습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        requestmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Request.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
