package com.example.tablecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1,edtNum2;
    Button numButton []= new Button[10];
    Integer numButtonID[]={R.id.btn0, R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4, R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9};
    //0~9버튼을 배열로 생성하였다.
    Button btnadd,btnsub,btnmul,btndiv;
    TextView tvresult;
    String strNum1,strnum2;
//    Edit text 에 있는 문자열을 숫자로 변환하기 위해 Siring 선언
    int result;
//  정수값 입력
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum1=(EditText)findViewById(R.id.edtNum1);
        edtNum2=(EditText)findViewById(R.id.edtNum2);
        for (int i=0; i<numButtonID.length ; i++) {
            numButton[i]=(Button)findViewById(numButtonID[i]);
        }
        btnadd=(Button)findViewById(R.id.btnadd);
        btnsub=(Button)findViewById(R.id.btnsub);
        btndiv=(Button)findViewById(R.id.btndiv);
        btnmul=(Button)findViewById(R.id.btnmul);
        tvresult=(TextView)findViewById(R.id.tvresult);

        for (int i=0; i<numButtonID.length; i++) {
            final int index;
            index=i;
            //        내부 변수를 적용하여, strNum1=edtNum1.getText().toString() + numButton[i].getText().toString(); 배열 i값이 고정 될 수 있도록 적용해야 한다.
            //        final int index;
            //        index=i;
            numButton[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(edtNum1.isFocused()==true) {
                        strNum1=edtNum1.getText().toString() + numButton[index].getText().toString();
                        // 예를들어서 2,6 을 입력하면 1번째 커서 란에 문자열로 "2"+"6"    26 이라는 문자열이 입력됨
                        edtNum1.setText(strNum1);
                        // 26 이라는 문자열을 set 한다 edtNum1로
                    }else if (edtNum2.isFocused()==true) {
                        strnum2=edtNum2.getText().toString() + numButton[index].getText().toString();
                        edtNum2.setText(strnum2);

                    }else {
                        Toast.makeText(getApplicationContext(), "먼저 에디터텍스트를 선택해주세요.", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNum1=edtNum1.getText().toString();
                strnum2=edtNum2.getText().toString();
                result= Integer.parseInt(strNum1)+ Integer.parseInt(strnum2);
                tvresult.setText("계산결과 : "+result);
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNum1=edtNum1.getText().toString();
                strnum2=edtNum2.getText().toString();
                result= Integer.parseInt(strNum1)- Integer.parseInt(strnum2);
                tvresult.setText("계산결과 : "+result);
            }
        });

        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNum1=edtNum1.getText().toString();
                strnum2=edtNum2.getText().toString();
                result= Integer.parseInt(strNum1)* Integer.parseInt(strnum2);
                tvresult.setText("계산결과 : "+result);
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strNum1=edtNum1.getText().toString();
                strnum2=edtNum2.getText().toString();
                result= Integer.parseInt(strNum1)/ Integer.parseInt(strnum2);
                tvresult.setText("계산결과 : "+result);
            }
        });
    }
}
