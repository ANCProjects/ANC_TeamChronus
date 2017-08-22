package team.chronus.amona.presentation.detail;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;

import team.chronus.amona.R;
import team.chronus.amona.data.model.distance.EndLocation;
import team.chronus.amona.data.model.distance.Leg;
import team.chronus.amona.data.model.distance.MeetUpDistance;
import team.chronus.amona.data.model.distance.Route;
import team.chronus.amona.data.model.distance.StartLocation;
import team.chronus.amona.data.model.distance.Steps;

/**
 * Created by ibrahimabdulkadir on 14/07/2017.
 */

public class DetailFragment extends SupportMapFragment{
    private static final String longitude = "Venue Long";
    private static final String latitude = "Venue Lat";
    private static final String locationProvider = "Provider";
    private Location eventLocation;
    private GoogleMap map;
    private FusedLocationProviderClient client;
    private static final int permissionCode = 1121;
    private static final String TAG = "DetailFragment";
    private PolylineOptions options;
    private List<Steps> stepList;

    public static DetailFragment newInstance(double lat, double lon){
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putDouble(longitude, lon);
        args.putDouble(latitude, lat);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);

        setMeetUpLocation();
        getMapAsync(googleMap -> map = googleMap);

        client = LocationServices.getFusedLocationProviderClient(getActivity());

        getCurrentLocation();
    }

    public void animateCamera(Location currentLocation){
        LatLng currentLatLng = new LatLng(currentLocation.getLatitude(),
                currentLocation.getLongitude());
        LatLng eventLatLng = new LatLng(eventLocation.getLatitude(),
                eventLocation.getLongitude());

        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(currentLatLng)
                .include(eventLatLng)
                .build();

        int dimen = getResources().getDimensionPixelOffset(R.dimen.map_inset);
        CameraUpdate update = CameraUpdateFactory.newLatLngBounds(bounds, dimen);

        map.animateCamera(update);
    }
    public void setMeetUpLocation(){
        Bundle args = getArguments();
        double lat = args.getDouble(latitude);
        double lon = args.getDouble(longitude);

        eventLocation = new Location(locationProvider);

        eventLocation.setLongitude(lon);
        eventLocation.setLatitude(lat);
    }

    public void getCurrentLocation(){
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    permissionCode);
        }else {
            currentLocation();
        }
    }

    public void currentLocation() throws SecurityException{
        client.getLastLocation().addOnSuccessListener(location -> {
            if (location != null){
                animateCamera(location);
            }else
                Log.d(TAG, "Location is null");
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantedPermissions){
        switch (requestCode){
            case permissionCode:
                if (grantedPermissions.length > 0 && grantedPermissions[0] ==
                        PackageManager.PERMISSION_GRANTED){
                    currentLocation();
                }
                else
                    Log.d(TAG, "Access Denied");
        }
    }

    public void showDirection(MeetUpDistance distance){
        Route route = distance.routes().get(0);
        Leg leg = route.legs().get(0);
        List<Steps> stepsList = leg.steps();
        stepList = stepsList;
        options = new PolylineOptions();

        map.clear();
        StartLocation startLocation = leg.startLocation();
        addStartLocation(startLocation);

        addStepMarkers(stepsList);

        EndLocation endLocation = leg.endLocation();
        addEndLocation(endLocation);

        showStepInstruction();
        //consider showing the distance and duration
    }

    public void addStartLocation(StartLocation startLocation){
        LatLng startLatLng = new LatLng(startLocation.lat(), startLocation.lng());
        options.add(startLatLng);

        BitmapDescriptor startDescriptor = BitmapDescriptorFactory.fromResource
                (R.drawable.current_position);
        MarkerOptions startOption = new MarkerOptions();
        startOption.position(startLatLng)
                .icon(startDescriptor);

        map.addMarker(startOption);
    }

    public void addStepMarkers(List<Steps> stepsList){
        for (Steps step : stepsList) {
            LatLng stepLatLng = new LatLng(step.startLocation().lat(),
                    step.startLocation().lng());
            options.add(stepLatLng);

            BitmapDescriptor stepDescriptor = BitmapDescriptorFactory.fromResource
                    (R.drawable.step_dot);
            MarkerOptions stepOption = new MarkerOptions();
            stepOption.position(stepLatLng)
                    .icon(stepDescriptor);
        }
    }

    public void addEndLocation(EndLocation endLocation){
        LatLng endLatLng = new LatLng(endLocation.lat(), endLocation.lng());
        options.add(endLatLng);
        BitmapDescriptor endDescriptor = BitmapDescriptorFactory.fromResource
                (R.drawable.destination);
        MarkerOptions endOption = new MarkerOptions();
        endOption.position(endLatLng)
                .icon(endDescriptor);
        map.addMarker(endOption);

        Polyline line = map.addPolyline(options);
        line.setGeodesic(true);
        line.setColor(Color.BLUE);
    }

    public void showStepInstruction(){
        //show specific instruction for every step on click
        map.setOnMapClickListener(latLng -> {
            List<LatLng> stepLatLng = options.getPoints();
            for (LatLng currentPosition : stepLatLng) {
                if (currentPosition.equals(latLng)){
                    //escape html characters
                    Steps step = returnLocationStep(currentPosition);
                    if (step != null){
                        CharSequence instruction = step.htmlInstructions();
                        showSnackBar(instruction);
                    }
                }
            }
        });
    }

    public Steps returnLocationStep(LatLng latLng){
        for (Steps step : stepList){
            if (step.startLocation().lat() == latLng.latitude &&
                    step.startLocation().lng() == latLng.longitude){
                return step;
            }
        }
        return null;
    }

    public void showSnackBar(CharSequence message){
        //test out snack bar for NPE
        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
    }
}
