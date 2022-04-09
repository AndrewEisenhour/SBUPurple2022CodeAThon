package com.example.sbupurple2022codeathon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sbupurple2022codeathon.databinding.HealthHomeBinding;

public class HealthHome extends Fragment {

    private HealthHomeBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = HealthHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HealthHome.this)
                        .navigate(R.id.action_HealthHome_to_FirstFragment);
            }
        });
        binding.pathOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HealthHome.this)
                        .navigate(R.id.action_HealthHome_to_healthPathOneOne);
            }
        });
        binding.pathTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HealthHome.this)
                        .navigate(R.id.action_HealthHome_to_healthPathTwoOne);
            }
        });
        binding.pathThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HealthHome.this)
                        .navigate(R.id.action_HealthHome_to_healthPathThreeOne);
            }
        });
        binding.pathFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HealthHome.this)
                        .navigate(R.id.action_HealthHome_to_healthPathFourOne);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}