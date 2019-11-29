package com.example.mydigitalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    //https://www.youtube.com/watch?v=aQAIMY-HzL8

    DatabaseHelper mDatabaseHelper;
    private Button btnaAdd, btnViewData;
    private EditText editText;
    private EditText editText3;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText = (EditText) findViewById(R.id.editText);
        editText3 = (EditText) findViewById(R.id.editText3);
        btnaAdd = (Button) findViewById(R.id.adddata);
        btnViewData = (Button) findViewById(R.id.viewdata);
        mDatabaseHelper = new DatabaseHelper(this);

        btnaAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = editText.getText().toString();
                String newEntry1 = editText3.getText().toString();
                if(editText.length() != 0 && editText3.length() != 0){
                    AddData(newEntry);
                    AddData(newEntry1);
                    editText.setText("");
                    editText3.setText("");
                }else{
                    toastMessage("you must put something in the text filed");
                }
            }
        });

        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, ListDataActivity.class);
                startActivity(intent);
            }
        });


    }

    public void AddData(String newEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData){
            toastMessage("Data Succes insert");
        }else{
            toastMessage("Sommething wrong");
        }

    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
