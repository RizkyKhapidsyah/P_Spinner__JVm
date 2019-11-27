package com.rizkykhapidsyah.p_spinner__jvm;

/* Created by Rizky Khapidsyah.
* An example how to using basic Spinner operations for student.
* Sometimes this is not efficient. Fix them. Thanks.
* Just write and share.
* */

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView TV_KotaAwal_IDJAVA, TV_KotaAkhir_IDJAVA, TV_Biaya_IDJAVA, TV_BiayaHasil_IDJAVA;
    Button B_Proses_IDJAVA, B_Keluar_IDJAVA;
    Spinner S_KotaAwal_IDJAVA, S_KotaAkhir_IDJAVA;

    String[] List_NamaKota = {
            "Banda Aceh",
            "Medan",
            "Pekan Baru",
            "Padang",
            "Jambi"
    };

    String[] IDR = {
            "Rp",
            "Rute Dengan Tujuan: ",
            " - ",
            ". Dikenakan Biaya Sebesar: ",
            "(Klik Tombol 'Proses' Untuk Melihat Total Biaya)"
    };

    String[] Info = {
            "Kota Awal: ",
            "Kota Tujuan: "
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TV_KotaAwal_IDJAVA = findViewById(R.id.TV_KotaAwal_IDXML);
        TV_KotaAkhir_IDJAVA = findViewById(R.id.TV_KotaAkhir_IDXML);
        TV_Biaya_IDJAVA = findViewById(R.id.TV_Biaya_IDXML);
        TV_BiayaHasil_IDJAVA = findViewById(R.id.TV_BiayaHasil_IDXML);
        B_Proses_IDJAVA = findViewById(R.id.B_Proses_IDXML);
        B_Keluar_IDJAVA = findViewById(R.id.B_Keluar_IDXML);
        S_KotaAwal_IDJAVA = findViewById(R.id.S_KotaAwal_ID_XML);
        S_KotaAkhir_IDJAVA = findViewById(R.id.S_KotaAkhir_ID_XML);

        TV_BiayaHasil_IDJAVA.setText(IDR[4]);

        S_KotaAwal_IDJAVA.setOnItemSelectedListener(this);
        S_KotaAkhir_IDJAVA.setOnItemSelectedListener(this);

        ArrayAdapter AdapterSpinner = new ArrayAdapter(this, android.R.layout.simple_spinner_item, List_NamaKota);
        AdapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        S_KotaAwal_IDJAVA.setAdapter(AdapterSpinner);
        S_KotaAkhir_IDJAVA.setAdapter(AdapterSpinner);

        B_Proses_IDJAVA.setOnClickListener(new View.OnClickListener() {
            int HargaTransportasi, HargaAdmin, TotalBiaya;

            @Override
            public void onClick(View v) {
                if (S_KotaAwal_IDJAVA.getSelectedItemPosition() == S_KotaAkhir_IDJAVA.getSelectedItemPosition()) {
                    HargaTransportasi = 10000;
                    HargaAdmin = 1000;
                } else {
                    switch (S_KotaAwal_IDJAVA.getSelectedItemPosition()) {
                        case 0:
                            if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 1) {
                                HargaTransportasi = 30000;
                                HargaAdmin = 2000;
                            } else if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 2) {
                                HargaTransportasi = 75000;
                                HargaAdmin = 3500;
                            } else if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 3) {
                                HargaTransportasi = 83000;
                                HargaAdmin = 3600;
                            } else if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 4) {
                                HargaTransportasi = 96000;
                                HargaAdmin = 5000;
                            }
                            break;
                        case 1:
                            if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 0) {
                                HargaTransportasi = 27000;
                                HargaAdmin = 2000;
                            } else if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 2) {
                                HargaTransportasi = 35000;
                                HargaAdmin = 2500;
                            } else if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 3) {
                                HargaTransportasi = 40000;
                                HargaAdmin = 3200;
                            } else if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 4) {
                                HargaTransportasi = 65000;
                                HargaAdmin = 4000;
                            }
                            break;
                        case 2:
                            if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 0) {
                                HargaTransportasi = 40000;
                                HargaAdmin = 5000;
                            } else if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 1) {
                                HargaTransportasi = 30000;
                                HargaAdmin = 4500;
                            } else if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 3) {
                                HargaTransportasi = 35000;
                                HargaAdmin = 3200;
                            } else if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 4) {
                                HargaTransportasi = 57000;
                                HargaAdmin = 5000;
                            }
                            break;
                        case 3:
                            if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 0) {
                                HargaTransportasi = 65000;
                                HargaAdmin = 7000;
                            } else if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 1) {
                                HargaTransportasi = 50000;
                                HargaAdmin = 4000;
                            } else if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 2) {
                                HargaTransportasi = 38000;
                                HargaAdmin = 3000;
                            } else if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 4) {
                                HargaTransportasi = 30000;
                                HargaAdmin = 2000;
                            }
                            break;
                        case 4:
                            if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 0) {
                                HargaTransportasi = 90000;
                                HargaAdmin = 10200;
                            } else if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 1) {
                                HargaTransportasi = 85000;
                                HargaAdmin = 6000;
                            } else if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 2) {
                                HargaTransportasi = 70000;
                                HargaAdmin = 3500;
                            } else if (S_KotaAkhir_IDJAVA.getSelectedItemPosition() == 3) {
                                HargaTransportasi = 55000;
                                HargaAdmin = 2500;
                            }
                            break;
                    }
                }
                TotalBiaya = HargaTransportasi + HargaAdmin;
                String X = new String(String.valueOf(TotalBiaya));
                TV_BiayaHasil_IDJAVA.setText(IDR[0] + X);

                Toast.makeText(MainActivity.this,
                        IDR[1] + S_KotaAwal_IDJAVA.getSelectedItem().toString() + IDR[2] + S_KotaAkhir_IDJAVA.getSelectedItem().toString() + "\n" + IDR[3] + IDR[0] + X,
                        Toast.LENGTH_LONG).show();
            }
        });

        B_Keluar_IDJAVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder KotakPesan = new AlertDialog.Builder(MainActivity.this);
                AlertDialog Buat_KotakPesan;

                KotakPesan
                        .setMessage(R.string.BertanyaKeluar)
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false)
                        .setPositiveButton(R.string.JawabanPositif, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface Tombol, int ID) {
                                MainActivity.this.finish();
                            }
                        })
                        .setNegativeButton(R.string.JawabanNegatif, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface Tombol, int ID) {
                                Tombol.cancel();
                            }
                        });
                Buat_KotakPesan = KotakPesan.create();
                Buat_KotakPesan.show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {
        Toast.makeText(MainActivity.this,
                Info[0] + S_KotaAwal_IDJAVA.getSelectedItem().toString() + "\n" +
                        Info[1] + S_KotaAkhir_IDJAVA.getSelectedItem().toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Kosong
    }
}
