package com.example.intentsenddataback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tvReceiveName, tvReceiveRollNo, tvReceivePhoneNo;
    EditText etTeacherName, etTeacherPhoneNo, etTeacherAddress;
    Button btnSendBack;

    public static final String TEACHER_NAME = "Name";
    public static final String TEACHER_PHONE_NO = "Phone";
    public static final String TEACHER_ADDRESS = "Address";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvReceiveName = findViewById(R.id.tvReceiveName);
        tvReceivePhoneNo = findViewById(R.id.tvReceivePhoneNo);
        tvReceiveRollNo = findViewById(R.id.tvReceiveRollNo);
        etTeacherName = findViewById(R.id.etTeacherName);
        etTeacherPhoneNo = findViewById(R.id.etTeacherPhoneNo);
        etTeacherAddress = findViewById(R.id.etTeacherAddress);
        btnSendBack = findViewById(R.id.btnSendBack);
        btnSendBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBack();
            }
        });
        Intent intent = getIntent();
        String rName = intent.getStringExtra(MainActivity.KEY_NAME);
        String rRollNo = intent.getStringExtra(MainActivity.KEY_ROLL_NO);
        String rPhoneNo = intent.getStringExtra(MainActivity.KEY_PHONE_NO);
        tvReceiveName.setText(rName);
        tvReceiveRollNo.setText(rRollNo);
        tvReceivePhoneNo.setText(rPhoneNo);
    }

    @Override
    public void finish() {
        sendBack();
        super.finish();
    }

    public void sendBack() {
        String sTeacherName = etTeacherName.getText().toString();
        String sTeacherPhoneNo = etTeacherPhoneNo.getText().toString();
        String sTeacherAddress = etTeacherAddress.getText().toString();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(TEACHER_NAME, sTeacherName);
        intent.putExtra(TEACHER_PHONE_NO, sTeacherPhoneNo);
        intent.putExtra(TEACHER_ADDRESS, sTeacherAddress);
        startActivity(intent);
    }
}
//TODO:10. Make the Second Empty Activity and Design xml
//TODO:11. Initialize the Variables and find View by Ids of all
//TODO:12. Make Global keys                                                                               line No 17-19
//TODO:13. Make getIntent and retrive Data from Intent and set on Text Views                              line No 38=44
//TODO:14. Make Click Listener of the Button                                                              line No 32
//TODO:15. Make a method ,convert EditText into string format and initialize the Intent                   Line No 53=61
//TODO:16. Call this Method in the ClickListener                                                          Line No 35
//TODO:17. Make the finish Method and call the sendBack Method also here                                  line No 48-49