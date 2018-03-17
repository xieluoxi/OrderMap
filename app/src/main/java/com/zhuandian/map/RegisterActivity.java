package com.zhuandian.map;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.ed_password)
    EditText edPassword;
    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_register)
    public void onViewClicked() {
        SharedPreferences sp = getSharedPreferences("user", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        if (edPassword.getText().toString().length() < 1
                || edPassword.getText().toString().length() < 1) {
            Toast.makeText(this, "Information is not allowed to be empty.", Toast.LENGTH_SHORT).show();
            return;
        }
        edit.putString("username", etUsername.getText().toString());
        edit.putString("password", edPassword.getText().toString());
        edit.commit();
        Toast.makeText(this, "Registered successfully.", Toast.LENGTH_SHORT).show();
    }
}
