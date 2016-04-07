package com.example.administrator.privateaccount.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrator.privateaccount.R;
import com.example.administrator.privateaccount.dao.Tb_inaccount;
import com.example.administrator.privateaccount.db.AccountDB;

import java.util.Calendar;

public class addinaccunt extends AppCompatActivity {

    protected static final int DATE_DIALOG_ID = 0;
    private EditText txtInMoney,txtInTime,txtInHandler,txtInMark;
    private Spinner spInType;
    private Button SaveButton,CancelButton;
    private int mYear,mMonth,mDay;

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            updateDisplay();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addinaccunt);
        txtInMoney = (EditText)findViewById(R.id.moneyEditText);
        txtInTime = (EditText)findViewById(R.id.timeEditText);
        txtInHandler = (EditText)findViewById(R.id.handlerEditText);
        txtInMark = (EditText)findViewById(R.id.remarkEditText);
        spInType = (Spinner)findViewById(R.id.spinerType);
        SaveButton = (Button)findViewById(R.id.saveButton);
        CancelButton = (Button)findViewById(R.id.cancelButton);

        txtInTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });
        final Calendar calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        updateDisplay();

        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringMoney = txtInMoney.getText().toString();
                String stringTime = txtInTime.getText().toString();
                String stringHandler = txtInHandler.getText().toString();
                String stringMark = txtInMark.getText().toString();
                String stringType = spInType.getSelectedItem().toString();
                if (!(TextUtils.isEmpty(stringMoney) || TextUtils.isEmpty(stringHandler))) {
                    AccountDB accountDB = AccountDB.getInstance(addinaccunt.this);
                    Tb_inaccount tb_inaccount = new Tb_inaccount(Double.parseDouble(stringMoney), stringTime, stringType, stringHandler, stringMark);
                    accountDB.saveInAccount(tb_inaccount);
                    Toast.makeText(addinaccunt.this, "保存成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(addinaccunt.this, "请输入完整信息", Toast.LENGTH_SHORT).show();
                }
            }
        });

        CancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtInMoney.setText("");
                txtInHandler.setText("");
                txtInMark.setText("");
                spInType.setSelection(0);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID: {
                return new DatePickerDialog(this,mDateSetListener,mYear,mMonth,mDay);
            }
        }
        return super.onCreateDialog(id);
    }

    private void updateDisplay() {
        txtInTime.setText(new StringBuilder().append(mYear).append("-").append(mMonth+1).append("-").append(mDay));
    }
}
