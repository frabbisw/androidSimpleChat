package com.example.chatspecial;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ChatActivity extends AppCompatActivity {
    List<Message>messages=new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        setLayout();
    }

    private void setLayout() {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        messages.add(new Message("hi there!","rabbi,","8:32",true));
        messages.add(new Message("bye!","hablu,","9:32",false));
        messages.add(new Message("bye!","hablu,","9:32",false));
        messages.add(new Message("bye!","hablu,","9:32",true));

        mAdapter = new RecyclerAdapter(getApplicationContext(),messages);
        recyclerView.setAdapter(mAdapter);
    }

    public void post(View view) {
        Date d = new Date();

        Random r = new Random();
        Message message = new Message("byesageseagsewg wagwe wagwagaw 3wag \naw3afwa3fgw3!","hablu,",""+d.getTime(),r.nextBoolean());

        messages.add(message);
        updateLayout();
    }

    public void updateLayout(){
        recyclerView.smoothScrollToPosition(mAdapter.getItemCount());
        mAdapter.notifyDataSetChanged();
    }
    public void scrollToBottom(View view){
        updateLayout();
    }
    public void addOwnMessage(Message message){
        messages.add(message);
        updateLayout();
    }
    public void addServerMessage(Message message){

        updateLayout();
    }
}
