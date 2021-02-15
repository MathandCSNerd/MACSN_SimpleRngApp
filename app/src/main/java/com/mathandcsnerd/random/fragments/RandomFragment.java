/* Copyright 2021 Matthew Macallister
 *
 * This file is part of MACSN Simple Rng App.
 *
 * MACSN Simple Rng App is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MACSN Simple Rng App is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MACSN Simple Rng App.  If not, see
 * <https://www.gnu.org/licenses/>.
 */

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