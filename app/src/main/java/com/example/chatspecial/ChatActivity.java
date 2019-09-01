package com.example.chatspecial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
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

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)


        List<Message>messages=new ArrayList<>();
        messages.add(new Message("hi there!","rabbi,","8:32"));
        messages.add(new Message("bye!","hablu,","9:32"));
        messages.add(new Message("go to hell!","gajakhor,","1:32"));
        messages.add(new Message("go to hell!\nasfasfgsafasg\nasfasgsewgwzsgseg segseg\nawfawfaw","gajakhor,","1:32"));
        messages.add(new Message("go to hell!","gajakhor,","1:32"));
        messages.add(new Message("go to hell!","gajakhor,","1:32"));
        messages.add(new Message("go to hell!","gajakhor,","1:32"));

        mAdapter = new RecyclerAdapter(getApplicationContext(),messages);
        recyclerView.setAdapter(mAdapter);
    }
}
