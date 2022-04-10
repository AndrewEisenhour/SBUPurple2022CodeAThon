package com.example.sbupurple2022codeathon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sbupurple2022codeathon.databinding.LifePathOneOneBinding;

public class LifePathOneOne extends Fragment {

    private LifePathOneOneBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = LifePathOneOneBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.LifeHome1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LifePathOneOne.this)
                        .navigate(R.id.action_lifePathOneOne_to_LifeHome1);
            }
        });
        binding.tieOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LifePathOneOne.this)
                        .navigate(R.id.action_lifePathOneOne_to_lifePathOneOneOne);
            }
        });
        binding.tieTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LifePathOneOne.this)
                        .navigate(R.id.action_lifePathOneOne_to_lifePathOneTwoOne);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}