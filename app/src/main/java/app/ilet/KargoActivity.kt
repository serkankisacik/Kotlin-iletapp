package app.ilet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import app.ilet.databinding.ActivityKargoBinding
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_ilan_detay_ekle.*
import kotlinx.android.synthetic.main.fragment_ilan_durak_ekle.*
import kotlinx.android.synthetic.main.fragment_ilan_onay.view.*

class KargoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kargo)
    }

}