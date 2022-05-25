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

public class ZakatEmas extends AppCompatActivity {

    double totZHarta = 0.00;
    double totZEmas = 0.00;
    double NisabZakatMal = 0.00;

    String hargaEmasRupiah;
    boolean hasConvertHargaEmas;
    boolean hasConvert;

    EditText edtHarta;
    EditText editHargaEmas;
    TextView textHZHarta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_emas);
        setTitle("Zakat Harta");

        edtHarta = (EditText)findViewById(R.id.editTotHarta);
        editHargaEmas = (EditText)findViewById(R.id.editHargaEmas);
        textHZHarta = (TextView)findViewById(R.id.textHZHarta);

        Button btn_HitungZHarta = (Button)findViewById(R.id.btn_hitungZHarta);
        btn_HitungZHarta.requestFocus();
        btn_HitungZHarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int z;
                if ( (!editHargaEmas.getText().toString().equalsIgnoreCase("")) )  {

                    String convertCommaEmas = FormatRupiah.replaceDot(editHargaEmas.getText().toString().substring(4));

                    z = Integer.parseInt(edtHarta.getText().toString());
                    Double hargaEmas = Double.parseDouble(FormatRupiah.replaceCommaToEmpty(convertCommaEmas));

                    totZHarta = z * hargaEmas;
                    NisabZakatMal = 85.00 * hargaEmas;

                    DecimalFormat formatter = new DecimalFormat("#,###,###");
                    String RupiahNisabZakatMal = formatter.format(NisabZakatMal);

                    if(totZHarta >= NisabZakatMal ){
                        totZEmas = totZHarta * 0.025;
                        formatter = new DecimalFormat("#,###,###");
                        String RupiahtotZHarta = formatter.format(totZEmas);
                        textHZHarta.setText("Nisab Zakat Emas Rp. "+ RupiahNisabZakatMal + "\nsehingga Zakat Harta yang harus dikeluarkan sebesar Rp. " + RupiahtotZHarta );
                    }else{
                        textHZHarta.setText("Anda tidak berkewajiban mengeluarkan Zakat Emas (Maal) karena Nisab Zakat Maal Lebih Besar dari Zakat yang harus anda keluarkan");
                    }

                } else {
                    Toast.makeText(ZakatEmas.this, "Silahkan lengkapi data terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //        merubah editText menjadi bentuk Rp
        functionForm();
    }

    public void functionForm(){
        /* function edit text Harga Emas */
        editHargaEmas.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    hasConvert = false;
                } else {
                    if (editHargaEmas.getText().toString().equalsIgnoreCase("Rp. ")) {
                        hasConvert = true;
                        editHargaEmas.setText("");
                    }
                }
            }
        });
        TextWatcher fieldValidatorHargaEmas = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                hargaEmasRupiah = editHargaEmas.getText().toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(hargaEmasRupiah) && !hasConvertHargaEmas) {
                    editHargaEmas.removeTextChangedListener(this);
                    String cleanString = s.toString().replaceAll("[Rp,. ]", "");
                    if (cleanString != "") {
                        editHargaEmas.setText("Rp. " + FormatRupiah.formatCurrency(Double.parseDouble(cleanString)));
                    } else if (cleanString == "" && editHargaEmas.isFocused()) {
                        editHargaEmas.setText("Rp. ");
                    }
                    editHargaEmas.setSelection(editHargaEmas.getText().toString().length());
                    editHargaEmas.addTextChangedListener(this);
                }
            }
        };
        editHargaEmas.addTextChangedListener(fieldValidatorHargaEmas);

    }
}