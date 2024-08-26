package com.example.customprogressbar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.customprogressbar_library.CircleStep;

public class CircleStepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_step);

        CircleStep circleStepProgressing = findViewById(R.id.circleStepProgressing);
        circleStepProgressing.setStatus("Progressing", 1);

        CircleStep circleStepError = findViewById(R.id.circleStepError);
        circleStepError.setStatus("Error", 1);

        CircleStep circleStepWarning = findViewById(R.id.circleStepWarning);
        circleStepWarning.setStatus("Warning", 1);
    }
}
