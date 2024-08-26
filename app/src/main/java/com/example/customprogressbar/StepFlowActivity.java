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

        List<String> steps = Arrays.asList("Checkout", "Shipping", "Payment", "Confirm");

        StepFlow stepFlowInitial = findViewById(R.id.step_flow_initial);
        setupStepFlow(stepFlowInitial, steps, "initial", 0);

        StepFlow stepFlowProgressing = findViewById(R.id.step_flow_progressing);
        setupStepFlow(stepFlowProgressing, steps, "progressing", 2);

        StepFlow stepFlowError = findViewById(R.id.step_flow_error);
        setupStepFlow(stepFlowError, steps, "error", 2);

        StepFlow stepFlowWarning = findViewById(R.id.step_flow_warning);
        setupStepFlow(stepFlowWarning, steps, "warning", 2);
    }

    private void setupStepFlow(StepFlow stepFlow, List<String> steps, String status, int currentStep) {
        stepFlow.setSteps(steps);
        stepFlow.setStatus(status);
        stepFlow.setCurrentStep(currentStep);
    }
}