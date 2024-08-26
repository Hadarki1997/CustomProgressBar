package com.example.customprogressbar_library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.google.android.material.progressindicator.CircularProgressIndicator;

public class CircleStep extends ConstraintLayout {

    private TextView titleTextView;
    private TextView descriptionTextView;
    private TextView statusTextView;
    private TextView currentStepTextView;
    private CircularProgressIndicator progressIndicator;
    private Button previousButton;
    private Button nextButton;

    public enum StepStatus {
        PROGRESSING, ERROR, WARNING
    }

    public CircleStep(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public CircleStep(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CircleStep(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.circle_step_layout, this, true);

        titleTextView = findViewById(R.id.titleTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        statusTextView = findViewById(R.id.statusTextView);
        currentStepTextView = findViewById(R.id.currentStepTextView);
        progressIndicator = findViewById(R.id.progressIndicator);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleStep);
            String title = a.getString(R.styleable.CircleStep_stepTitle);
            String description = a.getString(R.styleable.CircleStep_stepDescription);
            setTitle(title);
            setDescription(description);
            a.recycle();
        }
    }

    public void setTitle(String title) {
        titleTextView.setText(title);
    }

    public void setDescription(String description) {
        descriptionTextView.setText(description);
    }

    public void setStepStatus(StepStatus status, int current, int total) {
        statusTextView.setText("Status");
        currentStepTextView.setText(String.format("%d of %d", current, total));
        progressIndicator.setProgress((int) ((float) current / total * 100));

        int color;
        switch (status) {
            case ERROR:
                color = ContextCompat.getColor(getContext(), R.color.red);
                break;
            case WARNING:
                color = ContextCompat.getColor(getContext(), R.color.yellow);
                break;
            default:
                color = ContextCompat.getColor(getContext(), R.color.blue);
                break;
        }
        progressIndicator.setIndicatorColor(color);
        titleTextView.setTextColor(color);

        nextButton.setEnabled(status == StepStatus.PROGRESSING);
        nextButton.setTextColor(status == StepStatus.PROGRESSING ?
                ContextCompat.getColor(getContext(), R.color.circle_progress) :
                ContextCompat.getColor(getContext(), R.color.disabled_text_color));
    }

    public void setOnPreviousClickListener(OnClickListener listener) {
        previousButton.setOnClickListener(listener);
    }

    public void setOnNextClickListener(OnClickListener listener) {
        nextButton.setOnClickListener(listener);
    }
}