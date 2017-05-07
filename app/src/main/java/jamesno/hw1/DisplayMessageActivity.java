package jamesno.hw1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    private static final String TAG = DisplayMessageActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(JamesProfile.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() initiated");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() initiated");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() initiated");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() initiated");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() initiated");
    }
}
