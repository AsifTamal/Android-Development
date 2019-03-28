package com.example.asiftamal.weatherforcastwithwidget;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.asiftamal.weatherforcastwithwidget.Adapter.ViewPagerAdapter;
import com.example.asiftamal.weatherforcastwithwidget.Common.common;
import com.example.asiftamal.weatherforcastwithwidget.Fragments.CityFragment;
import com.example.asiftamal.weatherforcastwithwidget.Fragments.TodatWeatherFragment;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

public class WeatherMainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ViewPagerAdapter adapter;

    private CoordinatorLayout coordinatorLayout;

    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationCallback locationCallback;
    private LocationRequest locationRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_main);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.root_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new MultiplePermissionsListener() {

                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        BuildLocationRequest();
                        BuildLocationCallBack();
                        if (ActivityCompat.checkSelfPermission(WeatherMainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(WeatherMainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        fusedLocationProviderClient=LocationServices.getFusedLocationProviderClient(WeatherMainActivity.this);
                        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        Snackbar.make(coordinatorLayout,"Permission Denied",Snackbar.LENGTH_LONG).show();
                    }
                }).check();
    }

    private void BuildLocationCallBack() {
        locationCallback=new LocationCallback(){
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                common.current_location=locationResult.getLastLocation();
                viewPager=(ViewPager)findViewById(R.id.viewpager);
                setViewPager(viewPager);
                tabLayout=(TabLayout)findViewById(R.id.tabs);
                tabLayout.setupWithViewPager(viewPager);

                Log.d("Location",locationResult.getLastLocation().getLatitude()+"/"+locationResult.getLastLocation().getLongitude());
            }
        };
    }

    private void setViewPager(ViewPager viewPager) {
         adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(TodatWeatherFragment.getInstance(),"Today");
        adapter.addFragment(CityFragment.getInstance(),"Search By City");
        viewPager.setAdapter(adapter);
    }

    private void BuildLocationRequest() {
        locationRequest=new LocationRequest();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setSmallestDisplacement(10.f);
    }
}
