package com.example.asiftamal.calculatorconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnStandrdCal,BtnStandrdCal2,btnSciCalculator,btnUnitConverter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // btnStandrdCal= (Button) findViewById(R.id.btnCalculator);
        BtnStandrdCal2= (Button) findViewById(R.id.btnCalculator2);
        btnSciCalculator= (Button) findViewById(R.id.btnScientificCalculator);
        btnUnitConverter= (Button) findViewById(R.id.btnUnitConverter);

     //   SCalculatorClass calculator= new SCalculatorClass();
        SCalculatorClass2 calculator2= new SCalculatorClass2();
        ScientificCalculatorClass SciCalculator= new ScientificCalculatorClass();
        UnitConverterClass UnitCon= new UnitConverterClass();
       // btnStandrdCal.setOnClickListener(calculator);
        BtnStandrdCal2.setOnClickListener(calculator2);
        btnSciCalculator.setOnClickListener(SciCalculator);
        btnUnitConverter.setOnClickListener(UnitCon);

    }



    private class SCalculatorClass2 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intentStandardCalculator2=new Intent(MainActivity.this,StandardCalculator2.class);
            startActivity(intentStandardCalculator2);
        }
    }

    private class ScientificCalculatorClass implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent2=new Intent(MainActivity.this,ScientificCalculator.class);
            startActivity(intent2);
        }
    }

    private class UnitConverterClass implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intentUnitConverter=new Intent(MainActivity.this,UnitConverterMainActivity.class);
            startActivity(intentUnitConverter);
        }
    }
}
