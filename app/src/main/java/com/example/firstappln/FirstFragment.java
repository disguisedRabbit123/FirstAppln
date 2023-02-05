package com.example.firstappln;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.firstappln.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentCount = Integer.parseInt(binding.textviewFirst.getText().toString());
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount));
            }
        });

        binding.toastButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast myToast = Toast.makeText(getActivity(), R.string.toast_text, Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

        binding.countButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                countMe(view);
            }
        });
    }

    private void countMe(View view)
    {
        String countString = binding.textviewFirst.getText().toString();
        Integer counts = Integer.parseInt(countString);
        counts++;
        binding.textviewFirst.setText(counts.toString());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}