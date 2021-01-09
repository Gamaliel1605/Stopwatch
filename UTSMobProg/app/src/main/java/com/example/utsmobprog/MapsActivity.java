package com.example.utsmobprog;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<LatLng> arrayList = new ArrayList<LatLng>();
    LatLng EzyFoodyBintaro = new LatLng(-6.2854, 106.728);
    LatLng EzyFoodyBsd = new LatLng(-6.3243, 106.6838);
    LatLng EzyFoodyCiledug = new LatLng(-6.2204, 106.6984);
    LatLng EzyFoodyCipondoh = new LatLng(-6.1795, 106.6896);
    LatLng EzyFoodyCipete = new LatLng(-6.2768, 106.8129);
    LatLng EzyFoodyTanahAbang = new LatLng(-6.1754, 106.8142);

    private String[] name = {"EzyFoody Bintaro", "EzyFoody Bsd", "EzyFoody Ciledug",
            "EzyFoody Cipondoh", "EzyFoody Cipete", "EzyFoody Tanah Abang"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        arrayList.add(EzyFoodyBintaro);
        arrayList.add(EzyFoodyBsd);
        arrayList.add(EzyFoodyCiledug);
        arrayList.add(EzyFoodyCipondoh);
        arrayList.add(EzyFoodyCipete);
        arrayList.add(EzyFoodyTanahAbang);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        for (int i = 0;i<arrayList.size();i++){
            mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title(name[i]));
            CameraPosition cameraPosition = new CameraPosition.Builder().target(arrayList.get(i)).zoom(17).build();
            mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
        }
    }
}