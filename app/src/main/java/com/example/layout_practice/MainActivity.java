package com.example.layout_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;


public class MainActivity extends AppCompatActivity {

    TextInputEditText TextInputEditText_emil, TextInputEditText_password;
    TextView TextView_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //컴퍼런트 매칭 후 없는건 import

        TextInputEditText_emil = findViewById(R.id.TextInputEditText_email);
        TextInputEditText_password = findViewById(R.id.TextInputEditText_password);
        TextView_login = findViewById(R.id.TextView_login);

        //1. 값을 가져온다
        //2. 클릭을 감지한다
        //3. 1번의 값을 다음 엑티비티로 넘긴다

        TextView_login.setClickable(true);
        TextView_login.setOnClickListener(new View.OnClickListener() {  //클릭시 하고싶은 동작 작성
            @Override
            public void onClick(View v) {
                String email = TextInputEditText_emil.getText().toString();
                String password = TextInputEditText_password.getText().toString();

                //String 으로 값 받고 MainActivity 에서 LoginResultActivity 로 넘기기

                Intent intent = new Intent(MainActivity.this, LoginResultActivity.class);   //Activity 사용하려면 반드시 AndroidManifest.xml 에 선언
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                startActivity(intent);  //intent 를 실행하라
            }
        });
    }
}