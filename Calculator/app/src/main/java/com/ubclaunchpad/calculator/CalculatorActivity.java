package com.ubclaunchpad.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener{
    private final static String TAG = CalculatorActivity.class.getSimpleName();
    private final String ERROR_MESSAGE="Invalid format";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

    }

    /**
     * This implementation of the click listener is for the view found in res/layout/activity_calculator
     * The functions in general should grab the appropriate inputs, and if they are valid, computes the answer.
     * The answer should be displayed in a second activity labelled "AnswerActivity"
     * @param v
     */
    @Override
    public void onClick(View v) {

        EditText firstText;
        EditText secondText;

        Double firstNum;
        Double secondNum;


        switch (v.getId())
        {
            case R.id.operation_add:

                firstText = (EditText) findViewById(R.id.firstInput);
                secondText = (EditText) findViewById(R.id.secondInput);
                doOperation(firstText,secondText,'+');
                break;

            case R.id.operation_sub:
                firstText = (EditText) findViewById(R.id.firstInput);
                secondText = (EditText) findViewById(R.id.secondInput);
                doOperation(firstText,secondText,'-');
                break;

            case R.id.operation_multi:
                firstText = (EditText) findViewById(R.id.firstInput);
                secondText = (EditText) findViewById(R.id.secondInput);
                doOperation(firstText,secondText,'*');
                break;

            case R.id.operation_div:
                firstText = (EditText) findViewById(R.id.firstInput);
                secondText = (EditText) findViewById(R.id.secondInput);
                doOperation(firstText,secondText,'/');
                break;

            case R.id.operation_extra1:
                startNewExtraActivity("operation1");
                break;

            case R.id.operation_extra2:
                startNewExtraActivity("operation2");
                break;

            case R.id.operation_extra3:
                startNewExtraActivity("operation3");
                break;

            default:

                Toast.makeText(this, "Click not implmented yet", Toast.LENGTH_LONG).show();
                Log.e(TAG, "View id: " + v.getId() + " click not implemented yet");
                break;

        }
    }

    private Double getDouble(String string)     //Returns double in wrapper class. Returns null incase of Number format exception
    {
        Double number=null;

        try
        {
           number= Double.parseDouble(string);
        }
        catch(NumberFormatException e)
        {
            return null;
        }
        return number;
    }

    /*Does the operation*/
    private void doOperation (EditText firstText, EditText secondText, char operation)
    {
        Double firstNum = getDouble(firstText.getText().toString());
        Double secondNum = getDouble(secondText.getText().toString());
        String answer;

        if(firstNum == null || secondNum == null)
        {
            startNewActivity(ERROR_MESSAGE);
        }
        else
        {
            switch(operation)
            {
                case '+':
                    answer=Double.toString(firstNum+secondNum);
                    startNewActivity(answer);
                    break;
                case '-':
                    answer=Double.toString(firstNum-secondNum);
                    startNewActivity(answer);
                    break;
                case '*':
                    answer=Double.toString(firstNum*secondNum);
                    startNewActivity(answer);
                    break;
                case '/':
                    if(secondNum==0)
                        startNewActivity("Cannot divide by zero");
                    else
                    {
                        answer=Double.toString(firstNum/secondNum);
                        startNewActivity(answer);
                    }
                    break;
            }
        }
    }

    private void startNewActivity (String message)    //Starts new activity
    {
        Intent intent = new Intent(getApplicationContext(),AnswerActivity.class);
        intent.putExtra("Extra", message);
        startActivity(intent);
    }

    private void startNewExtraActivity(String message)  //Seperate activity for optional parts
    {
        Intent intent = new Intent(getApplicationContext(),ExtraAcitivty.class);
        intent.putExtra("Extra",message);
        startActivity(intent);
    }


}
