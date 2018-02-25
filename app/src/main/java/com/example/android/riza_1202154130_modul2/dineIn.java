package com.example.android.riza_1202154130_modul2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class dineIn extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    private String mSpinnerLabel = "";  //mendefinisikan callback pilihan untuk spinner
    private static final String TAG = dineIn.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dine_in);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
        mSpinnerLabel = adapterView.getItemAtPosition(i).toString();
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d(TAG, "onNothingSelected: ");
    }

    public void daftar_menu(View view) {
        Intent intent = new Intent(this, daftarMenu.class);   //Membuat Intent untuk memulai aktivitas baru
        startActivity(intent);      //Menjalankan aktivitas
    }
}
