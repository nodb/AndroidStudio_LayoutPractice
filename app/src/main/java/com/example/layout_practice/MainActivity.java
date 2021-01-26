package com.example.layout_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;


public class MainActivity extends AppCompatActivity {

    TextInputEditText TextInputEditText_email, TextInputEditText_password;
    TextView TextView_login;
    String emailOK = "123@gamil.com";
    String passwordOK = "1234";
    String inputEmail = "";
    String inputPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //컴퍼런트 매칭 후 없는건 import

        TextInputEditText_email = findViewById(R.id.TextInputEditText_email);
        TextInputEditText_password = findViewById(R.id.TextInputEditText_password);
        TextView_login = findViewById(R.id.TextView_login);

        //1. 값을 가져온다 - 검사 (123@gamil.com / 1234)
        //2. 클릭을 감지한다
        //3. 1번의 값을 다음 엑티비티로 넘긴다

        TextView_login.setClickable(false); //기본 로그인 비활성후 조건부 활성화
        TextInputEditText_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s != null) {    //null 체크 로직
                    Log.d("SENTI", s.toString());   //로그 확인용
                    inputEmail = s.toString();
                    TextView_login.setClickable(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        TextInputEditText_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s != null) {
                    Log.d("SENTI", s.toString());
                    inputPassword = s.toString();
                    TextView_login.setClickable(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

//        TextView_login.setClickable(true);
        TextView_login.setOnClickListener(new View.OnClickListener() {  //클릭시 하고싶은 동작 작성
            @Override
            public void onClick(View v) {
                String email = TextInputEditText_email.getText().toString();
                String password = TextInputEditText_password.getText().toString();

                //String 으로 값 받고 MainActivity 에서 LoginResultActivity 로 넘기기

                Intent intent = new Intent(MainActivity.this, LoginResultActivity.class);   //Activity 사용하려면 반드시 AndroidManifest.xml 에 선언
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                startActivity(intent);  //intent 를 실행하라
            }
        });
    }
    public boolean validation(){    //검사 함수
        return inputEmail.equals(emailOK)  && inputPassword.equals(passwordOK);  //자바에서 문자열 비교는 equals | == 는 사용 X
    }
}