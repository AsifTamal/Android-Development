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


public class FrequencyFragment extends Fragment {

    public FrequencyFragment() {
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
        View view = inflater.inflate(R.layout.fragment_frequency, container, false);


        final EditText hertz = view.findViewById(R.id.input_hertz);
        final EditText kilohertz = view.findViewById(R.id.input_kilohertz);
        final EditText megahertz = view.findViewById(R.id.input_megahertz);
        final EditText gigahertz = view.findViewById(R.id.input_gigahertz);

        hertz.addTextChangedListener(new TextWatcher() {
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
                if (hertz.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        kilohertz.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.001)));
                        megahertz.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000001));
                        gigahertz.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000000001));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        kilohertz.getText().clear();
                        megahertz.getText().clear();
                        gigahertz.getText().clear();
                    }
                }
            }
        });

        kilohertz.addTextChangedListener(new TextWatcher() {
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
                if (kilohertz.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        hertz.setText(String.valueOf((Double.parseDouble(s.toString()) * 1000)));
                        megahertz.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.001));
                        gigahertz.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000001));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        hertz.getText().clear();
                        megahertz.getText().clear();
                        gigahertz.getText().clear();
                    }
                }
            }
        });

        megahertz.addTextChangedListener(new TextWatcher() {
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
                if (megahertz.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        hertz.setText(String.valueOf((Double.parseDouble(s.toString()) * 1000000)));
                        kilohertz.setText(String.valueOf(Double.parseDouble(s.toString()) * 1000));
                        gigahertz.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.001));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        hertz.getText().clear();
                        kilohertz.getText().clear();
                        gigahertz.getText().clear();
                    }
                }
            }
        });

        gigahertz.addTextChangedListener(new TextWatcher() {
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
                if (gigahertz.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        hertz.setText(String.valueOf((Double.parseDouble(s.toString()) * 1000000000)));
                        kilohertz.setText(String.valueOf(Double.parseDouble(s.toString()) * 1000000));
                        megahertz.setText(String.valueOf(Double.parseDouble(s.toString()) * 1000));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        hertz.getText().clear();
                        kilohertz.getText().clear();
                        megahertz.getText().clear();
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
