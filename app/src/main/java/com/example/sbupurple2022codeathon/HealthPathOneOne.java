package com.example.sbupurple2022codeathon;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sbupurple2022codeathon.databinding.HealthPathOneOneBinding;

import java.util.Locale;

public class HealthPathOneOne extends Fragment {

    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = HealthPathOneOneBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HealthPathOneOne.this)
                        .navigate(R.id.action_LifeHome_to_FirstFragment);
            }
        });
    }
    private static final long START_TIME_IN_MILLIS = 600000;

    private TextView mTextViewCountdown;
    private Button mButtonStartPause;
    private Button mButtonReset;

    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    private HealthPathOneOneBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*mTextViewCountdown = mTextViewCountdown.findViewById(R.id.text_view_countdown);
        mButtonStartPause = mButtonStartPause.findViewById(R.id.button_start_pause);
        mButtonReset = mButtonReset.findViewById(R.id.button_reset);*/

        binding.buttonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }*/
            }
        });
        binding.buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });
        updateCountDownText();
    }

    private void startTimer(){
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                binding.buttonStartPause.setText("start");
                binding.buttonStartPause.setVisibility(View.INVISIBLE);
                binding.buttonReset.setVisibility(View.VISIBLE);

            }
        }.start();
        mTimerRunning = true;
        binding.buttonStartPause.setText("pause");
        binding.buttonReset.setVisibility(View.INVISIBLE);

    }
    private void pauseTimer(){
        mCountDownTimer.cancel();
        mTimerRunning = false;
        binding.buttonStartPause.setText("start");
        binding.buttonReset.setVisibility(View.VISIBLE);
    }
    private void resetTimer(){
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        binding.buttonReset.setVisibility(View.INVISIBLE);
        binding.buttonStartPause.setVisibility(View.VISIBLE);
    }
    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        binding.textViewCountdown.setText(timeLeftFormatted);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}