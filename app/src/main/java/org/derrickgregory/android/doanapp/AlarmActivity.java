package org.derrickgregory.android.doanapp;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import java.util.Calendar;


public class AlarmActivity extends AppCompatActivity {
    private Calendar mCalendar;
    private CountDownTimer mTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCalendar = Calendar.getInstance();

        final MediaPlayer gongPlayer = MediaPlayer.create(this, R.raw.bell);

        Button startButton = findViewById(R.id.button);
        startButton.setText(R.string.start_button_text);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Button startButton = (Button) view;
                mTimer = new CountDownTimer(mCalendar.getTimeInMillis() - System.currentTimeMillis(), 1000) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        gongPlayer.start();
                    }
                };

                if (startButton.getText().equals(getResources().getString(R.string.stop_button_text))) {
                    mTimer.cancel();
                    startButton.setText(R.string.start_button_text);
                } else {
                    mTimer.start();
                    startButton.setText(R.string.stop_button_text);
                }

            }
        });
    }

    //TODO: implement CountDownTimer: https://developer.android.com/reference/android/os/CountDownTimer
}
