package com.example.firebasechat2019;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button btnChat;
    EditText etChatMessage;
    TextView tvMsgList;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChat = findViewById(R.id.buttonChat);
        etChatMessage = findViewById(R.id.editTextMessage);
        tvMsgList = findViewById(R.id.textViewMsgList);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Chat2019");

        myRef.setValue("Hello, World!");

        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ---- Get a new database key for the vote
                String key = myRef.child("Favorite Pet Votes").push().getKey();
                // ---- set up the vote
                String msgText = etChatMessage.getText().toString();

                Vote vote = new Vote(voteText, voteNum);
                // ---- write the vote to Firebase
                myDbRef.child("Favorite Pet Votes").child(key).setValue(vote);
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        })

    }
}
