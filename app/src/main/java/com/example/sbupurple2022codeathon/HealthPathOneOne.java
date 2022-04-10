package com.example.sbupurple2022codeathon;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sbupurple2022codeathon.databinding.HealthPathOneOneBinding;

import org.w3c.dom.Text;

import java.util.Locale;

public class HealthPathOneOne extends Fragment  {

    private HealthPathOneOneBinding binding;
    TextView textView;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = HealthPathOneOneBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                breathTimer b = new breathTimer(view.findViewById(R.id.text_view_countdown), view.findViewById(R.id.button_start_pause), view.findViewById(R.id.button_reset), view.findViewById(R.id.text_view_instructions));
                b.startTimer();
                //binding.buttonStartPause.setText("hello");
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public class breathTimer extends AppCompatActivity {
        private static final long START_TIME_IN_MILLIS = 19000;

        private TextView mTextViewCountDown;
        private Button mButtonStartPause;
        private Button mButtonReset;
        private TextView mTextViewInstructions;

        private CountDownTimer mCountDownTimer;

        private boolean mTimerRunning;

        private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
        public breathTimer(TextView text, Button start, Button reset, TextView instructions){
            mTextViewCountDown = text;
            mButtonStartPause = start;
            mButtonReset = reset;
            mTextViewInstructions = instructions;
        }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.health_path_one_one);
/*
            mTextViewCountDown = findViewById(R.id.text_view_countdown);
            mTextViewInstructions = findViewById(R.id.text_view_instructions);
            mButtonStartPause = findViewById(R.id.button_start_pause);
            mButtonReset = findViewById(R.id.button_reset);
*/
            findViewById(R.id.button_start_pause).setOnClickListener(new View.OnClickListener() {
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
                public void onClick(View textView) {
                    resetTimer();
                }
            });

            updateCountDownText();
            timeCheck();
        }

        private void startTimer() {
            mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                    timeCheck();
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
            mButtonStartPause.setText("start");
            mButtonReset.setVisibility(View.VISIBLE);
        }

        private void resetTimer() {
            mTimeLeftInMillis = START_TIME_IN_MILLIS;
            updateCountDownText();
            timeCheck();
            mButtonReset.setVisibility(View.INVISIBLE);
            mButtonStartPause.setVisibility(View.VISIBLE);
        }

        private void updateCountDownText() {
            int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

            String timeLeftFormatted = String.format(Locale.getDefault(), "%02d", seconds);

            mTextViewCountDown.setText(timeLeftFormatted);
        }
        private void timeCheck(){
            if(mTimeLeftInMillis <= 8000){
                mTextViewInstructions.setText("Hold Breath");
            }else if(mTimeLeftInMillis <= 15000 && mTimeLeftInMillis > 8000){
                mTextViewInstructions.setText("Breath Out");
            }
        }
    }
}