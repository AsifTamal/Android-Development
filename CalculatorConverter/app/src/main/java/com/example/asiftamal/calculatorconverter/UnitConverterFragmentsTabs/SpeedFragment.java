package com.example.asiftamal.calculatorconverter.UnitConverterFragmentsTabs;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.asiftamal.calculatorconverter.R;


public class SpeedFragment extends Fragment {


    public SpeedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_speed, container, false);


        final EditText milesPerHour = view.findViewById(R.id.input_miles_per_hour);
        final EditText footPerSecond = view.findViewById(R.id.input_foot_per_second);
        final EditText metrePerSecond = view.findViewById(R.id.input_metre_per_second);
        final EditText kiloMetrePerHour = view.findViewById(R.id.input_kilometre_per_hour);
        final EditText knot = view.findViewById(R.id.input_knot);

        milesPerHour.addTextChangedListener(new TextWatcher() {
            int charCount = 0;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                charCount = count;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (milesPerHour.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        footPerSecond.setText(String.valueOf((Double.parseDouble(s.toString()) * 1.46667)));
                        metrePerSecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.44704));
                        kiloMetrePerHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 1.60934));
                        knot.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.868976));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        footPerSecond.getText().clear();
                        metrePerSecond.getText().clear();
                        kiloMetrePerHour.getText().clear();
                        knot.getText().clear();
                    }
                }
            }
        });

        footPerSecond.addTextChangedListener(new TextWatcher() {
            int charCount = 0;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                charCount = count;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (footPerSecond.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        milesPerHour.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.681818)));
                        metrePerSecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.3048));
                        kiloMetrePerHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 1.09728));
                        knot.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.592484));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        milesPerHour.getText().clear();
                        metrePerSecond.getText().clear();
                        kiloMetrePerHour.getText().clear();
                        knot.getText().clear();
                    }
                }
            }
        });

        metrePerSecond.addTextChangedListener(new TextWatcher() {
            int charCount = 0;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                charCount = count;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (metrePerSecond.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        milesPerHour.setText(String.valueOf((Double.parseDouble(s.toString()) * 2.23694)));
                        footPerSecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 3.28084));
                        kiloMetrePerHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 3.6));
                        knot.setText(String.valueOf(Double.parseDouble(s.toString()) * 1.94384));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        milesPerHour.getText().clear();
                        footPerSecond.getText().clear();
                        kiloMetrePerHour.getText().clear();
                        knot.getText().clear();
                    }
                }
            }
        });

        kiloMetrePerHour.addTextChangedListener(new TextWatcher() {
            int charCount = 0;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                charCount = count;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (kiloMetrePerHour.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        milesPerHour.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.621371)));
                        footPerSecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.911344));
                        metrePerSecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.277778));
                        knot.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.539957));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        milesPerHour.getText().clear();
                        footPerSecond.getText().clear();
                        metrePerSecond.getText().clear();
                        knot.getText().clear();
                    }
                }
            }
        });

        knot.addTextChangedListener(new TextWatcher() {
            int charCount = 0;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                charCount = count;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (knot.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        milesPerHour.setText(String.valueOf((Double.parseDouble(s.toString()) * 1.15078)));
                        footPerSecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 1.68781));
                        metrePerSecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.514444));
                        kiloMetrePerHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 1.852));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        milesPerHour.getText().clear();
                        footPerSecond.getText().clear();
                        metrePerSecond.getText().clear();
                        kiloMetrePerHour.getText().clear();
                    }
                }
            }
        });

        return view;
    }
    private boolean tryParseDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
