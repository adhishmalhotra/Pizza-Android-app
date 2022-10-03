package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView nameActivity2, addressActivity2, phoneActivity2, emailActivity2, specialInstructionsActivity2, totalPriceActivity2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //fetching intent from Activity1
        String name = getIntent().getStringExtra("keyName");
        String address = getIntent().getStringExtra("keyAddress");
        String phone = getIntent().getStringExtra("keyPhone");
        String email = getIntent().getStringExtra("keyEmail");
        String specialInstructions = getIntent().getStringExtra("keySpecialInstructions");
        String totalPrice = getIntent().getStringExtra("keyTotalPrice");

        //TextView
        nameActivity2 = findViewById(R.id.nameActivity2);
        addressActivity2 = findViewById(R.id.addressActivity2);
        phoneActivity2 = findViewById(R.id.phoneActivity2);
        emailActivity2 = findViewById(R.id.emailActivity2);
        specialInstructionsActivity2 = findViewById(R.id.specialInstructionsActivity2);
        totalPriceActivity2 = findViewById(R.id.totalPriceActivity2);

        //button
        button = findViewById(R.id.button);

        //setting the data
        nameActivity2.setText(name);
        addressActivity2.setText(address);
        phoneActivity2.setText(phone);
        emailActivity2.setText(email);
        specialInstructionsActivity2.setText(specialInstructions);
        totalPriceActivity2.setText(totalPrice);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}