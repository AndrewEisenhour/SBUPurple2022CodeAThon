package com.example.sbupurple2022codeathon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sbupurple2022codeathon.databinding.ConversionHomeBinding;

public class ConversionHome extends Fragment {

    private ConversionHomeBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = ConversionHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ConversionHome.this)
                        .navigate(R.id.action_ConversionHome_to_FirstFragment);
            }
        });
        binding.pathOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ConversionHome.this)
                        .navigate(R.id.action_ConversionHome_to_conversionPathOneOne);
            }
        });
        binding.pathTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ConversionHome.this)
                        .navigate(R.id.action_ConversionHome_to_conversionPathTwoOne);
            }
        });
        binding.pathThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ConversionHome.this)
                        .navigate(R.id.action_ConversionHome_to_conversionPathThreeOne);
            }
        });
        binding.pathFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ConversionHome.this)
                        .navigate(R.id.action_ConversionHome_to_conversionPathFourOne);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}