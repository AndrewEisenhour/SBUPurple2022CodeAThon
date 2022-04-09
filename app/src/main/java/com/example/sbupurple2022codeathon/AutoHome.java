package com.example.sbupurple2022codeathon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sbupurple2022codeathon.databinding.AutoHomeBinding;


public class AutoHome extends Fragment {

    private AutoHomeBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = AutoHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AutoHome.this)
                        .navigate(R.id.action_AutoHome_to_FirstFragment);
            }
        });
        binding.pathOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AutoHome.this)
                        .navigate(R.id.action_AutoHome_to_autoPathOneOne);
            }
        });
        binding.pathTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AutoHome.this)
                        .navigate(R.id.action_AutoHome_to_autoPathTwoOne);
            }
        });
        binding.pathThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AutoHome.this)
                        .navigate(R.id.action_AutoHome_to_autoPathThreeOne);
            }
        });
        binding.pathFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AutoHome.this)
                        .navigate(R.id.action_AutoHome_to_autoPathFourOne);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}