package com.example.sbupurple2022codeathon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sbupurple2022codeathon.databinding.ConversionPathFourOneBinding;

public class ConversionPathFourOne extends Fragment {

    private ConversionPathFourOneBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = ConversionPathFourOneBinding.inflate(inflater, container, false);
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
        binding.PtoKilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double input = Double.parseDouble(binding.inputPounds.getText().toString());
                binding.outputText2.setText(String.format("%f.2",PoundToKilogram(input)));
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public double PoundToKilogram(double input){
        return (input*0.45359237);
    }

}