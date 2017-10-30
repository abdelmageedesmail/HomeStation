package com.brand.homestation.trader_activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.customer_activities.FamiliesProdusesActivity;
import com.brand.homestation.models.DirectionsJSONParser;
import com.brand.homestation.models.GPSTracker;
import com.brand.homestation.utiles.UtilitiesClass;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    GPSTracker mGps;
    EditText editSearch;
    TextView traderName,phone,phoneNumber;
    Button more;
    RatingBar rate;
    FrameLayout frameData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        String per [] = {Manifest.permission.ACCESS_COARSE_LOCATION , Manifest.permission.ACCESS_FINE_LOCATION};
        ActivityCompat.requestPermissions(this, per,1);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        editSearch = (EditText) findViewById(R.id.editSearch);
        frameData=(FrameLayout) findViewById(R.id.frameData);
        traderName = (TextView) findViewById(R.id.traderName);
        phone = (TextView) findViewById(R.id.txtPhone);
        phoneNumber = (TextView) findViewById(R.id.phoneNumber);
        rate = (RatingBar) findViewById(R.id.rate);
        more=(Button) findViewById(R.id.more);
        UtilitiesClass.setFont(traderName,MapsActivity.this,0);
        UtilitiesClass.setFont(phone,MapsActivity.this,0);
        UtilitiesClass.setFont(phoneNumber,MapsActivity.this,0);
        UtilitiesClass.setFont(more,MapsActivity.this,0);
        UtilitiesClass.setFont(editSearch, this, 0);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MapsActivity.this, com.brand.homestation.customer_activities.TraderProfileActivity.class));
            }
        });

        mGps = new GPSTracker(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(mGps.getLatitude(), mGps.getLongitude());
        BitmapDescriptor iconLocation = BitmapDescriptorFactory.fromResource(R.mipmap.selected_1);

     //   mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in My Location").icon(iconLocation));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mMap.setMyLocationEnabled(true);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
        mMap.animateCamera(zoom);

        if (FamiliesProdusesActivity.fromWhat == 1) {

            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(mGps.getLatitude(), mGps.getLongitude())).icon(iconLocation));

            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    frameData.setVisibility(View.VISIBLE);
                    return true;
                }
            });

            mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                @Override
                public void onMapClick(LatLng latLng) {
                    frameData.setVisibility(View.GONE);
                }
            });
        } else {
            LatLng latLng = new LatLng(30.969082, 31.196661);
            DownloadTask task = new DownloadTask();
            String directionsUrl = getDirectionsUrl(sydney, latLng);
            task.execute(directionsUrl);
        }
    }


    public boolean initmap() {

        if (mMap != null) {
            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {
                    View v = LayoutInflater.from(MapsActivity.this).inflate(R.layout.trader_popup, null);
                    traderName = (TextView) v.findViewById(R.id.traderName);
                    phone = (TextView) v.findViewById(R.id.txtPhone);
                    phoneNumber = (TextView) v.findViewById(R.id.phoneNumber);
                    rate = (RatingBar) v.findViewById(R.id.rate);
                    more=(Button) v.findViewById(R.id.more);


                    mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                        @Override
                        public void onInfoWindowClick(Marker marker) {
                        }
                    });
                    UtilitiesClass.setFont(traderName,MapsActivity.this,0);
                    UtilitiesClass.setFont(phone,MapsActivity.this,0);
                    UtilitiesClass.setFont(phoneNumber,MapsActivity.this,0);
                    UtilitiesClass.setFont(more,MapsActivity.this,0);

                    return v;
                }
            });
        }
        return (mMap != null);
    }

    private String getDirectionsUrl(LatLng origin, LatLng dest) {

        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;

        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;

        // Sensor enabled
        String sensor = "sensor=false";

        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + sensor;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters;

        return url;
    }

    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {

        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    private class DownloadTask extends AsyncTask<String, Void, String> {

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);
        }
    }

    /**
     * A class to parse the Google Places in JSON format
     */
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }
                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(13);
                lineOptions.color(Color.parseColor("#5F331E"));
            }
            // Drawing polyline in the Google Map for the i-th route
            mMap.addPolyline(lineOptions);
        }
    }


    public class RefreshLocation extends TimerTask {

        @Override
        public void run() {
            mGps.getLatitude();
            mGps.getLongitude();

            Log.e("LocationRefresh", "................" + mGps.getLatitude());
            Log.e("LocationRefresh", "................" + mGps.getLongitude());

            //distFrom(mGPS.getLatitude(),mGPS.getLongitude(),Double.parseDouble(latTo),Double.parseDouble(longTo));
        }
    }

}
