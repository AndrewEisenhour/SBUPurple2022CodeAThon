package com.example.sbupurple2022codeathon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sbupurple2022codeathon.databinding.ConversionPathOneOneBinding;

public class ConversionPathOneOne extends Fragment {

    private ConversionPathOneOneBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = ConversionPathOneOneBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ConversionPathOneOne.this)
                        .navigate(R.id.action_LifeHome_to_FirstFragment);
            }
        });*/
        binding.LifeHome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double input = Double.parseDouble(binding.inputNumber.getText().toString());
                binding.outputText.setText(""+CelsiusToFahrenheit(input));
            }
        });
        binding.FtoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double input = Double.parseDouble(binding.inputNumber.getText().toString());
                binding.outputText.setText(""+FahrenheitToCelsius(input));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public double CelsiusToFahrenheit(double input){
        return (input*9.0)/5.0 + 32.0;
    }
    public double FahrenheitToCelsius(double input){
        return ((input-32)*5.0)/9.0;
    }
}