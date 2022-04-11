package com.example.sbupurple2022codeathon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sbupurple2022codeathon.databinding.LifePathFourOneBinding;

public class LifePathFourOne extends Fragment {

    private LifePathFourOneBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = LifePathFourOneBinding.inflate(inflater, container, false);
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
        binding.tipCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double input1 = Double.parseDouble(binding.inputBill.getText().toString());
                double input2 = Double.parseDouble(binding.inputTip.getText().toString());
                binding.tipAmount.setText(String.format("$%.2f", CalculatingTip(input1, input2)));
            }
        });
        binding.LifeHome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double input1 = Double.parseDouble(binding.inputBill.getText().toString());
                double input2 = Double.parseDouble(binding.inputTip.getText().toString());
                double total = (input1 + CalculatingTip(input1, input2));
                binding.outputTotal.setText(String.format("$%.2f", total));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public double CalculatingTip(double input1, double input2){
        return input1*(input2/100);
    }

}