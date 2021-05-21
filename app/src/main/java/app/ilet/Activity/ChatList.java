package app.ilet.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.ilet.Adapter.UserAdapter;
import app.ilet.Model.Chatlist;
import app.ilet.Model.User;
import app.ilet.Notifications.Token;
import app.ilet.R;

public class ChatList extends AppCompatActivity {
    private RecyclerView recyclerView;
    ExtendedFloatingActionButton rehber;
    private UserAdapter userAdapter;
    private List<User> mUsers= new ArrayList<>();

    FirebaseUser fuser;
    DatabaseReference reference;
    ValueEventListener chetsListener;


    private List<Chatlist> usersList;
    private List<Chatlist> usersList1;
    private List<String> mTel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);


        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        fuser = FirebaseAuth.getInstance().getCurrentUser();
        usersList = new ArrayList<>();
        usersList1 = new ArrayList<>();
        mTel= new ArrayList<>();

        reference = FirebaseDatabase.getInstance().getReference("Chatlist").child(fuser.getUid());
        chetsListener = reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                usersList.clear();
                usersList1.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Chatlist chatlist = snapshot.getValue(Chatlist.class);
                    usersList.add(chatlist);
                }
                ArrayList<Long> sıra = new ArrayList<>();
                for (Chatlist user : usersList) {
                    long s0 = Long.parseLong(user.date);
                    sıra.add(s0);

                }

                Collections.sort(sıra);
                for (int i = sıra.size() - 1; i >= 0; i--) {
                    Long s0 = sıra.get(i);
                    for (Chatlist user : usersList) {
                        long s1 = Long.parseLong(user.date);
                        if (s0 == s1) {
                            usersList1.add(user);
                        }
                    }
                }

                chatList();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        chatList();
        updateToken(FirebaseInstanceId.getInstance().getToken());

    }

    private void updateToken(String token) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Tokens");
        Token token1 = new Token(token);
        reference.child(fuser.getUid()).setValue(token1);
    }

    private void chatList() {
        mUsers.clear();
        mTel.clear();
        reference = FirebaseDatabase.getInstance().getReference("users");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mUsers.clear();
                for (Chatlist chatlist : usersList1) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        User user = snapshot.getValue(User.class);
                        if (user.getId().equals(chatlist.getId())) {
                            mUsers.add(user);

                        }
                    }
                }
                userAdapter = new UserAdapter(getApplicationContext(), mUsers);
                recyclerView.setAdapter(userAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        reference.removeEventListener(chetsListener);

    }
}