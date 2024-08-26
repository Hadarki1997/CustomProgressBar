package com.example.customprogressbar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.customprogressbar_library.TrackLine;

public class TrackLineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_line);

        setupTrackLine(R.id.track_line_progressing, "shipping", 2);
        setupTrackLine(R.id.track_line_error, "not confirmed", 1);
        setupTrackLine(R.id.track_line_warning, "payment pending", 2);
        setupTrackLine(R.id.track_line_complete, "completed", 5);
    }

    private void setupTrackLine(int trackLineId, String status, int completedSteps) {
        TrackLine trackLine = findViewById(trackLineId);
        trackLine.setStatus(status, completedSteps);
        setTrackLineLabels(trackLine);
    }

    private void setTrackLineLabels(TrackLine trackLine) {
        trackLine.setStepLabel(0, "Customer");
        trackLine.setStepLabel(1, "Shipping");
        trackLine.setStepLabel(2, "Payment");
        trackLine.setStepLabel(3, "Confirm");
        trackLine.setStepLabel(4, "Success");
    }
}
