package com.example.sbupurple2022codeathon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.sbupurple2022codeathon.databinding.LifePathOneOneTwoBinding;

public class LifePathOneOneTwo extends Fragment {

    private LifePathOneOneTwoBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = LifePathOneOneTwoBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LifePathOneOneTwo.this)
                        .navigate(R.id.action_lifePathOneOneTwo_to_lifePathOneOneThree);
            }
        });
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LifePathOneOneTwo.this)
                        .navigate(R.id.action_lifePathOneOneTwo_to_lifePathOneOneOne);
            }
        });
        binding.tiehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LifePathOneOneTwo.this)
                        .navigate(R.id.action_lifePathOneOneTwo_to_lifePathOneOne2);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}