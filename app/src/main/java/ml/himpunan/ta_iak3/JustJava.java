package ml.himpunan.ta_iak3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class JustJava extends AppCompatActivity {

    private int bill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_java);
    }

    // int quantity = 0;
    Coffee coffee = new Coffee();
    int finalPrize = coffee.basicPrize + coffee.toppingChocolate + coffee.toppingCreamer;

    //checkbox
    public void onCheckBoxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.chocolateCheckBox:
                if (checked) {
                    coffee.toppingChocolate = 2000;
                    displayBill();
                }
                // Put some meat on the sandwich
                else {
                    coffee.toppingChocolate = 0;
                    displayBill();
                }
                // Remove the meat
                break;
            case R.id.creamerCheckBox:
                if (checked) {
                    coffee.toppingCreamer = 1000;
                    displayBill();
                }
                // Cheese me
                else {
                    coffee.toppingCreamer = 0;
                    displayBill();
                }
                // I'm lactose intolerant
                break;
            // TODO: Veggie sandwich
        }
    }


    //increment button

    public void increment(View view) {


        if (coffee.quantity < 100) {
            coffee.quantityIncrement(1);
            TextView quantity_text = (TextView) findViewById(R.id.quantity);
            quantity_text.setText("" + coffee.quantity);
            displayBill();
        }

        if (coffee.quantity == 100) {
            //String toast = "Maaf, untuk saat ini anda hanya dapat memesan 100 cangkir dalam sekali pemesanan";
            //Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void incrementby5(View view) {


        if ((coffee.quantity + 5) <= 100) {
            coffee.quantityIncrement(5);
            TextView quantity_text = (TextView) findViewById(R.id.quantity);
            quantity_text.setText("" + coffee.quantity);
            displayBill();
        }
        else if ((coffee.quantity + 5) > 100) {
            coffee.quantity = 100;
            TextView quantity_text = (TextView) findViewById(R.id.quantity);
            quantity_text.setText("" + coffee.quantity);
            displayBill();
        }
        if (coffee.quantity == 100) {
            //String toast = "Maaf, untuk saat ini anda hanya dapat memesan 100 cangkir dalam sekali pemesanan";
            //Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
            return;
        }
    }

    //decrement button
    public void decrement(View view) {
        if (coffee.quantity > 1) {
            coffee.quantityDecrement(1);
            TextView quantity_text = (TextView) findViewById(R.id.quantity);
            quantity_text.setText("" + coffee.quantity);
            displayBill();
        }
        else if (coffee.quantity == 1) {
            //String toast = "Exit aplikasi untuk membatalkan pemesanan";
            //Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void decrementby5(View view) {
        if ((coffee.quantity - 5) >= 1) {
            coffee.quantityDecrement(5);
            TextView quantity_text = (TextView) findViewById(R.id.quantity);
            quantity_text.setText("" + coffee.quantity);
            displayBill();
        }
        else if ((coffee.quantity - 5) < 1) {
            coffee.quantity = 1;
            TextView quantity_text = (TextView) findViewById(R.id.quantity);
            quantity_text.setText("" + coffee.quantity);
            displayBill();
        }
        else if (coffee.quantity == 1) {
            //String toast = "Tidak bisa memesan dengan jumlah dibawah 1";
            //Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private void displayBill() {
        TextView prize_text = (TextView) findViewById(R.id.prize);
        finalPrize = coffee.basicPrize + coffee.toppingCreamer + coffee.toppingChocolate;
        bill = coffee.quantity * finalPrize;
        prize_text.setText("Rp. " + bill + " ,-");
    }

    //order button
    public void orderButton(View view) {
        displayBill();
        Toast.makeText(this, "sending order...", Toast.LENGTH_SHORT).show();
    }
}
