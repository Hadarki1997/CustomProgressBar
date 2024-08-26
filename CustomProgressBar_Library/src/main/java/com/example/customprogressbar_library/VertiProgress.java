package com.example.customprogressbar_library;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

public class VertiProgress extends LinearLayout {

    private ImageView statusIcon;
    private TextView statusPercentage;
    private TextView statusText;
    private ProgressBar progressBar;

    public VertiProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.vert_progress_layout, this);

        statusIcon = findViewById(R.id.status_icon);
        statusPercentage = findViewById(R.id.status_percentage);
        statusText = findViewById(R.id.status_text);
        progressBar = findViewById(R.id.progress_bar);
    }

    public void setStatus(String internalStatus, int percentage, String customText) {
        setStatusText(customText);
        setStatusPercentage(percentage);
        updateColorAndIcon(internalStatus);
    }

    // שמירה על המתודה הקיימת לתאימות לאחור
    public void setStatus(String status, int percentage) {
        setStatus(status, percentage, status);
    }

    private void setStatusText(String text) {
        if (statusText != null) {
            statusText.setText(text);
        }
    }

    private void setStatusPercentage(int percentage) {
        if (statusPercentage != null) {
            statusPercentage.setText(percentage + "%");
        }
        if (progressBar != null) {
            progressBar.setProgress(percentage);
        }
    }

    private void updateColorAndIcon(String status) {
        int color;
        Drawable iconDrawable;

        switch (status.toLowerCase()) {
            case "completed":
                iconDrawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_check);
                color = ContextCompat.getColor(getContext(), R.color.green);
                break;
            case "not confirmed":
                iconDrawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_error);
                color = ContextCompat.getColor(getContext(), R.color.red);
                break;
            case "shipping":
                iconDrawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_progress);
                color = ContextCompat.getColor(getContext(), R.color.blue);
                break;
            case "payment pending":
                iconDrawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_warning);
                color = ContextCompat.getColor(getContext(), R.color.yellow);
                break;
            default:
                iconDrawable = ContextCompat.getDrawable(getContext(), R.drawable.ic_default);
                color = ContextCompat.getColor(getContext(), R.color.gray);
                break;
        }

        // Set the progress color
        LayerDrawable layerDrawable = (LayerDrawable) progressBar.getProgressDrawable();
        Drawable progressDrawable = layerDrawable.findDrawableByLayerId(android.R.id.progress);
        progressDrawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);

        if (iconDrawable != null) {
            statusIcon.setImageDrawable(iconDrawable);
        }
    }
}