package com.yusuf.perhitunganzakat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class menu extends AppCompatActivity {

    private long lastPressedTime;
    private static final int PERIOD = 2000;

    ImageView btn_fb;
    ImageView btn_instagram;
    ImageView btn_twitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_fb = (ImageView) findViewById(R.id.btn_fb);
        btn_instagram = (ImageView) findViewById(R.id.btn_instagram);
        btn_twitter = (ImageView) findViewById(R.id.btn_google);

        //profil pembuat di facebook
        btn_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.facebook.com/profile.php?id=100004047024396");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //profil pembuat di instagram
        btn_instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.instagram.com/hrlmbyusuf/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //profil pembuat di twitter
        btn_twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://twitter.com/cubaangg");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Button pindahDonasi = (Button)findViewById(R.id.btn_donasi);
        pindahDonasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this, DonasiZakat.class);
//                Toast.makeText(MainActivity.this, kalimat, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        Button pindahFitrah = (Button)findViewById(R.id.btn_fitrah);
        pindahFitrah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this, InformasiZF.class);
//                Toast.makeText(MainActivity.this, kalimat, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        Button pindahHarta = (Button)findViewById(R.id.btn_harta);
        pindahHarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this, InformasiZe.class);
//                Toast.makeText(MainActivity.this, kalimat, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        Button pindahAbout = (Button)findViewById(R.id.btn_about);
        pindahAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu.this, About.class);
//                Toast.makeText(MainActivity.this, kalimat, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Apa kalian ingin Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        menu.this.finish();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present. getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}