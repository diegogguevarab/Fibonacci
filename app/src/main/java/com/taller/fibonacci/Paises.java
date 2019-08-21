package com.taller.fibonacci;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Paises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);
        try {
            JSONObject json = new JSONObject(loadJSONFromAsset());
            final JSONArray paisesJSON = json.getJSONArray("paises");
            final ArrayList<Pais> paises = new ArrayList<Pais>();
            String[] nombres = new String[paisesJSON.length()];
            for (int i = 0; i < paisesJSON.length(); i++) {
                JSONObject jsonObject = paisesJSON.getJSONObject(i);
                paises.add(new Pais(jsonObject.getString("capital"), jsonObject.getString("nombre_pais"), jsonObject.getString("nombre_pais_int"), jsonObject.getString("sigla")));
                nombres[i] = jsonObject.getString("nombre_pais");
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres);
            ListView listView = findViewById(R.id.list_paises);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getBaseContext(), InfoPais.class);
                    Bundle bundle = new Bundle();
                    try {
                        bundle.putString("capital", paisesJSON.getJSONObject(i).getString("capital"));
                        bundle.putString("nombre", paisesJSON.getJSONObject(i).getString("nombre_pais"));
                        bundle.putString("int", paisesJSON.getJSONObject(i).getString("nombre_pais_int"));
                        bundle.putString("sigla", paisesJSON.getJSONObject(i).getString("sigla"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    intent.putExtra("bundle",bundle);
                    startActivity(intent);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public class Pais implements Serializable {
        String capital;
        String nombre_pais;
        String nombre_pais_int;
        String sigla;

        public Pais() {

        }

        public Pais(String capital, String nombre_pais, String nombre_pais_int, String sigla) {
            Pais nuevo = new Pais();
            nuevo.capital = capital;
            nuevo.nombre_pais = nombre_pais;
            nuevo.nombre_pais_int = nombre_pais_int;
            nuevo.sigla = sigla;
        }

        public String toString() {
            return this.nombre_pais;
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("paises.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
