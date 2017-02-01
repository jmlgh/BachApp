package com.uem.javi.repaso1t;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static String COMP_INFO = "compInfo";
    final static String EXIT = "exit";
    final static String BACK_COLOR = "#009688";
    final static String ALT_COLOR = "#FFC107";
    final static String WIKI_URL = "https://en.wikipedia.org/wiki/Johann_Sebastian_Bach";

    Spinner spCompositions;
    Compositions compositions;
    RelativeLayout mainLay;
    TextView tvNameRes, tvYearsRes, tvRangeRes;
    Button btnMoreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spCompositions = (Spinner)findViewById(R.id.spCompositions);
        mainLay = (RelativeLayout)findViewById(R.id.mainLayout);
        tvNameRes = (TextView)findViewById(R.id.tvNamesResul);
        tvYearsRes = (TextView)findViewById(R.id.tvYearsRes);
        tvRangeRes = (TextView)findViewById(R.id.tvRangeRes);
        btnMoreInfo = (Button)findViewById(R.id.button);

        compositions = new Compositions();

        mainLay.setBackgroundColor(Color.parseColor(BACK_COLOR));

        // en nuestro spinner solo queremos un array de Strings
        String[] compNombres = new String[compositions.getComps().length];
        // guarda en el array de strings solo los nombres
        for(int i = 0; i < compNombres.length; i++){
            compNombres[i] = compositions.getComps()[i].getName();
        }

        // args: contexto, tipo, String[]
        ArrayAdapter compAdapter = new ArrayAdapter(this, R.layout.spinner_item, compNombres);
        spCompositions.setAdapter(compAdapter);
        spCompositions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Composition comp = compositions.getComps()[i];
                tvNameRes.setText(comp.getName());
                tvYearsRes.setText(String.valueOf(comp.getYear()));
                tvRangeRes.setText(comp.getBMVRange());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void verTodo(View v){
        Intent intent = new Intent(this, CompAllActivity.class);
        startActivity(intent);
    }

    // infla el menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top, menu);
        return true;
    }

    // cuando el usuario pincha sobre el icono del menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent goToWiki = new Intent(Intent.ACTION_VIEW, Uri.parse(WIKI_URL));
        startActivity(goToWiki);
        return true;
    }
}
