package com.example.customprogressbar_library;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class StepFlow extends LinearLayout {
    private List<String> steps;
    private List<View> stepViews;
    private int currentStep;
    private String currentStatus;

    public StepFlow(Context context) {
        super(context);
        init(context);
    }

    public StepFlow(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public StepFlow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setOrientation(VERTICAL);
        steps = new ArrayList<>();
        stepViews = new ArrayList<>();
    }

    public void setSteps(List<String> newSteps) {
        steps.clear();
        steps.addAll(newSteps);
        removeAllViews();
        stepViews.clear();

        for (String step : steps) {
            View stepView = LayoutInflater.from(getContext()).inflate(R.layout.step_flow_layout, this, false);
            TextView stepLabel = stepView.findViewById(R.id.step_label);
            stepLabel.setText(step);
            stepViews.add(stepView);
            addView(stepView);
        }
        updateStepViews();
    }

    public void setCurrentStep(int step) {
        this.currentStep = step;
        updateStepViews();
    }

    public void setStatus(String status) {
        this.currentStatus = status;
        updateStepViews();
    }

    private void updateStepViews() {
        int mainColor = ContextCompat.getColor(getContext(), R.color.blue);
        int errorColor = ContextCompat.getColor(getContext(), R.color.red);
        int warningColor = ContextCompat.getColor(getContext(), R.color.yellow);
        int inactiveColor = ContextCompat.getColor(getContext(), R.color.gray);

        for (int i = 0; i < stepViews.size(); i++) {
            View stepView = stepViews.get(i);
            View stepDot = stepView.findViewById(R.id.step_dot);
            View stepLine = stepView.findViewById(R.id.step_line);

            if (i < currentStep) {
                setStepColor(stepDot, stepLine, mainColor);
            } else if (i == currentStep) {
                int color;
                switch (currentStatus != null ? currentStatus.toLowerCase() : "") {
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
                setStepColor(stepDot, stepLine, color);
            } else {
                setStepColor(stepDot, stepLine, inactiveColor);
            }

            if (i == stepViews.size() - 1) {
                stepLine.setVisibility(GONE);
            }
        }
    }

    private void setStepColor(View dot, View line, int color) {
        if (dot.getBackground() != null) {
            dot.getBackground().setColorFilter(color, PorterDuff.Mode.SRC_IN);
        }
        line.setBackgroundColor(color);
    }

    public int getCurrentStep() {
        return currentStep;
    }
}