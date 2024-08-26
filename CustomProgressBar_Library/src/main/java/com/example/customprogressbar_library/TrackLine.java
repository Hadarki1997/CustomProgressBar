package com.example.customprogressbar_library;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class TrackLine extends LinearLayout {

    private static final int STEP_COUNT = 5;
    private ImageView[] stepIcons;
    private View[] connectors;
    private TextView[] stepLabels;

    public TrackLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.track_line_layout, this, true);

        stepIcons = new ImageView[STEP_COUNT];
        connectors = new View[STEP_COUNT - 1];
        stepLabels = new TextView[STEP_COUNT];

        for (int i = 0; i < STEP_COUNT; i++) {
            stepIcons[i] = findViewById(getResources().getIdentifier("step_icon_" + (i + 1), "id", context.getPackageName()));
            stepLabels[i] = findViewById(getResources().getIdentifier("step_label_" + (i + 1), "id", context.getPackageName()));
            if (i < STEP_COUNT - 1) {
                connectors[i] = findViewById(getResources().getIdentifier("connector_" + (i + 1), "id", context.getPackageName()));
            }
        }
    }

    public void setStatus(String status, int completedSteps) {
        updateSteps(status, completedSteps);
    }

    private void updateSteps(String status, int completedSteps) {
        int activeIconResource;
        int connectorColor;

        switch (status.toLowerCase()) {
            case "completed":
                activeIconResource = R.drawable.ic_check;
                connectorColor = ContextCompat.getColor(getContext(), R.color.green);
                break;
            case "not confirmed":
                activeIconResource = R.drawable.ic_error;
                connectorColor = ContextCompat.getColor(getContext(), R.color.red);
                break;
            case "shipping":
                activeIconResource = R.drawable.ic_progress;
                connectorColor = ContextCompat.getColor(getContext(), R.color.blue);
                break;
            case "payment pending":
                activeIconResource = R.drawable.ic_default;
                connectorColor = ContextCompat.getColor(getContext(), R.color.yellow);
                break;
            default:
                activeIconResource = R.drawable.ic_empty;
                connectorColor = ContextCompat.getColor(getContext(), R.color.gray);
                break;
        }

        for (int i = 0; i < STEP_COUNT; i++) {
            if (i < completedSteps - 1) {
                stepIcons[i].setImageResource(R.drawable.ic_levle_succeeded);
                if (i > 0) {
                    connectors[i - 1].setBackgroundColor(ContextCompat.getColor(getContext(), R.color.blue));
                }
            } else if (i == completedSteps - 1) {
                stepIcons[i].setImageResource(activeIconResource);
                if (i > 0) {
                    connectors[i - 1].setBackgroundColor(connectorColor);
                }
            } else {
                stepIcons[i].setImageResource(R.drawable.ic_empty);
                if (i > 0) {
                    connectors[i - 1].setBackgroundColor(ContextCompat.getColor(getContext(), R.color.gray));
                }
            }
        }
    }

    public void setStepLabel(int stepIndex, String label) {
        if (stepIndex >= 0 && stepIndex < STEP_COUNT) {
            stepLabels[stepIndex].setText(label);
        }
    }
}
