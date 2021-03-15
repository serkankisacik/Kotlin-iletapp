package app.ilet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_acilis.*
import kotlinx.android.synthetic.main.fragment_ana_profil.*
import kotlinx.android.synthetic.main.fragment_profil_ayarlari.*

class anaProfil : Fragment() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        val currentuser = auth.currentUser?.displayName.toString()
        println(currentuser)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ana_profil, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val currentuser = auth.currentUser?.displayName.toString()
        if(currentuser!=null){
            textViewKullaniciAd.text=currentuser
        }
        super.onViewCreated(view, savedInstanceState)
        buttonDuzenle.setOnClickListener {
            val action = anaProfilDirections.actionAnaProfilToAyarlar()
            Navigation.findNavController(it).navigate(action)
        }
        imageViewKullaniciFotograf.setOnClickListener {
            val action = anaProfilDirections.actionAnaProfilToProfilFotografi()
            Navigation.findNavController(it).navigate(action)
        }
        textViewGeziDurum.setOnClickListener {
            val action = anaProfilDirections.actionAnaProfilToYolda()
            Navigation.findNavController(it).navigate(action)
        }
    }
}