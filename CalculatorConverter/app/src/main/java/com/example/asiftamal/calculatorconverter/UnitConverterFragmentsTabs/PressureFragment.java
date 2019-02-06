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


public class PressureFragment extends Fragment {




    public PressureFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pressure, container, false);

        final EditText atmosphere = view.findViewById(R.id.input_atmosphere);
        final EditText bar = view.findViewById(R.id.input_bar);
        final EditText pascal = view.findViewById(R.id.input_pascal);
        final EditText poundForcePerSquareInch = view.findViewById(R.id.input_pound_force_per_square_inch);
        final EditText torr = view.findViewById(R.id.input_torr);

        atmosphere.addTextChangedListener(new TextWatcher() {
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
                if (atmosphere.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        bar.setText(String.valueOf((Double.parseDouble(s.toString()) * 1.01325)));
                        pascal.setText(String.valueOf(Double.parseDouble(s.toString()) * 101325));
                        poundForcePerSquareInch.setText(String.valueOf(Double.parseDouble(s.toString()) * 14.6959));
                        torr.setText(String.valueOf(Double.parseDouble(s.toString()) * 760));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        bar.getText().clear();
                        pascal.getText().clear();
                        poundForcePerSquareInch.getText().clear();
                        torr.getText().clear();
                    }
                }
            }
        });

        bar.addTextChangedListener(new TextWatcher() {
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
                if (bar.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        atmosphere.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.986923)));
                        pascal.setText(String.valueOf(Double.parseDouble(s.toString()) * 100000));
                        poundForcePerSquareInch.setText(String.valueOf(Double.parseDouble(s.toString()) * 14.5038));
                        torr.setText(String.valueOf(Double.parseDouble(s.toString()) * 750.062));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        atmosphere.getText().clear();
                        pascal.getText().clear();
                        poundForcePerSquareInch.getText().clear();
                        torr.getText().clear();
                    }
                }
            }
        });

        pascal.addTextChangedListener(new TextWatcher() {
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
                if (pascal.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        atmosphere.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.0000048692)));
                        bar.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00001));
                        poundForcePerSquareInch.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000145038));
                        torr.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00750062));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        atmosphere.getText().clear();
                        bar.getText().clear();
                        poundForcePerSquareInch.getText().clear();
                        torr.getText().clear();
                    }
                }
            }
        });

        poundForcePerSquareInch.addTextChangedListener(new TextWatcher() {
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
                if (poundForcePerSquareInch.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        atmosphere.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.068046)));
                        bar.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0689476));
                        pascal.setText(String.valueOf(Double.parseDouble(s.toString()) * 6894.76));
                        torr.setText(String.valueOf(Double.parseDouble(s.toString()) * 51.7149));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        atmosphere.getText().clear();
                        bar.getText().clear();
                        pascal.getText().clear();
                        torr.getText().clear();
                    }
                }
            }
        });

        torr.addTextChangedListener(new TextWatcher() {
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
                if (torr.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        atmosphere.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.00131579)));
                        bar.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00133322));
                        pascal.setText(String.valueOf(Double.parseDouble(s.toString()) * 133.322));
                        poundForcePerSquareInch.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0193368));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        atmosphere.getText().clear();
                        bar.getText().clear();
                        pascal.getText().clear();
                        poundForcePerSquareInch.getText().clear();
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
