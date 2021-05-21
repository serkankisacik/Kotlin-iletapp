package app.ilet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import app.ilet.Model.Post;


public class postSet extends AppCompatActivity {

    EditText baslik, mesaj, user;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_set);
        baslik = findViewById(R.id.baslik);
        mesaj = findViewById(R.id.post);
        user = findViewById(R.id.user);

    }

    public void paylas(View v) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("post");
        if (!mesaj.getText().toString().isEmpty() && !baslik.getText().toString().isEmpty() &&!user.getText().toString().isEmpty() ) {
            String sm = mesaj.getText().toString();
            String sb = baslik.getText().toString();
            String su = user.getText().toString();
            final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
            Post p = new Post(sb,sm,su,firebaseUser.getUid());
            myRef.push().setValue(p);
            finish();
            Toast.makeText(getApplicationContext(),"İlanınız Yayınlandı.",Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(getApplicationContext(),"Boş Alan Bırakmayınız",Toast.LENGTH_LONG).show();
        }

    }
}