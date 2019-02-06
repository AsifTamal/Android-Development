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


public class VolumeFragment extends Fragment {


    public VolumeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_volume, container, false);
        final EditText usLiquidGallon = view.findViewById(R.id.input_us_liquid_gallon);
        final EditText usLiquidQuart = view.findViewById(R.id.input_us_liquid_quart);
        final EditText usLiquidPint = view.findViewById(R.id.input_us_liquid_pint);
        final EditText usLegalCup = view.findViewById(R.id.input_us_legal_cup);
        final EditText usFluidOunce = view.findViewById(R.id.input_us_fluid_ounce);
        final EditText usTablespoon = view.findViewById(R.id.input_us_tablespoon);
        final EditText usTeaspoon = view.findViewById(R.id.input_us_teaspoon);
        final EditText litre = view.findViewById(R.id.input_litre);
        final EditText millilitre = view.findViewById(R.id.input_millilitre);
        final EditText imperialGallon = view.findViewById(R.id.input_imperial_gallon);
        final EditText imperialQuart = view.findViewById(R.id.input_imperial_quart);
        final EditText imperialPint = view.findViewById(R.id.input_imperial_pint);
        final EditText imperialFluidOunce = view.findViewById(R.id.input_imperial_fluid_ounce);
        final EditText imperialTablespoon = view.findViewById(R.id.input_imperial_tablespoon);
        final EditText imperialTeaspoon = view.findViewById(R.id.input_imperial_teaspoon);
        usLiquidGallon.addTextChangedListener(new TextWatcher() {
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
                if (usLiquidGallon.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        usLiquidQuart.setText(String.valueOf((Double.parseDouble(s.toString()) * 4)));
                        usLiquidPint.setText(String.valueOf(Double.parseDouble(s.toString()) * 8));
                        usLegalCup.setText(String.valueOf(Double.parseDouble(s.toString()) * 16));
                        usFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) * 128));
                        usTablespoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 256));
                        usTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 768));
                        litre.setText(String.valueOf((Double.parseDouble(s.toString()) * 3.785411784)));
                        millilitre.setText(String.valueOf(Double.parseDouble(s.toString()) * 3785.411784));
                        imperialGallon.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.83267384046639071232));
                        imperialQuart.setText(String.valueOf(Double.parseDouble(s.toString()) * 3.3306953618655629312));
                        imperialPint.setText(String.valueOf(Double.parseDouble(s.toString()) * 6.6613907237311258624));
                        imperialFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) * 133.22781447462252544));
                        imperialTablespoon.setText(String.valueOf((Double.parseDouble(s.toString()) * 213.16450315939602432)));
                        imperialTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 639.49350947818807296));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        usLiquidQuart.getText().clear();
                        usLiquidPint.getText().clear();
                        usLegalCup.getText().clear();
                        usFluidOunce.getText().clear();
                        usTablespoon.getText().clear();
                        usTeaspoon.getText().clear();
                        litre.getText().clear();
                        millilitre.getText().clear();
                        imperialGallon.getText().clear();
                        imperialQuart.getText().clear();
                        imperialPint.getText().clear();
                        imperialFluidOunce.getText().clear();
                        imperialTablespoon.getText().clear();
                        imperialTeaspoon.getText().clear();
                    }
                }
            }
        });

        usLiquidQuart.addTextChangedListener(new TextWatcher() {
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
                if (usLiquidQuart.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        usLiquidGallon.setText(String.valueOf((Double.parseDouble(s.toString()) / 4)));
                        usLiquidPint.setText(String.valueOf(Double.parseDouble(s.toString()) * 2));
                        usLegalCup.setText(String.valueOf(Double.parseDouble(s.toString()) * 4));
                        usFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) * 32));
                        usTablespoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 64));
                        usTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 192));
                        litre.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.94635294599999995904)));
                        millilitre.setText(String.valueOf(Double.parseDouble(s.toString()) * 946.35294599999995904));
                        imperialGallon.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.20816846011659767808));
                        imperialQuart.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.83267384046639071232));
                        imperialPint.setText(String.valueOf(Double.parseDouble(s.toString()) * 1.6653476809327814656));
                        imperialFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) * 33.306953618655629312));
                        imperialTablespoon.setText(String.valueOf((Double.parseDouble(s.toString()) * 53.291125789849001984)));
                        imperialTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 159.87337736954701824));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        usLiquidGallon.getText().clear();
                        usLiquidPint.getText().clear();
                        usLegalCup.getText().clear();
                        usFluidOunce.getText().clear();
                        usTablespoon.getText().clear();
                        usTeaspoon.getText().clear();
                        litre.getText().clear();
                        millilitre.getText().clear();
                        imperialGallon.getText().clear();
                        imperialQuart.getText().clear();
                        imperialPint.getText().clear();
                        imperialFluidOunce.getText().clear();
                        imperialTablespoon.getText().clear();
                        imperialTeaspoon.getText().clear();
                    }
                }
            }
        });

        usLiquidPint.addTextChangedListener(new TextWatcher() {
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
                if (usLiquidPint.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        usLiquidGallon.setText(String.valueOf((Double.parseDouble(s.toString()) / 8)));
                        usLiquidQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 2));
                        usLegalCup.setText(String.valueOf(Double.parseDouble(s.toString()) * 2));
                        usFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) * 16));
                        usTablespoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 32));
                        usTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 96));
                        litre.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.47317647299999997952)));
                        millilitre.setText(String.valueOf(Double.parseDouble(s.toString()) * 473.17647299999997952));
                        imperialGallon.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.10408423005829883904));
                        imperialQuart.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.41633692023319535616));
                        imperialPint.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.83267384046639071232));
                        imperialFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) * 16.653476809327814656));
                        imperialTablespoon.setText(String.valueOf((Double.parseDouble(s.toString()) * 26.645562894924500992)));
                        imperialTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 79.936688684773507072));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        usLiquidGallon.getText().clear();
                        usLiquidQuart.getText().clear();
                        usLegalCup.getText().clear();
                        usFluidOunce.getText().clear();
                        usTablespoon.getText().clear();
                        usTeaspoon.getText().clear();
                        litre.getText().clear();
                        millilitre.getText().clear();
                        imperialGallon.getText().clear();
                        imperialQuart.getText().clear();
                        imperialPint.getText().clear();
                        imperialFluidOunce.getText().clear();
                        imperialTablespoon.getText().clear();
                        imperialTeaspoon.getText().clear();
                    }
                }
            }
        });

        usLegalCup.addTextChangedListener(new TextWatcher() {
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
                if (usLegalCup.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        usLiquidGallon.setText(String.valueOf((Double.parseDouble(s.toString()) / 16)));
                        usLiquidQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 4));
                        usLiquidPint.setText(String.valueOf(Double.parseDouble(s.toString()) / 2));
                        usFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) * 8));
                        usTablespoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 16));
                        usTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 48));
                        litre.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.23658823649999998976)));
                        millilitre.setText(String.valueOf(Double.parseDouble(s.toString()) * 236.58823649999998976));
                        imperialGallon.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.052042115029149417472));
                        imperialQuart.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.20816846011659767808));
                        imperialPint.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.41633692023319535616));
                        imperialFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) * 8.3267384046639071232));
                        imperialTablespoon.setText(String.valueOf((Double.parseDouble(s.toString()) * 13.322781447462250496)));
                        imperialTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 39.968344342386753536));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        usLiquidGallon.getText().clear();
                        usLiquidQuart.getText().clear();
                        usLiquidPint.getText().clear();
                        usFluidOunce.getText().clear();
                        usTablespoon.getText().clear();
                        usTeaspoon.getText().clear();
                        litre.getText().clear();
                        millilitre.getText().clear();
                        imperialGallon.getText().clear();
                        imperialQuart.getText().clear();
                        imperialPint.getText().clear();
                        imperialFluidOunce.getText().clear();
                        imperialTablespoon.getText().clear();
                        imperialTeaspoon.getText().clear();
                    }
                }
            }
        });

        usFluidOunce.addTextChangedListener(new TextWatcher() {
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
                if (usFluidOunce.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        usLiquidGallon.setText(String.valueOf((Double.parseDouble(s.toString()) / 128)));
                        usLiquidQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 32));
                        usLiquidPint.setText(String.valueOf(Double.parseDouble(s.toString()) / 16));
                        usLegalCup.setText(String.valueOf(Double.parseDouble(s.toString()) / 8));
                        usTablespoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 2));
                        usTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 6));
                        litre.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.029573529562499997696)));
                        millilitre.setText(String.valueOf(Double.parseDouble(s.toString()) * 29.573529562499997696));
                        imperialGallon.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.006505264378643677184));
                        imperialQuart.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.026021057514574708736));
                        imperialPint.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.052042115029149417472));
                        imperialFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) * 1.0408423005829883904));
                        imperialTablespoon.setText(String.valueOf((Double.parseDouble(s.toString()) * 1.6653476809327814656)));
                        imperialTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 4.9960430427983437824));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        usLiquidGallon.getText().clear();
                        usLiquidQuart.getText().clear();
                        usLiquidPint.getText().clear();
                        usLegalCup.getText().clear();
                        usTablespoon.getText().clear();
                        usTeaspoon.getText().clear();
                        litre.getText().clear();
                        millilitre.getText().clear();
                        imperialGallon.getText().clear();
                        imperialQuart.getText().clear();
                        imperialPint.getText().clear();
                        imperialFluidOunce.getText().clear();
                        imperialTablespoon.getText().clear();
                        imperialTeaspoon.getText().clear();
                    }
                }
            }
        });

        usTablespoon.addTextChangedListener(new TextWatcher() {
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
                if (usTablespoon.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        usLiquidGallon.setText(String.valueOf((Double.parseDouble(s.toString()) / 256)));
                        usLiquidQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 64));
                        usLiquidPint.setText(String.valueOf(Double.parseDouble(s.toString()) / 32));
                        usLegalCup.setText(String.valueOf(Double.parseDouble(s.toString()) / 16));
                        usFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) / 2));
                        usTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 3));
                        litre.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.014786764781249998848)));
                        millilitre.setText(String.valueOf(Double.parseDouble(s.toString()) * 14.786764781249998848));
                        imperialGallon.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.003252632189321838592));
                        imperialQuart.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.013010528757287354368));
                        imperialPint.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.026021057514574708736));
                        imperialFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.52042115029149417472));
                        imperialTablespoon.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.83267384046639071232)));
                        imperialTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 2.4980215213991718912));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        usLiquidGallon.getText().clear();
                        usLiquidQuart.getText().clear();
                        usLiquidPint.getText().clear();
                        usLegalCup.getText().clear();
                        usFluidOunce.getText().clear();
                        usTeaspoon.getText().clear();
                        litre.getText().clear();
                        millilitre.getText().clear();
                        imperialGallon.getText().clear();
                        imperialQuart.getText().clear();
                        imperialPint.getText().clear();
                        imperialFluidOunce.getText().clear();
                        imperialTablespoon.getText().clear();
                        imperialTeaspoon.getText().clear();
                    }
                }
            }
        });

        usTeaspoon.addTextChangedListener(new TextWatcher() {
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
                if (usTeaspoon.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        usLiquidGallon.setText(String.valueOf((Double.parseDouble(s.toString()) / 768)));
                        usLiquidQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 192));
                        usLiquidPint.setText(String.valueOf(Double.parseDouble(s.toString()) / 96));
                        usLegalCup.setText(String.valueOf(Double.parseDouble(s.toString()) / 48));
                        usFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) / 6));
                        usTablespoon.setText(String.valueOf(Double.parseDouble(s.toString()) / 3));
                        litre.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.004928921593749999616)));
                        millilitre.setText(String.valueOf(Double.parseDouble(s.toString()) * 4.928921593749999616));
                        imperialGallon.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.00108421072977394606));
                        imperialQuart.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.004336842919095784243));
                        imperialPint.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.008673685838191568486));
                        imperialFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.1734737167638313984));
                        imperialTablespoon.setText(String.valueOf((Double.parseDouble(s.toString()) * 0.27755794682213023744)));
                        imperialTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.83267384046639071232));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        usLiquidGallon.getText().clear();
                        usLiquidQuart.getText().clear();
                        usLiquidPint.getText().clear();
                        usLegalCup.getText().clear();
                        usFluidOunce.getText().clear();
                        usTablespoon.getText().clear();
                        litre.getText().clear();
                        millilitre.getText().clear();
                        imperialGallon.getText().clear();
                        imperialQuart.getText().clear();
                        imperialPint.getText().clear();
                        imperialFluidOunce.getText().clear();
                        imperialTablespoon.getText().clear();
                        imperialTeaspoon.getText().clear();
                    }
                }
            }
        });

        litre.addTextChangedListener(new TextWatcher() {
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
                if (litre.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        usLiquidGallon.setText(String.valueOf((Double.parseDouble(s.toString()) / 3.785411784)));
                        usLiquidQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.94635294599999995904));
                        usLiquidPint.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.47317647299999997952));
                        usLegalCup.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.23658823649999998976));
                        usFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.029573529562499997696));
                        usTablespoon.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.014786764781249998848));
                        usTeaspoon.setText(String.valueOf((Double.parseDouble(s.toString()) / 0.004928921593749999616)));
                        millilitre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1000));
                        imperialGallon.setText(String.valueOf(Double.parseDouble(s.toString()) / 4.546091879));
                        imperialQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 1.13652296975));
                        imperialPint.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.56826148487499988992));
                        imperialFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.028413074243749994496));
                        imperialTablespoon.setText(String.valueOf((Double.parseDouble(s.toString()) / 0.017758171402343747584)));
                        imperialTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.005919390467447916134));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        usLiquidGallon.getText().clear();
                        usLiquidQuart.getText().clear();
                        usLiquidPint.getText().clear();
                        usLegalCup.getText().clear();
                        usFluidOunce.getText().clear();
                        usTablespoon.getText().clear();
                        usTeaspoon.getText().clear();
                        millilitre.getText().clear();
                        imperialGallon.getText().clear();
                        imperialQuart.getText().clear();
                        imperialPint.getText().clear();
                        imperialFluidOunce.getText().clear();
                        imperialTablespoon.getText().clear();
                        imperialTeaspoon.getText().clear();
                    }
                }
            }
        });

        millilitre.addTextChangedListener(new TextWatcher() {
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
                if (millilitre.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        usLiquidGallon.setText(String.valueOf((Double.parseDouble(s.toString()) / 3785.411784)));
                        usLiquidQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 946.35294599999995904));
                        usLiquidPint.setText(String.valueOf(Double.parseDouble(s.toString()) / 473.17647299999997952));
                        usLegalCup.setText(String.valueOf(Double.parseDouble(s.toString()) / 236.58823649999998976));
                        usFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) / 29.573529562499997696));
                        usTablespoon.setText(String.valueOf(Double.parseDouble(s.toString()) / 14.786764781249998848));
                        usTeaspoon.setText(String.valueOf((Double.parseDouble(s.toString()) / 4.928921593749999616)));
                        litre.setText(String.valueOf(Double.parseDouble(s.toString()) / 1000));
                        imperialGallon.setText(String.valueOf(Double.parseDouble(s.toString()) / 4546.091879));
                        imperialQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 1136.52296975));
                        imperialPint.setText(String.valueOf(Double.parseDouble(s.toString()) / 568.26148487499988992));
                        imperialFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) / 28.413074243749994496));
                        imperialTablespoon.setText(String.valueOf((Double.parseDouble(s.toString()) / 17.758171402343747584)));
                        imperialTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) / 5.9193904674479161344));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        usLiquidGallon.getText().clear();
                        usLiquidQuart.getText().clear();
                        usLiquidPint.getText().clear();
                        usLegalCup.getText().clear();
                        usFluidOunce.getText().clear();
                        usTablespoon.getText().clear();
                        usTeaspoon.getText().clear();
                        litre.getText().clear();
                        imperialGallon.getText().clear();
                        imperialQuart.getText().clear();
                        imperialPint.getText().clear();
                        imperialFluidOunce.getText().clear();
                        imperialTablespoon.getText().clear();
                        imperialTeaspoon.getText().clear();
                    }
                }
            }
        });

        imperialGallon.addTextChangedListener(new TextWatcher() {
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
                if (imperialGallon.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        usLiquidGallon.setText(String.valueOf((Double.parseDouble(s.toString()) / 0.83267384046639071232)));
                        usLiquidQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.20816846011659767808));
                        usLiquidPint.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.10408423005829883904));
                        usLegalCup.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.052042115029149417472));
                        usFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.006505264378643677184));
                        usTablespoon.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.003252632189321838592));
                        usTeaspoon.setText(String.valueOf((Double.parseDouble(s.toString()) / 0.00108421072977394606)));
                        litre.setText(String.valueOf(Double.parseDouble(s.toString()) * 4.546091879));
                        millilitre.setText(String.valueOf(Double.parseDouble(s.toString()) * 4546.091879));
                        imperialQuart.setText(String.valueOf(Double.parseDouble(s.toString()) * 4));
                        imperialPint.setText(String.valueOf(Double.parseDouble(s.toString()) * 8));
                        imperialFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) * 160));
                        imperialTablespoon.setText(String.valueOf((Double.parseDouble(s.toString()) * 256)));
                        imperialTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 768));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        usLiquidGallon.getText().clear();
                        usLiquidQuart.getText().clear();
                        usLiquidPint.getText().clear();
                        usLegalCup.getText().clear();
                        usFluidOunce.getText().clear();
                        usTablespoon.getText().clear();
                        usTeaspoon.getText().clear();
                        litre.getText().clear();
                        millilitre.getText().clear();
                        imperialQuart.getText().clear();
                        imperialPint.getText().clear();
                        imperialFluidOunce.getText().clear();
                        imperialTablespoon.getText().clear();
                        imperialTeaspoon.getText().clear();
                    }
                }
            }
        });

        imperialQuart.addTextChangedListener(new TextWatcher() {
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
                if (imperialQuart.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        usLiquidGallon.setText(String.valueOf((Double.parseDouble(s.toString()) / 3.3306953618655629312)));
                        usLiquidQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.83267384046639071232));
                        usLiquidPint.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.41633692023319535616));
                        usLegalCup.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.20816846011659767808));
                        usFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.026021057514574708736));
                        usTablespoon.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.013010528757287354368));
                        usTeaspoon.setText(String.valueOf((Double.parseDouble(s.toString()) / 0.004336842919095784243)));
                        litre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1.13652296975));
                        millilitre.setText(String.valueOf(Double.parseDouble(s.toString()) * 1136.52296975));
                        imperialGallon.setText(String.valueOf(Double.parseDouble(s.toString()) / 4));
                        imperialPint.setText(String.valueOf(Double.parseDouble(s.toString()) * 2));
                        imperialFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) * 40));
                        imperialTablespoon.setText(String.valueOf((Double.parseDouble(s.toString()) * 64)));
                        imperialTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 192));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        usLiquidGallon.getText().clear();
                        usLiquidQuart.getText().clear();
                        usLiquidPint.getText().clear();
                        usLegalCup.getText().clear();
                        usFluidOunce.getText().clear();
                        usTablespoon.getText().clear();
                        usTeaspoon.getText().clear();
                        litre.getText().clear();
                        millilitre.getText().clear();
                        imperialGallon.getText().clear();
                        imperialPint.getText().clear();
                        imperialFluidOunce.getText().clear();
                        imperialTablespoon.getText().clear();
                        imperialTeaspoon.getText().clear();
                    }
                }
            }
        });

        imperialPint.addTextChangedListener(new TextWatcher() {
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
                if (imperialPint.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        usLiquidGallon.setText(String.valueOf((Double.parseDouble(s.toString()) / 6.6613907237311258624)));
                        usLiquidQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 1.6653476809327814656));
                        usLiquidPint.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.83267384046639071232));
                        usLegalCup.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.41633692023319535616));
                        usFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.052042115029149417472));
                        usTablespoon.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.026021057514574708736));
                        usTeaspoon.setText(String.valueOf((Double.parseDouble(s.toString()) / 0.008673685838191568486)));
                        litre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.56826148487499988992));
                        millilitre.setText(String.valueOf(Double.parseDouble(s.toString()) * 568.26148487499988992));
                        imperialGallon.setText(String.valueOf(Double.parseDouble(s.toString()) / 8));
                        imperialQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 2));
                        imperialFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) * 20));
                        imperialTablespoon.setText(String.valueOf((Double.parseDouble(s.toString()) * 32)));
                        imperialTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 96));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        usLiquidGallon.getText().clear();
                        usLiquidQuart.getText().clear();
                        usLiquidPint.getText().clear();
                        usLegalCup.getText().clear();
                        usFluidOunce.getText().clear();
                        usTablespoon.getText().clear();
                        usTeaspoon.getText().clear();
                        litre.getText().clear();
                        millilitre.getText().clear();
                        imperialGallon.getText().clear();
                        imperialQuart.getText().clear();
                        imperialFluidOunce.getText().clear();
                        imperialTablespoon.getText().clear();
                        imperialTeaspoon.getText().clear();
                    }
                }
            }
        });

        imperialFluidOunce.addTextChangedListener(new TextWatcher() {
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
                if (imperialFluidOunce.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        usLiquidGallon.setText(String.valueOf((Double.parseDouble(s.toString()) / 133.22781447462252544)));
                        usLiquidQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 33.306953618655629312));
                        usLiquidPint.setText(String.valueOf(Double.parseDouble(s.toString()) / 16.653476809327814656));
                        usLegalCup.setText(String.valueOf(Double.parseDouble(s.toString()) / 8.3267384046639071232));
                        usFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) / 1.0408423005829883904));
                        usTablespoon.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.52042115029149417472));
                        usTeaspoon.setText(String.valueOf((Double.parseDouble(s.toString()) / 0.1734737167638313984)));
                        litre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.028413074243749994496));
                        millilitre.setText(String.valueOf(Double.parseDouble(s.toString()) * 28.413074243749994496));
                        imperialGallon.setText(String.valueOf(Double.parseDouble(s.toString()) / 160));
                        imperialQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 40));
                        imperialPint.setText(String.valueOf(Double.parseDouble(s.toString()) / 20));
                        imperialTablespoon.setText(String.valueOf((Double.parseDouble(s.toString()) * 1.6)));
                        imperialTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 4.8));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        usLiquidGallon.getText().clear();
                        usLiquidQuart.getText().clear();
                        usLiquidPint.getText().clear();
                        usLegalCup.getText().clear();
                        usFluidOunce.getText().clear();
                        usTablespoon.getText().clear();
                        usTeaspoon.getText().clear();
                        litre.getText().clear();
                        millilitre.getText().clear();
                        imperialGallon.getText().clear();
                        imperialQuart.getText().clear();
                        imperialPint.getText().clear();
                        imperialTablespoon.getText().clear();
                        imperialTeaspoon.getText().clear();
                    }
                }
            }
        });

        imperialTablespoon.addTextChangedListener(new TextWatcher() {
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
                if (imperialTablespoon.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        usLiquidGallon.setText(String.valueOf((Double.parseDouble(s.toString()) / 213.16450315939602432)));
                        usLiquidQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 53.291125789849001984));
                        usLiquidPint.setText(String.valueOf(Double.parseDouble(s.toString()) / 26.645562894924500992));
                        usLegalCup.setText(String.valueOf(Double.parseDouble(s.toString()) / 13.322781447462250496));
                        usFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) / 1.6653476809327814656));
                        usTablespoon.setText(String.valueOf(Double.parseDouble(s.toString()) / 0.83267384046639071232));
                        usTeaspoon.setText(String.valueOf((Double.parseDouble(s.toString()) / 0.27755794682213023744)));
                        litre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.017758171402343747584));
                        millilitre.setText(String.valueOf(Double.parseDouble(s.toString()) * 17.758171402343747584));
                        imperialGallon.setText(String.valueOf(Double.parseDouble(s.toString()) / 256));
                        imperialQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 64));
                        imperialPint.setText(String.valueOf(Double.parseDouble(s.toString()) / 32));
                        imperialFluidOunce.setText(String.valueOf((Double.parseDouble(s.toString()) / 1.6)));
                        imperialTeaspoon.setText(String.valueOf(Double.parseDouble(s.toString()) * 3));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        usLiquidGallon.getText().clear();
                        usLiquidQuart.getText().clear();
                        usLiquidPint.getText().clear();
                        usLegalCup.getText().clear();
                        usFluidOunce.getText().clear();
                        usTablespoon.getText().clear();
                        usTeaspoon.getText().clear();
                        litre.getText().clear();
                        millilitre.getText().clear();
                        imperialGallon.getText().clear();
                        imperialQuart.getText().clear();
                        imperialPint.getText().clear();
                        imperialFluidOunce.getText().clear();
                        imperialTeaspoon.getText().clear();
                    }
                }
            }
        });

        imperialTeaspoon.addTextChangedListener(new TextWatcher() {
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
                if (imperialTeaspoon.isFocused()) {
                    if (!s.toString().trim().isEmpty() && charCount > -1 && s.toString().trim().charAt(s.length() - 1) != '.' && tryParseDouble(s.toString().trim())) {
                        usLiquidGallon.setText(String.valueOf((Double.parseDouble(s.toString()) / 639.49350947818807296)));
                        usLiquidQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 159.87337736954701824));
                        usLiquidPint.setText(String.valueOf(Double.parseDouble(s.toString()) / 79.936688684773507072));
                        usLegalCup.setText(String.valueOf(Double.parseDouble(s.toString()) / 39.968344342386753536));
                        usFluidOunce.setText(String.valueOf(Double.parseDouble(s.toString()) / 4.9960430427983437824));
                        usTablespoon.setText(String.valueOf(Double.parseDouble(s.toString()) / 2.4980215213991718912));
                        usTeaspoon.setText(String.valueOf((Double.parseDouble(s.toString()) / 0.83267384046639071232)));
                        litre.setText(String.valueOf(Double.parseDouble(s.toString()) * 0.005919390467447916134));
                        millilitre.setText(String.valueOf(Double.parseDouble(s.toString()) * 5.9193904674479161344));
                        imperialGallon.setText(String.valueOf(Double.parseDouble(s.toString()) / 768));
                        imperialQuart.setText(String.valueOf(Double.parseDouble(s.toString()) / 192));
                        imperialPint.setText(String.valueOf(Double.parseDouble(s.toString()) / 96));
                        imperialFluidOunce.setText(String.valueOf((Double.parseDouble(s.toString()) / 4.8)));
                        imperialTablespoon.setText(String.valueOf(Double.parseDouble(s.toString()) / 3));
                    } else if (s.toString().trim().isEmpty() || s.toString().trim().charAt(s.length() - 1) != '.') {
                        usLiquidGallon.getText().clear();
                        usLiquidQuart.getText().clear();
                        usLiquidPint.getText().clear();
                        usLegalCup.getText().clear();
                        usFluidOunce.getText().clear();
                        usTablespoon.getText().clear();
                        usTeaspoon.getText().clear();
                        litre.getText().clear();
                        millilitre.getText().clear();
                        imperialGallon.getText().clear();
                        imperialQuart.getText().clear();
                        imperialPint.getText().clear();
                        imperialFluidOunce.getText().clear();
                        imperialTablespoon.getText().clear();
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
