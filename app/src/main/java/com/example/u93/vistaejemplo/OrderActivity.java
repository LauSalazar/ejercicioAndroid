package com.example.u93.vistaejemplo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Order order = (Order) getIntent().getSerializableExtra(Constantes.ORDER_OBJETO);
        mostrarMensaje(order);
    }

    private void mostrarMensaje(Order order) {
        Toast.makeText(this,"La orden es de "+order.getFood().toString(),Toast.LENGTH_LONG).show();

    }

    public void onRegresar(View view) {
        //using finish method
        //finish();
        Intent intent = new Intent();
        intent.putExtra(Constantes.CONFIRMACION,true);
        setResult(Constantes.RESULT_OK);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(Constantes.CONFIRMACION,true);
        setResult(Constantes.RESULT_OK);
        finish();
        super.onBackPressed();
    }
}
