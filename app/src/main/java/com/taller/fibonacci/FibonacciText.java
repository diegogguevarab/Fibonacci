package com.taller.fibonacci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FibonacciText extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci_text);

        final EditText pos = findViewById(R.id.fibTxt);
        final LinearLayout text_lay = findViewById(R.id.txt_lay);
        Button btn_calc = findViewById(R.id.btn_calcTxt);
        Button btn_ant = findViewById(R.id.btn_antTxt);
        Button btn_fib = findViewById(R.id.fib_img);
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int t1=0,fib=1, t2;
                text_lay.removeAllViews();
                for (int i = 0; i < Integer.parseInt(pos.getText().toString())-1; i++) {
                    if(i<=1){
                        TextView textView = new TextView(view.getContext());
                        textView.setText(Integer.toString(i));
                        text_lay.addView(textView);
                    }
                    t2=t1+fib;
                    t1=fib;
                    fib=t2;
                    TextView textView = new TextView(view.getContext());
                    textView.setText(Integer.toString(fib));
                    text_lay.addView(textView);
                }
            }
        });
        btn_ant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FibonacciList.class);
                startActivity(intent);
            }
        });
        btn_fib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Web.class);
                startActivity(intent);
            }
        });
    }
}
