/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /*This method is called when the plus button is clicked*/
    public void increment(View view){
        if (quantity == 100){
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity+1;
        displayQuantity(quantity);
    }
    /*This method is called when the minus button is clicked*/
    public void decrement(View view){
        //since the default quantity is 0 on launch, this block make the minus button not do anything
        if (quantity == 0){
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        if (quantity == 1){
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity-1;
        displayQuantity(quantity);
    }
    /**
     * This method is called when the order button is clicked.
     * @return total price
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_check);
        Boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("mainactivity","Has Whipped Cream " +hasWhippedCream);
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_check);
        Boolean hasChocolate = chocolateCheckBox.isChecked();
        EditText fullName = (EditText) findViewById(R.id.name_edit_text);
        String getFullName = fullName.getText().toString();
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String summary = createOrderSummary(price,hasWhippedCream,hasChocolate,getFullName);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order For " +getFullName);
        intent.putExtra(Intent.EXTRA_TEXT, summary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        //displayMessage(summary);
    }

    /* Calculates the price of the order at 5 dollars per cup
    *@param hasWhippedCream is whether or not the user wants whipped cream at 1 dollar extra
    *@param hasChocolate is whether or not the user wants chocolate at 2 dollars extra
    */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int basePrice = 5;
        if (hasWhippedCream){
            basePrice = basePrice + 1;
        }
        if (hasChocolate){
            basePrice = basePrice + 2;
        }
        return basePrice * quantity;
    }

   /* public void displayMessage(String message){
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }*/
    public String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String getFullName){
        String priceMessage = "Name: "+getFullName+ "\nWhipped Cream? "+hasWhippedCream+ "\nChocolate? "+hasChocolate+
                "\nQuantity: "+quantity+ "\nTotal: ₦"+price + "\n"+ getString(R.string.thank_you);
        return priceMessage;
    }
}