package com.example.u93.vistaejemplo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ComponentesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String TAG = "ComponentesActivity";
    private Order order;
    private TextView tvFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_componentes);

        tvFood = findViewById(R.id.tvFood);
        order = new Order();

        loadDataFoodList();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"On start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"On resume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"On restart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"On pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"On destroy");
    }



    private void loadDataFoodList() {

        Spinner spnFood = findViewById(R.id.spnFood);
        spnFood.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> foodAdapter = ArrayAdapter.createFromResource(this,R.array.food_list,android.R.layout.simple_spinner_item);
        foodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnFood.setAdapter(foodAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String foodSelected = (String) adapterView.getItemAtPosition(position);
        Log.i(TAG, foodSelected);
        tvFood.setText(foodSelected);
        order.setFood(foodSelected);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox)view).isChecked();
        String added = checked ? " con ":" sin ";
        switch (view.getId()){
            case R.id.chkSoda:
                order.setHasSoda(checked);
                break;
            case R.id.chkAcompa:
                order.setHasSnack(checked);
                break;
        }
    }

    public void onOrderClick(View view) {
        Intent intent = new Intent(ComponentesActivity.this,OrderActivity.class);
        intent.putExtra(Constantes.ORDER_OBJETO,order);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Constantes.RESULT_OK){
            Toast.makeText(this,"Su pedido ha sido confirmado",Toast.LENGTH_LONG).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
