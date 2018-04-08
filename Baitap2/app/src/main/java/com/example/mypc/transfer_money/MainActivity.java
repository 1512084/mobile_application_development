package com.example.mypc.transfer_money;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputVND=(EditText) findViewById(R.id.editTextInputVND);
        final EditText inputUSD=(EditText) findViewById(R.id.editTextInputUSD);
        Button USD=(Button) findViewById(R.id.USD);
        Button VND=(Button) findViewById(R.id.VND);

        USD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean error=false;
                String check=inputVND.getText().toString();
                int temp=0;
                for (int i=0; i<check.length();i++) if(check.codePointAt(i)==46) temp++;
                for(int i=0;i<check.length();i++) if ((check.codePointAt(i)<48 &&check.codePointAt(i)!=46)|| check.codePointAt(i)>57||temp>1) {
                    Toast.makeText(MainActivity.this, "Yeu cau nhap chinh xac!", Toast.LENGTH_SHORT).show();
                    error=true;
                    //break;
                      }
                if(!error) {
                    if (inputVND.getText().toString().equals("") == false) {
                        String InputI = inputVND.getText().toString();
                        float temp1 = Float.parseFloat(InputI);
                        float result = (float) temp1 / 22727;
                        inputUSD.setText((float) result + "");
                        Toast.makeText(MainActivity.this, result + "$", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        VND.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean error=false;
                String check=inputUSD.getText().toString();
                int temp=0;
                for (int i=0; i<check.length();i++) if(check.codePointAt(i)==46) temp++;
                for(int i=0;i<check.length();i++) if ((check.codePointAt(i)<48&&check.codePointAt(i)!=46) || check.codePointAt(i)>57 || temp>1) {
                    Toast.makeText(MainActivity.this, "Yeu cau nhap chinh xac!", Toast.LENGTH_SHORT).show();
                    error=true;
                    //break;
                }
               // inputVND.setText(inputVND+"");
                if(!error) {
                    if (inputUSD.getText().toString().equals("") == false) {
                        String InputI = inputUSD.getText().toString();
                        float temp1 = Float.parseFloat(InputI);
                        float result = (float) temp1 * 22727;
                        inputVND.setText((float) result + "");
                        Toast.makeText(MainActivity.this, result + "VND", Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }



}
