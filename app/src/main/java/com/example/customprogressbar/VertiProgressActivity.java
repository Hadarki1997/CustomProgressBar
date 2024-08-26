package com.example.customprogressbar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.customprogressbar_library.VertiProgress;

public class VertiProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verti_progress);

        // Completed example
        VertiProgress completedBar = findViewById(R.id.progressBarComplete);
        completedBar.setStatus("Completed", 100, "Task Finished");

        // Error example
        VertiProgress errorBar = findViewById(R.id.progressBarError);
        errorBar.setStatus("Not Confirmed", 75, "Error Occurred");

        // In Progress example
        VertiProgress progressingBar = findViewById(R.id.progressBarProgressing);
        progressingBar.setStatus("Shipping", 50, "In Transit");

        // Warning example
        VertiProgress warningBar = findViewById(R.id.progressBarWarning);
        warningBar.setStatus("Payment Pending", 25, "Action Required");
    }
}