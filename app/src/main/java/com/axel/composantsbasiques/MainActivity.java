package com.axel.composantsbasiques;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView incrementer;
    private Button countButton, changementActiviteButton;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incrementer = findViewById(R.id.countText);
        countButton = findViewById(R.id.incrementButton);
        changementActiviteButton = findViewById(R.id.changerActiviteButton);

        incrementer.setText(""+count);

        changementActiviteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent monIntent = new Intent(
                        MainActivity.this,
                        IntentActivity.class);

                monIntent.putExtra("COUNT", count);

                startActivity(monIntent);
            }
        });

      /*  countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                incrementer.setText(""+count);
            }
        });*/
    }


    public void cliquerSurLebutton(View view) {
        count++;
        incrementer.setText("Nouveau : "+count);
    }


}
























