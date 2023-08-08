package com.example.bmi_cal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//layout file is connected with this line



        //making var to store id(link)
        EditText edtWeight,edtHeightFt,edtHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout LiMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightFt);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        LiMain = findViewById(R.id.LiMain);

        //creating what will happen after clicks..
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //taking values from edit text
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());


                //bmi formula(weight in kilograms divided by height in meters squared)
                int totalIn = ft*12 + in;

                double totalCm = totalIn*2.53;

                double totoalM = totalCm/100;

                double bmi = wt/(totoalM*totoalM);

                //checking
                if(bmi>25){
                    txtResult.setText("You are over Weight");
                    LiMain.setBackgroundColor(getResources().getColor(R.color.Over_weight));
                    txtResult.setTextColor(getResources().getColor(R.color.white));
                    edtWeight.setTextColor(getResources().getColor(R.color.black));
                    edtHeightFt.setTextColor(getResources().getColor(R.color.black));
                    edtHeightIn.setTextColor(getResources().getColor(R.color.black));
                }
                else if(bmi<18){
                    txtResult.setText("You are under Weight");
                    LiMain.setBackgroundColor(getResources().getColor(R.color.Under_Wight));
                    txtResult.setTextColor(getResources().getColor(R.color.black));
                    edtWeight.setTextColor(getResources().getColor(R.color.black));
                    edtHeightFt.setTextColor(getResources().getColor(R.color.black));
                    edtHeightIn.setTextColor(getResources().getColor(R.color.black));
                }
                else {
                    txtResult.setText("You are Healthy");
                    LiMain.setBackgroundColor(getResources().getColor(R.color.Healthy));
                    txtResult.setTextColor(getResources().getColor(R.color.for_bgofTF));
                    edtWeight.setTextColor(getResources().getColor(R.color.black));
                    edtHeightFt.setTextColor(getResources().getColor(R.color.black));
                    edtHeightIn.setTextColor(getResources().getColor(R.color.black));
                }

            }
        });

    }

}