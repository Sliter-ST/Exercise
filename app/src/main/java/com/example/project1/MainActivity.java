package com.example.project1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                LayoutInflater inflater = getLayoutInflater();
                builder.setView(inflater.inflate(R.layout.login_dialog,null))
                        .setTitle("Login").setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int witch) {
                        AlertDialog ad = (AlertDialog) dialog;
                        EditText t1 = (EditText) ad.findViewById(R.id.editTextUserId);
                        String UserId = t1.getText().toString();

                        EditText t2 = (EditText) ad.findViewById(R.id.editTextPwd);
                        String PassWord = t2.getText().toString();

                        if (UserId.equals("abc")==false){
                            Toast.makeText(MainActivity.this,"用户名错误！",Toast.LENGTH_SHORT).show();
                        }
                        else if (PassWord.equals("123")==false){
                            Toast.makeText(MainActivity.this,"密码错误！",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"登陆成功！",Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int witch) {

                            }
                        });
                        builder.show();
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("提示").setMessage("请输入正确的用户名和密码！").setNegativeButton(R.string.OK, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int witch) {

                    }
                });
                builder.show();
            }
        });
    }

    }
