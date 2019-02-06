package com.example.asiftamal.calculatorconverter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.asiftamal.calculatorconverter.UnitConverterFragmentsTabs.AreaFragment;
import com.example.asiftamal.calculatorconverter.UnitConverterFragmentsTabs.LengthFragment;
import com.example.asiftamal.calculatorconverter.UnitConverterFragmentsTabs.MassFragment;

import java.util.ArrayList;
import java.util.List;


public class PagerAdapter extends FragmentPagerAdapter {

    /*int mNoOFTabs;
    public  PagerAdapter(FragmentManager fm, int NumberOfTabs){
        super(fm);
        this.mNoOFTabs= NumberOfTabs;

    }
    @Override
    public Fragment getItem(int i) {
        switch (i){

            case 0:
                AreaFragment areaFragment= new AreaFragment();
                return areaFragment;
            case 1:
                LengthFragment lengthFragment= new LengthFragment();
                return lengthFragment;
            case 2:
                MassFragment massFragment=new MassFragment();
                return massFragment;
                default:
                    return null;
        }

    }

    @Override
    public int getCount() {
        return mNoOFTabs;
    }*/
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();


    public  PagerAdapter(FragmentManager fm){
        super(fm);


    }
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
