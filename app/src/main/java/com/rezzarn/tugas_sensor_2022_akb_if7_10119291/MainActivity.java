package com.rezzarn.tugas_sensor_2022_akb_if7_10119291;

// 10119291 - Rezza Ramdhani Nahsurllah - IF7

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout draw;
    private GoogleMap mMap;
    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;

    private LatLng warungNasiSPG = new LatLng(-6.886585657627592, 107.61502601772244);
    private LatLng warkopSukarasa = new LatLng(-6.8877243, 107.6143175);
    private LatLng warman = new LatLng(-6.88703134000288, 107.61485187176665);
    private LatLng rMBogaRoso = new LatLng(-6.885930448553339, 107.61488666494027);
    private LatLng warungSteakDu = new LatLng(-6.890153060275174, 107.61622175566549);
    private LatLng ricisFactoryDu = new LatLng(-6.8878013706863435, 107.61515326985895);
    private LatLng mieGacoanDago = new LatLng(-6.8887724062934526, 107.61315126035227);
    private LatLng bebekAliBorme = new LatLng(-6.891920329259786, 107.61677041130967);

    private Marker mWarungNasiSPG;
    private Marker mWarkopSukarasa;
    private Marker mWarman;
    private Marker mRMBogaRoso;
    private Marker mWarungSteakDu;
    private Marker mRicisFactoryDu;
    private Marker mMieGacoanDago;
    private Marker mBebekAliBorme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        draw = findViewById(R.id.drawer_layout);
        final ActionBarDrawerToggle t = new ActionBarDrawerToggle(this, draw,
                R.string.open,
                R.string.close);

        draw.addDrawerListener(t);
        t.syncState();

        NavigationView navigationview = findViewById(R.id.nav_view);
        navigationview.setItemIconTintList(null);

        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id) {
                    case R.id.item1:
                        Intent profile = new Intent(MainActivity.this, ProfileActivity.class);
                        startActivity(profile);
                        break;
                    case R.id.tentang:
                        Intent tentang = new Intent(MainActivity.this, TentangActivity.class);
                        startActivity(tentang);
                        break;
                }
                return true;
            }
        });

        client = LocationServices.getFusedLocationProviderClient(this);
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getCurrentLocation();
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(@NonNull GoogleMap googleMap) {
                            mMap = googleMap;

                            List<Marker> markerList = new ArrayList<>();

                            mWarungNasiSPG = mMap.addMarker(new MarkerOptions().position(warungNasiSPG).title("Warung Nasi SPG"));
                            mWarungNasiSPG.setTag(0);
                            markerList.add(mWarungNasiSPG);

                            mWarkopSukarasa = mMap.addMarker(new MarkerOptions().position(warkopSukarasa).title("Warkop Sukarasa"));
                            mWarkopSukarasa.setTag(0);
                            markerList.add(mWarkopSukarasa);

                            mWarman = mMap.addMarker(new MarkerOptions().position(warman).title("warman"));
                            mWarman.setTag(0);
                            markerList.add(mWarman);

                            mRMBogaRoso = mMap.addMarker(new MarkerOptions().position(rMBogaRoso).title("Rumah Makan Boga Roso"));
                            mRMBogaRoso.setTag(0);
                            markerList.add(mRMBogaRoso);

                            mWarungSteakDu = mMap.addMarker(new MarkerOptions().position(warungSteakDu).title("Waroeng Steak & Shake Dipatiukur"));
                            mWarungSteakDu.setTag(0);
                            markerList.add(mWarungSteakDu);

                            mRicisFactoryDu = mMap.addMarker(new MarkerOptions().position(ricisFactoryDu).title("Richeese Factory Dipatiukur"));
                            mRicisFactoryDu.setTag(0);
                            markerList.add(mRicisFactoryDu);

                            mMieGacoanDago = mMap.addMarker(new MarkerOptions().position(mieGacoanDago).title("Mie Gacoan Dago"));
                            mMieGacoanDago.setTag(0);
                            markerList.add(mMieGacoanDago);

                            mBebekAliBorme = mMap.addMarker(new MarkerOptions().position(bebekAliBorme).title("Bebek Ali Borme"));
                            mBebekAliBorme.setTag(0);
                            markerList.add(mBebekAliBorme);

                            LatLng lokasi = new LatLng(location.getLatitude(), location.getLongitude());
                            MarkerOptions options = new MarkerOptions().position(lokasi).title("lokasi saat ini");

                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi, 12));
                            googleMap.addMarker(options);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 44) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getCurrentLocation();
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            openDrawer();
            if (item.getItemId() == android.R.id.home) {
                if ((draw) != null && (draw.isDrawerOpen(GravityCompat.START)))
                    closeDrawer();
            }
        }
        return true;
    }

    @SuppressWarnings("deprecation")
    private void closeDrawer() {
        draw.setDrawerListener(null);
        draw.closeDrawers();
    }
    @SuppressWarnings("deprecation")
    private void openDrawer() {
        draw.setDrawerListener(null);
        draw.openDrawer(GravityCompat.START);
    }

//    @Override
//    public void onMapReady(@NonNull GoogleMap googleMap) {
//        LatLng google = new LatLng(-6.227487391896707, 106.80857070594166);
//        googleMap.addMarker(new MarkerOptions().position(google).title("Kantor Google Indonesia"));
//        googleMap.moveCamera(CameraUpdateFactory.newLatLng(google));
//    }
}