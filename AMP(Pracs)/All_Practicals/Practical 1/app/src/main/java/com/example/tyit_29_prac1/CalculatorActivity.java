package com.example.tyit_29_prac1;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class CalculatorActivity extends AppCompatActivity  {

    MaterialTextView mtvCalculate;

    TextInputLayout tilNum1;
    TextInputLayout tilNum2;


    TextInputEditText metNum1 ;
    TextInputEditText metNum2;

    Spinner spinnerOperator;

    //Material Button
    MaterialButton mbtn;
    MaterialTextView mtvResult;

    //Selected operator
    String operatorSelected="+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        /*
        VARIABLES
         */
        ArrayList<String> operatorsList=new ArrayList<>();
        operatorsList.add("+");
        operatorsList.add("-");
        operatorsList.add("*");
        operatorsList.add("/");

        /*
        VIEWS
         */
        //MaterialTextViews
        mtvCalculate= findViewById(R.id.mtvCalculate);
        mtvResult=findViewById(R.id.mtvResult);
        //MaterialTextInputLayout
        tilNum1= findViewById(R.id.tilNum1);
        tilNum2= findViewById(R.id.tilNum2);

        //TextInputEditText
        metNum1 =findViewById(R.id.metNum1);
        metNum2 =findViewById(R.id.metNum2);

        //Spinner
        spinnerOperator = findViewById(R.id.spinnerOperator);

        //Material Button
        mbtn=findViewById(R.id.mbtnCalcualte);

        /*
        MAIN CODE
         */

        //Add the dropdown options to the spinner
        ArrayAdapter<String> operatorArrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,operatorsList);
        operatorArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerOperator.setAdapter(operatorArrayAdapter);

        /*
        LISTENERS
         */

        //when spinner/dropdown item is selected
        spinnerOperator.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                operatorSelected= parent.getItemAtPosition(position).toString();
                Log.d("SPINNER","Value selected is"+operatorSelected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //when calculate button is clicked
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1=0, num2=0;
                //CHeck whether the fields are empty of not
                if (metNum1.getText()!= null) {
                    if(!metNum1.getText().toString().isEmpty()){
                        num1 = Double.valueOf(metNum1.getText().toString());
                        metNum1.setError(null);
                    }
                    else{
                        metNum1.setError("REQUIRED");
                    }


                } else {
                    metNum1.setError("REQUIRED");
                }

                if (metNum2.getText() != null) {
                    if(!metNum2.getText().toString().isEmpty()){
                        num2 = Double.valueOf(metNum2.getText().toString());
                        metNum2.setError(null);
                    }
                    else {
                        metNum2.setError("REQUIRED");

                    }

                } else {
                    metNum2.setError("REQUIRED");

                }
                if (tilNum1.getError() == null && tilNum2.getError() == null) {
                    double result=0;
                    // display the result
                    switch (operatorSelected) {
                        case "+":
                            result=num1+num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            result = num1 / num2;
                            break;
                        default:
                            result = num1 + num2;
                            break;
                    }
                    mtvResult.setVisibility(View.VISIBLE);
                    mtvResult.setText("Result:\n" + result);

                }
            }
        });
    }


    //FUNCTIONS

}