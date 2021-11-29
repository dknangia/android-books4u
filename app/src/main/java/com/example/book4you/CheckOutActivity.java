package com.example.book4you;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CheckOutActivity extends AppCompatActivity {
    private static final String TAG = "Checkout Activity: ";
    Button btnSubmit, btnCancel;
    TextView vTxtProductName, vTxtProductPrice;
    EditText textPersonName, txtEmail, txtExpiryMMDD, txtCVCNumber, txtProductQuantity;
    Spinner spinner;
    ImageView imgBookCover;
    int bookId;
    int iProductQuantity = 1;
    ArrayAdapter<String> arrayAdapter;
    Book incomingBook;

    String[] countries = {"India", "USA", "China", "Japan", "Other"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        intiControls();

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        spinner.setAdapter(arrayAdapter);


        txtProductQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!txtProductQuantity.getText().toString().equals("")) {
                    int i = Integer.parseInt(txtProductQuantity.getText().toString());
                    Log.d(TAG, "onTextChanged, value of i : " + String.valueOf(i));
                    if(incomingBook != null) {
                        vTxtProductPrice.setText("Total cost $" + String.valueOf(i * incomingBook.getPrice()));
                    }
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckOutActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String orderNumber = java.util.UUID.randomUUID().toString();
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(CheckOutActivity.this);
                alertBuilder.setMessage("You order is recorded and you order number is #" + orderNumber);
                alertBuilder.setTitle("Order successful");
                alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(CheckOutActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                AlertDialog alert = alertBuilder.create();
                alert.setCancelable(true);
                alert.show();
            }
        });

        // Instead of using bookId, we should use an object passed that will help to save one round trip to server
        Intent intent = getIntent();
        bookId = intent.getIntExtra("bookId", -1);


        if (bookId != 0) {
            ArrayList<Book> books = Util.getAllBooks();
            for (Book b : books
            ) {
                if (b.getId() == bookId) {

                    // Bind data to controls
                    vTxtProductName.setText(b.getName());
                    vTxtProductPrice.setText("Total cost $" + String.valueOf(b.getPrice()));

                    if (imgBookCover != null && b.getBookImageUrl() != null && b.getBookImageUrl() != "") {
                        Glide.with(this).asBitmap()
                                .load(b.getBookImageUrl())
                                .into(imgBookCover);
                    }

                    incomingBook = b;

                }
            }
        }
    }

    private void intiControls() {
        btnSubmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);

        vTxtProductName = findViewById(R.id.vTxtProductName);
        vTxtProductPrice = findViewById(R.id.vTxtProductPrice);
        textPersonName = findViewById(R.id.txtFullName);
        txtEmail = findViewById(R.id.txtEmail);
        txtExpiryMMDD = findViewById(R.id.txtExpiryMMDD);
        txtCVCNumber = findViewById(R.id.txtCVCNumber);

        imgBookCover = findViewById(R.id.productImage);
        spinner = findViewById(R.id.spinner);
        txtProductQuantity = findViewById(R.id.txtProductQuantity);
        if (txtProductQuantity != null) {
            txtProductQuantity.setText(String.valueOf(iProductQuantity));
        }


    }
}