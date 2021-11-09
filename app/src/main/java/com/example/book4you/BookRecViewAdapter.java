package com.example.book4you;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookRecViewAdapter extends RecyclerView.Adapter<BookRecViewAdapter.ViewHolder> {

    private static final String TAG = "Book Recycler View";
    private ArrayList<Book> bookArrayList = new ArrayList<>();
    private Context context;

    public BookRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // The code will remain same for all the cases.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rec_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d(TAG, "onBindViewHolder: On BindViewHolder called");

        holder.bookName.setText(bookArrayList.get(position).getName());

        Glide.with(context)
                .asBitmap()
                .load(bookArrayList.get(position).getBookImageUrl())
                .into(holder.bookImage);

        holder.bookCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BookDetailActivity.class);
                intent.putExtra("bookId", bookArrayList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView bookImage;
        TextView bookName;
        CardView bookCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bookImage = itemView.findViewById(R.id.bookImage);
            bookName = itemView.findViewById(R.id.vtxtBookName);
            bookCardView = itemView.findViewById(R.id.bookCard);
        }
    }

    public void setBookArrayList(ArrayList<Book> list){
        this.bookArrayList = list;
        notifyDataSetChanged();
    }
}
