package com.example.zac.prcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {



    protected static final String TAG;

    static {
        TAG = "ZacsMessage";
    }
    private int max;
    private String lbs_or_kgs = " pounds";
    private String str_reps;
    private int weight;
    private int reps;
    private String message;

    public boolean isStringInt(String s)
    {
        try {
            Integer.parseInt(s);

            return true;
        }
        catch (NumberFormatException ex){

            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch switch1 = (Switch) findViewById(R.id.switch1);

        switch1.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            lbs_or_kgs = " kilograms.";
                        } else {
                            lbs_or_kgs = " pounds.";
                        }
                    }
                }
        );


        Button calcButton = (Button) findViewById(R.id.calcButton);


        calcButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView message_CalcedMax = (TextView) findViewById(R.id.calcedMax);

                        EditText str1_weight = (EditText) findViewById(R.id.weight);
                        final String str_weight = str1_weight.getText().toString();

                        EditText str1_reps = (EditText) findViewById(R.id.reps);
                        str_reps = str1_reps.getText().toString();


                        if (isStringInt(str_weight) && isStringInt(str_reps)) {
                            weight = Integer.parseInt(str_weight);
                            reps = Integer.parseInt(str_reps);
                            if(reps == 0){
                                max = 0;
                            }
                            else if(reps == 1){
                                max = weight;
                            }
                            else {
                                max = (((weight * reps) / 30) + weight);
                            }
                            message = "Your calculated max = " + max + lbs_or_kgs;
                        } else {
                            message = "Please enter a valid integer.";
                        }

                        message_CalcedMax.setText(message);
                    }
                }
        );
    }





    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
