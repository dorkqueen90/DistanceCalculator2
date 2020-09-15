/*  Assignment#:    InClass02
    File Name:      inClass2b
    Full Name:      Amber Sibel
 */
package com.example.inclass2b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    double meterAnswer;
    EditText text;
    TextView textResult;
    TextView resultLabel;
    String label;
    RadioGroup selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.editTextDistance);
        textResult = (TextView) findViewById(R.id.textViewAnswer);
        resultLabel = (TextView) findViewById(R.id.textViewResult);
        selected = (RadioGroup) findViewById(R.id.buttonGroup);

        findViewById(R.id.buttonInches).setOnClickListener(this);
        findViewById(R.id.buttonFeet).setOnClickListener(this);
        findViewById(R.id.buttonMiles).setOnClickListener(this);
        findViewById(R.id.buttonClearAll).setOnClickListener(this);
        findViewById(R.id.buttonConvert).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //error check, display toast message and prevent conversion
        if(text.getText().toString().length() < 1) {
            Toast.makeText(getApplicationContext(), "Sorry, there was an error",
                    Toast.LENGTH_LONG).show();
        }
        switch(v.getId()){
            case R.id.buttonInches:
            //1 Meter = 39.3701 Inch
            meterAnswer = Double.parseDouble(text.getText().toString()) * 39.3701;
            label = "Inches:";
            break;
            case R.id.buttonFeet:
            //1 Meter = 3.28 Foot
            meterAnswer = Double.parseDouble(text.getText().toString()) * 3.28;
            label = "Feet:";
            break;
            case R.id.buttonMiles:
            //1 Meter = 0.0006 Mile
            meterAnswer = Double.parseDouble(text.getText().toString()) * .0006;
            label = "Miles:";
            break;
            case R.id.buttonClearAll:
                //clear entered distance and result
                label = "Result:";
            break;
            case R.id.buttonConvert:
                if(selected.getCheckedRadioButtonId() == R.id.buttonClearAll) {
                    text.setText("");
                    textResult.setText("");
                    resultLabel.setText(label);
                } else {
                    resultLabel.setText(label);
                    textResult.setText(String.valueOf(meterAnswer));
                }
        }
    }
}
