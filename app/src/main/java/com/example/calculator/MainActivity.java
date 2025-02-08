package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView tvsec, tvMain;
    private Button bac, bc, bbrac1, bbrac2, bsin, bcos, btan, blog, bln,
            bfact, bsquare, bsqrt, binv, b0, b1, b2, b3, b4, b5,
            b6, b7, b8, b9, bpi, bmul, bminus, bplus, bequal, bdot, bdiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tvsec = findViewById(R.id.idTVSecondary);
        tvMain = findViewById(R.id.idTVprimary);
        bac = findViewById(R.id.bac);
        bc = findViewById(R.id.bc);
        bbrac1 = findViewById(R.id.bbrac1);
        bbrac2 = findViewById(R.id.bbrac2);
        bsin = findViewById(R.id.bsin);
        bcos = findViewById(R.id.bcos);
        btan = findViewById(R.id.btan);
        blog = findViewById(R.id.blog);
        bln = findViewById(R.id.bln);
        bfact = findViewById(R.id.bfact);
        bsquare = findViewById(R.id.bsquare);
        bsqrt = findViewById(R.id.bsqrt);
        binv = findViewById(R.id.binv);
        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        bpi = findViewById(R.id.bpi);
        bmul = findViewById(R.id.bmul);
        bminus = findViewById(R.id.bminus);
        bplus = findViewById(R.id.bplus);
        bequal = findViewById(R.id.bequal);
        bdot = findViewById(R.id.bdot);
        bdiv = findViewById(R.id.bdiv);

        bsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMain.append("sin");
            }
        });
        bcos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMain.append("cos");
            }
        });
        btan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMain.append("tan");
            }
        });
        bln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMain.append("ln");
            }
        });
        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMain.append("log");
            }
        });

        b1.setOnClickListener(v -> tvMain.append("1"));
        b2.setOnClickListener(v -> tvMain.append("2"));
        b3.setOnClickListener(v -> tvMain.append("3"));
        b4.setOnClickListener(v -> tvMain.append("4"));
        b5.setOnClickListener(v -> tvMain.append("5"));
        b6.setOnClickListener(v -> tvMain.append("6"));
        b7.setOnClickListener(v -> tvMain.append("7"));
        b8.setOnClickListener(v -> tvMain.append("8"));
        b9.setOnClickListener(v -> tvMain.append("9"));
        b0.setOnClickListener(v -> tvMain.append("0"));
        bdot.setOnClickListener(v -> tvMain.append("."));
        bplus.setOnClickListener(v -> tvMain.append("+"));
        bdiv.setOnClickListener(v -> tvMain.append("/"));
        bbrac1.setOnClickListener(v -> tvMain.append("("));
        bbrac2.setOnClickListener(v -> tvMain.append(")"));
        bpi.setOnClickListener(v -> {
            tvMain.append("3.142");
            tvsec.setText("π");
        });

        bminus.setOnClickListener(v -> {
            String str = tvMain.getText().toString();
            if (!str.endsWith("-")) {
                tvMain.append("-");
            }
        });

        bmul.setOnClickListener(v -> {
            String str = tvMain.getText().toString();
            if (!str.endsWith("*")) {
                tvMain.append("*");
            }
        });

        bsqrt.setOnClickListener(v -> {
            if (tvMain.getText().toString().isEmpty()) {
                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show();
            } else {
                double r = Math.sqrt(Double.parseDouble(tvMain.getText().toString()));
                tvMain.setText(String.valueOf(r));
            }
        });
        calculation cal = new calculation();
        bequal.setOnClickListener(v -> {
            String str = tvMain.getText().toString();
            double result = cal.evaluate(str);
            tvMain.setText(String.valueOf(result));
            tvsec.setText(str);

        });

        bac.setOnClickListener(v -> {
            tvMain.setText("");
            tvsec.setText("");
        });

        bc.setOnClickListener(v -> {
            String str = tvMain.getText().toString();
            if (!str.isEmpty()) {
                tvMain.setText(str.substring(0, str.length() - 1));
            }
        });
    }

}