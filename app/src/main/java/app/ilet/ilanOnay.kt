package app.ilet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import app.ilet.databinding.ActivityGirisBinding
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_ilan_detay_ekle.*
import kotlinx.android.synthetic.main.fragment_ilan_durak_ekle.*
import kotlinx.android.synthetic.main.fragment_ilan_konum.*
import kotlinx.android.synthetic.main.fragment_ilan_onay.*


class ilanOnay : Fragment() {
    private lateinit var auth: FirebaseAuth
    lateinit var binding: ActivityGirisBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ilan_onay, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var database = FirebaseDatabase.getInstance().reference
        auth = Firebase.auth
        buttonGEOnay.setOnClickListener {
            var nereden = editTextGENereden2.text.toString()
            var nereye = editTextGENereye2.text.toString()
            var arac = editTextGEArac.text.toString()
            var olusturma = Timestamp.now().toString()
            var cikis = editTextDateCikis.toString()
            var varis = editTextDateVaris.toString()
            var durak = editTextGEDurak.toString()
            var sure = editTextSure.toString()
            var kullanici = auth.currentUser!!.displayName.toString()
            val kullaniciid = auth.currentUser.tenantId.toString().toInt()

            database.setValue(Travel(nereden,nereye,arac,olusturma,cikis,varis,durak,sure,kullanici,kullaniciid))
        }
    }
}