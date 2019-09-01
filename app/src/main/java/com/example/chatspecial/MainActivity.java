package com.example.chatspecial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String name = MyCache.getUserFromCache(getApplicationContext());
        if(name != null){
            if(!name.equals("")){
                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }

    public void click(View view) {
        EditText editText = findViewById(R.id.name);
        String name = editText.getText().toString();
        MyCache.setName(getApplicationContext(), name);

        Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
        startActivity(intent);
        finish();
    }
}
