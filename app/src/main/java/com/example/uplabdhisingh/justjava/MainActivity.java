package com.example.uplabdhisingh.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=0; //global variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String createOrderSummary(int quant, int cost) {
        return "Name : Katherine Kunal \n Quantity : " + quant + "\n Total : $" + cost + "\n Thank You!";
    }


    private int calculatePrice(){
        int price = quantity * 5;
        return price;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int value = calculatePrice();
        String message = createOrderSummary(quantity,value);
        //String priceMessage = "Total: $"+value;
        //priceMessage=priceMessage+"\nThank You!";
        displayMessage(message);
    }
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity); //handling increment values.
    }
    public void decrement(View view) {
        quantity=quantity-1;
        displayQuantity(quantity);  //handling decrement values.
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numeric) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numeric);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int numeric) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(numeric));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}
