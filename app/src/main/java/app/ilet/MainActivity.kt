package app.ilet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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