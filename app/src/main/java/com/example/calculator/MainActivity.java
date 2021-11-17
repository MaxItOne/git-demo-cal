package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView txtLogic;
    TextView txtResult;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7 , btn8, btn9,btn0;
    Button btnAdd,btnSub, btnDelete, btnDevision, btnPoint, btnEqual, btnMul, btnClear;

    String currentNumber = "";
    float result = 0;

    List<Integer> arrNumber = new ArrayList<>();
    List<String>  arrOperation = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Calculator", "onCreate");
        mapping();
        setEvenOnClick();

    }


    private void mapping() {
        txtLogic  = findViewById(R.id.textViewLogic);
        txtResult = findViewById(R.id.textViewResult);

        btn0 = findViewById(R.id.buttonNumber0);
        btn1 = findViewById(R.id.buttonNumber1);
        btn2 = findViewById(R.id.buttonNumber2);
        btn3 = findViewById(R.id.buttonNumber3);
        btn4 = findViewById(R.id.buttonNumber4);
        btn5 = findViewById(R.id.buttonNumber5);
        btn6 = findViewById(R.id.buttonNumber6);
        btn7 = findViewById(R.id.buttonNumber7);
        btn8 = findViewById(R.id.buttonNumber8);
        btn9 = findViewById(R.id.buttonNumber9);

        btnAdd      = findViewById(R.id.buttonAdd);
        btnSub      = findViewById(R.id.buttonSub);
        btnMul      = findViewById(R.id.buttonMul);
        btnDevision = findViewById(R.id.buttonDivision);
        btnDelete  = findViewById(R.id.buttonDelete);
        btnPoint    = findViewById(R.id.buttonPoint);
        btnEqual    = findViewById(R.id.buttonEqual);
        btnClear    = findViewById(R.id.buttonClear);


    }
    private void setEvenOnClick() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDevision.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
    }

  /* boolean bracket = true;
    public void buttonBracket(View view){
        if (bracket){
            setValue("(");
            bracket = false;
        }else {
            setValue(")");
            bracket = true;
        }
    }
*/
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Calculator", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Calculator", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Calculator", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Calculator", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Calculator", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Calculator", "onDestroy");
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonNumber0:
                txtLogic.append("0");
                currentNumber = currentNumber+"0";
                break;
            case R.id.buttonNumber1:
                txtLogic.append("1");
                currentNumber = currentNumber+"1";
                break;
            case R.id.buttonNumber2:
                txtLogic.append("2");
                currentNumber = currentNumber+"2";
                break;
            case R.id.buttonNumber3:
                txtLogic.append("3");
                currentNumber = currentNumber+"3";
                break;
            case R.id.buttonNumber4:
                txtLogic.append("4");
                currentNumber = currentNumber+"4";
                break;
            case R.id.buttonNumber5:
                txtLogic.append("5");
                currentNumber = currentNumber+"5";
                break;
            case R.id.buttonNumber6:
                txtLogic.append("6");
                currentNumber = currentNumber+"6";
                break;
            case R.id.buttonNumber7:
                txtLogic.append("7");
                currentNumber = currentNumber+"7";
                break;
            case R.id.buttonNumber8:
                txtLogic.append("8");
                currentNumber = currentNumber+"8";
                break;
            case R.id.buttonNumber9:
                txtLogic.append("9");
                currentNumber = currentNumber+"9";
                break;

            case R.id.buttonClear:
                txtLogic.setText("");
                txtResult.setText("");
                arrNumber.clear();
                arrOperation.clear();
                break;
            case R.id.buttonAdd:
                txtLogic.append("+");
                arrOperation.add("+");
                if(!currentNumber.equals("")) {
                    arrNumber.add(Integer.parseInt(currentNumber));
                    currentNumber = "";
                }
                break;
            case R.id.buttonSub:
                txtLogic.append("-");
                arrOperation.add("-");
                if(!currentNumber.equals("")) {
                    arrNumber.add(Integer.parseInt(currentNumber));
                    currentNumber = "";
                }
                break;
            case R.id.buttonMul:
                txtLogic.append("*");
                arrOperation.add("*");
                if(!currentNumber.equals("")) {
                    arrNumber.add(Integer.parseInt(currentNumber));
                    currentNumber = "";
                }
                break;
            case R.id.buttonDivision:
                txtLogic.append("/");
                arrOperation.add("/");
                if(!currentNumber.equals("")) {
                    arrNumber.add(Integer.parseInt(currentNumber));
                    currentNumber = "";
                }
                break;
            case R.id.buttonPoint:
                txtLogic.append(".");
                currentNumber = currentNumber + ".";
                break;
            case R.id.buttonDelete:
                String delete = removeData(txtLogic.getText().toString());
                txtLogic.setText(delete);
               // String temp = removeData(currentNumber);
               // currentNumber = temp;
                break;


            case R.id.buttonEqual:
                DecimalFormat df = new DecimalFormat("#.####");
                if(!currentNumber.equals(""))
                    arrNumber.add(Integer.parseInt(currentNumber));
                if( arrNumber.size()-1==arrOperation.size()){
                    for(int i = 0 ; i < arrOperation.size(); i ++){
                    switch (arrOperation.get(i)){
                        case "+":
                            if(i == 0 ){
                                result = arrNumber.get(i) + arrNumber.get(i + 1);
                            }else{
                                result += arrNumber.get(i + 1);
                            }
                            break;
                        case "-":
                            if(i == 0 ){
                                result = arrNumber.get(i) - arrNumber.get(i + 1);
                            }else{
                                result -= arrNumber.get(i + 1);
                            }
                            break;
                        case "*":
                            if(i == 0 ){
                                result = (float) (arrNumber.get(i) * arrNumber.get(i + 1)* 1.0);
                            }else{
                                result *= arrNumber.get(i + 1);
                            }
                            break;
                        case "/":
                            if(i == 0 ){
                                result = (float) arrNumber.get(i)/ arrNumber.get(i + 1);
                            }else{
                                result /= (float)arrNumber.get(i + 1);
                            }
                            break;
                        case "":
                            result = result + Integer.parseInt(currentNumber);
                        }
                    }
                    txtResult.setText(""+df.format(result));
                    clearData();
                }else{
                        Toast.makeText(MainActivity.this, "Phép tính sai", Toast.LENGTH_SHORT).show();
                    }
                break;
        }

    }

    private void clearData() {
        currentNumber = "";
        result = 0;
    }
    public String removeData(String temp) {
            temp = temp.substring(0, temp.length() -1 );
        return temp;
    }
}