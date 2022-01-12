package com.sanket.funplay.ui.puzzle.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sanket.funplay.R;
import com.sanket.funplay.ui.mathstricks.tricks.Tricks;
import com.sanket.funplay.ui.puzzle.puzzle.Puzzle;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context context;
    ArrayList<String> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        CardView card;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.name_custom1);
            card = (CardView) view.findViewById(R.id.card_custom1);
        }
    }

    public CustomAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        myViewHolder.title.setText(list.get(i));

        myViewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              context.startActivity(new Intent(context, Puzzle.class).putExtra("puname",list.get(i)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}