package com.veltus.enginear;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.veltus.enginear.databinding.FragmentCraigslistBinding;

import java.util.ArrayList;

public class CraigslistFragment extends Fragment {

    private FragmentCraigslistBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCraigslistBinding.inflate(inflater, container, false);
        View view = binding.getRoot();



        return view;

    }
}
