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

import java.math.BigDecimal;


public class EnergyFragment extends Fragment {

    View view;
    public EnergyFragment() {
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
         view= inflater.inflate(R.layout.fragment_energy, container, false);





        final EditText joule = view.findViewById(R.id.input_joule);
        final EditText kiloJoule = view.findViewById(R.id.input_kilojoule);
        final EditText gramCalorie = view.findViewById(R.id.input_gram_calorie);
        final EditText kiloCalorie = view.findViewById(R.id.input_kilocalorie);
        final EditText wattHour = view.findViewById(R.id.input_watt_hour);
        final EditText kiloWattHour = view.findViewById(R.id.input_kilowatt_hour);
        final EditText electronVolt = view.findViewById(R.id.input_electronvolt);
        final EditText britishThermalUnit = view.findViewById(R.id.input_british_thermal_unit);
        final EditText usTherm = view.findViewById(R.id.input_us_therm);
        final EditText footPound = view.findViewById(R.id.input_foot_pound);

        joule.addTextChangedListener(new TextWatcher() {
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
                if (joule.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        kiloJoule.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.001)));
                        gramCalorie.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.239006));
                        kiloCalorie.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000239006));
                        wattHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000277778));
                        kiloWattHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000027778));
                        electronVolt.setText(String.valueOf(Double.parseDouble(s.toString()) * 6242000000000000000L));
                        britishThermalUnit.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000947817));
                        usTherm.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000000094804));
                        footPound.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.737562));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        kiloJoule.getText().clear();
                        gramCalorie.getText().clear();
                        kiloCalorie.getText().clear();
                        wattHour.getText().clear();
                        kiloWattHour.getText().clear();
                        electronVolt.getText().clear();
                        britishThermalUnit.getText().clear();
                        usTherm.getText().clear();
                        footPound.getText().clear();
                    }
                }
            }
        });

        gramCalorie.addTextChangedListener(new TextWatcher() {
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
                if (gramCalorie.isFocused()) {

                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        joule.setText(String.valueOf((Double.parseDouble(s.toString()) * 4.184)));
                        kiloJoule.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.004184));
                        kiloCalorie.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.001));
                        wattHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00116222));
                        kiloWattHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000011622));
                        BigDecimal sBigInteger = new BigDecimal(s.toString());
                        BigDecimal multiplicant = new BigDecimal("26110000000000000000");
                        electronVolt.setText(String.valueOf(sBigInteger.multiply(multiplicant)));
                        britishThermalUnit.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00396567));
                        usTherm.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000000039666));
                        footPound.setText(String.valueOf(Double.parseDouble(s.toString()) * 3.08596));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        joule.getText().clear();
                        kiloJoule.getText().clear();
                        kiloCalorie.getText().clear();
                        wattHour.getText().clear();
                        kiloWattHour.getText().clear();
                        electronVolt.getText().clear();
                        britishThermalUnit.getText().clear();
                        usTherm.getText().clear();
                        footPound.getText().clear();
                    }
                }
            }
        });

        kiloJoule.addTextChangedListener(new TextWatcher() {
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
                if (kiloJoule.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        joule.setText(String.valueOf((Double.parseDouble(s.toString()) * 1000)));
                        gramCalorie.setText(String.valueOf(Double.parseDouble(s.toString()) * 239.006));
                        kiloCalorie.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.239006));
                        wattHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.277778));
                        kiloWattHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00027778));
                        BigDecimal sBigInteger = new BigDecimal(s.toString());
                        BigDecimal multiplicant = new BigDecimal("6241999999999999976712");
                        electronVolt.setText(String.valueOf(sBigInteger.multiply(multiplicant)));
                        britishThermalUnit.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.947817));
                        usTherm.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0000094804));
                        footPound.setText(String.valueOf(Double.parseDouble(s.toString()) * 737.562));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        joule.getText().clear();
                        gramCalorie.getText().clear();
                        kiloCalorie.getText().clear();
                        wattHour.getText().clear();
                        kiloWattHour.getText().clear();
                        electronVolt.getText().clear();
                        britishThermalUnit.getText().clear();
                        usTherm.getText().clear();
                        footPound.getText().clear();
                    }
                }
            }
        });

        kiloCalorie.addTextChangedListener(new TextWatcher() {
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
                if (kiloCalorie.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        joule.setText(String.valueOf((Double.parseDouble(s.toString()) * 4184)));
                        gramCalorie.setText(String.valueOf(Double.parseDouble(s.toString()) * 1000));
                        kiloJoule.setText(String.valueOf(Double.parseDouble(s.toString()) * 4.184));
                        wattHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 1.16222));
                        kiloWattHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00116222));
                        BigDecimal sBigInteger = new BigDecimal(s.toString());
                        BigDecimal multiplicant = new BigDecimal("26110000000000000000288");
                        electronVolt.setText(String.valueOf(sBigInteger.multiply(multiplicant)));
                        britishThermalUnit.setText(String.valueOf(Double.parseDouble(s.toString()) * 3.96567));
                        usTherm.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000039666));
                        footPound.setText(String.valueOf(Double.parseDouble(s.toString()) * 3085.96));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        joule.getText().clear();
                        gramCalorie.getText().clear();
                        kiloJoule.getText().clear();
                        wattHour.getText().clear();
                        kiloWattHour.getText().clear();
                        electronVolt.getText().clear();
                        britishThermalUnit.getText().clear();
                        usTherm.getText().clear();
                        footPound.getText().clear();
                    }
                }
            }
        });

        wattHour.addTextChangedListener(new TextWatcher() {
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
                if (wattHour.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        joule.setText(String.valueOf((Double.parseDouble(s.toString()) * 3600)));
                        gramCalorie.setText(String.valueOf(Double.parseDouble(s.toString()) * 860.421));
                        kiloJoule.setText(String.valueOf(Double.parseDouble(s.toString()) * 3.6));
                        kiloCalorie.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.860421));
                        kiloWattHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.001));
                        BigDecimal sBigInteger = new BigDecimal(s.toString());
                        BigDecimal multiplicant = new BigDecimal("22470000000000000000136");
                        electronVolt.setText(String.valueOf(sBigInteger.multiply(multiplicant)));
                        britishThermalUnit.setText(String.valueOf(Double.parseDouble(s.toString()) * 3.41214));
                        usTherm.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00003413));
                        footPound.setText(String.valueOf(Double.parseDouble(s.toString()) * 2655.22));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        joule.getText().clear();
                        gramCalorie.getText().clear();
                        kiloJoule.getText().clear();
                        kiloCalorie.getText().clear();
                        kiloWattHour.getText().clear();
                        electronVolt.getText().clear();
                        britishThermalUnit.getText().clear();
                        usTherm.getText().clear();
                        footPound.getText().clear();
                    }
                }
            }
        });

        kiloWattHour.addTextChangedListener(new TextWatcher() {
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
                if (kiloWattHour.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        joule.setText(String.valueOf((Double.parseDouble(s.toString()) * 3600000)));
                        gramCalorie.setText(String.valueOf(Double.parseDouble(s.toString()) * 860421));
                        kiloJoule.setText(String.valueOf(Double.parseDouble(s.toString()) * 3600));
                        kiloCalorie.setText(String.valueOf(Double.parseDouble(s.toString()) * 860.421));
                        wattHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 1000));
                        BigDecimal sBigInteger = new BigDecimal(s.toString());
                        BigDecimal multiplicant = new BigDecimal("22470000000000004096440496");
                        electronVolt.setText(String.valueOf(sBigInteger.multiply(multiplicant)));
                        britishThermalUnit.setText(String.valueOf(Double.parseDouble(s.toString()) * 3412.14));
                        usTherm.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.0341296));
                        footPound.setText(String.valueOf(Double.parseDouble(s.toString()) * 2655000));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        joule.getText().clear();
                        gramCalorie.getText().clear();
                        kiloJoule.getText().clear();
                        kiloCalorie.getText().clear();
                        wattHour.getText().clear();
                        electronVolt.getText().clear();
                        britishThermalUnit.getText().clear();
                        usTherm.getText().clear();
                        footPound.getText().clear();
                    }
                }
            }
        });

        electronVolt.addTextChangedListener(new TextWatcher() {
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
                if (electronVolt.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        BigDecimal sBigInteger = new BigDecimal(s.toString());
                        BigDecimal multiplicantjoule = new BigDecimal("0.00000000000000000016022");
                        joule.setText(String.valueOf(sBigInteger.multiply(multiplicantjoule)));
                        BigDecimal multiplicantgramcalorie = new BigDecimal("0.000000000000000000038293");
                        gramCalorie.setText(String.valueOf(sBigInteger.multiply(multiplicantgramcalorie)));
                        BigDecimal multiplicantkilojoule = new BigDecimal("0.00000000000000000000016022");
                        kiloJoule.setText(String.valueOf(sBigInteger.multiply(multiplicantkilojoule)));
                        BigDecimal multiplicantkilocalorie = new BigDecimal("0.000000000000000000000038293");
                        kiloCalorie.setText(String.valueOf(sBigInteger.multiply(multiplicantkilocalorie)));
                        BigDecimal multiplicantwatthour = new BigDecimal("0.000000000000000000000044505");
                        wattHour.setText(String.valueOf(sBigInteger.multiply(multiplicantwatthour)));
                        BigDecimal multiplicantkilowatthour = new BigDecimal("0.000000000000000000000000044505");
                        kiloWattHour.setText(String.valueOf(sBigInteger.multiply(multiplicantkilowatthour)));
                        BigDecimal multiplicantbritishthermalunit = new BigDecimal("0.00000000000000000000015186");
                        britishThermalUnit.setText(String.valueOf(sBigInteger.multiply(multiplicantbritishthermalunit)));
                        BigDecimal multiplicantustherm = new BigDecimal("0.0000000000000000000000000015189");
                        usTherm.setText(String.valueOf(sBigInteger.multiply(multiplicantustherm)));
                        BigDecimal multiplicantfootpound = new BigDecimal("0.00000000000000000011817");
                        footPound.setText(String.valueOf(sBigInteger.multiply(multiplicantfootpound)));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        joule.getText().clear();
                        gramCalorie.getText().clear();
                        kiloJoule.getText().clear();
                        kiloCalorie.getText().clear();
                        wattHour.getText().clear();
                        kiloWattHour.getText().clear();
                        britishThermalUnit.getText().clear();
                        usTherm.getText().clear();
                        footPound.getText().clear();
                    }
                }
            }
        });

        britishThermalUnit.addTextChangedListener(new TextWatcher() {
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
                if (britishThermalUnit.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        joule.setText(String.valueOf((Double.parseDouble(s.toString()) * 1055.06)));
                        gramCalorie.setText(String.valueOf(Double.parseDouble(s.toString()) * 252.164));
                        kiloJoule.setText(String.valueOf(Double.parseDouble(s.toString()) * 1.05506));
                        kiloCalorie.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.252164));
                        wattHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.293071));
                        kiloWattHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000293071));
                        BigDecimal sBigInteger = new BigDecimal(s.toString());
                        BigDecimal multiplicant = new BigDecimal("6585000000000000000856");
                        electronVolt.setText(String.valueOf(sBigInteger.multiply(multiplicant)));
                        usTherm.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000010002));
                        footPound.setText(String.valueOf(Double.parseDouble(s.toString()) * 778.169));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        joule.getText().clear();
                        gramCalorie.getText().clear();
                        kiloJoule.getText().clear();
                        kiloCalorie.getText().clear();
                        wattHour.getText().clear();
                        kiloWattHour.getText().clear();
                        electronVolt.getText().clear();
                        usTherm.getText().clear();
                        footPound.getText().clear();
                    }
                }
            }
        });

        usTherm.addTextChangedListener(new TextWatcher() {
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
                if (usTherm.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        joule.setText(String.valueOf((Double.parseDouble(s.toString()) * 105500000)));
                        gramCalorie.setText(String.valueOf(Double.parseDouble(s.toString()) * 25210000));
                        kiloJoule.setText(String.valueOf(Double.parseDouble(s.toString()) * 105480));
                        kiloCalorie.setText(String.valueOf(Double.parseDouble(s.toString()) * 25210.4));
                        wattHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 29300.1));
                        kiloWattHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 29.3001));
                        BigDecimal sBigInteger = new BigDecimal(s.toString());
                        BigDecimal multiplicant = new BigDecimal("658400000000000128072472696");
                        electronVolt.setText(String.valueOf(sBigInteger.multiply(multiplicant)));
                        britishThermalUnit.setText(String.valueOf(Double.parseDouble(s.toString()) * 99976.1));
                        footPound.setText(String.valueOf(Double.parseDouble(s.toString()) * 77800000));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        joule.getText().clear();
                        gramCalorie.getText().clear();
                        kiloJoule.getText().clear();
                        kiloCalorie.getText().clear();
                        wattHour.getText().clear();
                        kiloWattHour.getText().clear();
                        electronVolt.getText().clear();
                        britishThermalUnit.getText().clear();
                        footPound.getText().clear();
                    }
                }
            }
        });

        footPound.addTextChangedListener(new TextWatcher() {
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
                if (footPound.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        joule.setText(String.valueOf((Double.parseDouble(s.toString()) * 1.35582)));
                        gramCalorie.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.324048));
                        kiloJoule.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00135582));
                        kiloCalorie.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000324048));
                        wattHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000376616));
                        kiloWattHour.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00000037662));
                        BigDecimal sBigInteger = new BigDecimal(s.toString());
                        BigDecimal multiplicant = new BigDecimal("8462000000000000000");
                        electronVolt.setText(String.valueOf(sBigInteger.multiply(multiplicant)));
                        britishThermalUnit.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00128507));
                        usTherm.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.000000012854));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        joule.getText().clear();
                        gramCalorie.getText().clear();
                        kiloJoule.getText().clear();
                        kiloCalorie.getText().clear();
                        wattHour.getText().clear();
                        kiloWattHour.getText().clear();
                        electronVolt.getText().clear();
                        britishThermalUnit.getText().clear();
                        usTherm.getText().clear();
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
