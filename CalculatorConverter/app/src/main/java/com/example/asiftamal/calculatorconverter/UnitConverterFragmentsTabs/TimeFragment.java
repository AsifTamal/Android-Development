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


public class TimeFragment extends Fragment {


    public TimeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_time, container, false);

        final EditText nanosecond = view.findViewById(R.id.input_nanosecond);
        final EditText microsecond = view.findViewById(R.id.input_microsecond);
        final EditText millisecond = view.findViewById(R.id.input_millisecond);
        final EditText second = view.findViewById(R.id.input_second);
        final EditText minute = view.findViewById(R.id.input_minute);
        final EditText hour = view.findViewById(R.id.input_hour);
        final EditText day = view.findViewById(R.id.input_day);
        final EditText week = view.findViewById(R.id.input_week);
        final EditText month = view.findViewById(R.id.input_month);
        final EditText year = view.findViewById(R.id.input_year);
        final EditText decade = view.findViewById(R.id.input_decade);
        final EditText century = view.findViewById(R.id.input_century);

        nanosecond.addTextChangedListener(new TextWatcher() {
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
                if (nanosecond.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        microsecond.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.001)));
                        millisecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000001));
                        second.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000000001));
                        minute.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000000000016667));
                        hour.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000000000027778));
                        day.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000000000000011574));
                        week.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000000000000016534));
                        month.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000000000000038052));
                        year.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000000000000003171));
                        decade.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000000000000000003171));
                        century.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000000000000000003171));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        microsecond.getText().clear();
                        millisecond.getText().clear();
                        second.getText().clear();
                        minute.getText().clear();
                        hour.getText().clear();
                        day.getText().clear();
                        week.getText().clear();
                        month.getText().clear();
                        year.getText().clear();
                        decade.getText().clear();
                        century.getText().clear();
                    }
                }
            }
        });

        microsecond.addTextChangedListener(new TextWatcher() {
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
                if (microsecond.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        nanosecond.setText(String.valueOf((Double.parseDouble(s.toString()) * 1000)));
                        millisecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.001));
                        second.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000001));
                        minute.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000000016667));
                        hour.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000000027778));
                        day.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000000000011574));
                        week.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000000000016534));
                        month.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000000000038052));
                        year.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000000000003171));
                        decade.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000000000000003171));
                        century.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000000000000003171));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        nanosecond.getText().clear();
                        millisecond.getText().clear();
                        second.getText().clear();
                        minute.getText().clear();
                        hour.getText().clear();
                        day.getText().clear();
                        week.getText().clear();
                        month.getText().clear();
                        year.getText().clear();
                        decade.getText().clear();
                        century.getText().clear();
                    }
                }
            }
        });

        millisecond.addTextChangedListener(new TextWatcher() {
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
                if (millisecond.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        nanosecond.setText(String.valueOf((Double.parseDouble(s.toString()) * 1000000)));
                        microsecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 1000));
                        second.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.001));
                        minute.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000016667));
                        hour.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000027778));
                        day.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000000011574));
                        week.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000000016534));
                        month.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000000038052));
                        year.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000000003171));
                        decade.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000000000003171));
                        century.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000000000003171));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        nanosecond.getText().clear();
                        microsecond.getText().clear();
                        second.getText().clear();
                        minute.getText().clear();
                        hour.getText().clear();
                        day.getText().clear();
                        week.getText().clear();
                        month.getText().clear();
                        year.getText().clear();
                        decade.getText().clear();
                        century.getText().clear();
                    }
                }
            }
        });

        second.addTextChangedListener(new TextWatcher() {
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
                if (second.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        nanosecond.setText(String.valueOf((Double.parseDouble(s.toString()) * 1000000000)));
                        microsecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 1000000));
                        millisecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 1000));
                        minute.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0166667));
                        hour.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000277778));
                        day.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000011574));
                        week.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000016534));
                        month.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000038052));
                        year.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000003171));
                        decade.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000000003171));
                        century.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000000003171));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        nanosecond.getText().clear();
                        microsecond.getText().clear();
                        millisecond.getText().clear();
                        minute.getText().clear();
                        hour.getText().clear();
                        day.getText().clear();
                        week.getText().clear();
                        month.getText().clear();
                        year.getText().clear();
                        decade.getText().clear();
                        century.getText().clear();
                    }
                }
            }
        });

        minute.addTextChangedListener(new TextWatcher() {
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
                if (minute.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        nanosecond.setText(String.valueOf((Double.parseDouble(s.toString()) * 60000000000L)));
                        microsecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 60000000));
                        millisecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 60000));
                        second.setText(String.valueOf(Double.parseDouble(s.toString()) * 60));
                        hour.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0166667));
                        day.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000694444));
                        week.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000099206));
                        month.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000022831));
                        year.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000019026));
                        decade.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000019026));
                        century.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000000019026));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        nanosecond.getText().clear();
                        microsecond.getText().clear();
                        millisecond.getText().clear();
                        second.getText().clear();
                        hour.getText().clear();
                        day.getText().clear();
                        week.getText().clear();
                        month.getText().clear();
                        year.getText().clear();
                        decade.getText().clear();
                        century.getText().clear();
                    }
                }
            }
        });

        hour.addTextChangedListener(new TextWatcher() {
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
                if (hour.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        nanosecond.setText(String.valueOf((Double.parseDouble(s.toString()) * 3600000000000L)));
                        microsecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 3600000000L));
                        millisecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 3600000));
                        second.setText(String.valueOf(Double.parseDouble(s.toString()) * 3600));
                        minute.setText(String.valueOf(Double.parseDouble(s.toString()) * 60));
                        day.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0416667));
                        week.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00595238));
                        month.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00136986));
                        year.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000114155));
                        decade.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000011416));
                        century.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000011416));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        nanosecond.getText().clear();
                        microsecond.getText().clear();
                        millisecond.getText().clear();
                        second.getText().clear();
                        minute.getText().clear();
                        day.getText().clear();
                        week.getText().clear();
                        month.getText().clear();
                        year.getText().clear();
                        decade.getText().clear();
                        century.getText().clear();
                    }
                }
            }
        });

        day.addTextChangedListener(new TextWatcher() {
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
                if (day.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        nanosecond.setText(String.valueOf((Double.parseDouble(s.toString()) * 86400000000000L)));
                        microsecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 86400000000L));
                        millisecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 8.64e+7));
                        second.setText(String.valueOf(Double.parseDouble(s.toString()) * 86400));
                        minute.setText(String.valueOf(Double.parseDouble(s.toString()) * 1440));
                        hour.setText(String.valueOf(Double.parseDouble(s.toString()) * 24));
                        week.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.142857));
                        month.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0328767));
                        year.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00273973));
                        decade.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000273973));
                        century.setText(String.valueOf(Double.parseDouble(s.toString()) * 2.7397e-5));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        nanosecond.getText().clear();
                        microsecond.getText().clear();
                        millisecond.getText().clear();
                        second.getText().clear();
                        minute.getText().clear();
                        hour.getText().clear();
                        week.getText().clear();
                        month.getText().clear();
                        year.getText().clear();
                        decade.getText().clear();
                        century.getText().clear();
                    }
                }
            }
        });

        week.addTextChangedListener(new TextWatcher() {
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
                if (week.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        nanosecond.setText(String.valueOf((Double.parseDouble(s.toString()) * 6.048e+14)));
                        microsecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 6.048e+11));
                        millisecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 6.048e+8));
                        second.setText(String.valueOf(Double.parseDouble(s.toString()) * 604800));
                        minute.setText(String.valueOf(Double.parseDouble(s.toString()) * 10080));
                        hour.setText(String.valueOf(Double.parseDouble(s.toString()) * 168));
                        day.setText(String.valueOf(Double.parseDouble(s.toString()) * 7));
                        month.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.230137));
                        year.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0191781));
                        decade.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00191781));
                        century.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000191781));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        nanosecond.getText().clear();
                        microsecond.getText().clear();
                        millisecond.getText().clear();
                        second.getText().clear();
                        minute.getText().clear();
                        hour.getText().clear();
                        day.getText().clear();
                        month.getText().clear();
                        year.getText().clear();
                        decade.getText().clear();
                        century.getText().clear();
                    }
                }
            }
        });

        month.addTextChangedListener(new TextWatcher() {
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
                if (month.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        nanosecond.setText(String.valueOf((Double.parseDouble(s.toString()) * 2.628e+15)));
                        microsecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 2.628e+12));
                        millisecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 2.628e+9));
                        second.setText(String.valueOf(Double.parseDouble(s.toString()) * 2.628e+6));
                        minute.setText(String.valueOf(Double.parseDouble(s.toString()) * 43800));
                        hour.setText(String.valueOf(Double.parseDouble(s.toString()) * 730.001));
                        day.setText(String.valueOf(Double.parseDouble(s.toString()) * 30.4167));
                        week.setText(String.valueOf(Double.parseDouble(s.toString()) * 4.34524));
                        year.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0833334));
                        decade.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00833334));
                        century.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000833334));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        nanosecond.getText().clear();
                        microsecond.getText().clear();
                        millisecond.getText().clear();
                        second.getText().clear();
                        minute.getText().clear();
                        hour.getText().clear();
                        day.getText().clear();
                        week.getText().clear();
                        year.getText().clear();
                        decade.getText().clear();
                        century.getText().clear();
                    }
                }
            }
        });

        year.addTextChangedListener(new TextWatcher() {
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
                if (year.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        nanosecond.setText(String.valueOf((Double.parseDouble(s.toString()) * 3.154e+16)));
                        microsecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 3.154e+13));
                        millisecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 3.154e+10));
                        second.setText(String.valueOf(Double.parseDouble(s.toString()) * 3.154e+7));
                        minute.setText(String.valueOf(Double.parseDouble(s.toString()) * 525600));
                        hour.setText(String.valueOf(Double.parseDouble(s.toString()) * 8760));
                        day.setText(String.valueOf(Double.parseDouble(s.toString()) * 365));
                        week.setText(String.valueOf(Double.parseDouble(s.toString()) * 52.1429));
                        month.setText(String.valueOf(Double.parseDouble(s.toString()) * 12));
                        decade.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.1));
                        century.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.01));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        nanosecond.getText().clear();
                        microsecond.getText().clear();
                        millisecond.getText().clear();
                        second.getText().clear();
                        minute.getText().clear();
                        hour.getText().clear();
                        day.getText().clear();
                        week.getText().clear();
                        month.getText().clear();
                        decade.getText().clear();
                        century.getText().clear();
                    }
                }
            }
        });

        decade.addTextChangedListener(new TextWatcher() {
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
                if (decade.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        nanosecond.setText(String.valueOf((Double.parseDouble(s.toString()) * 3.154e+17)));
                        microsecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 3.154e+14));
                        millisecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 3.154e+11));
                        second.setText(String.valueOf(Double.parseDouble(s.toString()) * 3.154e+8));
                        minute.setText(String.valueOf(Double.parseDouble(s.toString()) * 5.256e+6));
                        hour.setText(String.valueOf(Double.parseDouble(s.toString()) * 87600));
                        day.setText(String.valueOf(Double.parseDouble(s.toString()) * 3650));
                        week.setText(String.valueOf(Double.parseDouble(s.toString()) * 521.429));
                        month.setText(String.valueOf(Double.parseDouble(s.toString()) * 120));
                        year.setText(String.valueOf(Double.parseDouble(s.toString()) * 10));
                        century.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.1));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        nanosecond.getText().clear();
                        microsecond.getText().clear();
                        millisecond.getText().clear();
                        second.getText().clear();
                        minute.getText().clear();
                        hour.getText().clear();
                        day.getText().clear();
                        week.getText().clear();
                        month.getText().clear();
                        year.getText().clear();
                        century.getText().clear();
                    }
                }
            }
        });

        century.addTextChangedListener(new TextWatcher() {
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
                if (century.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        nanosecond.setText(String.valueOf((Double.parseDouble(s.toString()) * 3.154e+18)));
                        microsecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 3.154e+15));
                        millisecond.setText(String.valueOf(Double.parseDouble(s.toString()) * 3.154e+12));
                        second.setText(String.valueOf(Double.parseDouble(s.toString()) * 3.154e+9));
                        minute.setText(String.valueOf(Double.parseDouble(s.toString()) * 5.256e+7));
                        hour.setText(String.valueOf(Double.parseDouble(s.toString()) * 876000));
                        day.setText(String.valueOf(Double.parseDouble(s.toString()) * 36500));
                        week.setText(String.valueOf(Double.parseDouble(s.toString()) * 5214.29));
                        month.setText(String.valueOf(Double.parseDouble(s.toString()) * 1200));
                        year.setText(String.valueOf(Double.parseDouble(s.toString()) * 100));
                        decade.setText(String.valueOf(Double.parseDouble(s.toString()) * 10));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        nanosecond.getText().clear();
                        microsecond.getText().clear();
                        millisecond.getText().clear();
                        second.getText().clear();
                        minute.getText().clear();
                        hour.getText().clear();
                        day.getText().clear();
                        week.getText().clear();
                        month.getText().clear();
                        year.getText().clear();
                        decade.getText().clear();
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
