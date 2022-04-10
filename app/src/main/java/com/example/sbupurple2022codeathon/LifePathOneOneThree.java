package com.example.sbupurple2022codeathon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sbupurple2022codeathon.databinding.LifePathOneOneThreeBinding;

public class LifePathOneOneThree extends Fragment {

    private LifePathOneOneThreeBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = LifePathOneOneThreeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LifePathOneOneThree.this)
                        .navigate(R.id.action_lifePathOneOneThree_to_lifePathOneOneFour);
            }
        });
        binding.back5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LifePathOneOneThree.this)
                        .navigate(R.id.action_lifePathOneOneThree_to_lifePathOneOneTwo);
            }
        });
        binding.tiehome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LifePathOneOneThree.this)
                        .navigate(R.id.action_lifePathOneOneThree_to_lifePathOneOne);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}