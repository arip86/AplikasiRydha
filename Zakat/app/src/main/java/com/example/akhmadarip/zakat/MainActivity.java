package com.example.akhmadarip.zakat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public Spinner spinnerKategori;
    public Button btnHitung;
    public EditText editInputZakat;
    public Double input, hasil;
    ArrayList<String> kategori = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Toast.makeText(getApplicationContext(), "Selamat datang di apps zakat", Toast.LENGTH_SHORT).show();

        editInputZakat = (EditText) findViewById(R.id.formInput);

        spinnerKategori = (Spinner) findViewById(R.id.spinner);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, kategori);
        kategori.add("Zakat fitrah");
        kategori.add("Zakat profesi");
        kategori.add("Zakat mal");
        spinnerKategori.setAdapter(adapter);

        btnHitung = (Button) findViewById(R.id.button);
        btnHitung.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                hitungZakat();

            }

        });

    }
    public void hitungZakat() {
        if (editInputZakat.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Isi Gaji anda", Toast.LENGTH_SHORT);

        } else {
            input = Double.parseDouble(editInputZakat.getText().toString());
            if (input >= 4000000) {
                if (spinnerKategori.getLastVisiblePosition() == 1) {
                    hasil = input * 0.025;
                    showDialog(String.valueOf(hasil) + "Rp (2.5% dari total gaji");
                } else if (spinnerKategori.getLastVisiblePosition() == 2) {
                    hasil = input * 0.025;
                    //hitungannya masih salah
                    // yang benar adalah 0.025 * input
                    showDialog(String.valueOf(hasil) + "Rp (2.5% dari total pendapatan)");
                }
                } else {
                    showDialog("harta anda belum nisab");
                }
            }

        }


            public void showDialog(String pesan){
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("Hasil Perhitungan");
                alertDialogBuilder
                        .setMessage(pesan)
                        .setCancelable(false)
                        .setNeutralButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }

                        });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
    }




