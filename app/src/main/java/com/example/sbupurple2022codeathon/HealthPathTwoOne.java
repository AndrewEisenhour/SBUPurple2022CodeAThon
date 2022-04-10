package com.example.sbupurple2022codeathon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sbupurple2022codeathon.databinding.HealthPathTwoOneBinding;

public class HealthPathTwoOne extends Fragment {

    private HealthPathTwoOneBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = HealthPathTwoOneBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.LifeHome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HealthPathTwoOne.this)
                        .navigate(R.id.action_LifeHome_to_FirstFragment);
            }
        });
        class pulseTimer extends AppCompatActivity {
            private static final long START_TIME_IN_MILLIS = 15000;

            private TextView mTextViewCountDown;
            private Button mButtonStartPause;
            private Button mButtonReset;

            private CountDownTimer mCountDownTimer;

            private boolean mTimerRunning;

            private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                mTextViewCountDown = findViewById(R.id.text_view_countdown);

                mButtonStartPause = findViewById(R.id.button_start_pause);
                mButtonReset = findViewById(R.id.button_reset);

                mButtonStartPause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mTimerRunning) {
                            pauseTimer();
                        } else {
                            startTimer();
                        }
                    }
                });

                mButtonReset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        resetTimer();
                    }
                });

                updateCountDownText();
            }

            private void startTimer() {
                mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mTimeLeftInMillis = millisUntilFinished;
                        updateCountDownText();
                    }

                    @Override
                    public void onFinish() {
                        mTimerRunning = false;
                        mButtonStartPause.setText("Start");
                        mButtonStartPause.setVisibility(View.INVISIBLE);
                        mButtonReset.setVisibility(View.VISIBLE);
                    }
                }.start();

                mTimerRunning = true;
                mButtonStartPause.setText("pause");
                mButtonReset.setVisibility(View.INVISIBLE);
            }

            private void pauseTimer() {
                mCountDownTimer.cancel();
                mTimerRunning = false;
                mButtonStartPause.setText("Start");
                mButtonReset.setVisibility(View.VISIBLE);
            }

            private void resetTimer() {
                mTimeLeftInMillis = START_TIME_IN_MILLIS;
                updateCountDownText();
                mButtonReset.setVisibility(View.INVISIBLE);
                mButtonStartPause.setVisibility(View.VISIBLE);
            }

            private void updateCountDownText() {
                int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

                String timeLeftFormatted = String.format(Locale.getDefault(), "%02d", seconds);

                mTextViewCountDown.setText(timeLeftFormatted);
            }
        }
        binding.pulse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double input = Double.parseDouble(binding.inputNumber.getText().toString());
                binding.outputText.setText(""+pulse(input));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public double pulse(double input) {return (input * 2.0);}
}