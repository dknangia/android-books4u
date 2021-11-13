package com.example.book4you;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookDetailActivity extends AppCompatActivity {
    private static final String TAG = "Book Details Activity";
    Button btnCheckout;
    TextView vTxtBookName, vTxtAuthorName, vTxtNumberOfPages, vTxtBookDescription, vTxtBookPrice;
    ImageView imgBookCover;
    Book paramBook;
    int bookId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        //Back button on top bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initControls();

        Intent intent = getIntent();

        bookId = intent.getIntExtra("bookId", 0);
        Log.d(TAG, "onCreate: " + bookId);
        if (bookId != 0) {
            ArrayList<Book> books = Util.getAllBooks();
            for (Book b : books
            ) {
                if (b.getId() == bookId) {
                    // Bind data to controls
                    vTxtBookName.setText(b.getName());
                    vTxtAuthorName.setText(b.getAuthor());
                    vTxtNumberOfPages.setText("Pages :" +String.valueOf(b.getPages()));
                    vTxtBookDescription.setText(b.getDescription());
                    vTxtBookPrice.setText("$" +String.valueOf(b.getPrice()));
                    if (imgBookCover != null && b.getBookImageUrl() != null && b.getBookImageUrl() != "") {
                        Glide.with(this).asBitmap()
                                .load(b.getBookImageUrl())
                                .into(imgBookCover);
                    }
                    paramBook = b;

                }
            }
        }
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookDetailActivity.this, CheckOutActivity.class);
                intent.putExtra("bookId", bookId);
                startActivity(intent);
            }
        });

    }

    private void initControls() {
        btnCheckout = findViewById(R.id.btnCheckOut);
        vTxtBookName = findViewById(R.id.vTxtBookName);
        vTxtAuthorName = findViewById(R.id.vTxtAuthorName);
        vTxtNumberOfPages = findViewById(R.id.vTxtNumberOfPages);
        vTxtBookDescription = findViewById(R.id.vTxtBookDescription);
        imgBookCover = findViewById(R.id.imgBookCover);
        vTxtBookPrice = findViewById(R.id.vTxtBookPrice);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}