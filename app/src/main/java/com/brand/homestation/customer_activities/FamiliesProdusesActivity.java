package com.brand.homestation.customer_activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.brand.homestation.R;
import com.brand.homestation.trader_activities.MapsActivity;
import com.brand.homestation.utiles.UtilitiesClass;

public class FamiliesProdusesActivity extends AppCompatActivity {
    Button map;
    TextView discover,best;
    public static int fromWhat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_families_produses);
        discover=(TextView) findViewById(R.id.discover);
        best=(TextView) findViewById(R.id.best);
        map=(Button) findViewById(R.id.map);

        UtilitiesClass.setFont(discover,this,0);
        UtilitiesClass.setFont(best,this,0);
        UtilitiesClass.setFont(map,this,0);

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fromWhat=1;
                startActivity(new Intent(FamiliesProdusesActivity.this, MapsActivity.class));
            }
        });
    }
}
