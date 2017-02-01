package com.uem.javi.repaso1t;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class CompAllActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    final static String URL_LUTE = "https://en.wikipedia.org/wiki/List_of_compositions_by_Johann_Sebastian_Bach#BWV_Chapter_9";
    final static String URL_CANTATAS = "https://en.wikipedia.org/wiki/List_of_Bach_cantatas";
    final static String URL_ORGANS= "https://en.wikipedia.org/wiki/List_of_organ_compositions_by_Johann_Sebastian_Bach";
    final static String URL_CANNONS = "https://en.wikipedia.org/wiki/List_of_compositions_by_Johann_Sebastian_Bach#BWV_Chapter_12";

    RelativeLayout relCompAll;
    ListView lvAllComps;
    Compositions comps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp_all);

        lvAllComps = (ListView)findViewById(R.id.lvAllComps);
        relCompAll = (RelativeLayout)findViewById(R.id.relCompAll);
        relCompAll.setBackgroundColor(Color.parseColor(MainActivity.BACK_COLOR));
        comps = new Compositions();

        CompositionsAdapter adapter = new CompositionsAdapter(this, comps);
        lvAllComps.setAdapter(adapter);
        lvAllComps.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String compType = comps.getComps()[i].getName();
        Intent intent;
        if(compType.equals("Cantatas")){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_CANTATAS));
            startActivity(intent);
        } else if(compType.equals("Lute")){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_LUTE));
            startActivity(intent);
        } else if(compType.equals("Cannons")){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_CANNONS));
            startActivity(intent);
        } else{
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL_ORGANS));
            startActivity(intent);
        }
    }
}
