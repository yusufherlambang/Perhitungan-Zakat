package com.yusuf.perhitunganzakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InformasiZF extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi_z_f);

        Button share = (Button) findViewById(R.id.btn_share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT, "Perhitungan Zakat");
                String kata = "Zakat fitrah adalah zakat yang wajib dikeluarkan umat muslim menjelang Idul Fitri pada bulan suci Ramadhan. Besar zakat ini setara dengan 2,5kg atau 3,5 liter beras atau makanan pokok per jiwa . beras atau makanan pokok tersebut dapat diganti dengan uang seharga 2,5 kg atau 3,5 liter beras yang diberikan kepada lembaga - lembaga penyalur zakat";
                share.putExtra(Intent.EXTRA_TEXT, "Penjelasan " +kata);
                startActivity(Intent.createChooser(share,"Share Via"));
            }
        });

        Button kembali = (Button)findViewById(R.id.kembali);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformasiZF.this, menu.class);
                startActivity(intent);
            }
        });

        Button lanjut = (Button)findViewById(R.id.btn_next);
        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformasiZF.this,ZakatFitrah.class);
                startActivity(intent);
            }
        });
    }
}