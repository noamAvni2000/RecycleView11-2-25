package com.example.recycleview11_2_25;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {
    private ArrayList<DataItem> mData;
    private Context mContext;
    public MyAdapter(Context context, ArrayList<DataItem>data ) {
        this.mContext=context;
        this.mData=data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myEt.setText(" ");
        holder.myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = holder.myEt.getText().toString();
                Toast.makeText(v.getContext(), text, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        EditText myEt;
        Button myBtn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myEt = itemView.findViewById(R.id.editText_item);
            myBtn= itemView.findViewById(R.id.button_submit);
        }
    }
}
