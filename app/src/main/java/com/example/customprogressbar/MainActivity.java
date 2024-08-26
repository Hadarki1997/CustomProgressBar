package com.example.customprogressbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnVertiProgress = findViewById(R.id.btnVertiProgress);
        btnVertiProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VertiProgressActivity.class);
                startActivity(intent);
            }
        });

        Button btnTrackLine = findViewById(R.id.btnTrackLine);
        btnTrackLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TrackLineActivity.class);
                startActivity(intent);
            }
        });

        Button btnStepFlow = findViewById(R.id.btnStepFlow);
        btnStepFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StepFlowActivity.class);
                startActivity(intent);
            }
        });

        Button btnCircleStep = findViewById(R.id.btnCircleStep);
        btnCircleStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CircleStepActivity.class);
                startActivity(intent);
            }
        });
    }
}
