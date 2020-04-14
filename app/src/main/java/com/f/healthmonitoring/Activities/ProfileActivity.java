package com.f.healthmonitoring.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.f.healthmonitoring.R;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
Button temp,heartbeat,ecg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        temp=(Button)findViewById(R.id.temp);
        heartbeat=(Button)findViewById(R.id.heart);
        ecg=(Button)findViewById(R.id.ecg);
        heartbeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfileActivity.this, CheckHeartbeatActivity.class);
                startActivity(intent);
            }
        });
        ecg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(ProfileActivity.this, CheckEcgActivity.class);
                startActivity(intent1);
            }
        });
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 =new Intent(ProfileActivity.this, CheckTemperatureActivity.class);
                startActivity(intent2);
            }
        });

    }


}
