package com.yusuf.perhitunganzakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InformasiZe extends AppCompatActivity {

    Button btnShare, kembali, lanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi_ze);

        btnShare = (Button)findViewById(R.id.btn_share);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_SUBJECT, "Perhitungan Zakat");
                String kata = "Zakat Emas merupakan zakat yang wajib dikeluarkan oleh seorang muslim yang mempunyai emas bila telah mencapat nisab atau haul. Zakat Emas merupakan zakat yang wajib dikeluarkan oleh seorang muslim yang mempunyai emas bila telah mencapat nisab atau haul. Adapun nisab emas sebesar 20 Dinar emas (85 gram), dengan haul selama satu tahun dan kadar 2,5%. Artinya bila seorang muslim memiliki emas sebesar setidaknya 20 Dinar emas (85 gram) selama satu tahun ia wajib membayar zakat sebesar 2,5% dari jumlah emasnya tersebut.";
                share.putExtra(Intent.EXTRA_TEXT, "Penjelasan " +kata);
                startActivity(Intent.createChooser(share,"Share Via"));
            }
        });

        kembali = (Button)findViewById(R.id.kembali);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformasiZe.this, menu.class);
                startActivity(intent);
            }
        });

        lanjut = (Button)findViewById(R.id.btn_next);
        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformasiZe.this,ZakatEmas.class);
                startActivity(intent);
            }
        });
    }
}