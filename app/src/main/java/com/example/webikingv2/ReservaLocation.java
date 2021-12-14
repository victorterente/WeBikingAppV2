package com.example.webikingv2;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.webikingv2.databinding.ActivityReservaLocationBinding;

public class ReservaLocation extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityReservaLocationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityReservaLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        LatLng sintra = new LatLng(38.7826, -9.3562);
        LatLng cascais = new LatLng(38.72879783602574, -9.41716994994609);
        LatLng lisboa = new LatLng(38.732295699759135, -9.152057060190211);
       
        mMap.addMarker(new MarkerOptions().position(sintra).title("ponto de recolha em Sintra"));
        mMap.addMarker(new MarkerOptions().position(cascais).title("Ponto de recolha em Cascais"));
        mMap.addMarker(new MarkerOptions().position(lisboa).title("Ponto de recolha em Lisboa"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sintra, 15f));
    }
}