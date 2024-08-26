package com.example.customprogressbar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.customprogressbar_library.StepFlow;
import java.util.Arrays;
import java.util.List;

public class StepFlowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_flow);

        StepFlow stepFlowProgressing = findViewById(R.id.step_flow_progressing);
        setupStepFlow(stepFlowProgressing, "progressing", 2);

        StepFlow stepFlowError = findViewById(R.id.step_flow_error);
        setupStepFlow(stepFlowError, "error", 2);

        StepFlow stepFlowWarning = findViewById(R.id.step_flow_warning);
        setupStepFlow(stepFlowWarning, "warning", 2);
    }

    private void setupStepFlow(StepFlow stepFlow, String status, int currentStep) {
        stepFlow.setStepLabel(0, "Checkout");
        stepFlow.setStepLabel(1, "Shipping");
        stepFlow.setStepLabel(2, "Payment");
        stepFlow.setStepLabel(3, "Confirm");
        stepFlow.setStatus(status, currentStep);
    }
}