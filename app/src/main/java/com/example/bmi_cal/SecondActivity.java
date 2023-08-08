package com.example.bmi_cal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        Intent fromActivity = getIntent();
        // Get the string values from the intent extras
        String weightString = fromActivity.getStringExtra("Weight");
        String heightFtString = fromActivity.getStringExtra("Height");
        String heightInString = fromActivity.getStringExtra("heightIn");

//        String weightString = fromActivity.getStringExtra("Weight");
//        String heightFtString = fromActivity.getStringExtra("Height");
//        String heightInString = fromActivity.getStringExtra("heightIn");

        // Initialize default values
        double Weight = 0.0;
        int Height = 0;
        int heightIn = 0;

        // Parse the strings if they are not null
        if (weightString != null) {
            Weight = Double.parseDouble(weightString);
        }

        if (heightFtString != null) {
            Height = Integer.parseInt(heightFtString);
        }

        if (heightInString != null) {
            heightIn = Integer.parseInt(heightInString);
        }

        TextView txtWeightinfo;
        TextView txtHeightinfo;
        TextView txtHeightInInfo;

        txtWeightinfo = findViewById(R.id.WeightInfo);
        txtHeightinfo = findViewById(R.id.HeightInfo);
        txtHeightInInfo = findViewById(R.id.HeightInInfo);

        txtWeightinfo.setText("Weight is: " + Weight);
        txtHeightinfo.setText("Height is: " + Height); // Change "Weight is" to "Height is"
        txtHeightInInfo.setText("HeightIn is: " + heightIn); // Change "Weight is" to "HeightIn is"

        getSupportActionBar().setTitle("Weight Info");
//        TextView txtWeightinfo;
//        TextView txtHeightinfo;
//        TextView txtHeightInInfo;
//
//        txtWeightinfo = findViewById(R.id.WeightInfo);
//        txtHeightinfo = findViewById(R.id.HeightInfo);
//        txtHeightInInfo = findViewById(R.id.HeightInInfo);
//
//        txtWeightinfo.setText("Weight is: "+Weight);
//        txtHeightinfo.setText("Weight is: "+Height);
//        txtHeightInInfo.setText("Weight is: "+heightIn);
//
//        getSupportActionBar().setTitle("Weight Info");
    }
}