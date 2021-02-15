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

package com.mathandcsnerd.random;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mathandcsnerd.random.data.CustomRng;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static public CustomRng rng = new CustomRng();
    static private ArrayList<Integer> _randomList = new ArrayList<Integer>();
    public ArrayAdapter<Integer> randomResults;

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        randomResults = new ArrayAdapter<Integer>(getApplicationContext(), android.R.layout.simple_list_item_1, _randomList);

        FloatingActionButton fab = findViewById(R.id.addToBlockList);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et = findViewById(R.id.inputDialog);
                try {
                    int max = Integer.parseInt(et.getText().toString());
                    int randNum = rng.getNumOutOf(max);
                    try {
                        randomResults.add(randNum);
                        randomResults.notifyDataSetChanged();
                    }
                    catch(Exception ex) {
                        Log.e(TAG,"failed to add int to dataset: " + ex.toString());
                    }
                }
                catch(Exception ex) {
                    Log.e(TAG,"failed to parse upper bound as an int: " + ex.toString());
                }
            }
        });

    }

}
