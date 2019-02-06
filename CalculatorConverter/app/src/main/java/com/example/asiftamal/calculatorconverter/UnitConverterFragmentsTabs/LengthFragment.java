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


public class LengthFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_length, container, false);

        final EditText kilometre = view.findViewById(R.id.input_kilometre);
        final EditText metre = view.findViewById(R.id.input_metre);
        final EditText centimetre = view.findViewById(R.id.input_centimetre);
        final EditText millimetre = view.findViewById(R.id.input_millimetre);
        final EditText micrometre = view.findViewById(R.id.input_micrometre);
        final EditText nanometre = view.findViewById(R.id.input_nanometre);
        final EditText mile = view.findViewById(R.id.input_mile);
        final EditText yard = view.findViewById(R.id.input_yard);
        final EditText foot = view.findViewById(R.id.input_foot);
        final EditText inch = view.findViewById(R.id.input_inch);
        final EditText nauticalMile = view.findViewById(R.id.input_nautical_mile);

        kilometre.addTextChangedListener(new TextWatcher() {
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
                if (kilometre.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        metre.setText(String.valueOf((Double.parseDouble(s.toString()) * 1000)));
                        centimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 100000));
                        millimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1000000));
                        micrometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1000000000));
                        nanometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1000000000000L));
                        mile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.621371));
                        yard.setText(String.valueOf(Double.parseDouble(s.toString()) * 1093.61));
                        foot.setText(String.valueOf(Double.parseDouble(s.toString()) * 3280.84));
                        inch.setText(String.valueOf(Double.parseDouble(s.toString()) * 39370.1));
                        nauticalMile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.539957));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        metre.getText().clear();
                        centimetre.getText().clear();
                        millimetre.getText().clear();
                        micrometre.getText().clear();
                        nanometre.getText().clear();
                        mile.getText().clear();
                        yard.getText().clear();
                        foot.getText().clear();
                        inch.getText().clear();
                        nauticalMile.getText().clear();
                    }
                }
            }
        });

        metre.addTextChangedListener(new TextWatcher() {
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
                if (metre.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        kilometre.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.001)));
                        centimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 100));
                        millimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1000));
                        micrometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1000000));
                        nanometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1000000000));
                        mile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000621371));
                        yard.setText(String.valueOf(Double.parseDouble(s.toString()) * 1.09361));
                        foot.setText(String.valueOf(Double.parseDouble(s.toString()) * 3.28084));
                        inch.setText(String.valueOf(Double.parseDouble(s.toString()) * 39.3701));
                        nauticalMile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000539957));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        kilometre.getText().clear();
                        centimetre.getText().clear();
                        millimetre.getText().clear();
                        micrometre.getText().clear();
                        nanometre.getText().clear();
                        mile.getText().clear();
                        yard.getText().clear();
                        foot.getText().clear();
                        inch.getText().clear();
                        nauticalMile.getText().clear();
                    }
                }
            }
        });

        centimetre.addTextChangedListener(new TextWatcher() {
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
                if (centimetre.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        kilometre.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.00001)));
                        metre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.01));
                        millimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 10));
                        micrometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 10000));
                        nanometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 10000000));
                        mile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000062137));
                        yard.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.010936111996938));
                        foot.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0328084));
                        inch.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.393701));
                        nauticalMile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000539957));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        kilometre.getText().clear();
                        metre.getText().clear();
                        millimetre.getText().clear();
                        micrometre.getText().clear();
                        nanometre.getText().clear();
                        mile.getText().clear();
                        yard.getText().clear();
                        foot.getText().clear();
                        inch.getText().clear();
                        nauticalMile.getText().clear();
                    }
                }
            }
        });

        millimetre.addTextChangedListener(new TextWatcher() {
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
                if (millimetre.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        kilometre.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.000001)));
                        metre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.001));
                        centimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.1));
                        micrometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1000));
                        nanometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1000000));
                        mile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000062137));
                        yard.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00109361));
                        foot.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00328084));
                        inch.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0393701));
                        nauticalMile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000053996));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        kilometre.getText().clear();
                        metre.getText().clear();
                        centimetre.getText().clear();
                        micrometre.getText().clear();
                        nanometre.getText().clear();
                        mile.getText().clear();
                        yard.getText().clear();
                        foot.getText().clear();
                        inch.getText().clear();
                        nauticalMile.getText().clear();
                    }
                }
            }
        });

        micrometre.addTextChangedListener(new TextWatcher() {
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
                if (micrometre.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        kilometre.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.000000001)));
                        metre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000001));
                        centimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0001));
                        millimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.001));
                        nanometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1000));
                        mile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000000062137));
                        yard.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000010936));
                        foot.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000032808));
                        inch.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00003937));
                        nauticalMile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000000053996));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        kilometre.getText().clear();
                        metre.getText().clear();
                        centimetre.getText().clear();
                        millimetre.getText().clear();
                        nanometre.getText().clear();
                        mile.getText().clear();
                        yard.getText().clear();
                        foot.getText().clear();
                        inch.getText().clear();
                        nauticalMile.getText().clear();
                    }
                }
            }
        });

        nanometre.addTextChangedListener(new TextWatcher() {
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
                if (nanometre.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        kilometre.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.000000000001)));
                        metre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000000001));
                        centimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000001));
                        millimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000001));
                        micrometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.001));
                        mile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000000000062137));
                        yard.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000010936));
                        foot.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000000010936));
                        inch.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000003937));
                        nauticalMile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000000000053996));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        kilometre.getText().clear();
                        metre.getText().clear();
                        centimetre.getText().clear();
                        millimetre.getText().clear();
                        micrometre.getText().clear();
                        mile.getText().clear();
                        yard.getText().clear();
                        foot.getText().clear();
                        inch.getText().clear();
                        nauticalMile.getText().clear();
                    }
                }
            }
        });

        mile.addTextChangedListener(new TextWatcher() {
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
                if (mile.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        kilometre.setText(String.valueOf((Double.parseDouble(s.toString()) * 1.60934)));
                        metre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1609.34));
                        centimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 160934));
                        millimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1609000));
                        micrometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1609000000));
                        nanometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1609000000000L));
                        yard.setText(String.valueOf(Double.parseDouble(s.toString()) * 1760));
                        foot.setText(String.valueOf(Double.parseDouble(s.toString()) * 5280));
                        inch.setText(String.valueOf(Double.parseDouble(s.toString()) * 63360));
                        nauticalMile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.868976));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        kilometre.getText().clear();
                        metre.getText().clear();
                        centimetre.getText().clear();
                        millimetre.getText().clear();
                        micrometre.getText().clear();
                        nanometre.getText().clear();
                        yard.getText().clear();
                        foot.getText().clear();
                        inch.getText().clear();
                        nauticalMile.getText().clear();
                    }
                }
            }
        });

        yard.addTextChangedListener(new TextWatcher() {
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
                if (yard.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        kilometre.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.0009144)));
                        metre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.9144));
                        centimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 91.44));
                        millimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 914.4));
                        micrometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 914400));
                        nanometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 914400000));
                        mile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000568182));
                        foot.setText(String.valueOf(Double.parseDouble(s.toString()) * 3));
                        inch.setText(String.valueOf(Double.parseDouble(s.toString()) * 36));
                        nauticalMile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000493737));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        kilometre.getText().clear();
                        metre.getText().clear();
                        centimetre.getText().clear();
                        millimetre.getText().clear();
                        micrometre.getText().clear();
                        nanometre.getText().clear();
                        mile.getText().clear();
                        foot.getText().clear();
                        inch.getText().clear();
                        nauticalMile.getText().clear();
                    }
                }
            }
        });

        foot.addTextChangedListener(new TextWatcher() {
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
                if (foot.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        kilometre.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.0003048)));
                        metre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.3048));
                        centimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 30.48));
                        millimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 304.8));
                        micrometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 304800));
                        nanometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 304800000));
                        mile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000189394));
                        yard.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.333333));
                        inch.setText(String.valueOf(Double.parseDouble(s.toString()) * 12));
                        nauticalMile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000164579));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        kilometre.getText().clear();
                        metre.getText().clear();
                        centimetre.getText().clear();
                        millimetre.getText().clear();
                        micrometre.getText().clear();
                        nanometre.getText().clear();
                        mile.getText().clear();
                        yard.getText().clear();
                        inch.getText().clear();
                        nauticalMile.getText().clear();
                    }
                }
            }
        });

        inch.addTextChangedListener(new TextWatcher() {
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
                if (inch.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        kilometre.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.0000254)));
                        metre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0254));
                        centimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 2.54));
                        millimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 25.4));
                        micrometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 25400));
                        nanometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 25400000));
                        mile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000015783));
                        yard.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0277778));
                        foot.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0833333));
                        nauticalMile.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000013715));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        kilometre.getText().clear();
                        metre.getText().clear();
                        centimetre.getText().clear();
                        millimetre.getText().clear();
                        micrometre.getText().clear();
                        nanometre.getText().clear();
                        mile.getText().clear();
                        yard.getText().clear();
                        foot.getText().clear();
                        nauticalMile.getText().clear();
                    }
                }
            }
        });

        nauticalMile.addTextChangedListener(new TextWatcher() {
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
                if (nauticalMile.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        kilometre.setText(String.valueOf((Double.parseDouble(s.toString()) * 1.852)));
                        metre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1852));
                        centimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 185200));
                        millimetre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1852000));
                        micrometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1852000000));
                        nanometre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1852000000000L));
                        mile.setText(String.valueOf(Double.parseDouble(s.toString()) * 1.15078));
                        yard.setText(String.valueOf(Double.parseDouble(s.toString()) * 2025.37));
                        foot.setText(String.valueOf(Double.parseDouble(s.toString()) * 6076.12));
                        inch.setText(String.valueOf(Double.parseDouble(s.toString()) * 72913.4));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        kilometre.getText().clear();
                        metre.getText().clear();
                        centimetre.getText().clear();
                        millimetre.getText().clear();
                        micrometre.getText().clear();
                        nanometre.getText().clear();
                        mile.getText().clear();
                        yard.getText().clear();
                        foot.getText().clear();
                        inch.getText().clear();
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
