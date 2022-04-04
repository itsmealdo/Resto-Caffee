package quiz.aldosaaputra.restocaffe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvMainWho;
    private String nama;
    private String KEY_NAME ="YOURNAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Open Get Name
        tvMainWho = (TextView) findViewById(R.id.tvMainWho);

        Bundle extras = getIntent().getExtras();
        nama = extras.getString(KEY_NAME);
        tvMainWho.setText("" + nama + " ");
        //Close Get Name
    }

        public void submitOrder(View view) {
            //Find the user's name
            TextView UserInfo = (TextView) findViewById(R.id.tvMainWho);
            String value = UserInfo.getText().toString();
            //Kopi Robusta
            RadioButton KopiRobustaButton = (RadioButton) findViewById(R.id.robusta_radio);
            boolean hasKopiRobusta = KopiRobustaButton.isChecked();
            //Kopi Expresso
            RadioButton KopiExpressoButton = (RadioButton) findViewById(R.id.expresso_radio);
            boolean hasKopiExpresso = KopiExpressoButton.isChecked();
            //Kopi Luwak
            RadioButton KopiLuwakButton = (RadioButton) findViewById(R.id.luwak_radio);
            boolean hasKopiLuwak = KopiLuwakButton.isChecked();
            //Cream Topping
            CheckBox CreamCheckBox = (CheckBox) findViewById(R.id.cream_checkbox);
            boolean hasCream = CreamCheckBox.isChecked();
            //Sugar Topping
            CheckBox SugarCheckBox = (CheckBox) findViewById(R.id.sugar_checkbox);
            boolean hasSugar = SugarCheckBox.isChecked();
            //Nasi Goreng
            RadioButton NasiGorengButton = (RadioButton) findViewById(R.id.nasigoreng_radio);
            boolean hasNasiGoreng = NasiGorengButton.isChecked();
            //Mie Goreng
            RadioButton MieGorengButton = (RadioButton) findViewById(R.id.miegoreng_radio);
            boolean hasMieGoreng = MieGorengButton.isChecked();
            int price = calculatePrice(hasKopiRobusta, hasKopiExpresso, hasKopiLuwak, hasCream, hasSugar, hasNasiGoreng, hasMieGoreng);
            String priceMessage = createOrderSummary(value, price, hasKopiRobusta, hasKopiExpresso, hasKopiLuwak, hasCream, hasSugar, hasNasiGoreng, hasMieGoreng);
            displayMessage(priceMessage);
        }


    private int calculatePrice(boolean addRobusta, boolean addExpresso, boolean addLuwak, boolean addCream, boolean addSugar, boolean addNasiGoreng, boolean addMieGoreng) {
        int basePrice = 0;
        //Add $1 if the user wants whipped cream
        if (addRobusta) {
            basePrice = basePrice + 10000;
        }
        //Add $2 if the user wants chocolate
        if (addExpresso) {
            basePrice = basePrice + 20000;
        }
        if (addLuwak)   {
            basePrice = basePrice + 30000;
        }
        if (addCream)   {
            basePrice = basePrice + 1000;
        }
        if (addSugar)   {
            basePrice = basePrice +500;
        }
        if (addNasiGoreng)  {
            basePrice = basePrice +10000;
        }
        if (addMieGoreng)   {
            basePrice = basePrice +15000;
        }
        //Calculate the total order price
        return basePrice;
    }

    private String createOrderSummary(String nama, int price,boolean addRobusta, boolean addExpresso, boolean addLuwak, boolean addCream, boolean addSugar, boolean addNasiGoreng, boolean addMieGoreng) {
        String priceMessage = "Name: " + nama;
        priceMessage += "\nKopi Robusta " + addRobusta;
        priceMessage += "\nKopi Expresso " + addExpresso;
        priceMessage += "\nKopi Luwak " + addLuwak;
        priceMessage += "\nTambahan Cream?" + addCream;
        priceMessage += "\nTambahan Sugar?" + addSugar;
        priceMessage += "\nNasi Goreng" + addNasiGoreng;
        priceMessage += "\nMie Goreng" + addMieGoreng;
        priceMessage += "\nTotal: Rp." + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    private void displayMessage(String message) {
        TextView OrderSummaryTextView = (TextView) findViewById(R.id.tvOrderSummary);
        OrderSummaryTextView.setText(message);
    }

}