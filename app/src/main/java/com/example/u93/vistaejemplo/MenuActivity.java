package com.example.u93.vistaejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tvUser = findViewById(R.id.tvUser);
        tvUser.setText(getIntent().getStringExtra("nombre"));
    }
}
