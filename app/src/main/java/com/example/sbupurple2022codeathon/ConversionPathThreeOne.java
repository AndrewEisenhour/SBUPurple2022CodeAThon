package com.example.sbupurple2022codeathon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sbupurple2022codeathon.databinding.ConversionPathThreeOneBinding;

public class ConversionPathThreeOne extends Fragment {

    private ConversionPathThreeOneBinding binding;
    EditText num1;
    EditText num2;
    //Btn FeetToInches;
    TextView conversion;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = ConversionPathThreeOneBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.FeetToInches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double input1 = Double.parseDouble(binding.inputheightft.getText().toString());
                double input2 = Double.parseDouble(binding.inputheightin.getText().toString());
                binding.outputHeightinInches.setText(""+FeettoInches(input1, input2));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public double FeettoInches(double input1, double input2){
        return (input1*12) + input2;
    }
}