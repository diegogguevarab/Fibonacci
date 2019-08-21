package com.taller.fibonacci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoPais extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pais);
        TextView info = findViewById(R.id.infoTxt);
        Bundle bundle = getIntent().getBundleExtra("bundle");
        info.setText("País: "+bundle.get("nombre")+"\nNombre interacional: "+bundle.get("int")+"\nCapital: "+bundle.get("capital")+"\nSigla: "+bundle.get("sigla"));
    }
}
