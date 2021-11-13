package com.example.book4you;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    Button btnSubmit, btnCancel;
    TextView vTxtProductName, vTxtProductPrice;
    EditText textPersonName, txtEmail, txtExpiryMMDD, txtCVCNumber;
    Spinner spinner;
    ImageView imgBookCover;
    int bookId;
    ArrayAdapter<String> arrayAdapter;

    String[] countries = {"India", "USA", "China", "Japan", "Other"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        intiControls();

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        spinner.setAdapter(arrayAdapter);

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
                AlertDialog.Builder alert = new AlertDialog.Builder(CheckOutActivity.this);
                alert.setMessage("You order is recorded and you order number is #" + orderNumber);
                alert.setTitle("Order successful");
                alert.setCancelable(true);
                alert.show();
            }
        });

        Intent intent = getIntent();
        bookId = intent.getIntExtra("bookId", -1);


        if (bookId != 0) {
            ArrayList<Book> books = Util.getAllBooks();
            for (Book b : books
            ) {
                if (b.getId() == bookId) {
                    // Bind data to controls
                    vTxtProductName.setText(b.getName());
                    vTxtProductPrice.setText("$"+String.valueOf(b.getPrice()));

                    if (imgBookCover != null && b.getBookImageUrl() != null && b.getBookImageUrl() != "") {
                        Glide.with(this).asBitmap()
                                .load(b.getBookImageUrl())
                                .into(imgBookCover);
                    }

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


    }
}