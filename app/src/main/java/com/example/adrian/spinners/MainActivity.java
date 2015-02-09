package com.example.adrian.spinners;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    Spinner miSpinner;
    String[] misColores;
    Context miContexto;
    ArrayList<String> coloresArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miContexto = this;
        miSpinner = (Spinner)findViewById(R.id.spinnerColores);
       cargarColores();

             ArrayAdapter<String> miAdapter = new ArrayAdapter<String>(miContexto,android.R.layout.simple_spinner_item,coloresArray);
        miAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        miSpinner.setAdapter(miAdapter);



       miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               RelativeLayout miLayout = (RelativeLayout)findViewById(R.id.miLayout);
                String miColor=coloresArray.get(position);
                miLayout.setBackgroundColor(getResources().getColor(getResources().getIdentifier(miColor, "color", miContexto.getPackageName())));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void cargarColores(){
        int i = 0;
        TypedArray colores = getResources().obtainTypedArray(R.array.colors);
        coloresArray = new ArrayList<String>();
        while(i<colores.length()){
            int aux = colores.getResourceId(i,-1);
            coloresArray.add(getResources().getResourceEntryName(aux));
            i++;
        }
       // Toast.makeText(this,coloresArray[i],Toast.LENGTH_LONG).show();
      // coloresArray.toArray(misColores);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
