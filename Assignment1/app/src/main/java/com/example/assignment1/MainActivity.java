package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner toppings;
    RadioGroup radioGroupPizzaSize;
    RadioButton RadioButton6Slices, RadioButton8Slices, RadioButton10Slices, RadioButton12Slices;
    CheckBox checkBoxExtraCheese, checkBoxIncludeDelivery;
    EditText editTextSpecialInstructions, editTextName, editTextAddress, editTextPhone,editTextMail;
    Button btnSubmit;
    String toppingsArray[] = {"Select Topping", "Mushroom($5)", "Sun Dried Tomatoes($5)",
                                "Chicken($7)", "Ground beef($8)", "Shrimps($10)",
                                "Pineapple($5)", "Steak($9)", "Avocado($5)", "Tuna($5)",
                                "Broccoli($8)"};
    ArrayAdapter<String> adapter;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //radio button group
        RadioButton6Slices = findViewById(R.id.RadioButton6Slices);
        RadioButton8Slices = findViewById(R.id.RadioButton8Slices);
        RadioButton10Slices = findViewById(R.id.RadioButton10Slices);
        RadioButton12Slices = findViewById(R.id.RadioButton12Slices);
        radioGroupPizzaSize = findViewById(R.id.radioGroupPizzaSize);

        //Spinner
        toppings = findViewById(R.id.toppingsSpinner);

        //checkboxes
        checkBoxExtraCheese = findViewById(R.id.checkBoxExtraCheese);
        checkBoxIncludeDelivery = findViewById(R.id.checkBoxIncludeDelivery);

        //EditText
        editTextSpecialInstructions = findViewById(R.id.editTextSpecialInstructions);
        editTextName = findViewById(R.id.editTextName);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextMail = findViewById(R.id.editTextMail);

        //submit button
        btnSubmit = findViewById(R.id.btnSubmit);

        //adapter for spinner
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, toppingsArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toppings.setAdapter(adapter);
        toppings.setOnItemSelectedListener(this);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double totalPrice = 0;
                if(RadioButton6Slices.isChecked()){
                    totalPrice += 5.50;
                }
                if(RadioButton8Slices.isChecked()){
                    totalPrice += 7.99;
                }
                if(RadioButton10Slices.isChecked()){
                    totalPrice += 9.50;
                }
                if(RadioButton12Slices.isChecked()){
                    totalPrice += 11.38;
                }
                if(checkBoxExtraCheese.isChecked()){
                    totalPrice+=5;
                }
                if(checkBoxIncludeDelivery.isChecked()){
                    totalPrice+=5;
                }
                if(toppings.getSelectedItem() == toppingsArray[1]){
                    totalPrice += 5;
                }
                if(toppings.getSelectedItem() == toppingsArray[2]){
                    totalPrice += 5;
                }
                if(toppings.getSelectedItem() == toppingsArray[3]){
                    totalPrice += 7;
                }
                if(toppings.getSelectedItem() == toppingsArray[4]){
                    totalPrice += 8;
                }
                if(toppings.getSelectedItem() == toppingsArray[5]){
                    totalPrice += 10;
                }
                if(toppings.getSelectedItem() == toppingsArray[6]){
                    totalPrice += 5;
                }
                if(toppings.getSelectedItem() == toppingsArray[7]){
                    totalPrice += 9;
                }
                if(toppings.getSelectedItem() == toppingsArray[8]){
                    totalPrice += 5;
                }
                if(toppings.getSelectedItem() == toppingsArray[9]){
                    totalPrice += 5;
                }
                if(toppings.getSelectedItem() == toppingsArray[10]){
                    totalPrice += 8;
                }

                Toast.makeText(getApplicationContext(), "Total Price so far: $" + df.format(totalPrice), Toast.LENGTH_LONG).show();

                String name = editTextName.getText().toString();
                String address = editTextAddress.getText().toString();
                String phone = editTextPhone.getText().toString();
                String email = editTextMail.getText().toString();
                String specialInstructions = editTextSpecialInstructions.getText().toString();


                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("keyName", name);
                intent.putExtra("keyAddress", address);
                intent.putExtra("keyPhone", phone);
                intent.putExtra("keyEmail", email);
                intent.putExtra("keySpecialInstructions", specialInstructions);
                intent.putExtra("keyTotalPrice", df.format(totalPrice));
                startActivity(intent);

            }
        });
    }




    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        String str = "";

        //check which radio button was clicked

        switch(view.getId()){

            case R.id.RadioButton6Slices:
                if(checked) {
                    str = "6 slices is selected";
                }
                break;

            case R.id.RadioButton8Slices:
                if(checked) {
                    str = "8 slices is selected";
                }
                break;

            case R.id.RadioButton10Slices:
                if(checked) {
                    str = "10 slices is selected";
                }
                break;

            case R.id.RadioButton12Slices:
                if(checked) {
                    str = "12 slices is selected";
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}