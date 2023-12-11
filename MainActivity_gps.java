package com.example.capston_rb;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity_gps extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gps);

        //홈 화면으로 이동하기.
        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity_gps.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }

    public void onMapReady(GoogleMap googleMap) {
        GoogleMap mMap = googleMap;

        // 12개의 핀을 미리 지정된 위도와 경도로 추가하기
        LatLng[] locations = {
                new LatLng(36.3319323161052, 127.464592331317),
                new LatLng(36.3327172788944, 127.463770010316),
                new LatLng(36.334411653435, 127.463727147909),
                new LatLng(36.335796, 127.463702),
                new LatLng(36.336455, 127.463584),
                new LatLng(36.330507, 127.463373),
                new LatLng(36.3353858638678, 127.456459687872),
                new LatLng(36.3342547662703, 127.45590175662),
                new LatLng(36.332769, 127.455149),
                new LatLng(36.3320177235, 127.45586923),
                new LatLng(36.33080968, 127.45539998),
                new LatLng(36.32958, 127.45459),
                new LatLng(36.328257, 127.454157),
                new LatLng(36.327915, 127.455132),
                new LatLng(36.32778866, 127.4541712)
        };

        // 각 마커에 고유한 ID 부여
        final String[] markerIds = {"light_1", "light_2", "light_3", "light_4", "light_5", "light_6", "light_7", "light_8", "light_9", "light_10", "light_11", "light_12", "light_13", "light_14", "light_15"};
        // 추가할 핀의 개수에 따라 markerIds 배열에 각 마커의 고유 ID를 추가하세요.

        for (int i = 0; i < locations.length; i++) {
            LatLng location = locations[i];
            MarkerOptions markerOptions = new MarkerOptions().position(location).title("신호등 " + (i + 1));
            Marker marker = mMap.addMarker(markerOptions);
            marker.setTag(markerIds[i]); // 각 마커에 고유한 태그 설정
        }

        // 첫 번째 마커로 맵 카메라 이동하기
        LatLng firstMarkerLocation = locations[0];
        mMap.moveCamera(CameraUpdateFactory.newLatLng(firstMarkerLocation));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16)); // 줌 레벨 조절

        // 마커 클릭 리스너 설정
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                // 마커를 클릭했을 때 해당 핀의 ID를 가져와서 다른 화면으로 전달
                String markerId = (String) marker.getTag();

                // 각각의 마커 ID에 따라 다른 화면으로 전환
                if (markerId != null) {
                    Intent intent;
                    switch (markerId) {
                        case "light_1":
                            intent = new Intent(MainActivity_gps.this, Traffic_Light_1.class);
                            break;
                        case "light_2":
                            intent = new Intent(MainActivity_gps.this, Traffic_Light_2.class);
                            break;
                        case "light_3":
                            intent = new Intent(MainActivity_gps.this, Traffic_Light_3.class);
                            break;
                        case "light_4":
                            intent = new Intent(MainActivity_gps.this, Traffic_Light_4.class);
                            break;
                        case "light_5":
                            intent = new Intent(MainActivity_gps.this, Traffic_Light_5.class);
                            break;
                        case "light_6":
                            intent = new Intent(MainActivity_gps.this, Traffic_Light_6.class);
                            break;
                        case "light_7":
                            intent = new Intent(MainActivity_gps.this, Traffic_Light_7.class);
                            break;
                        case "light_8":
                            intent = new Intent(MainActivity_gps.this, Traffic_Light_8.class);
                            break;
                        case "light_9":
                            intent = new Intent(MainActivity_gps.this, Traffic_Light_9.class);
                            break;
                        case "light_10":
                            intent = new Intent(MainActivity_gps.this, Traffic_Light_10.class);
                            break;
                        case "light_11":
                            intent = new Intent(MainActivity_gps.this, Traffic_Light_11.class);
                            break;
                        case "light_12":
                            intent = new Intent(MainActivity_gps.this, Traffic_Light_12.class);
                            break;
                        case "light_13":
                            intent = new Intent(MainActivity_gps.this, Traffic_Light_13.class);
                            break;
                        case "light_14":
                            intent = new Intent(MainActivity_gps.this, Traffic_Light_14.class);
                            break;
                        case "light_15":
                            intent = new Intent(MainActivity_gps.this, Traffic_Light_15.class);
                            break;
                        default:
                            // 기본적으로 어떤 마커 ID에도 해당하지 않는 경우, 기본 화면으로 설정
                            intent = new Intent(MainActivity_gps.this, MainActivity.class);
                            break;
                    }

                    // 해당 마커의 ID를 전달
                    intent.putExtra("markerId", markerId);
                    Log.d("MarkerClick", "Marker ID: " + markerId);

                    // 화면 전환
                    startActivity(intent);
                }

                return true;
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}