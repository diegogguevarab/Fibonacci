package com.taller.fibonacci;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Factorial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);
        TextView txt = findViewById(R.id.factorialTxt);
        String multi= "";
        for(int i=1; i<getIntent().getIntExtra("num",0);i++)
        {
            multi+= (i)+"*";
        }
        multi+=getIntent().getIntExtra("num",0);
        txt.setText("Multiplicación: "+multi+"\nResultado: "+factorial(getIntent().getIntExtra("num",0)));
    }
    static int factorial(int n)
    {
        if (n == 0)
            return 1;
        return n*factorial(n-1);
    }
}
