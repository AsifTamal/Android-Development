package com.example.asiftamal.calculatorconverter;

import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;

import com.example.asiftamal.calculatorconverter.UnitConverterFragmentsTabs.AreaFragment;
import com.example.asiftamal.calculatorconverter.UnitConverterFragmentsTabs.EnergyFragment;
import com.example.asiftamal.calculatorconverter.UnitConverterFragmentsTabs.FrequencyFragment;
import com.example.asiftamal.calculatorconverter.UnitConverterFragmentsTabs.LengthFragment;
import com.example.asiftamal.calculatorconverter.UnitConverterFragmentsTabs.MassFragment;
import com.example.asiftamal.calculatorconverter.UnitConverterFragmentsTabs.PressureFragment;
import com.example.asiftamal.calculatorconverter.UnitConverterFragmentsTabs.SpeedFragment;
import com.example.asiftamal.calculatorconverter.UnitConverterFragmentsTabs.TemperatureFragment;
import com.example.asiftamal.calculatorconverter.UnitConverterFragmentsTabs.TimeFragment;
import com.example.asiftamal.calculatorconverter.UnitConverterFragmentsTabs.VolumeFragment;

public class UnitConverterMainActivity extends AppCompatActivity  {

    private ListView listView;
    private TabLayout tabLayout;
    private  ViewPager Viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter_main);
        setTitle("Unit Converter");
        tabLayout= (TabLayout) findViewById(R.id.tablayoutid);
        Viewpager= (ViewPager) findViewById(R.id.Pagerid);
        PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AreaFragment(),"Area ");
        adapter.addFragment(new LengthFragment(),"Length ");
        adapter.addFragment(new MassFragment(),"Mass ");
        adapter.addFragment(new PressureFragment(),"Pressure");
        adapter.addFragment(new SpeedFragment(),"Speed");
        adapter.addFragment(new TimeFragment(),"Time ");
        adapter.addFragment(new VolumeFragment(),"Volume ");
        adapter.addFragment(new TemperatureFragment(),"Temperature ");
        adapter.addFragment(new EnergyFragment(),"Energy");
        adapter.addFragment(new FrequencyFragment(),"Frequency");
        Viewpager.setAdapter(adapter);
       tabLayout.setupWithViewPager(Viewpager);



//        TableLayout tableLayout= (TableLayout) findViewById(R.id.tablayoutid);
//        tableLayout
//
//       final ViewPager viewPager= (ViewPager) findViewById(R.id.Pager);
//       final PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager(),ta)

       /* listView= findViewById(R.id.scrollableTablistviewID);
        String[] UnitConverterTabs= {"Area","Length","Area","Length","Area","Length","Area","Length","Area","Length"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,UnitConverterTabs);
        listView.setAdapter(adapter);
        UnitConverterFragmentTabClass UnitCon= new UnitConverterFragmentTabClass();
        listView.setOnItemClickListener(UnitCon);*/
    }

  /*  private class UnitConverterFragmentTabClass implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            android.support.v4.app.Fragment fragment;
            if(position==0){
                fragment=new AreaFragment();
                android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentID,fragment);
                fragmentTransaction.commit();
            }
            else if(position==1){
                fragment=new LengthFragment();
                android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentID,fragment);
                fragmentTransaction.commit();
            }
        }
    }*/
}
