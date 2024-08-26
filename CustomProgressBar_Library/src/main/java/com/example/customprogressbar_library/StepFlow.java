package com.example.customprogressbar_library;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class StepFlow extends LinearLayout {

    private static final int STEP_COUNT = 4;
    private ProgressBar[] stepProgressBars;
    private TextView[] stepLabels;
    private View[] stepDots;

    public StepFlow(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.step_flow_layout, this, true);

        stepProgressBars = new ProgressBar[STEP_COUNT];
        stepLabels = new TextView[STEP_COUNT];
        stepDots = new View[STEP_COUNT];

        for (int i = 0; i < STEP_COUNT; i++) {
            stepProgressBars[i] = findViewById(getResources().getIdentifier("step_progress_" + (i + 1), "id", context.getPackageName()));
            stepLabels[i] = findViewById(getResources().getIdentifier("step_label_" + (i + 1), "id", context.getPackageName()));
            stepDots[i] = findViewById(getResources().getIdentifier("step_dot_" + (i + 1), "id", context.getPackageName()));
        }
    }

    public void setStatus(String status, int currentStep) {
        int mainColor, errorColor, warningColor, inactiveColor;
        mainColor = ContextCompat.getColor(getContext(), R.color.blue);
        errorColor = ContextCompat.getColor(getContext(), R.color.red);
        warningColor = ContextCompat.getColor(getContext(), R.color.yellow);
        inactiveColor = ContextCompat.getColor(getContext(), R.color.gray);

        updateSteps(status, currentStep, mainColor, errorColor, warningColor, inactiveColor);
    }

    private void updateSteps(String status, int currentStep, int mainColor, int errorColor, int warningColor, int inactiveColor) {
        for (int i = 0; i < STEP_COUNT; i++) {
            if (i < currentStep) {
                // Completed steps
                stepProgressBars[i].setProgress(100);
                stepProgressBars[i].getProgressDrawable().setColorFilter(mainColor, android.graphics.PorterDuff.Mode.SRC_IN);
                stepDots[i].getBackground().setColorFilter(mainColor, android.graphics.PorterDuff.Mode.SRC_IN);
            } else if (i == currentStep) {
                // Current step
                stepProgressBars[i].setProgress(100);
                int color;
                switch (status.toLowerCase()) {
                    case "error":
                        color = errorColor;
                        break;
                    case "warning":
                        color = warningColor;
                        break;
                    default:
                        color = mainColor;
                        break;
                }
                stepProgressBars[i].getProgressDrawable().setColorFilter(color, android.graphics.PorterDuff.Mode.SRC_IN);
                stepDots[i].getBackground().setColorFilter(color, android.graphics.PorterDuff.Mode.SRC_IN);
            } else {
                // Future steps
                stepProgressBars[i].setProgress(100);
                stepProgressBars[i].getProgressDrawable().setColorFilter(inactiveColor, android.graphics.PorterDuff.Mode.SRC_IN);
                stepDots[i].getBackground().setColorFilter(inactiveColor, android.graphics.PorterDuff.Mode.SRC_IN);
            }
        }
    }

    public void setStepLabel(int stepIndex, String label) {
        if (stepIndex >= 0 && stepIndex < STEP_COUNT) {
            stepLabels[stepIndex].setText(label);
        }
    }
}