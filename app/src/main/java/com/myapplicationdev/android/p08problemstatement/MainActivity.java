package com.myapplicationdev.android.p08problemstatement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {


    Button btn1, btn2, btn3;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)
                fm.findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                LatLng singapore = new LatLng(1.461708, 103.813500);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(singapore,
                        15));
                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION);

                if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);
                } else {
                    Log.e("GMap - Permission", "GPS access has not been granted");
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
                }


            }
        });

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng north = new LatLng(1.461708, 103.813500);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(north,
                        15));
                if (map != null) {
                    north = new LatLng(1.461708, 103.813500);
                    Marker cp = map.addMarker(new
                            MarkerOptions()
                            .position(north)
                            .title("North - HQ")
                            .snippet("Block 333, Admiralty Ave 3, 765654 Operating hours: 10am-5pm\n" +
                                    "Tel:65433456\n")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.star)));
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng central = new LatLng(1.300542, 103.841226);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(central,
                        15));
                if (map != null) {
                    central = new LatLng(1.300542, 103.841226);
                    Marker cp = map.addMarker(new
                            MarkerOptions()
                            .position(central)
                            .title("Central")
                            .snippet("Block 3A, Orchard Ave 3, 134542 \n" +
                                    "Operating hours: 11am-8pm\n" +
                                    "Tel:67788652\n ")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng East = new LatLng(1.350057, 103.934452);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(East,
                        15));
                if (map != null) {
                    East = new LatLng(1.350057, 103.934452);
                    Marker cp = map.addMarker(new
                            MarkerOptions()
                            .position(East)
                            .title("East")
                            .snippet("Block 555, Tampines Ave 3, 287788 \n" +
                                    "Operating hours: 9am-5pm\n" +
                                    "Tel:66776677\"\n" )
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                }
            }
        });

    }
}
