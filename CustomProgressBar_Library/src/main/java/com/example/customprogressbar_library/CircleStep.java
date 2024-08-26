package com.example.customprogressbar_library;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class CircleStep extends LinearLayout {

    private ProgressBar statusCircle;
    private TextView statusText;
    private TextView stepCount;

    public CircleStep(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.circle_step_layout, this, true);
        statusCircle = findViewById(R.id.status_circle);
        statusText = findViewById(R.id.status_text);
        stepCount = findViewById(R.id.step_count);
    }

    public void setStatus(String status, int step) {
        stepCount.setText("Step " + step + " of 4");

        int color;

        switch (status.toLowerCase()) {
            case "progressing":
                color = ContextCompat.getColor(getContext(), R.color.blue);
                break;
            case "error":
                color = ContextCompat.getColor(getContext(), R.color.red);
                break;
            case "warning":
                color = ContextCompat.getColor(getContext(), R.color.yellow);
                break;
            default:
                color = ContextCompat.getColor(getContext(), R.color.gray);
                break;
        }

        statusCircle.getProgressDrawable().setColorFilter(color, PorterDuff.Mode.SRC_IN);
        statusCircle.setProgress(step * 25); // assuming each step is 25% progress

        statusText.setText(status);
        statusText.setTextColor(color);
    }
}
