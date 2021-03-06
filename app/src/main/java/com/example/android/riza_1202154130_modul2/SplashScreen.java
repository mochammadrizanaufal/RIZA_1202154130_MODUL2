package com.example.android.riza_1202154130_modul2;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    private static int splashInterval = 5000;   //Set waktu lamanya splashscreen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,    //Agar splashscreen ditampilkan full
                WindowManager.LayoutParams.FLAG_FULLSCREEN);                //Menghilangkan ActionBar di atas aplikasi

        setContentView(R.layout.activity_splash_screen);

        //Membuat Toast Nama dan NIM
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "RIZA_1202154130", Toast.LENGTH_LONG);
        toast.show();

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i); // menghubungkan activity splashscren ke main activity dengan intent


                //jeda selesai Splashscreen agar tidak dapat kembali ke splashscreen dengan tombol back
                this.finish();
            }

            private void finish() {
                // TODO Auto-generated method stub

            }
        }, splashInterval);

    };
}