package com.biswadeep.developer.shopmaniacc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;

public class Payment_Activity extends AppCompatActivity {

    public static final String GPAY_PACKAGE_NAME = "com.google.android.apps.nbu.paisa.user";
    EditText name, upiId, amount, note;
    Button pay;
    Uri uri;
    String approvalRefNo;

    BottomNavigationView bv;

    private static final String TAG = "Payment_Activity";

    Food f1;

    public static String payerName, UpiId, msgNote, sendAmount, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_);

        f1= new Food();

        name = (TextInputEditText) findViewById(R.id.name);
        upiId = (TextInputEditText) findViewById(R.id.upi_id);
        amount = (TextInputEditText) findViewById(R.id.amount);
        note = (TextInputEditText) findViewById(R.id.transaction_note);

        bv= (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bv.setOnNavigationItemSelectedListener(navListener);


        pay = findViewById(R.id.pay);


        //initialising default value
        Intent getData= getIntent();
        String amt= getData.getStringExtra("mymoney");
        String txt= getData.getStringExtra("mytext");
        name.setText("");
        upiId.setText("");
        note.setText("Payment for this " + txt + " item");
        amount.setText(amt);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                payerName = name.getText().toString();
                UpiId = upiId.getText().toString();
                msgNote = note.getText().toString();
                sendAmount = amount.getText().toString();

                if(!payerName.equals("") && !upiId.equals("") && !msgNote.equals("") && !sendAmount.equals("")){

                    uri = getUpiPaymentUri(payerName, UpiId, msgNote, sendAmount);
                    payWithGpay(GPAY_PACKAGE_NAME);

                }
                else {
                    Toast.makeText(Payment_Activity.this,"Fill all above details and try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home:
                    startActivity(new Intent(Payment_Activity.this,MainActivity.class));
                    finish();
                    break;
                case R.id.cart:
                    startActivity(new Intent(Payment_Activity.this, Cart.class));
                    finish();
                    break;
            }
            return false;
        }
    };

    private static Uri getUpiPaymentUri(String name, String upiId, String note, String amount){
        return  new Uri.Builder()
                .scheme("upi")
                .authority("pay")
                .appendQueryParameter("pa",upiId)
                .appendQueryParameter("pn",name)
                .appendQueryParameter("tn",note)
                .appendQueryParameter("am",amount)
                .appendQueryParameter("cu","INR")
                .build();
    }

    private void payWithGpay(String packageName){

        if(isAppInstalled(this,packageName)){

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setPackage(packageName);
            startActivityForResult(intent,0);

        }
        else{
            Toast.makeText(Payment_Activity.this,"Google pay is not installed. Please istall and try again.", Toast.LENGTH_SHORT).show();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null) {
            status = data.getStringExtra("Status").toLowerCase();
            approvalRefNo = data.getStringExtra("txnRef");
        }
        if ((RESULT_OK == resultCode) && status.equals("success")) {
            Toast.makeText(Payment_Activity.this, "Transaction successful. "+approvalRefNo, Toast.LENGTH_SHORT).show();
        }

        else{
            Toast.makeText(Payment_Activity.this, "Transaction cancelled or failed please try again.", Toast.LENGTH_SHORT).show();
          //  msg.setText("Transaction Failed of ₹" + sendAmount);
          //  msg.setTextColor(Color.RED);
        }

    }

    public static boolean isAppInstalled(Context context, String packageName){
        try{
            context.getPackageManager().getApplicationInfo(packageName,0);
            return true;
        }catch (PackageManager.NameNotFoundException e){
            return false;
        }
    }
}