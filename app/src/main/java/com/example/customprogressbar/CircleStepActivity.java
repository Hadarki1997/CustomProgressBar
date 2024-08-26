package com.example.customprogressbar;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.customprogressbar_library.CircleStep;

public class CircleStepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_step);

        // Progressing Example
        CircleStep progressingStep = findViewById(R.id.circleStepProgressing);
        setupStep(progressingStep, "Payment", "Securely processing your payment details. This usually takes a few moments.", CircleStep.StepStatus.PROGRESSING, 1, 4);

        // Error Example
        CircleStep errorStep = findViewById(R.id.circleStepError);
        setupStep(errorStep, "Payment", "Oops! There seems to be an issue with the payment. Please check your card details and try again.", CircleStep.StepStatus.ERROR, 1, 4);

        // Warning Example
        CircleStep warningStep = findViewById(R.id.circleStepWarning);
        setupStep(warningStep, "Payment", "Your payment is pending authorization. This may take a few minutes. Please don't close the app.", CircleStep.StepStatus.WARNING, 3, 4);
    }

    private void setupStep(CircleStep step, String title, String description, CircleStep.StepStatus status, int current, int total) {
        step.setTitle(title);
        step.setDescription(description);
        step.setStepStatus(status, current, total);

        step.setOnPreviousClickListener(v -> {
            Toast.makeText(this, "Returning to previous step", Toast.LENGTH_SHORT).show();
        });
    }
}
