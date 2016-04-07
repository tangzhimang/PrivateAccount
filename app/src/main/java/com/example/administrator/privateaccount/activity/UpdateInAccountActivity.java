package com.example.administrator.privateaccount.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.administrator.privateaccount.R;

public class UpdateInAccountActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_update_in_account);

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
    }


    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID: {
                return new DatePickerDialog(this,mDateSetListener,mYear,mMonth,mDay);
            }
        }
        return super.onCreateDialog(id);
    }





    private void updateDisplay() {
        txtInTime.setText(new StringBuilder().append(mYear).append("-").append(mMonth + 1).append("-").append(mDay));
    }
}
