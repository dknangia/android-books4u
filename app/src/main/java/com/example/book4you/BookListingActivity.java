package com.example.book4you;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class BookListingActivity extends AppCompatActivity {
    RecyclerView bookRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_listing);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bookRecView = findViewById(R.id.bookRecView);

        BookRecViewAdapter adapter = new BookRecViewAdapter(this);
        bookRecView.setAdapter(adapter);
        bookRecView.setLayoutManager(new GridLayoutManager(this, 2));

        Util util = new Util();
        ArrayList<Book> albums = Util.getAllBooks();
        adapter.setBookArrayList(albums);
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