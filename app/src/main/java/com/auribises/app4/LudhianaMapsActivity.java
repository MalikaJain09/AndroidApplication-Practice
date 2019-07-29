package com.auribises.app4;

import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.List;

public class LudhianaMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LocationCallback locationCallback;
    FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ludhiana_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        //this is a request to google server to fetch google maps images in the background
        mapFragment.getMapAsync(this);

        //Create Location Request
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(10000);          //After every 10 secs
        locationRequest.setFastestInterval(5000);   // Fastest Interval
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
         // Location CALLbACK --> HANDLES fETCHED lOCTION FROM GOOGLE api
        locationCallback = new LocationCallback(){
            public  void  onLocationResult(LocationResult locationResult){
                Location location = locationResult.getLocations().get(0);
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                float speed=location.getSpeed();
                try{
                    Geocoder geocoder = new Geocoder(LudhianaMapsActivity.this);
                    List<Address> addresses = geocoder.getFromLocation(latitude,longitude,1);
                    Address address = addresses.get(0);
                    String adrsLine= address.getAddressLine(address.getMaxAddressLineIndex());

                   Toast.makeText(LudhianaMapsActivity.this,adrsLine+"\n"+latitude+","+longitude+"speed is "+speed,Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        };
         client= LocationServices.getFusedLocationProviderClient(this);
        client.requestLocationUpdates(locationRequest, locationCallback, null);

    }


   //onMapReady will be executed when we have got a response from google server
    @Override
    public void onMapReady(GoogleMap googleMap) {   // reference variable googleMap holds hashcode
        mMap = googleMap;

        FusedLocationProviderClient client = LocationServices.getFusedLocationProviderClient(this);

        client.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null){
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    //GEOCODING Obtaing Latitude and Longitude
                    LatLng myLocation= new LatLng(latitude,longitude);

                    // Reverse GeoCoding : obtain Address from long and lat

                    try{
                        Geocoder geocoder = new Geocoder(LudhianaMapsActivity.this);
                        List<Address> addresses = geocoder.getFromLocation(latitude,longitude,1);
                        Address address = addresses.get(0);
                        String adrsLine= address.getAddressLine(address.getMaxAddressLineIndex());

                        mMap.addMarker(new MarkerOptions().position(myLocation).title(adrsLine).snippet("location"+latitude+","+longitude));

                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myLocation,16));

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }else {
                    Toast.makeText(LudhianaMapsActivity.this, "Location Not Available", Toast.LENGTH_SHORT).show();
                }

            }
        });
        // LatLang --> latitude and longitude
        // Add a marker in Sydney and move the camera
//        LatLng ludhiana = new LatLng(30.9003263,75.7866328);
//        LatLng auribises = new LatLng(30.9024779,75.8201934);
//
//        mMap.addMarker(new MarkerOptions().position(ludhiana).title("Marker in Ludhiana").snippet("This is Snippet"));
//        mMap.addMarker(new MarkerOptions().position(auribises).title("Auribises Technologies").snippet("www.auribises.com"));
////        mMap.moveCamera(CameraUpdateFactory.newLatLng(ludhiana));
//
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ludhiana,12));
//
//        mMap.getUiSettings().setZoomControlsEnabled(true);
//        mMap.getUiSettings().setCompassEnabled(true);
//
//        mMap.setTrafficEnabled(true);
//        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
//
//        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
//            @Override
//            public boolean onMarkerClick(Marker marker) {
//                Toast.makeText(LudhianaMapsActivity.this, "You Selected Marker", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
    }
    protected  void onDestroy(){
        super.onDestroy();

        client.removeLocationUpdates(locationCallback);

    }

}
