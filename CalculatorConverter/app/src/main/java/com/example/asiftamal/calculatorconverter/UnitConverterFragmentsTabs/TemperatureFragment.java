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


public class TemperatureFragment extends Fragment {


    public TemperatureFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_temperature, container, false);


        final EditText celsius = view.findViewById(R.id.input_celsius);
        final EditText fahrenheit = view.findViewById(R.id.input_fahrenheit);
        final EditText kelvin = view.findViewById(R.id.input_kelvin);

        celsius.addTextChangedListener(new TextWatcher() {
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
                if (celsius.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        fahrenheit.setText(String.valueOf(((9.0 / 5.0) * Double.parseDouble(s.toString())) + 32));
                        kelvin.setText(String.valueOf(Double.parseDouble(s.toString()) + 273.15));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        fahrenheit.getText().clear();
                        kelvin.getText().clear();
                    }
                }
            }
        });

        fahrenheit.addTextChangedListener(new TextWatcher() {
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
                if (fahrenheit.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        celsius.setText(String.valueOf((((Double.parseDouble(s.toString()) - 32) * 5) / 9)));
                        kelvin.setText(String.valueOf((5.0 / 9 * (Double.parseDouble(s.toString()) - 32) + 273.15)));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        celsius.getText().clear();
                        kelvin.getText().clear();
                    }
                }
            }
        });

        kelvin.addTextChangedListener(new TextWatcher() {
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
                if (kelvin.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        celsius.setText(String.valueOf(Double.parseDouble(s.toString()) - 273.15));
                        fahrenheit.setText(String.valueOf(((Double.parseDouble(s.toString()) * 9 / 5) - 459.67)));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        celsius.getText().clear();
                        fahrenheit.getText().clear();
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
