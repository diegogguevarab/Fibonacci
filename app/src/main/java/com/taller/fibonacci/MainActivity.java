package com.taller.fibonacci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ArrayList<Integer> fib = new ArrayList<>();
        fib.add(0);
        fib.add(1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView fib_text = findViewById(R.id.fib_text);
        fib_text.setText(fib.toString());
        Button btn_calc = findViewById(R.id.btn_calc);
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fib.add(fib.get(fib.size() - 2) + fib.get(fib.size() - 1));
                fib_text.setText(fib.toString());
            }
        });
        Button btn_sig = findViewById(R.id.btn_sig);
        btn_sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FibonacciList.class);
                startActivity(intent);
            }
        });
    }
}
