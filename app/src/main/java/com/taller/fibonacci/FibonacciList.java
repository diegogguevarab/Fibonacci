package com.taller.fibonacci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FibonacciList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci_list);
        final ArrayList<Integer> fib = new ArrayList<>();
        final LinearLayout scroll_lay = findViewById(R.id.list_lay);
        Button btn_calc = findViewById(R.id.btn_calcList);
        Button btn_ant = findViewById(R.id.btn_ant);
        Button btn_sig = findViewById(R.id.btn_sigList);
        fib.add(0);
        fib.add(1);
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fib.add(fib.get(fib.size() - 2) + fib.get(fib.size() - 1));
                TextView textView = new TextView(view.getContext());
                textView.setText(Integer.toString(fib.get(fib.size() - 1)));
                scroll_lay.addView(textView);
            }
        });
        btn_ant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        btn_sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FibonacciText.class);
                startActivity(intent);
            }
        });
    }
}
