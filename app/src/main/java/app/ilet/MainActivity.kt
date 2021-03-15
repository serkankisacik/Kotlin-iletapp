package app.ilet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth

        val currentUser = auth.currentUser
        if ( currentUser == null){
            
            val intent = Intent(applicationContext,giris::class.java)
            startActivity(intent)
        }
    }
    fun gitGiris( view: View){
        val intent = Intent(applicationContext,giris::class.java)
        startActivity(intent)
    }
    fun gitProfil( view: View){
        val intent = Intent(applicationContext,ProfilActivity::class.java)
        startActivity(intent)
    }
    fun gitKargo( view: View){
        val intent = Intent(applicationContext,KargoActivity::class.java)
        startActivity(intent)
    }
}