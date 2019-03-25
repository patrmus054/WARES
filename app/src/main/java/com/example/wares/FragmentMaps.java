package com.example.wares;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class FragmentMaps extends Fragment implements OnMapReadyCallback {

    SupportMapFragment mapFragment;
    Fragment manager;
    private GoogleMap mMap;
    MapView mapView;
    View mView;

    private final static String TAG = FragmentMaps.class.getSimpleName();

    public FragmentMaps(){
/*        FragmentMaps maps = new FragmentMaps();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frame_container, maps, "Mapy").commit();*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //manager = getFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
    try {
        mView = inflater.inflate(R.layout.activity_maps, container, false);
      /*  SupportMapFragment mapFragment = (SupportMapFragment)this.getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);*/

     /* mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
      if(mapFragment == null){
          FragmentManager fm = getFragmentManager();
          FragmentTransaction ft = fm.beginTransaction();
          mapFragment = SupportMapFragment.newInstance();
          ft.replace(R.id.map, mapFragment).commit();
      }
      mapFragment.getMapAsync(this);*/


        MapsInitializer.initialize(this.getActivity());
        mapView = (MapView) mView.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }catch (InflateException e){
        Log.e(TAG, "InflateException");
    }
        return mView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
/*
    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapView = (MapView) mView.findViewById(R.id.map);
        if(mapView != null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        *//*MapsInitializer.initialize(getContext());
        mMap = googleMap;

        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        LatLng sydney = new LatLng(-33.852, 151.211);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*//*
    }*/

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
