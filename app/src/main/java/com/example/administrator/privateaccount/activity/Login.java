package com.example.administrator.privateaccount.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.privateaccount.R;

public class Login extends AppCompatActivity implements View.OnClickListener{

    private EditText editText;
    private Button loginButton;
    private Button closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText = (EditText) findViewById(R.id.txtLogin);
        loginButton = (Button) findViewById(R.id.btnLogin);
        closeButton = (Button) findViewById(R.id.btnClose);
        loginButton.setOnClickListener(this);
        closeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogin: {

                break;
            }
            case R.id.btnClose: {
                finish();
                break;
            }
            default:
                break;
        }
    }
}
