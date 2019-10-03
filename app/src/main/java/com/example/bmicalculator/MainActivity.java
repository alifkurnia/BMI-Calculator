package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.InputDevice;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editWeight, editHeigth;
    TextView hasil;
    Button buttonSubmit, buttonReset;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editWeight = (EditText) findViewById(R.id.editWeight);
        editHeigth = (EditText) findViewById(R.id.editHeight);
        hasil = (TextView) findViewById(R.id.hasilBb);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonReset = (Button) findViewById(R.id.buttonReset);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    int Weight = Integer.parseInt(editWeight.getText().toString());
                    double Height = Double.parseDouble(editHeigth.getText().toString());
                    double last = Weight / (Math.pow(Height,2));

                    if (last > 1 && last < 18.4){
                        hasil.setText("Hasil :\t"+" Kekurangan Berat Badan");
                    }
                    else if (last > 18.5 && last < 24.9){
                        hasil.setText("Hasil :\t"+" Berat Badan Normal (Ideal)");
                    }
                    else if (last > 25 && last < 30 ){
                        hasil.setText("Hasil :\t"+" Kelebihan Berat Badan");
                    }
                    else if (last > 30){
                        hasil.setText("Hasil :\t"+" Kegemukan (Obesitas)");
                    }
                    else {
                        hasil.setText("Pastikan data yang anda Inputkan sesuai dengan satuan!!");
                    }
                }
                catch (Exception e) {
                    Log.e("Error", String.valueOf(e));
                    hasil.setText("");
                    toast = Toast.makeText(getApplicationContext(), "data tidak boleh kosong", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editWeight.setText("");
                editHeigth.setText("");
                hasil.setText("");
                editWeight.requestFocus();
            }
        });
    }
}