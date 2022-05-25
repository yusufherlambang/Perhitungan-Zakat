package com.yusuf.perhitunganzakat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ZakatFitrah extends AppCompatActivity {

    double hasil=0;

    String hargaBerasRupiah;
    boolean hasConvertHargaBeras;
    boolean hasConvert;

    EditText editHargaBeras,orang;
    TextView textHasilFitrah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_fitrah);
        setTitle("Zakat Fitrah");
        editHargaBeras = (EditText)findViewById(R.id.editHargaBeras);
        orang   = (EditText) findViewById(R.id.orang);
        textHasilFitrah = (TextView)findViewById(R.id.textHasilFitrah);

        Button btnHitung = (Button)findViewById(R.id.btn_hitungFitrah);
        btnHitung.requestFocus();
        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int o;

                if (!editHargaBeras.getText().toString().equalsIgnoreCase("")) {
                    String convertComma = FormatRupiah.replaceDot(editHargaBeras.getText().toString().substring(4));

                    o = Integer.parseInt(orang.getText().toString());
                    Double dblHargaBeras = Double.parseDouble(FormatRupiah.replaceCommaToEmpty(convertComma));

                    hasil = (dblHargaBeras * 3.5)*o;

                    DecimalFormat formatter = new DecimalFormat("#,###,###");
                    String Rupiahhasil = formatter.format(hasil);

                    textHasilFitrah.setText("Anda dapat membayar zakat fitrah dengan : \nBeras sebesar 3,5 liter atau \n2.5 kg makanan pokok (tepung, kurma, gandum, aqith) atau yang biasa dikonsumsi di daerah bersangkutan atau \nAnda dapat membayar Zakat Fitrah dengan uang sebesar Rp. " + Rupiahhasil);
                } else {
                    Toast.makeText(ZakatFitrah.this, "Silahkan isi Harga Beras terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        function untuk mengconvert angka menjadi ada Rp.
        functionForm();
    }


    public void functionForm(){
        editHargaBeras = (EditText) findViewById(R.id.editHargaBeras);

        /* function edit text harga */
        editHargaBeras.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    hasConvert = false;
                } else {
                    if (editHargaBeras.getText().toString().equalsIgnoreCase("Rp. ")) {
                        hasConvert = true;
                        editHargaBeras.setText("");
                    }
                }
            }
        });
        TextWatcher fieldValidatorTotalHarga = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                hargaBerasRupiah = editHargaBeras.getText().toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(hargaBerasRupiah) && !hasConvertHargaBeras) {
                    editHargaBeras.removeTextChangedListener(this);
                    String cleanString = s.toString().replaceAll("[Rp,. ]", "");
                    if (cleanString != "") {
                        editHargaBeras.setText("Rp. " + FormatRupiah.formatCurrency(Double.parseDouble(cleanString)));
                    } else if (cleanString == "" && editHargaBeras.isFocused()) {
                        editHargaBeras.setText("Rp. ");
                    }
                    editHargaBeras.setSelection(editHargaBeras.getText().toString().length());
                    editHargaBeras.addTextChangedListener(this);
                }
            }
        };
        editHargaBeras.addTextChangedListener(fieldValidatorTotalHarga);

    }
}