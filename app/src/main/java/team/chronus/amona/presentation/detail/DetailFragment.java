package team.chronus.amona.presentation.detail;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.maps.android.PolyUtil;

import java.util.List;

import team.chronus.amona.R;

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
        LatLng latLng;

    }
}
