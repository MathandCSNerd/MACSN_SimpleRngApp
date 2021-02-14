package com.mathandcsnerd.random.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.mathandcsnerd.random.MainActivity;
import com.mathandcsnerd.random.R;
import com.mathandcsnerd.random.data.CustomRng;

public class RandomFragment extends Fragment {

    ArrayAdapter<Integer> arrayAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.blocked_numbers_fragment, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainActivity activity = ((MainActivity)getActivity());

        ListView numListView = activity.findViewById(R.id.blocked_list);
        arrayAdapter = activity.randomResults;
        numListView.setAdapter(arrayAdapter);

        numListView.setOnItemClickListener((parent, argView, position, id) -> {
            Integer x = (Integer) parent.getItemAtPosition(position);
            arrayAdapter.remove(x);
            arrayAdapter.notifyDataSetChanged();
        });
        numListView.setClickable(true);
    }
}