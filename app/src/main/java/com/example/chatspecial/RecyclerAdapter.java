package com.example.chatspecial;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;
import java.util.Random;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Vholder> {

    private Context context;
    private List<Message> dataMemberses;

    public RecyclerAdapter(Context context, List<Message> dataMemberses) {
        this.context = context;
        this.dataMemberses = dataMemberses;
    }

    @Override
    public Vholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        View view;
        view = inflater.inflate(R.layout.messege_item, parent, false);

        return new Vholder(view);
    }

    @Override
    public void onBindViewHolder(final Vholder holder, final int position) {
        final Message message = dataMemberses.get(position);

        if(message.isSender){
            holder.msgText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            holder.msgSender.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            holder.msgTime.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        }

        holder.msgText.setText(message.text);
        holder.msgSender.setText(message.sender);
        holder.msgTime.setText(message.time);
    }

    @Override
    public int getItemCount() {
        return dataMemberses.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class Vholder extends RecyclerView.ViewHolder {

        TextView msgSender;
        TextView msgText;
        TextView msgTime;

        public Vholder(View itemView) {
            super(itemView);

            msgSender = (TextView) itemView.findViewById(R.id.msg_sender);
            msgText = (TextView) itemView.findViewById(R.id.msg_text);
            msgTime = (TextView) itemView.findViewById(R.id.msg_time);
        }
    }

    public void setItems(List<Message> messages) {
        this.dataMemberses = messages;
    }
}