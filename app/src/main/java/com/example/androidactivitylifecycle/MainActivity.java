package com.example.androidactivitylifecycle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int threadCounter = 1;
    int restartCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        threadCounter += 0;

        TextView threadCounterText = findViewById(R.id.thread_counter_txt);
        threadCounterText.setText("Thread Counter: " + String.valueOf(threadCounter));

        restartCounter += 1;

        TextView restartCounterText = findViewById(R.id.restart_counter_txt);
        restartCounterText.setText("Restart Counter: " + String.valueOf(restartCounter));
    }

    public void onStartActivityB (View view) {
        threadCounter += 5;
        Intent activityBIntent = new Intent(MainActivity.this, ActivityB.class);
        startActivity(activityBIntent);
    }

    public void onStartActivityC (View view) {
        threadCounter += 10;
        Intent activityCIntent = new Intent(MainActivity.this, ActivityC.class);
        startActivity(activityCIntent);
    }

    public void onTriggerDialog (View view) {
        new AlertDialog.Builder(this)
                .setTitle("Dialog")
                .setMessage("Simple Dialog")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {}
                })
                .show();
    }

    public void onCloseApp (View view) {
        finish();
        System.exit(0);
    }
}