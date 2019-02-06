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


public class AreaFragment extends Fragment {
View view;
public AreaFragment(){}



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_area, container, false);


        final EditText squareKilometre = view.findViewById(R.id.input_square_kilometer);
        final EditText squareMetre = view.findViewById(R.id.input_square_metre);
        final EditText squareMile = view.findViewById(R.id.input_square_mile);
        final EditText squareYard = view.findViewById(R.id.input_square_yard);
        final EditText squareFoot = view.findViewById(R.id.input_square_foot);
        final EditText squareInch = view.findViewById(R.id.input_square_inch);
        final EditText hectare = view.findViewById(R.id.input_hectare);
        final EditText acre = view.findViewById(R.id.input_acre);

        squareKilometre.addTextChangedListener(new TextWatcher() {
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
                if (squareKilometre.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        squareMetre.setText(String.valueOf((Double.parseDouble(s.toString()) * 1000000)));
                        squareMile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.38610));
                        squareYard.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.00000083612736));
                        squareFoot.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.00000009290304));
                        squareInch.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.00000000064516));
                        hectare.setText(String.valueOf(Double.parseDouble(s.toString()) * 100));
                        acre.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.00404685642));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        squareMetre.getText().clear();
                        squareMile.getText().clear();
                        squareYard.getText().clear();
                        squareFoot.getText().clear();
                        squareInch.getText().clear();
                        hectare.getText().clear();
                        acre.getText().clear();
                    }
                }
            }
        });

        squareMetre.addTextChangedListener(new TextWatcher() {
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
                if (squareMetre.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        squareKilometre.setText(String.valueOf((Double.parseDouble(s.toString()) / 1000000)));
                        squareMile.setText(String.valueOf(Double.parseDouble(s.toString()) / 2589988.11));
                        squareYard.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.83612736));
                        squareFoot.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.09290304));
                        squareInch.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.00064516));
                        hectare.setText(String.valueOf(Double.parseDouble(s.toString()) / 10000));
                        acre.setText(String.valueOf(Double.parseDouble(s.toString()) / 4046.85642));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        squareKilometre.getText().clear();
                        squareMile.getText().clear();
                        squareYard.getText().clear();
                        squareFoot.getText().clear();
                        squareInch.getText().clear();
                        hectare.getText().clear();
                        acre.getText().clear();
                    }
                }
            }
        });

        squareMile.addTextChangedListener(new TextWatcher() {
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
                if (squareMile.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        squareKilometre.setText(String.valueOf((Double.parseDouble(s.toString()) * 2.58998811)));
                        squareMetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 2589988.11));
                        squareYard.setText(String.valueOf(Double.parseDouble(s.toString()) * 3097600));
                        squareFoot.setText(String.valueOf(Double.parseDouble(s.toString()) * 27878400));
                        squareInch.setText(String.valueOf(Double.parseDouble(s.toString()) * 4014489600L));
                        hectare.setText(String.valueOf(Double.parseDouble(s.toString()) * 258.998811));
                        acre.setText(String.valueOf(Double.parseDouble(s.toString()) * 640));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        squareKilometre.getText().clear();
                        squareMetre.getText().clear();
                        squareYard.getText().clear();
                        squareFoot.getText().clear();
                        squareInch.getText().clear();
                        hectare.getText().clear();
                        acre.getText().clear();
                    }
                }
            }
        });

        squareYard.addTextChangedListener(new TextWatcher() {
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
                if (squareYard.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        squareKilometre.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.00000083612736)));
                        squareMetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.83612736));
                        squareMile.setText(String.valueOf(Double.parseDouble(s.toString()) / 3097600));
                        squareFoot.setText(String.valueOf(Double.parseDouble(s.toString()) * 9));
                        squareInch.setText(String.valueOf(Double.parseDouble(s.toString()) * 1296));
                        hectare.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000083612736));
                        acre.setText(String.valueOf(Double.parseDouble(s.toString()) / 4840));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        squareKilometre.getText().clear();
                        squareMetre.getText().clear();
                        squareMile.getText().clear();
                        squareFoot.getText().clear();
                        squareInch.getText().clear();
                        hectare.getText().clear();
                        acre.getText().clear();
                    }
                }
            }
        });

        squareFoot.addTextChangedListener(new TextWatcher() {
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
                if (squareFoot.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        squareKilometre.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.00000009290304)));
                        squareMetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.09290304));
                        squareMile.setText(String.valueOf(Double.parseDouble(s.toString()) / 27878400));
                        squareYard.setText(String.valueOf(Double.parseDouble(s.toString()) / 9));
                        squareInch.setText(String.valueOf(Double.parseDouble(s.toString()) * 144));
                        hectare.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000009290304));
                        acre.setText(String.valueOf(Double.parseDouble(s.toString()) / 43560));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        squareKilometre.getText().clear();
                        squareMetre.getText().clear();
                        squareMile.getText().clear();
                        squareYard.getText().clear();
                        squareInch.getText().clear();
                        hectare.getText().clear();
                        acre.getText().clear();
                    }
                }
            }
        });

        squareInch.addTextChangedListener(new TextWatcher() {
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
                if (squareInch.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        squareKilometre.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.00000000064516)));
                        squareMetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00064516));
                        squareMile.setText(String.valueOf(Double.parseDouble(s.toString()) / 4014489600L));
                        squareYard.setText(String.valueOf(Double.parseDouble(s.toString()) / 1296));
                        squareFoot.setText(String.valueOf(Double.parseDouble(s.toString()) / 144));
                        hectare.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000000064516));
                        acre.setText(String.valueOf(Double.parseDouble(s.toString()) / 6272640));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        squareKilometre.getText().clear();
                        squareMetre.getText().clear();
                        squareMile.getText().clear();
                        squareYard.getText().clear();
                        squareFoot.getText().clear();
                        hectare.getText().clear();
                        acre.getText().clear();
                    }
                }
            }
        });

        hectare.addTextChangedListener(new TextWatcher() {
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
                if (hectare.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        squareKilometre.setText(String.valueOf((Double.parseDouble(s.toString()) / 100)));
                        squareMetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 10000));
                        squareMile.setText(String.valueOf(Double.parseDouble(s.toString()) / 258.998811));
                        squareYard.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.000083612736));
                        squareFoot.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.000009290304));
                        squareInch.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.000000064516));
                        acre.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.404685642));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        squareKilometre.getText().clear();
                        squareMetre.getText().clear();
                        squareMile.getText().clear();
                        squareYard.getText().clear();
                        squareFoot.getText().clear();
                        squareInch.getText().clear();
                        acre.getText().clear();
                    }
                }
            }
        });

        acre.addTextChangedListener(new TextWatcher() {
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
                if (acre.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        squareKilometre.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.00404685642)));
                        squareMetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 4046.85642));
                        squareMile.setText(String.valueOf(Double.parseDouble(s.toString()) / 640));
                        squareYard.setText(String.valueOf(Double.parseDouble(s.toString()) * 4840));
                        squareFoot.setText(String.valueOf(Double.parseDouble(s.toString()) * 43560));
                        squareInch.setText(String.valueOf(Double.parseDouble(s.toString()) * 6272640));
                        hectare.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.404685642));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        squareKilometre.getText().clear();
                        squareMetre.getText().clear();
                        squareMile.getText().clear();
                        squareYard.getText().clear();
                        squareFoot.getText().clear();
                        squareInch.getText().clear();
                        hectare.getText().clear();
                    }
                }
            }
        });

        return  view;



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
