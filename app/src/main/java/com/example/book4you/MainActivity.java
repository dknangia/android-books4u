package com.example.book4you;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imgAboutus, imgBrowseBooks;
    TextView vTxtAboutus, vTxtBrowseBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initControls();

        imgBrowseBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browseButtonTapped();
            }
        });

        imgAboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutUsButtonTapped();
            }
        });

        vTxtAboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutUsButtonTapped();
            }
        });

        vTxtBrowseBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browseButtonTapped();
            }
        });
    }

    private void browseButtonTapped() {
        Intent intent = new Intent(MainActivity.this, BookListingActivity.class);
        startActivity(intent);
    }

    private void aboutUsButtonTapped() {

        Intent intent = new Intent(MainActivity.this, AboutUsActivity.class);
        startActivity(intent);
    }

    private void initControls() {
        imgAboutus = findViewById(R.id.imgAboutUs);
        imgBrowseBooks = findViewById(R.id.imgBrowseBooks);

        vTxtAboutus = findViewById(R.id.vTxtAboutUs);
        vTxtBrowseBooks = findViewById(R.id.vTxtBrowsebooks);
    }
}