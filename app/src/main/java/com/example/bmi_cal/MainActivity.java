package com.example.bmi_cal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
        Button btnNext;
        //adding animation on the result
        TextView txtResult;
        //adding buttons
        Button btnTranslate,btnAlpha,btnRoatate,btnScale;

        LinearLayout LiMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnNext = findViewById(R.id.btnNext);
        //adding animation on the result
        txtResult = findViewById(R.id.txtResult);
        //id finding
        btnTranslate = findViewById(R.id.btnTranslate);
        btnAlpha = findViewById(R.id.btnAlpha);
        btnRoatate = findViewById(R.id.btnRoatate);
        btnScale = findViewById(R.id.btnScale);

        LiMain = findViewById(R.id.LiMain);



        //creating listener for animation buttons
        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation move = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
                txtResult.startAnimation(move);

            }
        });
        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation alpha = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
                txtResult.startAnimation(alpha);

            }
        });
        btnRoatate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                txtResult.startAnimation(rotate);

            }
        });
        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation scale = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);
                txtResult.startAnimation(scale);

            }
        });
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
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iNext;

                //telling intent that we are currently on main class and we want to go to second class
                iNext = new Intent(MainActivity.this, SecondActivity.class);
                // Get the values from the EditText fields
                String weightValue = edtWeight.getText().toString();
                String heightFtValue = edtHeightFt.getText().toString();
                String heightInValue = edtHeightIn.getText().toString();

                // Pass the values to the intent extras
                iNext.putExtra("Weight", weightValue);
                iNext.putExtra("Height", heightFtValue);
                iNext.putExtra("heightIn", heightInValue);
                startActivity(iNext);

            }
        });

    }

}